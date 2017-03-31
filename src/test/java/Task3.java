import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task3 {

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
    public void Task3() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.name("email")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}