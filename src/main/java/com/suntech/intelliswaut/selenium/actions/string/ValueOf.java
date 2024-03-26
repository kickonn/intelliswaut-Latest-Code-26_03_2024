package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

public class ValueOf {

	public String run(HashMap<String, Object> params) {
		try {
			if (params.get("Value") != null) {

				String value = params.get("Value").toString();

				Integer val = Integer.parseInt(value);

				return String.valueOf(val);
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
