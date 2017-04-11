import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Task5 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        System.setProperty("wdm.targetPath", "D://Projects/WebDriverManager/.m2/repository/webdriver");
        ChromeDriverManager.getInstance().setup();
        InternetExplorerDriverManager.getInstance().arch32().setup();
        FirefoxDriverManager.getInstance().setup();

//        DesiredCapabilities caps = new DesiredCapabilities();
//        driver = new InternetExplorerDriver();
//        driver = new ChromeDriver(caps);
//        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Task5_Chrome() {

        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new ChromeDriver(caps);
        driver.get("http://localhost/litecart/");

        //Main page
        String name1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).getText();
        System.out.println("Name1= " + name1);
        String regPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice1= " + regPrice1);
        String disPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice1= " + disPrice1);
        String regColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor1= " + regColor1);
        String regLine1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine1= " + regLine1);
        String disColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor1= " + disColor1);
        String disStyle1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle1= " + disStyle1);

        //Product page
        driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).click();
        String name2 = driver.findElement(By.cssSelector("h1.title")).getText();
        System.out.println("Name2= " + name2);
        String regPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice2= " + regPrice2);
        String disPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice2= " + disPrice2);
        String regColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor2= " + regColor2);
        String regLine2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine2= " + regLine2);
        String disColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor2= " + disColor2);
        String disStyle2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle2= " + disStyle2);

        //Comparing parameters
        Assert.assertTrue("Name not the same!", name1.equals(name2) );
        Assert.assertTrue("RegPrice not the same!", regPrice1.equals(regPrice2) );
        Assert.assertTrue("DisPrice not the same!", disPrice1.equals(disPrice2) );
        Assert.assertTrue("RegColor not the same!", regColor1.equals(regColor2) );
        Assert.assertTrue("RegLine not the same!", regLine1.equals(regLine2) );
        Assert.assertTrue("DisColor not the same!", disColor1.equals(disColor2) );
        Assert.assertTrue("DisStyle not the same!", disStyle1.equals(disStyle2) );

    }

    @Test
    public void Task5_FireFox() {

        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new FirefoxDriver(caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/");

        //Main page
        String name1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).getText();
        System.out.println("Name1= " + name1);
        String regPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice1= " + regPrice1);
        String disPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice1= " + disPrice1);
        String regColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor1= " + regColor1);
        String regLine1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine1= " + regLine1);
        String disColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor1= " + disColor1);
        String disStyle1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle1= " + disStyle1);

        //Product page
        driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).click();
        String name2 = driver.findElement(By.cssSelector("h1.title")).getText();
        System.out.println("Name2= " + name2);
        String regPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice2= " + regPrice2);
        String disPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice2= " + disPrice2);
        String regColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor2= " + regColor2);
        String regLine2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine2= " + regLine2);
        String disColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor2= " + disColor2);
        String disStyle2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle2= " + disStyle2);

        //Comparing parameters
        Assert.assertTrue("Name not the same!", name1.equals(name2) );
        Assert.assertTrue("RegPrice not the same!", regPrice1.equals(regPrice2) );
        Assert.assertTrue("DisPrice not the same!", disPrice1.equals(disPrice2) );
        Assert.assertTrue("RegColor not the same!", regColor1.equals(regColor2) );
        Assert.assertTrue("RegLine not the same!", regLine1.equals(regLine2) );
        Assert.assertTrue("DisColor not the same!", disColor1.equals(disColor2) );
        Assert.assertTrue("DisStyle not the same!", disStyle1.equals(disStyle2) );

    }

    @Test
    public void Task5_IE() {

        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new InternetExplorerDriver(caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/");

        //Main page
        String name1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).getText();
        System.out.println("Name1= " + name1);
        String regPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice1= " + regPrice1);
        String disPrice1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice1= " + disPrice1);
        String regColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor1= " + regColor1);
        String regLine1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine1= " + regLine1);
        String disColor1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor1= " + disColor1);
        String disStyle1 = driver.findElement(By.id("box-campaigns")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle1= " + disStyle1);

        //Product page
        driver.findElement(By.id("box-campaigns")).findElement(By.className("name")).click();
        String name2 = driver.findElement(By.cssSelector("h1.title")).getText();
        System.out.println("Name2= " + name2);
        String regPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getText();
        System.out.println("regPrice2= " + regPrice2);
        String disPrice2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getText();
        System.out.println("disPrice2= " + disPrice2);
        String regColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("color");
        System.out.println("regColor2= " + regColor2);
        String regLine2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("regular-price")).getCssValue("text-decoration");
        System.out.println("regLine2= " + regLine2);
        String disColor2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("color");
        System.out.println("disColor2= " + disColor2);
        String disStyle2 = driver.findElement(By.cssSelector("div.price-wrapper")).findElement(By.className("campaign-price")).getCssValue("font-weight");
        System.out.println("disStyle2= " + disStyle2);

        //Comparing parameters
        Assert.assertTrue("Name not the same!", name1.equals(name2) );
        Assert.assertTrue("RegPrice not the same!", regPrice1.equals(regPrice2) );
        Assert.assertTrue("DisPrice not the same!", disPrice1.equals(disPrice2) );
        Assert.assertTrue("RegColor not the same!", regColor1.equals(regColor2) );
        Assert.assertTrue("RegLine not the same!", regLine1.equals(regLine2) );
        Assert.assertTrue("DisColor not the same!", disColor1.equals(disColor2) );
        Assert.assertTrue("DisStyle not the same!", disStyle1.equals(disStyle2) );

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}