package loantester.com.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
   public WebDriver driver;
    @BeforeTest
    public void createDriver() {
        //WebDriverManager.chromedriver().setup();
        System.out.println("Start Chrome browser from BaseTest1");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với tgian 10s
       // chờ đợi trang load xong (trong 40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }


    @AfterTest
    public void closeBrowser() {
        System.out.println("close Chrome browser from BaseTest1");
        driver.quit();
    }
}
