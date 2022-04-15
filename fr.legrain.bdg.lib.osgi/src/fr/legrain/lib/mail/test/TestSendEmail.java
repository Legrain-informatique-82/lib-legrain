package fr.legrain.lib.mail.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestSendEmail {

	public void actSendMail(String adresse) {
		if(Desktop.isDesktopSupported() && 
				Desktop.getDesktop().isSupported(java.awt.Desktop.Action.MAIL)) {
			/*
			 * Definition du format de l'uri mailto
			 * http://www.ietf.org/rfc/rfc2368.txt
			 */
			File file =new File("/home/lee/Bureau/testFindMyKey.odt");

			URI uriFile = file.toURI();
			URI u = null;
			try {
//				String uriString = "mailto:test@test.com?subject=Test&cc=test@test.com&bcc=test@test.com"
//					+"&attachment="+"\""+file.getAbsolutePath()+"\"" // IGNORED
//					+"&body=Test";
				String uriString = "mailto:"+adresse
					+"?attachment="+uriFile.toString();
//					+"&body=Test";
//				u = new URI("mailto:"+adresse/*+"?subject=current-issue"+&body=aaa"*/);
				//u = new URI("mailto:"+adresse+"?subject=current-issue"/*+&body=aaa"*/);
				//u = new URI("mailto",adresse,null);
			
				u = new URI(uriString);
				Desktop.getDesktop().mail(u);
				
//				 Message mail = new Message();
//			      mail.setAttachments(attachments);
//			      mail.setBody("Voici une pièce jointe.");
//			      mail.setSubject(file.getName());
//			      mail.setToAddrs(tos);
			      
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
