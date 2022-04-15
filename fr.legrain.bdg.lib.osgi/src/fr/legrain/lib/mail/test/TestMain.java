package fr.legrain.lib.mail.test;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSendEmail testSendEmail = new TestSendEmail();
		testSendEmail.actSendMail("zhaolin@lgrser.lgr");
		testSendEmail.actSendMail("nicolas@lgrser.lgr");
	}

}
