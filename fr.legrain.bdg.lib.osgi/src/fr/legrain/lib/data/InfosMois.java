package fr.legrain.lib.data;

import java.math.BigDecimal;
import java.util.Date;

public class InfosMois {
	private String nomCourt;
	private String nomLong;
	private Integer index;
	private String codeMoisAnnee;
	private String codeMoisAnnee1Annee2;
	private String annee;
	private String mois;
	private Date premierJourMois;
	private Date dernierJourMois;
	private BigDecimal montant;
	
	
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
	public Date getPremierJourMois() {
		return premierJourMois;
	}
	public void setPremierJourMois(Date premierJourMois) {
		this.premierJourMois = premierJourMois;
	}
	public Date getDernierJourMois() {
		return dernierJourMois;
	}
	public void setDernierJourMois(Date dernierJourMois) {
		this.dernierJourMois = dernierJourMois;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	public String getCodeMoisAnnee1Annee2() {
		return codeMoisAnnee1Annee2;
	}
	public void setCodeMoisAnnee1Annee2(String codeMoisAnnee1Annee2) {
		this.codeMoisAnnee1Annee2 = codeMoisAnnee1Annee2;
	}

}
