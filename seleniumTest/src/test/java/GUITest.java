import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.*;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.List;

public class GUITest {
    private WebDriver driver;
    private String url = "http://www.toolfk.com/";

    public GUITest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void back2Default() {
        driver.navigate().to(url);
    }

    public void TestInput(){
        WebElement regexElm = driver.findElement(By.xpath("//a[@title='在线短网址生成']"));
        regexElm.click();
        //find input area
        WebElement input = driver.findElement(By.name("url"));
        //clear old value
        input.clear();
        //fill it with new content
        input.sendKeys("www.baidu.com");
        //check valid
        assertEquals(input.getAttribute("value"), "www.baidu.com");
    }

    public void TestShotScreen() throws IOException {
        try {
            //wait for loading web successful
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        //get show screen
        File screenShotFile = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        //save as relative path
        FileUtils.copyFile(screenShotFile, new File("./test.png"));
        //check valid
        assertEquals(new File("test.png").exists(), true);
    }


    public void TestCheckBoxShow()throws IOException {
        WebElement regexElm = driver.findElement(By.xpath("//a[@title='在线正则表达式测试']"));
        //assertEquals(regexElm.getAttribute("href"), "http://www.toolfk.com/tool-online-regex");
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
    }

    public void TestCheckBoxFunc()throws IOException {
        driver.findElement(By.xpath("//a[@title='在线正则表达式测试']")).click();
        driver.findElement(By.linkText("匹配中文")).click();
        List<WebElement> checkBoxList = driver.findElements(By.className("regex-flag"));
        WebElement allCheckBox = checkBoxList.get(0);
        // default, regex match all Chinese Text, should be 8 result
        WebElement resultCount = driver.findElement(By.id("result_count"));
        assertEquals(resultCount.getText(), "8");

        // change check box, match all -> match one line
        allCheckBox.click();
        // regex match one line, should be 1 result
        assertEquals(resultCount.getText(),"1");
    }

    public void TestDropDownBox() throws IOException{
        /*
        // get select box
        WebElement showSelectElm = driver.findElement(By.name("modules"));
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(showSelectElm));
        showSelectElm.click();
        Select selectTool = new Select(driver.findElement(By.name("modules")));
        // select and jump
        //selectTool.selectByValue("/tool-online-manual");
        selectTool.selectByVisibleText("在线it在线电子教程");
        assertEquals(driver.getCurrentUrl(), "https://www.toolfk.com/tool-online-manual");
         */
        // switch to tool-password-generator
        driver.findElement(By.xpath(".//a[@title='在线随机密码生成']")).click();
        // init Select, select pwd length 9 and verify
        Select selectTool = new Select(driver.findElement(By.id("pgLength")));
        List<WebElement> optionElms = selectTool.getAllSelectedOptions();

        // "Copy" length
        int childLen = "copy".length();
        // selecteBy value
        selectTool.selectByValue("9");
        WebElement pwdGenButton = driver.findElement(By.className("generate-password"));
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(pwdGenButton));
        pwdGenButton.click();
        WebElement pwdBlock = driver.findElement(By.className("layui-input-block"));
        // note getText also get the childNode test "Copy",
        // so the text length is 4 longer than pws
        assertEquals(pwdBlock.getText().length(), 9+childLen);

        // selectBy Index
        selectTool.selectByIndex(10);
        pwdGenButton.click();
        // TODO: seems getAllSelectedOptions not right
        // TODO: seems pwdBlock cannot be reused
        //assertEquals(driver.findElement(By.className("layui-input-block")).getText().length(), optionElms.get(10).getText().length()+"copy".length());
        assertEquals(driver.findElement(By.className("layui-input-block")).getText().length(), 18+childLen);

        // selectBy visible text
        selectTool.selectByVisibleText("15");
        pwdGenButton.click();
        assertEquals(driver.findElement(By.className("layui-input-block")).getText().length(), 15+childLen);
    }


    public void TestButton(){
        WebElement e1 = driver.findElement(By.xpath(".//a[@title='在线进制转换']"));
        e1.click();
    }

    public void TestSingleRadio()throws IOException{
    	WebElement e1 = driver.findElement(By.xpath(".//a[@title='在线进制转换']"));
        e1.click();
        WebElement e2 = driver.findElement(By.xpath(".//input[@id='hex_8']"));
        e2.click();
    }

    public void TestUpload()throws IOException{
    	driver.findElement(By.xpath(".//a[@title='在线PDF转图片']")).click();
    	WebElement adFileUpload = driver.findElement(By.id("pdf"));
    	//get project's root path
        File directory = new File("");
        String FilePath = directory.getCanonicalPath();
        //add relative path
        FilePath = FilePath + "\\src\\test\\java\\testfile\\test.pdf";
        //upload
    	adFileUpload.sendKeys(FilePath);
    	//check valid
    	assertEquals(driver.findElement(By.id("pdfName")).getText().length(), 8);
    }
}
