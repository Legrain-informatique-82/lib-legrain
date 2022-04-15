package fr.legrain.lib.mail.test;

import fr.legrain.lib.mail.MailUtil;


public class TestJavaMail {
	public void testPOP() {
		MailUtil m = new MailUtil();
		String serveurPOP = "mail.xxxxxxx.fr";
		String popUser = "xxxxx";
		String popUserPassword = "xxxxx";

		m.popMailReader(serveurPOP,popUser,popUserPassword,true);
	}
	
	public void testSMTP() {
		MailUtil m = new MailUtil();
		String serveurSMTP = "smtp.xxxxxxx.fr";
		String from = "xxxxxxxxxx@legrain.fr";
		String to = "xxxxxxxxx@legrain.fr";
		String sujet = "sujet";
		String texte = "texte";
		
		try {
			m.smtpMailSender(serveurSMTP, from, to, sujet, texte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
