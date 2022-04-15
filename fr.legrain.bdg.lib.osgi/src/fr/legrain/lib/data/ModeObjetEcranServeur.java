package fr.legrain.lib.data;


/**
 * <p>Title: </p>
 * <p>Description: Etat de l'objet gérant la base de données.</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Le Grain SA</p>
 * @author Le Grain SA
 * @version 1.0
 */

public class ModeObjetEcranServeur extends ModeObjet {
	
	private static final long serialVersionUID = -6087899855659103651L;

	public void setMode(EnumModeObjet mode) {
		if (this.mode!=mode){
			this.mode = mode;
			switch (mode) {
			case C_MO_CONSULTATION :
			case C_MO_EDITION :  
			case C_MO_INSERTION :
				break;
			default:
				break;
			}
		}	  
		fireChangementMode(new ChangeModeEvent(this,getMode(),mode));
	}
	
	public void destroy(){		
		super.destroy();
	}
	
	public boolean dataSetEnModif() {
		if(getMode()==EnumModeObjet.C_MO_EDITION
				|| getMode()==EnumModeObjet.C_MO_IMPORTATION
				|| getMode()==EnumModeObjet.C_MO_INSERTION)
			return true;
		else
			return false;
	}
	
	public boolean dataSetEnModeModification() {
		if(getMode()==EnumModeObjet.C_MO_EDITION)
			return true;
		else
			return false;
	}
	
	public boolean dataSetEnModeConsultation() {
		if(getMode()==EnumModeObjet.C_MO_CONSULTATION)
			return true;
		else
			return false;
	}
	
	public boolean dataSetEnInsertion() {
		if(getMode()==EnumModeObjet.C_MO_INSERTION)
			return true;
		else
			return false;
	}
	
}
