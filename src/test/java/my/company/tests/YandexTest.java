package my.company.tests;

import my.company.steps.YandexSite;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

@Title("Testing Yandex.Market")
public class YandexTest {
    @BeforeClass
    public static void OnlyOnce() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
    }
    WebDriver driver;
    YandexSite yandexSite;

    @Before
    @Step("Come to tab market and computer")
    public void Setup() throws InterruptedException {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        yandexSite= new YandexSite(driver);
        driver.get("http://yandex.ru/");
        yandexSite.mainPage().ClickMarketIcon();
        yandexSite.marketPage().ClickComputerIcon();
    }
    @Test
    @Title("Testing Notebooks")
    @Step("Come to tab notebooks and enter search information")
     public void testYandexSearchNotebooks() throws InterruptedException {
        yandexSite.notebooksPage().ClickNotebookIcon();
        yandexSite.searchPage().PriceTo("30000");
        yandexSite.searchPage().ClickHPIcon();
        yandexSite.searchPage().ClickLenovoIcon();
    }
    @Test
    @Title("Testing Tablets")
    @Step("Come to tab tablets and enter search information")
    public void testYandexSearchTablets() throws InterruptedException {

        yandexSite.tabletsPage().ClickTabletIcon();
        yandexSite.searchPage().PriceFrom("20000");
        yandexSite.searchPage().PriceTo("25000");
        yandexSite.searchPage().ClickAcerIcon();
        yandexSite.searchPage().ClickButtonMore();
        yandexSite.searchPage().WriteText("Dell");
        yandexSite.searchPage().ClickDellIcon();

    }
    @After
    @Step("Apply request and check results ")
    public  void tearDown() throws InterruptedException {

        yandexSite.searchPage().ClickApplay();
        Assert.assertTrue(driver.findElements(By.cssSelector(".n-snippet-card.snippet-card.clearfix.i-bem.n-snippet-card_js_inited")).size()==12);
        String search,search2;
        search =  yandexSite.searchPage().RememderElement();
        yandexSite.searchPage().Search(search);
        search2= yandexSite.secondSearchPage().SecondSearch();
        Assert.assertTrue(search.equals(search2));
        driver.quit();
    }
}
