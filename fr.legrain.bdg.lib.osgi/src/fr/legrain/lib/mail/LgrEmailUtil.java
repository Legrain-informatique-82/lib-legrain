package fr.legrain.lib.mail;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import fr.legrain.lib.data.LibCrypto;
import fr.legrain.lib.mail.MailUtil;


public class LgrEmailUtil {

/*
 * http://commons.apache.org/proper/commons-email/userguide.html
 * https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 */
	
	private String smtpHostName; //smtp.googlemail.com
	private int smtpPort = 465; //25 classique ou 465 ssl ou 25 avec STARTTLS
	private boolean ssl = false;
	private String login;
	private String password;

	/**
	 * 
	 * @param smtpHostName - serveur SMTP hote
	 * @param smtpPort - port du serveur SMTP
	 * @param ssl - activé le SSL
	 * @param login - login de connexion au serveur SMTP
	 * @param password - mot de passe de connexion au serveur SMTP
	 */
	public LgrEmailUtil(String smtpHostName, int smtpPort, boolean ssl, String login, String password) {
		this.smtpHostName = smtpHostName;
		this.smtpPort = smtpPort;
		this.ssl = ssl;
		this.login = login;
		this.password = password;
	}
	
	/**
	 * Envoi d'un email simple (message texte)
	 * @param subject - sujet du mail
	 * @param msgTxt - message/corps de l'email
	 * @param fromEmail - adresse email de l'expediteur
	 * @param fromName - nom de l'expediteur
	 * @param toEmailandName - tableau d'adresse et de nom des destinataires [email][nom]
	 */
	public void sendEmail(String subject, String msgTxt, String fromEmail, String fromName, String[][] toEmailandName) {
		MailUtil m =new MailUtil();

		try {
			Email email = new SimpleEmail();
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			email.setDebug(true);
			email.setHostName(smtpHostName);
			email.setSmtpPort(smtpPort);
			email.setAuthenticator(new DefaultAuthenticator(login, password));
			email.setSSLOnConnect(true);
			if(fromName!=null) {
				email.setFrom(fromEmail,fromName);
			} else {
				email.setFrom(fromEmail);
			}
			email.setSubject(subject);
			email.setMsg(msgTxt);
			
			for (String[] strings : toEmailandName) {
				if(strings[1]!=null) {
					email.addTo(strings[0],strings[1]);
				} else {
					email.addTo(strings[0]);
				}
			}
			
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ReponseEmailSendService send(String fromEmail, String fromName, String subject, String textPart, String htmlPart,
			String[] destinataires, String[] cc, String[] bcc, File[] attachments, String replyToEmail) {
		// Create the attachment
		ReponseEmailSendService r = null;		
				try {	

					// Create the email message
					MultiPartEmail email = new MultiPartEmail();
					email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
					email.setDebug(true);
					email.setHostName(smtpHostName);
					email.setSmtpPort(smtpPort);
					email.setAuthenticator(new DefaultAuthenticator(login, password));
					email.setSSLOnConnect(true);
					
					if(fromName!=null) {
						email.setFrom(fromEmail,fromName);
					} else {
						email.setFrom(fromEmail);
					}
					
					email.setSubject(subject);
					email.setMsg(textPart);
					
					if(replyToEmail!=null && !replyToEmail.equals("")) {
						email.addReplyTo(replyToEmail);
					}
					
					for (String d : destinataires) {
						email.addTo(d);
					}
					
					for (String c : cc) {
						email.addCc(c);
					}
					
					for (String bc : bcc) {
						email.addBcc(bc);
					}

					// add the attachment
					String attachmentPath = null;
					String attachmentURL = null;
					EmailAttachment attachment = null;
					for (File file : attachments) {
						attachment = new EmailAttachment();
//						if(attachmentPath!=null) {
							//envoi d'un fichier local
							attachment.setPath(file.getAbsolutePath());
//						} else {
							//télécharge le fichier correspondant à l'url et envoi
//							attachment.setURL(new URL(attachmentURL));
//						}
						attachment.setDisposition(EmailAttachment.ATTACHMENT);
						//attachment.setDescription(attachmentDescription);
						attachment.setName(file.getName());
						
						email.attach(attachment);
					}
					
					r = new ReponseEmailSendService();
					String s = email.send();
					r.setReponseTxt(s);
					
					return r;
				} catch (EmailException e) {
					e.printStackTrace();
//				} catch (MalformedURLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
				return null;
	}

	public void sendEmailAttachement(String subject, String msgTxt, String fromEmail, String fromName, String[][] toEmailandName,
			String attachmentPath, String attachmentURL, String attachmentDescription, String attachmentName) {
		try {
			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			if(attachmentPath!=null) {
				//envoi d'un fichier local
				attachment.setPath(attachmentPath);
			} else {
				//télécharge le fichier correspondant à l'url et envoi
				attachment.setURL(new URL(attachmentURL));
			}
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription(attachmentDescription);
			attachment.setName(attachmentName);
			

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName(smtpHostName);
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			
			if(fromName!=null) {
				email.setFrom(fromEmail,fromName);
			} else {
				email.setFrom(fromEmail);
			}
			email.setSubject(subject);
			email.setMsg(msgTxt);
			
			for (String[] strings : toEmailandName) {
				if(strings[1]!=null) {
					email.addTo(strings[0],strings[1]);
				} else {
					email.addTo(strings[0]);
				}
			}

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void sendEmailHTML(String subject, String msgTxt, String fromEmail, String fromName, String[][] toEmailandName) {
		try {
			// Create the email message
			HtmlEmail email = new HtmlEmail();
			email.setHostName(smtpHostName);
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			if(fromName!=null) {
				email.setFrom(fromEmail,fromName);
			} else {
				email.setFrom(fromEmail);
			}
			email.setSubject(subject);
			email.setMsg(msgTxt);
			
			for (String[] strings : toEmailandName) {
				if(strings[1]!=null) {
					email.addTo(strings[0],strings[1]);
				} else {
					email.addTo(strings[0]);
				}
			}

			// embed the image and get the content id
			URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			String cid = email.embed(url, "Apache logo");

			// set the html message
			email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

			// set the alternative message
			email.setTextMsg(msgTxt);

			// send the email
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendEmailHTMLDynmicEmbeddedImage(String subject,String msgHTML, String msgTxt, String fromEmail, String fromName, String[][] toEmailandName) {
		try {
			// load your HTML email template
//			String htmlEmailTemplate = ".... <img src=\"http://www.apache.org/images/feather.gif\"> ....";
			String htmlEmailTemplate = msgHTML;

			// define you base URL to resolve relative resource locations
			URL url = new URL("http://www.apache.org");

			// create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName(smtpHostName);
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			
			if(fromName!=null) {
				email.setFrom(fromEmail,fromName);
			} else {
				email.setFrom(fromEmail);
			}
			email.setSubject(subject);
			email.setMsg(msgTxt);
			
			for (String[] strings : toEmailandName) {
				if(strings[1]!=null) {
					email.addTo(strings[0],strings[1]);
				} else {
					email.addTo(strings[0]);
				}
			}

			// set the html message
			email.setHtmlMsg(htmlEmailTemplate);

			// set the alternative message
			email.setTextMsg(msgTxt);

			// send the email
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
