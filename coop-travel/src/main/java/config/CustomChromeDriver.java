package config;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class CustomChromeDriver {

    private final ChromeDriver chromeDriver;

    public CustomChromeDriver() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);

        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);

        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

//        options.addArguments("enable-automation");
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        chromeDriver = new ChromeDriver(options);

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    public ChromeDriver getChromeDriver(){
        return chromeDriver;
    }

}
