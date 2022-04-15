package fr.legrain.lib.data;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.groovy.runtime.typehandling.BigDecimalMath;

public class InfosJours {

	private String nomCourt;
	private String nomLong;
	private Integer index;
	private String codeJour;
	private String codeMois;
	private String codeAnnee;
	private String codeMoisAnnee;
	private String codeJourMoisAnnee;
	private Date dateDuJour;
	private BigDecimal montant = BigDecimal.ZERO;

	public Date getDateDuJour() {
		return dateDuJour;
	}
	public void setDateDuJour(Date dateDuJour) {
		this.dateDuJour = dateDuJour;
	}
	public String getCodeJourMoisAnnee() {
		return codeJourMoisAnnee;
	}
	public void setCodeJourMoisAnnee(String codeJourMoisAnnee) {
		this.codeJourMoisAnnee = codeJourMoisAnnee;
	}

	public String getNomCourt() {
		return nomCourt;
	}
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}
	public String getNomLong() {
		return nomLong;
	}
	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getCodeMoisAnnee() {
		return codeMoisAnnee;
	}
	public void setCodeMoisAnnee(String codeMoisAnnee) {
		this.codeMoisAnnee = codeMoisAnnee;
	}
	public String getCodeJour() {
		return codeJour;
	}
	public void setCodeJour(String codeJour) {
		this.codeJour = codeJour;
	}
	public String getCodeMois() {
		return codeMois;
	}
	public void setCodeMois(String codeMois) {
		this.codeMois = codeMois;
	}
	public String getCodeAnnee() {
		return codeAnnee;
	}
	public void setCodeAnnee(String codeAnnee) {
		this.codeAnnee = codeAnnee;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

}
