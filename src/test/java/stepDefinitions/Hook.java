package stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.PropertiesReader;

import java.io.IOException;


public class Hook {
    static public WebDriver driver;


    @Before
    static public void setUp() throws IOException {

            String path = "";
            if (System.getProperty("os.name").contains("Windows"))
                path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("chromeDriverWin");
            System.setProperty("webdriver.chrome.driver", path);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                    "--disable-dev-shm-usage", "--no-sandbox", "--remote-debugging-port=9922");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

    }


    @After
    static public void quit() {
        driver.quit();
    }

}
