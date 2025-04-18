import org.example.DocumentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocumentFreePageTest {
    WebDriver driver;
    DocumentPage doc ;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://app.levelset.com/wizard/SelectDocument/");

        doc = new DocumentPage(driver);
        doc.setupDocumentPage("Free");
    }
    @Test
    public void getDoc()
    {
        var count = doc.getSelectedElementsCount();
        var name1 = doc.getSelectedElementText(0);
        var name2 = doc.getSelectedElementText(1);

        System.out.println("size = " + count);
        System.out.println("first document: " + name1);
        System.out.println("second document: " + name2);

        Assert.assertEquals(2, count);
        Assert.assertEquals("Exchange a Waiver", name1);
        Assert.assertEquals("Send a Payment Document", name2);
    }
    @AfterMethod
    public void shutDownDriver() {
        driver.quit();
    }
}
