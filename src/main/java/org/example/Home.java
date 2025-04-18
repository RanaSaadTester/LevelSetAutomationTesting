package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Home {
    WebDriver driver;
    public String navigateBtn="//a[@class=\"btn btn-info btn-outline mob-dropdown-btn\"]";
    public Home(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement getNavigateBtn()
    {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(navigateBtn)));
    }
    public void navigateBtnClick(WebElement button){
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }
}
