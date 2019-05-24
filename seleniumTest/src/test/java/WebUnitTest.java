import junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class WebUnitTest {
    GUITest test;

    @BeforeClass
    public void setUp() throws Exception {
        test = new GUITest();
    }
    @After
    public void revert(){
    }

    @Test
    public void TestInput() throws IOException {
        test.TestInput();
    }

    @Test
    public void TestShotScreen() throws IOException{
        test.TestShotScreen();
    }

    @Test
    public void TestCheckBoxShow() throws IOException{
        test.TestCheckBoxShow();
    }

    @Test
    public void TestUpload() throws IOException{
        test.TestUpload();
    }

    @Test
    public void TestCheckBoxFunc() throws IOException{
        test.TestCheckBoxFunc();
    }

    @Test
    public void TestDropDownBox() throws IOException{
        test.TestDropDownBox();
    }

    @Test
    public void TestButton() throws IOException{
        test.TestButton();
    }

    @Test
    public void TestSingleRadio() throws IOException {
        test.TestSingleRadio();
    }

    public void main(){

    }
}
