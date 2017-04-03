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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Task4 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        System.setProperty("wdm.targetPath", "D://Projects/WebDriverManager/.m2/repository/webdriver");
        ChromeDriverManager.getInstance().setup();
//        InternetExplorerDriverManager.getInstance().arch32().setup();

        DesiredCapabilities caps = new DesiredCapabilities();
//        driver = new InternetExplorerDriver();
        driver = new ChromeDriver(caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Task4() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();


        List <WebElement> list = driver.findElements(By.id("app-"));


        for (int i=0; i<list.size(); i++){

            driver.findElement(By.className("list-vertical")).findElements(By.className("name")).get(i).click();
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