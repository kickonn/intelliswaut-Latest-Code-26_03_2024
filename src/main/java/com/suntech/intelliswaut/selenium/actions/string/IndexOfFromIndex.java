package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class IndexOfFromIndex {


	public int run(HashMap<String, Object>params) throws Exception {
		try {
			
			String text1 = Get.param(params,"Text");
			String Character = Get.param(params,"Character");
			String Index = Get.param(params,"Index");

			if(text1.equals("")||Character.equals("")||Index.equals("")){
				Log.error("IndexOfFromIndex Action , Paramter Text,Character or Index cant be null");
				return -1;
			}			
			Integer i=Integer.parseInt(Index);
			return text1.indexOf(Character,i);		
		} catch (Exception e) {
			Log.error("Exception caught in IndexOfFromIndex Action, Message is " + e.getMessage());
			throw e;
		}

	}

}
