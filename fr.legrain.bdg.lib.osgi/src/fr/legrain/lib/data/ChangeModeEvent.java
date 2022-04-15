package fr.legrain.lib.data;

import java.util.EventObject;

public class ChangeModeEvent extends EventObject {
	
	private EnumModeObjet ancienMode = null;
	private EnumModeObjet nouveauMode = null;
	
	public ChangeModeEvent(Object source) {
		super(source);
	}
	
	public ChangeModeEvent(Object source, EnumModeObjet nouveauMode) {
		super(source);
		this.nouveauMode = nouveauMode; 
	}
	
	public ChangeModeEvent(Object source, EnumModeObjet nouveauMode, EnumModeObjet ancienMode) {
		super(source);
		this.nouveauMode = nouveauMode;
		this.ancienMode = ancienMode;
	}

	public EnumModeObjet getAncienMode() {
		return ancienMode;
	}

	public void setAncienMode(EnumModeObjet ancienMode) {
		this.ancienMode = ancienMode;
	}

	public EnumModeObjet getNouveauMode() {
		return nouveauMode;
	}

	public void setNouveauMode(EnumModeObjet nouveauMode) {
		this.nouveauMode = nouveauMode;
	}
	
}
