package fr.legrain.lib.data;

// Generated 20 mars 2007 09:51:19 by Hibernate Tools 3.2.0.b9


/**
 * https://stackoverflow.com/questions/9811114/why-do-enum-permissions-often-have-0-1-2-4-values
 */
public class IHMEtat extends ModelObject {

	
	public static int insertion=1<<2; //4
	public static int edition=1<<3; //8
	public static int suppression=1<<4; //16
	public static int enregistrer=1<<5; //32
	public static int integre=1<<6; //64
	public static int multiple=1<<7; //128
	
	public IHMEtat() {
	}
	
	



}
