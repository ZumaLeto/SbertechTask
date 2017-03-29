package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[href*='/catalog/54425?hid=91009&track=menu']")
    WebElement ComputerClick;

    public MarketPage(WebDriver webDriver){
        driver=webDriver;
        wait = new WebDriverWait(driver,10,500);

        PageFactory.initElements(driver,this);
    }
    @Step("Click Computer Icon")
    public void ClickComputerIcon() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href*='/catalog/54425?hid=91009&track=menu']")));
        Thread.sleep(3000);
        ComputerClick.click();
    }
}
