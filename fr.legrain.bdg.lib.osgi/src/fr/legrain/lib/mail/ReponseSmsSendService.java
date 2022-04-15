package fr.legrain.lib.mail;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.legrain.lib.data.LibConversion;

public class ReponseSmsSendService {
	
	private String reponseTxt;
	private String messageID;
	private String status;
	private String statusCode;
	private String data;
	private boolean erreur = false;
	
	
	public void initWithMailjetJson(String mailjetJson) {
		//{"ID":"3da1cbef-651c-46d7-9cbb-51c24532bae8","From":"LGR","To":"+33678373655","Status":{"Code":1,"Name":"sent_pending","Description":"Message is being sent"},
		//"Cost":{"Value":0.04,"Currency":"EUR"},"CreationTS":1528730809,"Text":"azerty  rf","SmsCount":1}
		//this.mailjetJson = mailjetJson;
		//JSONArray o = new JSONArray(mailjetJson);
		JSONObject o = new JSONObject(mailjetJson);
		//status = o.getJSONObject(0).getJSONArray("Data").getJSONObject(0).getString("Status");
		messageID = o.getString("ID");
		JSONObject statusObject = o.getJSONObject("Status");
		String statusCode = LibConversion.integerToString(statusObject.getInt("Code"));
		Map<String, String> mStatus = new HashMap<>();
		mStatus.put("1", "MJ-Envoi en cours");
		mStatus.put("2", "MJ-Envoyé");
//		mStatus.put("spam", "MJ-spam");
//		mStatus.put("open", "MJ-ouvert");
//		mStatus.put("queued", "MJ-file d'attente");
		if(statusCode!=null && !statusCode.equals("") && mStatus.get(statusCode)!=null) {
			status = mStatus.get(statusCode);
		} else {
			status = statusObject.getString("Name");
		}
		
		if(!statusCode.equals("1")
				&& !(statusCode.equals("2"))) {
			erreur = true;
		}
//		toEmail = o.getJSONObject(0).getString("ToEmail");
//		sent = o.getJSONObject(0).getBoolean("Sent");
//		open = o.getJSONObject(0).getBoolean("Open");
//		spam = o.getJSONObject(0).getBoolean("Spam");
		System.out.println("ReponseSmsSendService.ReponseInformationService()");
	}
	
	public void initWithOvhJson(String ovhJson) {
		//{"totalCreditsRemoved":1,"invalidReceivers":[],"ids":[27814656],"validReceivers":["+33600000000"]}
		//JSONArray o = new JSONArray(mailjetJson);
		JSONObject o = new JSONObject(ovhJson);
		//status = o.getJSONObject(0).getJSONArray("Data").getJSONObject(0).getString("Status");
		if(o.has("ids") && o.getJSONArray("ids").length()>0) {
			messageID = LibConversion.integerToString((Integer)(o.getJSONArray("ids").get(0)));
//			JSONObject statusObject = o.getJSONObject("Status");
	//		String statusCode = LibConversion.integerToString(statusObject.getInt("Code"));
	//		Map<String, String> mStatus = new HashMap<>();
	//		mStatus.put("1", "MJ-Envoi en cours");
	//		mStatus.put("2", "MJ-Envoyé");
	////		mStatus.put("spam", "MJ-spam");
	////		mStatus.put("open", "MJ-ouvert");
	////		mStatus.put("queued", "MJ-file d'attente");
	//		if(statusCode!=null && !statusCode.equals("") && mStatus.get(statusCode)!=null) {
	//			status = mStatus.get(statusCode);
	//		} else {
	//			status = statusObject.getString("Name");
	//		}

			erreur = false;
		} else {
			erreur = true;
		}

		System.out.println("ReponseSmsSendService.ReponseInformationService()");
	}

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
