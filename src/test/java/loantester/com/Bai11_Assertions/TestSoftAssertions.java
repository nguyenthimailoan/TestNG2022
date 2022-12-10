package loantester.com.Bai11_Assertions;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssertions extends BaseTest {
    @Test
    public void testSoftAssert() {
        driver.get("https://rise.fairsketch.com/signin");

        String headerSignInPage = driver.findElement(By.xpath("//h2[normalize-space()='Sign in']")).getText();

        SoftAssert softAssert = new SoftAssert();  // KHỞI TẠO BẮT BUỘC
        softAssert.assertEquals(headerSignInPage, "Sign in 123", "Header Sign In page chưa đúng");

        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        WebElement menuClient = driver.findElement(By.xpath("//span[normalize-space()='Clients']"));
        softAssert.assertTrue(menuClient.isDisplayed(), "Menu Client Không hiển thị.");

        menuClient.click();

        WebElement headerTotalClient = driver.findElement(By.xpath("//span[normalize-space()='Total clients']"));
        softAssert.assertTrue(headerTotalClient.isEnabled(), "Header Total Client không được bật");
        softAssert.assertEquals(headerTotalClient.getText(), "Selenium", "Content of  Total header Client not match");

        //Cuối cùng của SoftAssert là phải dùng hàm assertAll() để chốt xác nhận các soft bên trên
        softAssert.assertAll();  //TỔNG KẾT CÁC ASSERT BÊN TRÊN => bắt buộc khai báo


    }
}
