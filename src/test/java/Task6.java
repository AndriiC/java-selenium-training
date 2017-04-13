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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task6 {

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
    public void Task6() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();
        driver.findElements(By.id("app-")).get(1).click();

        List <WebElement> prod = driver.findElements(By.cssSelector("tr[class=row]"));

        driver.findElements(By.className("button")).get(1).click();

        //General tab
        driver.findElements(By.cssSelector("[name=status]")).get(0).click();
        driver.findElement(By.name("name[en]")).sendKeys("wasp1");
        driver.findElement(By.name("code")).sendKeys("123");

        List <WebElement> ch = driver.findElements(By.cssSelector("input[type=checkbox]"));
        ch.get(1).click();

        Select sl = new Select(driver.findElement(By.cssSelector("select[name=default_category_id]")));
        sl.selectByValue("1");

        ch.get(4).click();

        driver.findElement(By.name("quantity")).sendKeys("10");

        Select sl1 = new Select(driver.findElement(By.cssSelector("select[name=sold_out_status_id]")));
        sl1.selectByValue("2");

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("img.png").getFile());
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.name("date_valid_from")).sendKeys("04122017");
        driver.findElement(By.name("date_valid_to")).sendKeys("04122020");

        //Information tab
        driver.findElement(By.cssSelector("ul[class=index]")).findElements(By.cssSelector("li")).get(1).click();

        Select man = new Select(driver.findElement(By.cssSelector("select[name=manufacturer_id]")));
        man.selectByValue("1");

        driver.findElement(By.name("keywords")).sendKeys("and1");
        driver.findElement(By.name("short_description[en]")).sendKeys("hrhrhrhfhr");
        driver.findElement(By.cssSelector("div[class=trumbowyg-editor]")).sendKeys("ergerfgerferf");
        driver.findElement(By.name("head_title[en]")).sendKeys("and2");
        driver.findElement(By.name("meta_description[en]")).sendKeys("and3");

        //Prices tab
        driver.findElement(By.cssSelector("ul[class=index]")).findElements(By.cssSelector("li")).get(3).click();
        driver.findElement(By.name("purchase_price")).sendKeys("12");

        Select pur = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        pur.selectByValue("USD");

        driver.findElement(By.name("save")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Check
        driver.findElements(By.id("app-")).get(1).click();
        List <WebElement> prod1 = driver.findElements(By.cssSelector("tr[class=row]"));
        int i = prod.size();
        System.out.println(i);
        int z = prod1.size();
        System.out.println(z);
        Assert.assertTrue("Product not found", i>z );

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}