import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestNGTestCase {
    WebDriver driver;

    @BeforeClass
    void openBrowser() {
        System.out.println("user able to open browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void selectComputersFromNopcommerceWebsite() {
        System.out.println("user able select computers");
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
    }

    @Test(priority = 3)
    void selectDesktopFromComputers() {
        System.out.println("user able to select desktop");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")).click();
    }

    @Test(priority = 4)
    void selectLenovoIdeaCentre600AllinOnePC() {
        System.out.println("user able to select product");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
    }

    @Test(priority = 5)
    void selectQuantity() {
        System.out.println("user able to select quantity");
        driver.findElement(By.className("qty-input")).click();

    }

    @Test(priority = 6)
    void AddProductInTheCart() {
        System.out.println("user able to add product in a cart");
        driver.findElement(By.id("add-to-cart-button-3")).click();
    }

    @Test(priority = 7)
    void ShowTheBarNotification() {
        System.out.println("user should see green bar notification on top after add item in a cart");
        //driver.findElement(By.className("bar-notification success")).click();
        // Assert.fail();
        // Alert alert = driver.switchTo().alert();
        //System.out.println(alert.getText());


    }

    @Test(priority = 7)
    void OpenCart() {
        System.out.println("user able to open cart");
        driver.findElement(By.className("cart-label")).click();
    }

    @Test(priority = 8)
    void SelectTermAndCondition() {
        System.out.println("user able to select term and condition");
        driver.findElement(By.id("termsofservice")).click();
    }

    @Test(priority = 9)
    void GoToCheckout() {
        System.out.println("user able to do checkout");
        driver.findElement(By.id("checkout")).click();
    }

    @Test(priority = 10)
    void CheckoutAsGuest() {
        System.out.println("user able to checkout as guest");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 11)
    void GuestAddress() {
        System.out.println("user able to checkout as guest");
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("abc");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("xyz");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("abcd@abc.com");
        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(country);
        select.selectByVisibleText("United Kingdom");
        //driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]"));
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("harrow");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("61");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("ha36eu");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0741653248");
        driver.findElement(By.name("save")).click();

        driver.quit();

    }
}
