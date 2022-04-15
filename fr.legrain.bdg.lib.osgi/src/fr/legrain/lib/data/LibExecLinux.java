package fr.legrain.lib.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

public class LibExecLinux {
	
	private static String cheminCmdPwgen = "/usr/bin/pwgen";
	
	public static String pwgen() {
		return pwgen(cheminCmdPwgen,"10",null);
	}
	
	public static String pwgen(String nbCaractere) {
		return pwgen(cheminCmdPwgen,nbCaractere,null);
	}
	
	public static String pwgen(String nbCaractere,String[] options) {
		return pwgen(cheminCmdPwgen,nbCaractere,null);
	}
	
	public static String pwgen(String cheminCmd, String nbCaractere, String[] options) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Map map = new HashMap();
	//		map.put("file", new File("invoice.pdf"));
			CommandLine cmdLine = new CommandLine(cheminCmd);
			cmdLine.addArgument(nbCaractere);
			
			if(options!=null && options.length>0) {
				for (String opt : options) {
					cmdLine.addArgument(opt);
				}
			}
	//		cmdLine.addArgument("${file}");
	//		cmdLine.setSubstitutionMap(map);
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(0);
			ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
			executor.setWatchdog(watchdog);
		
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
			executor.setStreamHandler(streamHandler);
			int exitValue = executor.execute(cmdLine);
		    return (outputStream.toString().trim());
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
