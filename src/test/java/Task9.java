import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.EventListener;
import java.util.List;

public class Task9 {

     EventFiringWebDriver driver;
     WebDriverWait wait;

     public static class EventListener extends AbstractWebDriverEventListener{
         @Override
         public void beforeFindBy(By by, WebElement element, WebDriver driver){
             System.out.println(by);
         }
         @Override
         public void afterFindBy(By by, WebElement element, WebDriver driver){
             System.out.println(by + "Found");
         }
         @Override
         public void onException(Throwable throwable, WebDriver driver){
             System.out.println(throwable);
             File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

         }

    }

    @Before
    public void start() {

        System.setProperty("wdm.targetPath", "D://Projects/WebDriverManager/.m2/repository/webdriver");
        ChromeDriverManager.getInstance().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventListener());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Task9() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();


        List <WebElement> list = driver.findElements(By.id("app-"));


        for (int i=0; i<list.size(); i++){

            driver.findElement(By.className("list-vertical")).findElements(By.id("app-")).get(i).click();

            List <WebElement> sub = driver.findElement(By.className("list-vertical")).findElements(By.id("app-")).get(i).findElements(By.className("name"));

            if(sub.size() >1){

                for(int k=0; k<sub.size(); k++)
                    driver.findElement(By.className("list-vertical")).findElements(By.id("app-")).get(i).findElements(By.className("name")).get(k).click();
                Assert.assertTrue("Not found" , isPresent(By.cssSelector("h1")));

            }

            Assert.assertTrue("Not found" , isPresent(By.cssSelector("h1")));
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public boolean isPresent(By by){
        return driver.findElements(by).size() > 0;
    }
}