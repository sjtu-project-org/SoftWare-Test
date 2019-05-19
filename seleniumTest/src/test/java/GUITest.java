import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

import java.util.List;

public class GUITest {
    private WebDriver driver;
    private String url = "http://www.toolfk.com/";
    public GUITest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void TestInput(){
        WebElement e1 = driver.findElement(By.name("wd"));
        e1.sendKeys("Test");
        String v = e1.getAttribute("value");
        System.out.printf("get value:%s\n", v);
    }

    public void TestPPopupDialogs(){
        List<WebElement> es = driver.findElements(By.className("app"));
    }
    public static void main(String args[]){

    }
}
