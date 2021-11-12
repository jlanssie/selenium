import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
 
public class SeleniumTest {
        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
                //System.setProperty("webdriver.chrome.whitelistedIps", "");
                
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("--no-sandbox");
 
                WebDriver driver = new ChromeDriver(chromeOptions);

                driver.get("https://www.jeremylanssiers.com");
 
                //Thread.sleep(1000);

                if (driver.getPageSource().contains("Jeremy")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }
                driver.quit();
        }
}