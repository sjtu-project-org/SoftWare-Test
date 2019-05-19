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
    public void TestButton(){
        WebElement e1 = driver.findElement(By.xpath(".//a[@title='在线进制转换']"));
        e1.click();
    }
    public void TestSingleRadio(){
    	WebElement e1 = driver.findElement(By.xpath(".//a[@title='在线进制转换']"));
        e1.click();
        WebElement e2 = driver.findElement(By.xpath(".//input[@id='hex_8']"));
        e2.click();
    }
    public static void main(String args[]){

    }
}
