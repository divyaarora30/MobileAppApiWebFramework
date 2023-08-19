package com.qa.mobileUtils;

import com.qa.apiUtils.PropertiesFileManager;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();


        try {
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android":

                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesFileManager.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", PropertiesFileManager.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", PropertiesFileManager.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());

                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
