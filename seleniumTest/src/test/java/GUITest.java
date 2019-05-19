import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

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


    public void TestCheckBox() {
        WebElement regexElm = driver.findElement(By.xpath("//a[@title='在线正则表达式测试']"));
        assertEquals(regexElm.getAttribute("href"), "http://www.toolfk.com/tool-online-regex");
        regexElm.click();
        List<WebElement> checkBoxList = driver.findElements(By.className("regex-flag"));
        // select all checkbox
        for (WebElement e : checkBoxList) {
            if (!e.isSelected()) {
                e.click();
            }
        }
        // assert checkbox selected
        for (WebElement e : checkBoxList) {
            assertEquals(e.isSelected(), true);
        }
        // sleep 2s
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        // unselect all check box
        for (WebElement e: checkBoxList) {
            e.click();
        }
        // assert not selected
        for (WebElement e: checkBoxList) {
            assertEquals(e.isSelected(), false);
        }
        //driver.switchTo().defaultContent();
    }

    public void TestDropDownBox() {
        // get select box
        WebElement showSelectElm = driver.findElement(By.className("layui-edge"));
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(showSelectElm));
        showSelectElm.click();
        Select selectTool = new Select(driver.findElement(By.name("modules")));
        // select and jump
        //selectTool.selectByValue("/tool-online-manual");
        selectTool.selectByVisibleText("在线it在线电子教程");
        assertEquals(driver.getCurrentUrl(), "https://www.toolfk.com/tool-online-manual");
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
