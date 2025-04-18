import org.example.DocumentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocPricePageTest {
    WebDriver driver;
    DocumentPage doc ;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://app.levelset.com/wizard/SelectDocument/");
        driver.manage().window().maximize();
        doc = new DocumentPage(driver);
        doc.setupDocumentPage(30, 60);
    }
    @Test
    public void SelectDoc()
    {
        var count = doc.getSelectedElementsCount();
        String result = doc.getSelectedElementText(0);
        System.out.println(count);
        System.out.println(result);
        Assert.assertEquals(result,"Send a Warning");
        Assert.assertEquals(count,1);
    }

    @AfterMethod
    public void shutDownDriver() {
        driver.quit();
    }
}



