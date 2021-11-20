import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;

import org.testng.Assert;
import org.testng.annotations.*;
 
public class TestNGTest {
        public static WebDriver driver;
        public static Logger logger = Logger.getLogger("org.openqa.selenium");

        @BeforeTest
        public void setDriver() throws IOException, InterruptedException {
                // Selenium logging
                logger.setLevel(Level.OFF);

                // Chrome options
                System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
                //System.setProperty("webdriver.chrome.whitelistedIps", "");
                System.setProperty("webdriver.chrome.silentOutput", "true");

                // Chrome driver service options
                DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
                ChromeDriverService chromeDriverService = serviceBuilder.build();
                chromeDriverService.sendOutputTo(new FileOutputStream("/dev/null", true));
                
                // Chrome driver options
                ChromeOptions chromeDriverOptions = new ChromeOptions();
                chromeDriverOptions.setHeadless(true);
                //chromeDriverOptions.addArguments("--no-sandbox");
 
                // Init Chrome driver
                driver = new ChromeDriver(chromeDriverService, chromeDriverOptions);
        }

        @Test (priority=1) 
        public void getUrl() {
                // Chrome driver gets url
                driver.get("https://www.jeremylanssiers.com");
        }

        @Test (priority=2) 
        public void urlContainsString() {
                // Chrome driver loads page source code and checks if it contains a string
                driver.getPageSource().contains("Jeremy");
        }

        @AfterTest 
        public void killDriver() {
                // Kill Chrome driver
               driver.quit(); 
        }
}