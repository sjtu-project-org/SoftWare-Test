import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class openBrowser {
    public static void main(String args[]) throws IOException {
        GUITest test = new GUITest();
        //test.TestInput();
        test.TestShotScreen();
        //test.TestCheckBox();
        //test.TestUpload();
        test.TestCheckBoxFunc();
        //open chrome
        //System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //String url = "http://www.lib.sjtu.edu.cn";
        //String url = "http://www.baidu.com";
        //driver.get(url);
        //test input field
        //WebElement e1 = driver.findElement(By.name("wd"));
        //e1.sendKeys("Test");
        //String v = e1.getAttribute("value");
        //System.out.printf("get value:%s\n", v);
        //test popup dialogs
        //Alert alert =

        //get()
        //driver.get(url);

        //navigate()
        //driver.navigate().to(url);

        //getTitle()
        //String title = driver.getTitle();

        //getCurrentUrl()
        //String currentUrl = driver.getCurrentUrl();
        //System.out.printf("title: %s\nurl:%s\n", title, currentUrl);

        //findByX()
        //WebElement e0 = driver.findElement(By.id("isMainPage"));
        //WebElement e1 = driver.findElement(By.name("wd"));
        //e1.sendKeys("Test");
        //e1.clear();
        //String v = e1.getAttribute("value");
        //List<WebElement> e2 = driver.findElements(By.className("module-link"));

        /*
        <div id=“food”>
          <span class=“dairy”>milk</span>
          <span class=“dairy aged”>cheese</span>
        </div>
        */
        //WebElement e3 =driver.findElement(By.cssSelector("#food span.dairy.aged"));

        /*
        <ahref="http://www.google.com/search?q=cheese">cheese</a>>
        */
        //WebElement cheese  = driver.findElement(By.linkText("cheese"));

        //quit & close
        //driver.quit();
    }
}
