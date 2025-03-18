import org.example.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;
    Home home ;

    @BeforeMethod
    public void setUp() {
         driver = new ChromeDriver();
        driver.get("https://www.levelset.com/");
         home=new Home(driver);
    }

    @Test
    public void navigateHome()
    {
        WebElement navigateBtn = home.getNavigateBtn();
        Assert.assertTrue(navigateBtn.isDisplayed());
        Assert.assertTrue(navigateBtn.isEnabled(), "Navigate button is not enabled!");

        home.navigateBtnClick(navigateBtn);

        Assert.assertEquals(driver.getTitle(), "Levelset | File Any Document in Minutes");
    }
    @AfterMethod
    public void shutDownDriver() {
         driver.quit();
    }



}
