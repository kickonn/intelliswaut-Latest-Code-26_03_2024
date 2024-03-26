package com.suntech.intelliswaut.selenium.actions.winapp;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WindowApp {

    public static RemoteWebDriver driver = null;
    public static WiniumDriverService service = null;

    public void run(HashMap<String, Object> params) {
        try {
            String strAppPath = Get.param(params, "Application Path");
            String server = Get.param(params, "Server");
            String port = Get.param(params, "Port");
            DesiredCapabilities appCapabilities = new DesiredCapabilities();
            appCapabilities.setCapability("app", strAppPath);


            try {
                //  driver = new WindowsDriver(new URL("http://"+server+":"+port+""), appCapabilities);
                //  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
                driver = new RemoteWebDriver(new URL("http://" + server + ":" + port + ""), appCapabilities);

            } catch (Exception e) {
                Log.failed("Open Windows " + e.getMessage());
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            Log.passed("Succesfully opened the Application loacted at--> " + strAppPath);
        } catch (Exception e) {
            try {
                Log.failed("Open Windows " + e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /IM ";

    public static boolean isProcessRunging(String serviceName) throws Exception {

        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(serviceName)) {
                return true;
            }
        }

        return false;

    }

    public static void killProcess(String serviceName) throws Exception {

        Process process = Runtime.getRuntime().exec(KILL + serviceName);
        process.waitFor();
        process.destroy();

    }

}