package loantester.com.Bai11_Assertions;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssert extends BaseTest {
    @Test(priority = 1)
    public void TestAssertEquals() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester - Automation Testing";

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle,"tiêu đề trang chưa đúng");

        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Log in']")).getText().trim(),"LOG IN" ,"Text not Login");

        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Log in']")).getText().trim().equals("LOG IN"),"Text not login");
        System.out.println("Hello Automation class");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester - Automation Testing";

        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Tiêu đề không chứa" +expectedTitle);
        System.out.println("làm gì đó....");


//        if(actualTitle.equals("Anh Tester 123") == true){
//            System.out.println("làm gì đó...");
//            System.out.println("làm gì đó...");
//            System.out.println("làm gì đó...");
//        }
//        System.out.println(actualTitle);
    }
}
