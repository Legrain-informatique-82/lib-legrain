package fr.legrain.validator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;
//import org.hibernate.mapping.Property;


import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import fr.legrain.lib.data.EnumModeObjet;
import fr.legrain.lib.data.ExceptLgr;
import fr.legrain.lib.data.MessCtrlLgr;
import fr.legrain.lib.data.ModeObjet;
import fr.legrain.lib.ejb.EJBLookup;

//public class LgrHibernateValidator implements Validator<LgrHibernateValidated>, PropertyConstraint {
public class LgrHibernateValidator implements ConstraintValidator<LgrHibernateValidated, Object> {
	
	static Logger logger = Logger.getLogger(LgrHibernateValidator.class);
	
	private static final String VALIDATION_CLIENT_PLUGIN_ID = "fr.legrain.bdg.lib.client.rcp.osgi";

	private String champBd;
	private String champEntite;
	private String table;
	private Class<?> clazz;
	private ICtrlLgr ctrl;
	
	public ICtrlLgr getICtrlLgr() {
		ICtrlLgr ctrlLgr = null;
		String validatorServerClass = "fr.legrain.validator.JPACtrl_Application";
		String validatorClientClass = "fr.legrain.lib.validator.JPACtrl_ApplicationClient";
		try {
			//return new JPACtrl_Application();
			Class c = Class.forName(validatorServerClass);
			ctrlLgr = (ICtrlLgr) c.newInstance();
			ICtrlLgr reg = null;
			try {
//				ICtrlLgr reg = (ICtrlLgr) new InitialContext().lookup("java:comp/ICtrlLgr");
				reg = new EJBLookup<ICtrlLgr>().doLookup(new InitialContext(),EJBLookup.EJB_NAME_CTRL_APPLICATION, ICtrlLgr.class.getName());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			//reg.setModeServeur(true);
			return reg;
		} catch(ClassNotFoundException e) {
			logger.info("Validator serveur ("+validatorServerClass+") introuvable dans le classpath => mode client");
			System.out.println("Validator serveur ("+validatorServerClass+") introuvable dans le classpath => mode client");
			Class c;
			try {
				Bundle b = getBundle(FrameworkUtil.getBundle(getClass()).getBundleContext(),VALIDATION_CLIENT_PLUGIN_ID);
//				c = Class.forName(validatorClientClass,true,);
				c = b.loadClass(validatorClientClass);
				ctrlLgr = (ICtrlLgr) c.newInstance();
				return ctrlLgr;
			} catch (ClassNotFoundException e1) {
				logger.info("Validator client ("+validatorClientClass+") introuvable dans le classpath => pas de validation");
				System.out.println("Validator client ("+validatorClientClass+") introuvable dans le classpath => pas de validation");
			} catch (InstantiationException e1) {
				logger.error("",e);
			} catch (IllegalAccessException e1) {
				logger.error("",e);
			}
		} catch (InstantiationException e) {
			logger.error("",e);
		} catch (IllegalAccessException e) {
			logger.error("",e);
		}
		return null;
	}
	
	private Bundle getBundle(BundleContext bundleContext, String symbolicName) {
	    Bundle result = null;
	    for (Bundle candidate : bundleContext.getBundles()) {
	        if (candidate.getSymbolicName().equals(symbolicName)) {
	            if (result == null || result.getVersion().compareTo(candidate.getVersion()) < 0) {
	                result = candidate;
	            }
	        }
	    }
	    return result;
	}

//	part of the Validator<Annotation> contract,
//	allows to get and use the annotation values
	public void initialize(LgrHibernateValidated parameters) {
		champBd = parameters.champBd();
		table = parameters.table();
		clazz = parameters.clazz();
		champEntite = parameters.champEntite();
		ctrl = getICtrlLgr();
	}

//	part of the property constraint contract
	@Override
	public boolean isValid(Object value,ConstraintValidatorContext arg1) {
		boolean valid = true;

		if(ctrl!=null) {
			System.out.println("Validate appellé automatiquement à partir des Beans Validation et annotation : "+champEntite);
			MessCtrlLgr mess = new MessCtrlLgr();
			mess.setNomChampEntite(champEntite);
			mess.setNomChampBd(champBd);
			mess.setNomTable(table);
			mess.setEntityClass(clazz);
			ModeObjet m = new ModeObjet();
			m.setMode(EnumModeObjet.C_MO_EDITION);
			mess.setModeObjet(m);
			if(value!=null) {
				mess.setValeur(value.toString());
			}
			try {
				ctrl.ctrlSaisie(mess);
			} catch (ExceptLgr e) {
				logger.error("",e);
				arg1.disableDefaultConstraintViolation();
				arg1.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
				valid = false;
			}
		}
		
		return valid;
	}

}        