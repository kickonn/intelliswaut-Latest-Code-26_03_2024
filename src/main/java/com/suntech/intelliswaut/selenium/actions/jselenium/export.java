package com.suntech.intelliswaut.selenium.actions.jselenium;

import com.suntech.intelliswaut.selenium.actions.reports.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class export {
    public void run(HashMap<String, Object> params) throws Exception {
        try {
            String elemName =  Get.param(params, "File Name");
        } catch (Exception e) {
            Log.failed("Exception caught while clicking on element " + e.getMessage());
            throw e;
        }
    }
}
