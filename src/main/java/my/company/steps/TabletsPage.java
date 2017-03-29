package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;


public class TabletsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[href*='/catalog/54545/list?hid=6427100&track=fr_ctlg']")
    WebElement TabletClick;

    public TabletsPage(WebDriver webDriver){
        driver = webDriver;
        wait = new WebDriverWait(driver, 10,500);

        PageFactory.initElements(driver,this);
    }
    @Step(" CLock Tablet Icon")
    public void ClickTabletIcon() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href*='/catalog/54545/list?hid=6427100&track=fr_ctlg']")));
        Thread.sleep(3000);
        TabletClick.click();
    }
}
