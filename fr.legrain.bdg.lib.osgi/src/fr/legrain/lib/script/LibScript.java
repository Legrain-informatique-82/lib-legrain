package fr.legrain.lib.script;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/* JSR-233 */
public class LibScript {
	
	/*
	 http://www.w3schools.com/jsref/jsref_obj_math.asp
	 https://szyzygycode.wordpress.com/2010/03/03/embedding-jython-script-in-java-with-scriptengine/
	 http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
	 */
	
	static public int SCRIPT_RUBY = 1;
	static public int SCRIPT_PYTHON = 2;
	static public int SCRIPT_GROOVY = 3;
	static public int SCRIPT_JAVASCRIPT = 4;
	
	public Object evalScript(String script, int langage) throws ScriptException {
		Object retour = null;
		switch (langage) {
		case 1:
			retour = ruby(script);
			break;
		case 2:
			retour = python(script);
			break;
		case 3:
			retour = groovy(script);
			break;
		case 4:
			retour = javaScript(script);
			break;
		default:
			System.out.println("Type de script inconnu "+langage+" javaScript par défaut");
			retour = javaScript(script);
			break;
		}
		return retour;
	}
	
	public List<String> findAllScriptEngine() {
		ScriptEngineManager mgr = new ScriptEngineManager();
		List<String> l = new ArrayList<String>();
		for (ScriptEngineFactory sef : mgr.getEngineFactories()) {
			l.add(sef.getEngineName()+" - "+sef.getLanguageVersion());
		}
		return l;
	}
	
	public Object javaScript(String scriptJs) throws ScriptException{
		/* JSR-233 */
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    System.out.println(engine.getFactory().getEngineName()+" - "+engine.getFactory().getLanguageVersion());
//	    scriptJs = "2+1";
	    Object res = null;
//	    try {
	    	System.out.println("Script : "+scriptJs);
	    	res = engine.eval(scriptJs);
	    	
			System.out.println("Résultat du script : "+res.toString());
			
//		} catch (ScriptException e) {
//			throw new Exception(e);
//		}
	    return res;
	}
	
	public Object python(String scriptPython) {
		/* JSR-233 */
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("jython");
	    System.out.println(engine.getFactory().getEngineName()+" - "+engine.getFactory().getLanguageVersion());
//	    scriptPython = "2+1";
	    Object res = null;
	    try {
	    	System.out.println(scriptPython);
	    	res = engine.eval(scriptPython);
	    	
			System.out.println("Résultat du script : "+res.toString());
			
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	    return res;
	}
	
	public Object ruby(String scriptRuby) {
		/* JSR-233 */
		//https://github.com/jruby/jruby/wiki/RedBridge
		ScriptEngineManager mgr = new ScriptEngineManager();
		//mgr.registerEngineName("jruby", new JRubyEngineFactory());
	    ScriptEngine engine = mgr.getEngineByName("jruby");
	    System.out.println(engine.getFactory().getEngineName()+" - "+engine.getFactory().getLanguageVersion());
//	    scriptRuby = "2+1";
	    Object res = null;
	    try {
	    	System.out.println(scriptRuby);
	    	res = engine.eval(scriptRuby);
	    	
			System.out.println("Résultat du script : "+res.toString());
			
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	    return res;
	}
	
	public Object groovy(String scriptGroovy) {
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("groovy");
	    System.out.println(engine.getFactory().getEngineName()+" - "+engine.getFactory().getLanguageVersion());
//	    scriptPython = "2+1";
	    Object res = null;
	    try {
	    	System.out.println(scriptGroovy);
	    	res = engine.eval(scriptGroovy);
	    	
			System.out.println(res.toString());
			
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	    return res;
	}

}
