package fr.legrain.lib.mail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.Resource;
import com.mailjet.client.resource.Contact;
import com.mailjet.client.resource.Email;
import com.mailjet.client.resource.Emailv31;
import com.mailjet.client.resource.Sender;

import fr.legrain.lib.data.LibConversion;

public class LgrMailjet {

/*
 * https://mvnrepository.com/artifact/com.mailjet/mailjet-client/4.1.1
 */
	
	private String MJ_APIKEY_PUBLIC = null;
	private String MJ_APIKEY_PRIVATE = null;
	
	private String MJ_BEARER_TOKEN = null;
	
	private final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();  
	
	public LgrMailjet(String mjApikeyPublic, String mjApikeyPrivate) {
		MJ_APIKEY_PUBLIC = mjApikeyPublic;
		MJ_APIKEY_PRIVATE = mjApikeyPrivate;
	}
	
	public LgrMailjet(String mjBearerToken) {
		MJ_BEARER_TOKEN = mjBearerToken;
	}
	
	public void send(String fromEmail, String fromName, String subject, String textPart, String htmlPart, String[] destinataires, File[] attachment) {
		send(fromEmail, fromName, subject, textPart, htmlPart, destinataires, null, null, attachment);
	}


	/*
	 * Version 3.0
	 */
	public void send(String fromEmail, String fromName, String subject, String textPart, String htmlPart, String[] destinataires, String[] cc, String[] bcc, File[] attachment) {

		try {
			MailjetClient client = new MailjetClient(MJ_APIKEY_PUBLIC, MJ_APIKEY_PRIVATE/*,new ClientOptions("v3.0","https://api.eu.mailjet.com")*/);
			
			MailjetRequest sender;
			MailjetResponse r;

			sender = new MailjetRequest(Sender.resource)
			            .property(Sender.EMAIL, fromEmail);

			r = client.post(sender);
			
			String base64 = null;
			
			JSONArray recipients = new JSONArray();
			for (String d : destinataires) {
				recipients.put(new JSONObject().put(Contact.EMAIL, d));
			}
			
			MailjetRequest request;
			MailjetResponse response;
			request = new MailjetRequest(Email.resource)
					.property(Email.FROMEMAIL, fromEmail)
					.property(Email.FROMNAME, fromName)
					.property(Email.SUBJECT, subject)
					.property(Email.TEXTPART, textPart)
					.property(Email.HTMLPART, htmlPart)
					
					.property(Email.RECIPIENTS, recipients) // RECIPIENTS et TO sont différents voir la doc de l'api https://dev.mailjet.com/guides/#send-api-v3-1-beta
//					.property(Email.TO,recipients)
					
					;
			if(cc!=null) {
				JSONArray ccjson = new JSONArray();
//				String ccjson = "";
				boolean premier = true;
				for (String adr : cc) {
					ccjson.put(new JSONObject().put(Contact.EMAIL, adr));
//					if(premier) {
//						ccjson += adr;
//						premier = false;
//					} else {
//						ccjson += ", "+adr;
//					}
				}
				request.property(Email.CC, ccjson);
			}
			
			if(bcc!=null) {
//				String bccjson = "";
				JSONArray bccjson = new JSONArray();
				boolean premier = true;
				for (String adr : bcc) {
					bccjson.put(new JSONObject().put(Contact.EMAIL, adr));
//					if(premier) {
//						bccjson += adr;
//						premier = false;
//					} else {
//						bccjson += ", "+adr;
//					}
				}
				request.property(Email.BCC, bccjson);
			}
			
			if(attachment!=null) {
				JSONArray piecesJointes = new JSONArray();
				for (File file : attachment) {
					base64 = DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get(file.getPath())));
					String mime = Files.probeContentType(file.toPath());
					if(mime==null || mime.equals("")) {
						fileTypeMap.getContentType(file);
					}
					piecesJointes.put(new JSONObject()
							//.put("Content-type", "application/pdf")
							.put("Content-type", mime)
							.put("Filename", file.getName())
							.put("content", base64));
				}
				
				request.property(Email.ATTACHMENTS, piecesJointes);
			}
			
