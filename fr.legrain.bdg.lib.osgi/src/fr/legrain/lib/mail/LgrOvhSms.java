package fr.legrain.lib.mail;
import java.net.*;
import java.io.*;
import java.util.Date;

import org.json.JSONObject;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * https://eu.api.ovh.com/createToken/?GET=/sms/&GET=/sms//jobs/&POST=/sms//jobs/
 * https://api.ovh.com/console/#/sms/%7BserviceName%7D/jobs#POST
 * 
 * http://www.waibe.fr/blog-1-1453053924_2016_-comment-utiliser-la-nouvelle-api-php-v6-de-programmation-d-ovh-.html
 * 
 * https://api.ovh.com/console/
 * /me/api/application
 * 
 */
public class LgrOvhSms {
	//(utilisable dans parametrage dossier, faire des param programme pour les SMS ????)
	private String APPLICATION_KEY = null;
	private String APPLICATION_SECRET = null;
	private String CONSUMER_KEY = null;
	private String SERVICE_NAME = null;
	
	/// Liste des chemin a activer pour ce token
//	 {
//
//    ovhSupport: false
//    status: "validated"
//    applicationId: 55316
//    credentialId: 188698062
//    -
//    rules: [
//        -
//        {
//            method: "GET"
//            path: "/sms/"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/jobs/"
//        }
//        -
//        {
//            method: "POST"
//            path: "/sms/*/jobs/"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/outgoing/*"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/incoming/*"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/jobs/*"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/outgoing/"
//        }
//        -
//        {
//            method: "GET"
//            path: "/sms/*/incoming/"
//        }
//    ]
//    expiration: null
//    lastUse: null
//    creation: "2018-06-13T16:05:00+02:00"
//
//}
	
	public LgrOvhSms(String APPLICATION_KEY, String APPLICATION_SECRET, String CONSUMER_KEY, String SERVICE_NAME) {
		super();
		this.APPLICATION_KEY = APPLICATION_KEY;
		this.APPLICATION_SECRET = APPLICATION_SECRET;
		this.CONSUMER_KEY = CONSUMER_KEY;
		this.SERVICE_NAME = SERVICE_NAME;
	}
    
