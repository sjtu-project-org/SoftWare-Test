import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class openBrowser {
    public static void main(String args[]){
        //open chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://www.lib.sjtu.edu.cn";
        //get method
        driver.get(url);

        //getTitle()
        String title = driver.getTitle();

        //getCurrentUrl()
        String curentUrl = driver.getCurrentUrl();

        //navigate method
        //driver.navigate().to(url);

        //quit & close
        //driver.quit();
    }
}
