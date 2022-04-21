import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;
 
public class SeleniumTest {
        public String url = "https://www.jeremylanssiers.com";

        public static void main(String[] args) throws IOException, InterruptedException {
                // Selenium logging
                java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

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
                WebDriver driver = new ChromeDriver(chromeDriverService, chromeDriverOptions);

                // Run Chrome driver
                driver.get("https://www.google.be/");
 
                //Thread.sleep(1000);

                if (driver.getPageSource().contains("google")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }

                // Kill Chrome driver
                driver.quit();
        }
}