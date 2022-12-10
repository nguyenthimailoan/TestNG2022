package loantester.com.Bai13_Alert_Popup_iFarme;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleFrame extends BaseTest {

    @Test
    public void iFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(8000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(7000);
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(5000);
    }

}
