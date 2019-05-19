import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class openBrowser {
    public static void main(String args[]){
        //open firefox
        System.setProperty("webdriver.chrome.driver", "D:\\JavaWorkspace\\WebTest\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://www.lib.sjtu.edu.cn";
        driver.get(url);
    }
}
