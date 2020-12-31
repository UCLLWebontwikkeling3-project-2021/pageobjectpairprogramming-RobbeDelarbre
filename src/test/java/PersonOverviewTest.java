import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.PersonOverviewPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author Robbe Delarbre r0803569 en Lorenzo Catalano r0790963
 */

public class PersonOverviewTest {

    private WebDriver driver;
    private String path = "http://localhost:8080/opdracht_web3_war_exploded/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Robbe Delarbre\\OneDrive - UC Leuven-Limburg\\SERVER\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
//        driver.quit();
    }

    @Test
    public void userNotLoggedInNavigatesToPersonOverview() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", driver.getTitle());
        assertTrue(homePage.hasErrorMessage("Session expired."));
    }

    @Test
    public void userLoggedInNavigatesToPersonOverview() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginAsUser();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Error", driver.getTitle());
    }

    @Test
    public void adminLoggedInNavigatesToPersonOverview() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginAsAdmin();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Overview", driver.getTitle());
    }
}
