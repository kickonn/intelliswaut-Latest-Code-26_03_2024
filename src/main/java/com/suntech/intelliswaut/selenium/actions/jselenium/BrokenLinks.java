package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class BrokenLinks {
	public void run(HashMap<String, Object> params) throws Exception{		
			params.put("ID Type", "Tag Name");
			params.put("ID", "a");
			List<WebElement> element = Elements.findAll(params, Browser.Driver);					
			element.stream().filter(Objects::nonNull)
            .map(s -> s.getAttribute("href"))
            .distinct()
            .filter(Objects::nonNull)
            .forEach(t -> {
				try {
					connection(t);
				} catch (Exception e) {
					Log.fail("Exception occured while validating broken links "+e.getMessage());
				}
			});
	}
	
	
	public void connection(String url) throws Exception {
	    HttpURLConnection huc;
	    int respCode = 0;
	    try {
	        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
	            public X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }

	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }

	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }};

	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        huc = (HttpURLConnection) (new URL(url).openConnection());
	        huc.setRequestMethod("HEAD");

	        huc.connect();

	        respCode = huc.getResponseCode();

	        if (respCode >= 400 && respCode != 401  ) {
	        	Log.fail(url + " is a broken link");
	       } else {
	           Log.info(url + " is a valid link");
	       }

	    } catch (NoSuchAlgorithmException | KeyManagementException | IOException e) {
	        e.printStackTrace();
	    }

	}

}
