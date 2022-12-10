package loantester.com.Bai10_AnnotationTestNG;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCMS extends BaseTest {

//    @BeforeMethod
//    public void beforeMethodChild(){
//        System.out.println("beforeMethodChild");
//    }

    @Test(priority =2, description = "login CMS Test")
    public void testLoginCMS() throws InterruptedException {
        System.out.println("Run testAnhTesterBlog");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);

    }
    @Test (priority = 1, description = "Check Blog on Anh Tester")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

//    @AfterMethod
//    public void afterMethodChild(){
//        System.out.println("afterMethodChild");
//    }
}
