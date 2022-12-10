package loantester.com.Bai15_Waits;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Learn_Wait extends BaseTest {
    @Test(priority = 1)
    public void ExplicitWaitDemo01(){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
        
    }


}
