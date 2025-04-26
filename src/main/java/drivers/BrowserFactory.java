
package com.SprintDemo.drivers;;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class BrowserFactory {
    public static WebDriver getBrowser(String BrowserName) {
        switch (BrowserName.toLowerCase()) {
            case ("chrome"):
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                options.addArguments("--incognito");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-notifications");
                Map<String, Object> prefs = Map.of("profile.default_content_setting_values.notification", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(options);

            case ("firefox"):
                FirefoxOptions Foptions = new FirefoxOptions();
                //Foptions.addArguments("--headless");
                Foptions.addArguments("--incognito");
                Foptions.addArguments("--disable-extensions");
                Foptions.addArguments("--no-sandbox");
                Foptions.addArguments("--start-maximized");
                Foptions.addArguments("--disable-infobars");
                Foptions.addArguments("--disable-notifications");
                Foptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                Foptions.setAcceptInsecureCerts(true);
                return new FirefoxDriver(Foptions);
            default:

                EdgeOptions Edgeoptions = new EdgeOptions();
                //    Edgeoptions.addArguments("--headless");
                Edgeoptions.addArguments("--incognito");
                Edgeoptions.addArguments("--disable-extensions");
                Edgeoptions.addArguments("--no-sandbox");
                Edgeoptions.addArguments("--start-maximized");
                Edgeoptions.addArguments("--disable-infobars");
                Edgeoptions.addArguments("--disable-notifications");
                Map<String, Object> Egeprefs = Map.of("profile.default_content_setting_values.notification", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);
                Edgeoptions.setExperimentalOption("Egeprefs", Egeprefs);
                Edgeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new EdgeDriver(Edgeoptions);

        }

    }
}

