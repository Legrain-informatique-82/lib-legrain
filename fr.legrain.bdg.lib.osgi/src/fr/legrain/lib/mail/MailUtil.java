package fr.legrain.lib.mail;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;


public class MailUtil {

	static Logger logger = Logger.getLogger(MailUtil.class.getName());

//	/**
//	 * Récupération de mail de mise à jour
//	 * @param host - serveur POP
//	 * @param user - nom d'utilisateur
//	 * @param password - mot de passe
//	 * @param delete - vrai ssi les messages doivent etre supprimer apres reception
//	 * @return - liste contenant les mails de MAJ ou null si aucun mail n'est trouvé
//	 */
//	public List<MailUpdate> findMailUpdate(String host, String user, String password, boolean delete) {
//		List<MailUpdate> result = null;
//		Message messages[] = popMailReader(host, user, password, delete);
//		if(messages.length>0) {
//			result = new LinkedList<MailUpdate>();
//			for (int i=0, n=messages.length; i<n; i++) {
//				result.add(new MailUpdate(messages[i]));
//			}
//		}
//		return result;
//	}

	/**
	 * Récupération des emails par le protocole POP
	 * @param host - serveur POP
	 * @param user - nom d'utilisateur
	 * @param password - mot de passe
	 * @param delete - vrai ssi les messages doivent etre supprimer apres reception
	 */
	public Message[] popMailReader(String host, String user, String password, boolean delete) {		
		String PROTOCOL_STORE = "pop3";
		String POP_FOLDER = "INBOX";
		Message messages[] = null;

		try {
			Properties props = new Properties();
			/** zhaolin 21/05/210**/
//			props.setProperty("mail.pop3.disabletop", "true");
			//Creation/récupération de la session
			Session session = Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			//session.setDebugOut(System.out);

			//Connexion au serveur mail
			Store store = session.getStore(PROTOCOL_STORE);
			store.connect(host, user, password);

			//Connexion à la "Boite de réception" 
			Folder folder = store.getFolder(POP_FOLDER);
			folder.open(Folder.READ_WRITE);

			//Verification des messages
			messages = folder.getMessages();

			//Traitement des messages
			if(messages.length>0) {
				logger.info("De nouveaux messages sont disponibles");

				for (int i=0, n=messages.length; i<n; i++) {
					System.out.println(i + ": " + messages[i].getFrom()[0] + "\t" + messages[i].getSubject());
					if(delete)
						messages[i].setFlag(Flags.Flag.DELETED, true);
					//message[i].writeTo(System.out);
					System.out.println(messages[i].getContent());
				}
			}

			//Deconnexion
			folder.close(true);
			store.close();

			return messages;

		} catch (NoSuchProviderException e) {
			logger.error(e);
		} catch (MessagingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return messages;
	}

	/**
	 * 
	 * @param host - serveur smtp
	 * @param from - adresse de l'expediteur
	 * @param to - adresse du destinataire
	 * @param subject - sujet
	 * @param text - corps
	 */
	public void smtpMailSender(String host, String from, String to, String subject, String text) throws Exception {

//		try {
			//Get system properties
//		PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//		.getShell().setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_WAIT));
			Properties props = System.getProperties();

			//Setup mail server
			props.put("mail.smtp.host", host);

			//Get session
			Session session = Session.getDefaultInstance(props, null);

			//Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);

			//Send message
			Transport.send(message);
//			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//			.getShell().setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_ARROW));
			
//		} catch (NoSuchProviderException e) {
//			logger.error(e);
//		} catch (MessagingException e) {
//			logger.error(e);
//		}
	}

	/**
	 * 
	 * @param host
	 * @param user
	 * @param password
	 * @param ssl
	 * @param from
	 * @param to
	 * @param subject
	 * @param text
	 * @param fileAttachments
	 */
	public void smtpMailSender(String host,final String user,final String password, boolean ssl, String from, String to, String subject, String text, String[] fileAttachments)throws Exception {

//		try {
//		PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//		.getShell().setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_WAIT));

			//Get system properties
			Properties props = System.getProperties();

			//Setup mail server
			props.put("mail.smtp.host", host);
			if(ssl) {
				props.put("mail.smtp.auth", "true");
			}

			//Get session
			Session session = null;
			if(user!=null && password!=null && !user.equals("") && !password.equals("")) {
				session = Session.getDefaultInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
			} else {
				session = Session.getDefaultInstance(props, null);
			}
			session.setDebug(true);


			//Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			//message.setText(text);

			// Create the message part 
			BodyPart messageBodyPart = new MimeBodyPart();
			MimeBodyPart attachedFilePart;

			// Fill the message
			messageBodyPart.setText(text);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Attached Files
			for (int i=0; i < fileAttachments.length; i++) {
				if(fileAttachments[i]!=null){
				attachedFilePart = new MimeBodyPart();
				FileDataSource source = new FileDataSource(fileAttachments[i]);
				attachedFilePart.attachFile(fileAttachments[i]);
				attachedFilePart.setFileName(source.getName());
				multipart.addBodyPart(attachedFilePart);
				}
			}

			// Put parts in message
			message.setContent(multipart);

			// Send the message
			Transport.send(message);
//			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//			.getShell().setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_ARROW));
			
//		} catch (NoSuchProviderException e) {
//			logger.error(e);
//		} catch (MessagingException e) {
//			logger.error(e);
//		} catch (Exception e) {
//			logger.error(e);
//		}
	}

	/**
	 * Envoie d'un email sans authentification
	 * @param host
	 * @param from
	 * @param to
	 * @param subject
	 * @param text
	 * @param fileAttachments
	 */
	public void smtpMailSender(String host, String from, String to, String subject, String text, String[] fileAttachments) throws Exception {
		smtpMailSender(host,null,null, false, from, to, subject, text, fileAttachments);
	}

	/** zhaolin 21/05/2010 **/
	
	public Message[] imapMailReader(String host, String user, String password, boolean delete) {
		Message messages[] = null;
		
		return messages;
	}
}
