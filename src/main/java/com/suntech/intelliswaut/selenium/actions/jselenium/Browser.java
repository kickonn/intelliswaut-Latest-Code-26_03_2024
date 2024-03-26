package com.suntech.intelliswaut.selenium.actions.jselenium;


import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Browser {

	public static WebDriver Driver = null;
	public static String MainWinHandle = null;

	public void run(HashMap<String, Object> params) throws Exception {

		String os = System.getProperty("os.name");
		String execEnv = Get.param(params, "Execution Environment").toLowerCase().trim();
		System.out.println("execEnv in open browser :::::::::::: " + execEnv);
		String browser = Get.param(params, "BrowserType").toLowerCase().trim();
		System.out.println("Browser in open browser :::::::::::: " + browser);
		if(execEnv.equals("")){
			execEnv = "desktop";
		}
		if(browser.equals("")){
			browser = "chrome";
		}
		try{
			switch(execEnv){
			case "desktop":
				switch(browser){
				case "chrome":
					try {
						WebDriverManager.chromedriver().setup();
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

						Driver = new ChromeDriver(chromeOptions);


						WebDriverManager.firefoxdriver().setup();
						FirefoxOptions options = new FirefoxOptions();
						Driver = new FirefoxDriver(options);
					} catch (Exception e) {
						Log.failed("Exception caught while launching browser "+e.getMessage());
					}
					break;

				case "internet explorer":
					try {
						WebDriverManager.iedriver().setup();
						InternetExplorerOptions options = new InternetExplorerOptions();
						options.destructivelyEnsureCleanSession();
						options.ignoreZoomSettings();
						options.introduceFlakinessByIgnoringSecurityDomains();
						options.setCapability("silent", true);
						Driver = new InternetExplorerDriver(options);
					} catch (Exception e) {
						Log.failed("Exception caught while launching browser "+e.getMessage());
						throw e;
					}
					break;

				case "firefox":
					try {
						WebDriverManager.firefoxdriver().setup();
						FirefoxOptions options = new FirefoxOptions();
						Driver = new FirefoxDriver(options);
					} catch (Exception e) {
						Log.failed("Exception caught while launching browser "+e.getMessage());
						throw e;
					}
					break;

				case "edge":
					try {
						WebDriverManager.edgedriver().setup();
						EdgeOptions options = new EdgeOptions();
						Driver= new EdgeDriver(options);
					} catch (Exception e) {
						Log.failed("Exception caught while launching browser "+e.getMessage());
						throw e;
					}
					break;

				default:
					try {
//						WebDriverManager.chromedriver().setup();
//						ChromeOptions chromeOptions = new ChromeOptions();
//						chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//						Driver = new ChromeDriver(chromeOptions);
//

						WebDriverManager.firefoxdriver().setup();
						FirefoxOptions options = new FirefoxOptions();
						Driver = new FirefoxDriver(options);
					} catch (Exception e) {
						Log.failed("Exception caught while launching browser "+e.getMessage());
						throw e;
					}
					break;
				}
				break;
			case "browserstack":
				try{
					final String USERNAME = Get.Global("Cloud Username");
					final String AUTOMATE_KEY = Get.Global("Cloud Access Key");
					final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
					DesiredCapabilities caps = new DesiredCapabilities();

					caps.setCapability("os", Get.Global("Cloud OS"));
					caps.setCapability("os_version", Get.Global("Cloud OS Version"));
					caps.setCapability("browser", Get.Global("Cloud Browser"));
					caps.setCapability("browser_version", Get.Global("Cloud Browser Version"));
					caps.setCapability("name", "IntelliSWAUT Testing");
					Driver = new RemoteWebDriver(new URL(URL), caps);
				}catch(Exception e){
					Log.failed("Exception caught while launching browser in browser stack "+e.getMessage());
					throw e;
				}
				break;
			case "saucelabs":
				try{
					final String USERNAME = Get.Global("Cloud Username");
					final String AUTOMATE_KEY = Get.Global("Cloud Access Key");
					String sauceURL = "https://ondemand.saucelabs.com/wd/hub";

					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("username", USERNAME);
					capabilities.setCapability("accessKey", AUTOMATE_KEY);
					capabilities.setCapability("browserName", Get.Global("Cloud Browser"));
					capabilities.setCapability("platform", Get.Global("Cloud OS"));
					capabilities.setCapability("version", Get.Global("Cloud OS Version"));
					capabilities.setCapability("build", "IntelliSWAUT Testing");
					capabilities.setCapability("name", "IntelliSWAUT");
					Driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
				}catch(Exception e){
					Log.failed("Exception caught while launching browser in browser stack "+e.getMessage());
					throw e;
				}
				break;
			}

			String url = Get.param(params, "URL");
			System.out.println("url in open browser :::::::::::: " + url);

			if (url == "") {
				Log.failed("URL is empty, please pass the valid url");
			}else{
				if (url.startsWith("http://")
						|| url.startsWith("https://")) {
					Driver.get(url);
					Driver.manage().window().maximize();
				} else {
					Driver.get("http://" + url);
					Driver.manage().window().maximize();
				}
			}
			Log.info("Launched the browser successfully with URL : "+url);
			Log.setConfig(browser, url);
			Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}catch(Exception e) {
			Log.failed("Exception caught while Opening the browser, Message is "+e.getMessage());

		}
	}

}
