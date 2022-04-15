package fr.legrain.lib.data;

import java.io.Serializable;

import javax.swing.event.EventListenerList;

/**
 * <p>Title: </p>
 * <p>Description: Etat de l'objet gérant la base de données.</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Le Grain SA</p>
 * @author Le Grain SA
 * @version 1.0
 */

public class ModeObjet implements Serializable {
	
	private static final long serialVersionUID = -5858140865269168370L;

	//static public enum EnumModeObjet {C_MO_CONSULTATION,C_MO_EDITION,C_MO_INSERTION,C_MO_IMPORTATION,C_MO_ERREUR,C_MO_SUPPRESSION};
	protected EventListenerList listenerList = new EventListenerList();
	
//	public static final int C_MO_CONSULTATION = 0; //MoConsultation
//	public static final int C_MO_EDITION      = 1; //MoEdition
//	public static final int C_MO_INSERTION    = 2; //MoInsertion
//	public static final int C_MO_IMPORTATION  = 3; //MoImportation
//	public static final int C_MO_ERREUR       = 4; //MoErreur
//	public static final int C_MO_SUPPRESSION  = 5; //MoSuppression
	
	protected EnumModeObjet mode = EnumModeObjet.C_MO_CONSULTATION;	
	public ModeObjet() {}
	
	public ModeObjet(EnumModeObjet mode) {
		this.mode = mode;
	}
	
	public String modeString(EnumModeObjet mode) {
		String modeString = "";
		switch (mode) {
			case C_MO_CONSULTATION : modeString = "C_MO_CONSULTATION"; break;
			case C_MO_EDITION : modeString = "C_MO_EDITION"; break;
			case C_MO_INSERTION : modeString = "C_MO_INSERTION"; break;
			case C_MO_IMPORTATION : modeString = "C_MO_IMPORTATION"; break;
			case C_MO_ERREUR : modeString = "C_MO_ERREUR"; break;
			case C_MO_SUPPRESSION : modeString = "C_MO_SUPPRESSION"; break;
			default:
				modeString = null; break; //Mode objet inconnue
		}
		return modeString;
	}
	
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
	
	protected void fireChangementMode(ChangeModeEvent evt) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChangeModeListener.class) {
				if (evt == null)
					evt = new ChangeModeEvent(this);
				( (ChangeModeListener) listeners[i + 1]).changementMode(evt);
			}
		}
	}
	
	public void addChangeModeListener(ChangeModeListener l) {
		listenerList.add(ChangeModeListener.class, l);
	}
	
	public void removeChangeModeListener(ChangeModeListener l) {
		listenerList.remove(ChangeModeListener.class, l);
	}
	
	public EnumModeObjet getMode() {
		return mode;
	}

	public void destroy(){		
		mode = null;
	}
}
