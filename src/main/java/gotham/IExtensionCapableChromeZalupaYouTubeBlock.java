package gotham;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;


public interface IExtensionCapableChromeZalupaYouTubeBlock {
String EXT_PATH_FILENAME = "4.3.1_0.crx";
String CHROMEDRIVER_FILENAME = "chromedriver";



    default void setChromedriverPath(){
        URL fileUrl = this.getClass()
                .getClassLoader().getResource(CHROMEDRIVER_FILENAME);
        assert fileUrl != null;
        String filePath = fileUrl.getPath();

        System.setProperty("webdriver.chrome.driver", filePath);
    }

    default WebDriver initDriver(){
        setChromedriverPath();

        URL fileUrl = this.getClass()
                .getClassLoader().getResource(EXT_PATH_FILENAME);
        assert fileUrl != null;
        String filePath = fileUrl.getPath();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(filePath));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        return driver;
    }
}