	public ReponseSmsSendService sendSMS(String fromNumber, String fromName, String text, String[] to) {	
		/*
		 *	Script Name: sendsms_bdg_programme
		 *	Script Description: envoi de sms avec le programme bdg
		 *	Application Key: lYcWRiDCghiI4CoE
		 *	Application Secret: 0UQhmqlj9CjkZLYNJx1CXsNIcEwfONzT
		 *	Consumer Key: CGNAjXpBon6Upf2njkV71bToQhLuY5y2
    	 */
        String AK = APPLICATION_KEY;
        String AS = APPLICATION_SECRET;
        String CK = CONSUMER_KEY;

        String ServiceName = SERVICE_NAME;
        String METHOD = "POST";
        ReponseSmsSendService r = null;
        
        try {
            URL    QUERY  = new URL("https://eu.api.ovh.com/1.0/sms/"+ServiceName+"/jobs/");
            
            String numberStr = to[0];
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            
            int i = 0;
            for (String string : to) {
            	 try {
                     PhoneNumber frNumberProto = phoneUtil.parse(numberStr, "FR");
                     boolean isValid = phoneUtil.isValidNumber(frNumberProto); // returns true
                     numberStr = phoneUtil.format(frNumberProto, PhoneNumberFormat.E164);
                     to[i] = numberStr;
                     i++;
                   } catch (NumberParseException e) {
                   	  System.err.println("NumberParseException was thrown: " + e.toString());
                   }
			}
           
            
            System.out.println("LgrMailjet.sendSMS() To :"+to[0]+" To E164 : "+numberStr);
            
            JSONObject b = new JSONObject();
            b.put("charset", "UTF-8");
            b.put("coding", "7bit");
            b.put("receivers", to);
            b.put("message", new String(text.getBytes("UTF-8"), "ISO-8859-1"));
            //b.put("message",text);
            b.put("priority", "high");
            b.put("senderForResponse", true);
            String BODY = b.toString();
            
            //String BODY   = "{\"receivers\":[\"+33678373655\"],\"message\":\"Test SMS OVH\",\"priority\":\"high\",\"senderForResponse\":true}";

            long TSTAMP  = new Date().getTime()/1000;

            //Création de la signature
            String toSign    = AS + "+" + CK + "+" + METHOD + "+" + QUERY + "+" + BODY + "+" + TSTAMP;
            String signature = "$1$" + HashSHA1(toSign);
            System.out.println(signature);

            HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
            req.setRequestMethod(METHOD);
            req.setRequestProperty("Content-Type",      "application/json");
            req.setRequestProperty("X-Ovh-Application", AK);
            req.setRequestProperty("X-Ovh-Consumer",    CK);
            req.setRequestProperty("X-Ovh-Signature",   signature);
            req.setRequestProperty("X-Ovh-Timestamp",   "" + TSTAMP);

            if(!BODY.isEmpty()) {
                req.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
                wr.writeBytes(BODY);
                wr.flush();
                wr.close();
//            	req.setDoOutput(true);
//                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
////                wr.writeBytes(BODY);
////                wr.flush();
//                writer.write(BODY);
//                writer.close();
//                wr.close();
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
			r.initWithOvhJson(response.toString());
			//r.setStatus(LibConversion.integerToString(response.getStatus()));

			 System.out.println(response.toString());
			 
			 return r;

        } catch (Exception e) {
            final String errmsg = "Exception: " + e;
            e.printStackTrace();
        }
		return null;
    }

    public static String HashSHA1(String text)  {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] sha1hash = new byte[40];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
//            md.update(text.getBytes("UTF-8"), 0, text.length());
            sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (NoSuchAlgorithmException e) {
            final String errmsg = "NoSuchAlgorithmException: " + text + " " + e;
            return errmsg;
        } catch (UnsupportedEncodingException e) {
            final String errmsg = "UnsupportedEncodingException: " + text + " " + e;
            return errmsg;
        }
    }

    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    }
    
    public ReponseOvhSmsInformationService findMessageSMSInformation(String messageId) {
		ReponseOvhSmsInformationService r = null;
		
		String AK = APPLICATION_KEY;
        String AS = APPLICATION_SECRET;
        String CK = CONSUMER_KEY;

        String ServiceName = SERVICE_NAME;
        
        String METHOD = "GET";
        try {
            URL QUERY  = new URL("https://eu.api.ovh.com/1.0/sms/"+ServiceName+"/outgoing/"+messageId);
            String BODY   = "";
            
            long TSTAMP  = new Date().getTime()/1000;

            //Création de la signature
            String toSign    = AS + "+" + CK + "+" + METHOD + "+" + QUERY + "+" + BODY + "+" + TSTAMP;
            String signature = "$1$" + HashSHA1(toSign);
            System.out.println(signature);

            HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
            req.setRequestMethod(METHOD);
            req.setRequestProperty("Content-Type",      "application/json");
            req.setRequestProperty("X-Ovh-Application", AK);
            req.setRequestProperty("X-Ovh-Consumer",    CK);
            req.setRequestProperty("X-Ovh-Signature",   signature);
            req.setRequestProperty("X-Ovh-Timestamp",   "" + TSTAMP);

            if(!BODY.isEmpty())
            {
//                req.setDoOutput(true);
//                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
//                wr.writeBytes(BODY);
//                wr.flush();
//                wr.close();
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
            if ( responseCode == 200 )
            {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            }
            else
            {
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
            
            r = new ReponseOvhSmsInformationService(response.toString());
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

//Voici le type de réponse attendue :
//
//{"totalCreditsRemoved":1,"invalidReceivers":[],"ids":[27814656],"validReceivers":["+33600000000"]}
