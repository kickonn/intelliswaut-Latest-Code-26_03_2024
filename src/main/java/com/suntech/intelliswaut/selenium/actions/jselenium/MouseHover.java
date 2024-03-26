package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {


    public void run(HashMap<String, Object> params) throws Exception {
        try {
            Wait.waitForElement(params);
            WebElement element = Elements.find(params, Browser.Driver);

            if (Browser.Driver != null) {

//				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//
//				JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
//				js.executeScript(mouseOverScript,element);

                new Actions(Browser.Driver).moveToElement(element).build().perform();

            }
        } catch (Exception e) {
            Log.failed("Exception caught in MouseHover Action " + e.getMessage());
            throw e;
        }
    }
}
