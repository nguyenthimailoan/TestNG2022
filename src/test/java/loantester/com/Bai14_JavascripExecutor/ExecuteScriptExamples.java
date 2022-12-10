package loantester.com.Bai14_JavascripExecutor;

import loantester.com.Common.BaseTest;
import loantester.com.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExecuteScriptExamples extends BaseTest {

    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommergce/users/loin");
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")).click();

        //Click object với JavascriptExecitor (cách 2 dùng javascriptExecutor)
        JavascriptExecutor js =(JavascriptExecutor) driver; // khai báo và khởi tạo giá trị cho đối tượng
       js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")));
//
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        WebUI.sleep(2);

        //Điền giá trị vào cái input cách 1:
//      js.executeScript("document.getElementById('email').setAttribute('value','customer@example.com');");
//        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        //Điền giá trị vào cái input cách 2:
     //   js.executeScript("arguments[0].setAttribute('value','123456');",driver.findElement(By.xpath("//input[@id='password']")));
     //   driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Điền giá trị vào cái input cách 3:
//        js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement(By.xpath("//input[@id='email']")),"customer@example.com");
//        js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement(By.xpath("//input[@id='password']")),"123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

      // cuộn chuột
        WebElement buttonupgradePackage = driver.findElement(By.xpath("//a[normalize-space()='Upgrade Package']"));

        js.executeScript("arguments[0].scrollIntoView(false);", buttonupgradePackage);

        WebUI.sleep(2);
    }

    @Test
    public void testScript02() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        JavascriptExecutor js =(JavascriptExecutor) driver; // khai báo và khởi tạo giá trị cho đối tượng
        WebUI.sleep(2);
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();


        // js.executeScript("alert('Welcome To Anh Tester-loan');");

     //   String innerText = js.executeScript("arguments[0].innerText",driver.findElement(By.xpath(""))

        js.executeScript("history.go(0)");

        System.out.println(js.executeScript("return window.innerHeight;").toString());
        System.out.println(js.executeScript("return window.innerWidth;").toString());

        //Hightlight phần tử trên web
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")));

        ////input[@id='email']
        js.executeScript("arguments[0].style.border='3px solid blue'", driver.findElement(By.xpath("//input[@id='email']")));

        WebUI.sleep(2);

        // chụp màn hình
        // Tạo tham chiếu của TakesScreenshot với driver hiện tại
        TakesScreenshot ts = (TakesScreenshot) driver;
// Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
//Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
        File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
// result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
       try {
           FileHandler.copy(source, new File("./Screenshots/screenshot.png"));
           System.out.println("Screenshot taken");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
        System.out.println("Screenshot taken");




    }
}
