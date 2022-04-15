package fr.legrain.lib.mail.test;

import java.io.File;

import fr.legrain.lib.mail.LgrMailjet;
import fr.legrain.lib.mail.ReponseEmailSendService;

public class TestMJ {

	public static void main(String[] args) {
		String mjApikeyPublic = "xxxxxxxxxxxxxxxxxxxxxxx";
		String mjApikeyPrivate = "xxxxxxxxxxxxxxxxxxxxxxxxx";
		LgrMailjet mj = new LgrMailjet(mjApikeyPublic, mjApikeyPrivate);
		
		String fromEmail = "xxxxxxxxxxxxxxxxx@xxxxxxxxxx.biz";
		String fromName = null;
		String subject = "test 123";
		String textPart = "test"; 
		String htmlPart = null; 
		String[] destinataires = new String[] {"xxxxxxxxxxxxxx@xxxxxxxxxxx.fr"}; 
		String[] cc = null;
		String[] bcc = null;
		File[] attachment = null; 
		String replyToEmail = null;
		
		ReponseEmailSendService r = null;
		//r = mj.send_v3_1(fromEmail, fromName, subject, textPart, htmlPart, destinataires, cc,  bcc,  attachment, replyToEmail);
		
		mj.findMessageInformation(000000000000000000000l);

	}

}
