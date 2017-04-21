import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task8 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        System.setProperty("wdm.targetPath", "D://Projects/WebDriverManager/.m2/repository/webdriver");
        ChromeDriverManager.getInstance().setup();

        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Task8() {


        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();


        driver.findElements(By.cssSelector("[id=app-]")).get(2).click();
        driver.findElement(By.cssSelector("[id=content]")).findElement(By.cssSelector("a.button")).click();
        List <WebElement> ls = driver.findElements(By.cssSelector("i.fa.fa-external-link"));

        String homeWind = driver.getWindowHandle();
        for(WebElement bt : ls){
            bt.click();

            for(String tab : driver.getWindowHandles()){
                if(!tab.equals(homeWind)) {
                    driver.switchTo().window(tab);
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("body")));
                    driver.close();
                    driver.switchTo().window(homeWind);
                }
            }

        }



    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}