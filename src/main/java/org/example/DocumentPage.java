package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DocumentPage {
    WebDriver driver;
    String DocByPrice = "//div[@class='left' and following-sibling::div[contains(@class, 'right')]//span[contains(@class, 'price-amount') and text()='%s']]";
    String DocByPriceRange = "//div[@class=\"left\" and following-sibling::div[contains(@class, 'right')]//span[@class=\"price-amount\" and number(translate(text(), \"$\", \"\")) > %d and number(translate(text(), \"$\", \"\")) < %d]]";
    List<WebElement> SelectedElements;
    WebDriverWait wait;

    public DocumentPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void setupDocumentPage(String priceAmount){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(DocByPrice, priceAmount))));
        SelectedElements = driver.findElements(By.xpath(String.format(DocByPrice, priceAmount)));
    }

    public void setupDocumentPage(int priceGreaterThan, int priceLowarThan){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(DocByPriceRange, priceGreaterThan, priceLowarThan))));
        SelectedElements = driver.findElements(By.xpath(String.format(DocByPriceRange, priceGreaterThan, priceLowarThan)));
    }

    public int getSelectedElementsCount()
    {
        return SelectedElements.size();
    }

    public String getSelectedElementText(int index)
    {
        try
        {
            return SelectedElements.get(index).getText();
        }
        catch(Exception e){
            return "InvalidIndex";
        }
    }
}