			response = client.post(request);
			System.out.println(response.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * v3.1
	 */
	public ReponseEmailSendService send_v3_1(String fromEmail, String fromName, String subject, String textPart, String htmlPart, String[] destinataires, String[] cc, String[] bcc, File[] attachment, String replyToEmail) {

		try {
			ReponseEmailSendService r = null;
			MailjetClient client;
			MailjetRequest request;
			MailjetResponse response;
			String base64 = null;
			
			//obligé de mettre la base url à cause d'un problème de certificat ssl : https://github.com/mailjet/mailjet-apiv3-java/issues/126
			//évite une erreur : javax.net.ssl.SSLHandshakeException: No subject alternative DNS name matching api.mailjet.com found
			//même si d'après des dev sur github c'est deja corrigé
			client = new MailjetClient(MJ_APIKEY_PUBLIC, MJ_APIKEY_PRIVATE, new ClientOptions("v3.1","https://api.eu.mailjet.com"));
			
			JSONObject message = new JSONObject();
			
			message.put(Emailv31.Message.FROM, new JSONObject()
							.put(Emailv31.Message.EMAIL, fromEmail)
							.put(Emailv31.Message.NAME, fromName));
			
			message.put(Emailv31.Message.SUBJECT, subject)
					.put(Emailv31.Message.TEXTPART, textPart)
					.put(Emailv31.Message.HTMLPART, htmlPart);
			
			if(replyToEmail!=null && !replyToEmail.equals("")) {
				message.put(Emailv31.Message.REPLYTO, new JSONObject()
						.put(Emailv31.Message.EMAIL, replyToEmail)
						.put(Emailv31.Message.NAME, replyToEmail));
			}
			
			JSONArray recipients = new JSONArray();
			for (String d : destinataires) {
				recipients.put(new JSONObject().put(Emailv31.Message.EMAIL, d));
			}
			message.put(Emailv31.Message.TO, recipients);
			
			if(cc!=null) {
				JSONArray ccjson = new JSONArray();
				for (String adr : cc) {
					ccjson.put(new JSONObject().put(Emailv31.Message.EMAIL, adr));
				}
				message.put(Emailv31.Message.CC, ccjson);
			}
			
			if(bcc!=null) {
				JSONArray bccjson = new JSONArray();
				for (String adr : bcc) {
					bccjson.put(new JSONObject().put(Emailv31.Message.EMAIL, adr));
				}
				message.put(Emailv31.Message.BCC, bccjson);
			}
					
			if(attachment!=null) {
				JSONArray piecesJointes = new JSONArray();
				for (File file : attachment) {
					base64 = DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get(file.getPath())));
					String mime = Files.probeContentType(file.toPath());
					if(mime==null || mime.equals("")) {
						mime = fileTypeMap.getContentType(file);
						if(mime==null || mime.equals("")) {
							mime = "application/pdf"; //l'API MailJet n'accepte pas de type mime vide qui ferait planter l'envoi du mail
						}
					}
					piecesJointes.put(new JSONObject()
							//.put("Content-type", "application/pdf")
							.put("ContentType", mime)
							.put("Filename", file.getName())
							.put("Base64Content", base64));
				}
				message.put(Emailv31.Message.ATTACHMENTS, piecesJointes);
			}
				
			request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, (new JSONArray()).put(message));
			
			response = client.post(request);
			
			r = new ReponseEmailSendService();
			if(response.getStatus() == 200) {
				JSONObject jb = response.getData().getJSONObject(0).getJSONArray("To").getJSONObject(0);
				r.setMessageID(String.valueOf(jb.getLong("MessageID")));
				r.setErreur(false);
			} else {
				r.setErreur(true);
			}
			r.setReponseTxt(response.getData().toString());
			r.setData(response.getData().toString());
			r.setStatus(LibConversion.integerToString(response.getStatus()));
			
