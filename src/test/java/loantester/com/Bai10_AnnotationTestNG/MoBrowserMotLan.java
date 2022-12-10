package loantester.com.Bai10_AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MoBrowserMotLan {

    //BeforeTest hoặc @BeforeClass
    WebDriver driver;

    @BeforeClass
    public void createDriver() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @Test (priority = 1)
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

//    @Test
//    public void testGoogleSearch() throws InterruptedException {
//        driver.get("https://www.google.com/");
//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("anhtester", Keys.ENTER);
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester - Automation Testing']")).click();
//        Thread.sleep(2000);
//    }

    @Test (priority = 2)
    public void testAnhTesterLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText());
        Thread.sleep(2000);
}

    //AfterTest hoặc @AfterClass
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
