package fr.legrain.bdg.lib.osgi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface CodeToCheck {
	public String rapporteur();
	public  String detail();
	public String attribution();
	public String ticket();
}

