package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[href*='https://market.yandex.ru/?clid=505&utm_source=face_abovesearch']")
    WebElement MarketClick;

    public MainPage(WebDriver webdriver){
        driver = webdriver;

        wait = new WebDriverWait(driver,10,500);

        PageFactory.initElements(driver,this);
    }
    @Step("CLick Market")
    public void ClickMarketIcon() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href*='https://market.yandex.ru/?clid=505&utm_source=face_abovesearch']")));
        Thread.sleep(2000);
        MarketClick.click();
    }}
