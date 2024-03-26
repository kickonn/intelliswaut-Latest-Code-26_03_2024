package com.suntech.intelliswaut.selenium.actions.jselenium;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class SwitchToRequiredWindowBasedOnIndex
{
    public void run(HashMap<String, Integer> params) throws Exception {
        try {
            ArrayList<String> tabs = new ArrayList<>(Browser.Driver.getWindowHandles());
            Browser.Driver.switchTo().window(tabs.get(params.get("index")));

        } catch (Exception e) {
            Log.failed("Exception caught in NavigateToParentWindow Action " + e.getMessage());
            throw e;
        }
    }
}

