package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;


public class SecondSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "div[class*='n-product-title']")
    WebElement SecondSearch;
    public SecondSearchPage(WebDriver webDriver){
        driver=webDriver;
        wait=new WebDriverWait(driver,10,500);

        PageFactory.initElements(driver,this);
    }
    @Step("Check Results")
    public String SecondSearch() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='n-product-title']")));
        Thread.sleep(4000);
        WebElement SecondElement=SecondSearch.findElement(By.cssSelector("div[class*='n-title__text']"));
        return SecondElement.getText();
    }
}
