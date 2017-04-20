import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Task7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        System.setProperty("wdm.targetPath", "D://Projects/WebDriverManager/.m2/repository/webdriver");
        ChromeDriverManager.getInstance().setup();

    }

    @Test
    public void Task7() {

        int numberOfItems = 3;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);


        //Add items
        for(int i=0; i<=3; i++) {

            driver.get("http://localhost/litecart/");
            driver.findElement(By.cssSelector("[id=box-most-popular]")).findElements(By.cssSelector("li.product.column.shadow.hover-light")).get(0).click();
            try {
                Select sl = new Select(driver.findElement(By.name("options[Size]")));
                sl.selectByValue("Small");
            } catch (Exception e){
                            }
            driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
            WebElement el = driver.findElement(By.cssSelector("div#cart")).findElement(By.cssSelector("span[class=quantity]"));
            wait.until(ExpectedConditions.attributeContains(el, "textContent", i + 1 + ""));

        }

        //Remove items
        driver.findElement(By.cssSelector("div[id=cart]")).click();

        List<WebElement> ls = driver.findElements(By.cssSelector("td.tax"));
        for(int z=0; z<=(numberOfItems+1); z++) {
            driver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
            wait.until(ExpectedConditions.stalenessOf(ls.get(0)));

        }


        //Verify Remove
        driver.get("http://localhost/litecart/");
        String st = driver.findElement(By.cssSelector("div#cart")).findElement(By.cssSelector("span[class=quantity]")).getAttribute("textContent");
        System.out.println(st);
        Assert.assertTrue("Not clear!!", st.equals("0"));



    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }



}