			System.out.println(response.getStatus());
			System.out.println(response.getData());
			System.out.println(r.getMessageID());
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ReponseMailjetEmailInformationService findMessageInformation(long messageId) {
		MailjetClient client;
		MailjetRequest request;
		MailjetResponse response;
		try {
			//client = new MailjetClient(MJ_APIKEY_PUBLIC, MJ_APIKEY_PRIVATE, new ClientOptions("v3.1"));
			client = new MailjetClient(MJ_APIKEY_PUBLIC, MJ_APIKEY_PRIVATE, new ClientOptions("v3"));
			
			//Resource resource = new Resource("message");
			Resource resource = new Resource("messagesentstatistics");

			
			
			request = new MailjetRequest(resource, messageId);

			response = client.get(request);
			ReponseMailjetEmailInformationService r = new ReponseMailjetEmailInformationService(response.getData().toString());
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	String MJ_TOKEN = "be8e140bcecc4f0bbcd022f364ae1f74"; //token "Legrain" compte legrain
//	String MJ_TOKEN = "	1d4e31f9e33647af8f5d589851ac907d; //token "test" compte legrain
    public ReponseSmsSendService sendSMS(String fromNumber, String fromName, String text, String[] to) {

    	ReponseSmsSendService r = null;
        String METHOD = "POST";
        try {
            URL QUERY  = new URL("https://api.mailjet.com/v4/sms-send");

            String numberStr = to[0];
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            try {
              PhoneNumber frNumberProto = phoneUtil.parse(numberStr, "FR");
              boolean isValid = phoneUtil.isValidNumber(frNumberProto); // returns true
              numberStr = phoneUtil.format(frNumberProto, PhoneNumberFormat.E164);
            } catch (NumberParseException e) {
            	  System.err.println("NumberParseException was thrown: " + e.toString());
            }
            
            System.out.println("LgrMailjet.sendSMS() To :"+to[0]+" To E164 : "+numberStr);
            //String BODY   = "{\"To\": \""+numberStr+"\",\"Text\":\""+text+"\",\"From\":\""+fromName+"\"}";
            
            JSONObject b = new JSONObject();
            b.put("To", numberStr);
            b.put("Text", text);
            b.put("From", fromName);
            String BODY = b.toString();

            HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
            req.setRequestMethod(METHOD);
            req.setRequestProperty("Content-Type", "application/json");
            req.setRequestProperty("Authorization", "Bearer "+MJ_BEARER_TOKEN);

            if(!BODY.isEmpty()) {
                req.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
//                wr.writeBytes(BODY);
//                wr.flush();
                writer.write(BODY);
                writer.close();
                wr.close();
            }

            String inputLine;
            BufferedReader in;
            int responseCode = req.getResponseCode();
            if ( responseCode == 200 ) {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
            }
            StringBuffer response   = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            
            r = new ReponseSmsSendService();
//			if(response.getStatus() == 200) {
//				JSONObject jb = response.getData().getJSONObject(0).getJSONArray("To").getJSONObject(0);
//				r.setMessageID(String.valueOf(jb.getLong("MessageID")));
//				r.setErreur(false);
//			} else {
//				r.setErreur(true);
//			}
			r.setReponseTxt(response.toString());
			r.setData(response.toString());
			r.initWithMailjetJson(response.toString());
			//r.setStatus(LibConversion.integerToString(response.getStatus()));

			 System.out.println(response.toString());
			 
			 return r;

        } catch (Exception e) {
            final String errmsg = "Exception: " + e;
            e.printStackTrace();
        }
		return null;
    }
    
    
	public ReponseMailjetSmsInformationService findMessageSMSInformation(String messageId) {
		ReponseMailjetSmsInformationService r = null;
        String METHOD = "GET";
        try {
            URL QUERY  = new URL("https://api.mailjet.com/v4/sms/"+messageId);
//            String BODY   = "{\"To\": \"+33678373655\",\"Text\":\"Test SMS \",\"From\":\"nico\"}";
            
            String BODY   = "";

            HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
            req.setRequestMethod(METHOD);
            req.setRequestProperty("Content-Type",      "application/json");
            req.setRequestProperty("Authorization", "Bearer "+MJ_BEARER_TOKEN);

            if(!BODY.isEmpty()) {
                req.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
                wr.writeBytes(BODY);
                wr.flush();
                wr.close();
            }

            String inputLine;
            BufferedReader in;
            int responseCode = req.getResponseCode();
            if ( responseCode == 200 ) {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
            }
            StringBuffer response   = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            
//			if(response.getStatus() == 200) {
//				JSONObject jb = response.getData().getJSONObject(0).getJSONArray("To").getJSONObject(0);
//				r.setMessageID(String.valueOf(jb.getLong("MessageID")));
//				r.setErreur(false);
//			} else {
//				r.setErreur(true);
//			}
            
            r = new ReponseMailjetSmsInformationService(response.toString());
//			r.setReponseTxt(response.toString());
//			r.setData(response.toString());
			//r.setStatus(LibConversion.integerToString(response.getStatus()));

			 System.out.println(response.toString());
			 
			 return r;

        } catch (Exception e) {
            final String errmsg = "Exception: " + e;
            e.printStackTrace();
        }
		
		return null;
	}

	
}
