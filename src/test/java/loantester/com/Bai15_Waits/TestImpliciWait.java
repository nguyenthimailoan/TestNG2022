package loantester.com.Bai15_Waits;

import loantester.com.Common.BaseTest;
import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestImpliciWait extends BaseTest {

    @Test
    public void loginCRM(){

       // chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với tgian 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        WebUI.sleep(2);
    }

    @Test
    public void loginHRM(){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.xpath("//button[contains(.,'Super Admin')]")).click();

        driver.findElement(By.xpath("//span[contains(.,'Login')]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();
        WebUI.sleep(2);
    }

}
