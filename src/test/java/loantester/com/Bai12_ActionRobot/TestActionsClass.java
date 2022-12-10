package loantester.com.Bai12_ActionRobot;

import loantester.com.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionsClass extends BaseTest {

    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").build().perform();

        WebElement titleResult = driver.findElement(By.xpath("//h3[.='[Selenium Java] Bài 4: Cài đặt môi trường Selenium với Java']"));
        action.click(titleResult).perform();

        Thread.sleep(2000);
    }

        @Test
        public void testdoubleClick() throws InterruptedException {
            driver.get("https://anhtester.com/");
            Thread.sleep(2000);
            //Element của Headert page
            WebElement element = driver.findElement(By.xpath("//h2[contains(.,'Anh Tester  Automation Testing')]"));
            Actions action = new Actions(driver);

            //click chuột trái 2 lân vào header page
            action.doubleClick(element).perform();
            Thread.sleep(2000);

        }

        @Test
        public void testcontextClick() throws InterruptedException {
            driver.get("https://anhtester.com/");
            WebElement element = driver.findElement(By.xpath("//h2[contains(.,'Anh Tester  Automation Testing')]"));
            Actions action = new Actions(driver);
            action.contextClick(element).perform();  //kích chuột phải
            Thread.sleep(2000);
        }

        @Test
        public void testmoveToElement () throws InterruptedException {
            driver.get("https://anhtester.com/");
            WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Tất Cả Khóa Học']"));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();   // di chuyển đến phần tử nào đó
            Thread.sleep(2000);
        }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(2000);
        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);

        // Gọi hàm dragAndDrop giữa Element
        action.dragAndDrop(From, To).build().perform();

        Thread.sleep(3000);

        // Drag and Drop by Pixel.
//        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
//        action.dragAndDropBy(from_5000, 168, 50).build().perform();

    //    Thread.sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh").keyUp(Keys.SHIFT).sendKeys("tester").build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down cuối trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(2000);
        // Scroll up đầu trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(2000);
    }
    public void Refresh () throws InterruptedException {
        driver.get("https://anhtester.com/");
        WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Tất Cả Khóa Học']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();   // di chuyển đến phần tử nào đó
        Thread.sleep(2000);

        action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();

    }

    }

