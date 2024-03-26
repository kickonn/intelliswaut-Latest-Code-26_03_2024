package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

public class Get {

	public static String Global(String key){
		try{
//			String value = redwood.launcher.Launcher.variables.get(key);
//			if(value ==null){
//				return "";
//			}
//			return (String)value;
			return "";
		}catch(Exception e){
			return "";
		}
	}
	
	public static String param(HashMap<String, Object> params,String key){
		try{
			Object value = params.get(key);
			if(value ==null){
				return "";
			}
			return (String)value;
		}catch(Exception e){
			return "";
		}
	}
}
