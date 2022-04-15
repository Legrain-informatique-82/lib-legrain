package fr.legrain.lib.mail;

public class ReponseEmailSendService {
	
	private String reponseTxt;
	private String messageID;
	private String status;
	private String statusCode;
	private String data;
	private boolean erreur = false;;

	public String getReponseTxt() {
		return reponseTxt;
	}

	public void setReponseTxt(String reponseTxt) {
		this.reponseTxt = reponseTxt;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isErreur() {
		return erreur;
	}

	public void setErreur(boolean erreur) {
		this.erreur = erreur;
	}
	
}
