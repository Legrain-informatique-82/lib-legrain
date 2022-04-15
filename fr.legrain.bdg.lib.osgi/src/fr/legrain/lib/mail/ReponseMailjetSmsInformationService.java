package fr.legrain.lib.mail;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.legrain.lib.data.LibConversion;

public class ReponseMailjetSmsInformationService {
	
	private String json;
	
	private String arrivalTs;	//"2018-06-06T09:30:43Z"
	private Boolean blocked;
	private Boolean bounce;
	private String bounceDate;
	private String bounceReason;
	private Long campaignID; 	//5984024554
	private Boolean click;
	private Integer cntRecipients; //1
	private String complaintDate;
	private Long contactID;	//1689829865
	private String details;
	private String fBLSource;
    private Long messageID; //70368744378462260
	private Boolean open;
	private Boolean queued;
	private Boolean sent;
	private Boolean spam;
	private Boolean statePermanent;
	private String status;
	private String toEmail;
	private Boolean unsub;
	
	/*
	"Data":[
	    {
	      "From": "MJPilot",
	      "To":"+33600000000",
	      "Status": {
	        "Code": 2,
	        "Name": "sent",
	        "Description": "Message sent"
	      },
	      "MessageId":"744ecf8c-9fed-4ec9-acd0-9b326671f5df",
	      "CreationTS": 1033552800,
	      "SentTS": 1033552802,
	      "SMSCount":1,
	      "Cost": {
	        "Value": 0.04,
	        "Currency": "EUR"
	      }
	    }
	  ]
	 */
	public ReponseMailjetSmsInformationService(String json) {
		this.json = json;
		JSONObject o = new JSONObject(json);
		//status = o.getJSONObject(0).getJSONArray("Data").getJSONObject(0).getString("Status");
//		JSONArray data = o.getJSONArray("Data");
		JSONObject statusObject = o.getJSONObject("Status");
		String statusCode = LibConversion.integerToString(statusObject.getInt("Code"));
		Map<String, String> mStatus = new HashMap<>();
		mStatus.put("1", "MJ-Envoi en cours");
		mStatus.put("2", "MJ-Envoyé");
		mStatus.put("3", "MJ-Délivré");
//		mStatus.put("spam", "MJ-spam");
//		mStatus.put("open", "MJ-ouvert");
//		mStatus.put("queued", "MJ-file d'attente");
		if(statusCode!=null && !statusCode.equals("") && mStatus.get(statusCode)!=null) {
			status = mStatus.get(statusCode);
		} else {
			status = statusObject.getString("Name");
		}
		
//		if(!statusCode.equals("1")
//				&& !(statusCode.equals("2"))) {
//			erreur = true;
//		}
		System.out.println("ReponseMailjetEmailInformationService.ReponseInformationService()");
	}
	
	public String getArrivalTs() {
		return arrivalTs;
	}
	public void setArrivalTs(String arrivalTs) {
		this.arrivalTs = arrivalTs;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	public Boolean getBounce() {
		return bounce;
	}
	public void setBounce(Boolean bounce) {
		this.bounce = bounce;
	}
	public String getBounceDate() {
		return bounceDate;
	}
	public void setBounceDate(String bounceDate) {
		this.bounceDate = bounceDate;
	}
	public String getBounceReason() {
		return bounceReason;
	}
	public void setBounceReason(String bounceReason) {
		this.bounceReason = bounceReason;
	}
	public Long getCampaignID() {
		return campaignID;
	}
	public void setCampaignID(Long campaignID) {
		this.campaignID = campaignID;
	}
	public Boolean getClick() {
		return click;
	}
	public void setClick(Boolean click) {
		this.click = click;
	}
	public Integer getCntRecipients() {
		return cntRecipients;
	}
	public void setCntRecipients(Integer cntRecipients) {
		this.cntRecipients = cntRecipients;
	}
	public String getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}
	public Long getContactID() {
		return contactID;
	}
	public void setContactID(Long contactID) {
		this.contactID = contactID;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getfBLSource() {
		return fBLSource;
	}
	public void setfBLSource(String fBLSource) {
		this.fBLSource = fBLSource;
	}
	public Long getMessageID() {
		return messageID;
	}
	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getQueued() {
		return queued;
	}
	public void setQueued(Boolean queued) {
		this.queued = queued;
	}
	public Boolean getSent() {
		return sent;
	}
	public void setSent(Boolean sent) {
		this.sent = sent;
	}
	public Boolean getSpam() {
		return spam;
	}
	public void setSpam(Boolean spam) {
		this.spam = spam;
	}
	public Boolean getStatePermanent() {
		return statePermanent;
	}
	public void setStatePermanent(Boolean statePermanent) {
		this.statePermanent = statePermanent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public Boolean getUnsub() {
		return unsub;
	}
	public void setUnsub(Boolean unsub) {
		this.unsub = unsub;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}


	
}
