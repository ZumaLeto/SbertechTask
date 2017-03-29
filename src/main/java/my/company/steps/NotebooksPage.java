package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class NotebooksPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "a[href*='/catalog/54544/list?hid=91013&track=fr_ctlg']")
    WebElement NotebooksClick;

    public NotebooksPage(WebDriver webDriver){
        driver=webDriver;
        wait=new WebDriverWait(driver,10,500);

        PageFactory.initElements(driver,this);
    }
    @Step("Click Notebook Icon")
    public void ClickNotebookIcon() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href*='/catalog/54544/list?hid=91013&track=fr_ctlg']")));
        Thread.sleep(3000);
        NotebooksClick.click();
    }
}
