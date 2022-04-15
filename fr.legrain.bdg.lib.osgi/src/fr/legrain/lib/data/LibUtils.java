package fr.legrain.lib.data;

public class LibUtils {

	
	  public static final boolean equalsWithNulls(Object a, Object b) {
		    if (a==b) return true;
		    if(a==null && b!=null)return false;
		    if(a!=null && b==null)return false;
		    if ((a==null)&&(b==null)) return true;
		    return a.equals(b);
		  }
}
