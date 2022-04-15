package fr.legrain.validator;

import javax.ejb.Local;
import javax.ejb.Remote;

import fr.legrain.lib.data.ExceptLgr;
import fr.legrain.lib.data.MessCtrlLgr;

@Local
public interface ICtrlLgr {
	
	public void ctrlSaisie(MessCtrlLgr message) throws ExceptLgr;
	
	public boolean isModeServeur();
	public void setModeServeur(boolean modeServeur);

}
