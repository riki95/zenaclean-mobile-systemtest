import Objects.AccountPage;
import Objects.AppPage;
import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

public class LogoutTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLogoutWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin();

        new AppPage(driver).getAccountButton().click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.getLogoutButton().click();
        driver.findElementByXPath("//*[@text='OK']").click();

        Assert.assertEquals("SCORRI PER PIÙ INFORMAZIONI ", homepage.getTextBelow().getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
