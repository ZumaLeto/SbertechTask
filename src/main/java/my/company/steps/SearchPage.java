package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "glf-pricefrom-var")
    WebElement PriceFrom;
    @FindBy(id = "glf-priceto-var")
    WebElement PriceTo;
    @FindBy(css = "label[for*='glf-7893318-152722']")
    WebElement HP;
    @FindBy(css = "label[for*='glf-7893318-152981']")
    WebElement Lenovo;
    @FindBy(css = "label[for*='glf-7893318-267101']")
    WebElement Acer;
    @FindBy(css = "label[for*='glf-7893318-153080']")
    WebElement Dell;
    @FindBy(css = "button[class*='button button_size_xs button_pseudo_yes button_theme_pseudo i-bem button_js_inited']")
    WebElement MoreButton;
    @FindBy(css = "span[class*='input__box']")
    WebElement InputDell;
    @FindBy(css = "button[class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']")
    WebElement Apply;
    @FindBy(css = "a[class='snippet-card__header-link shop-history__link link i-bem link_js_inited']")
    WebElement FirstElement;

    @FindBy(id = "header-search")
    WebElement Search;
    @FindBy(css = "span[class='search2__button']")
    WebElement SearchButton;
    public SearchPage(WebDriver webDriver){
        driver= webDriver;
        wait=new WebDriverWait(driver,10,500);

        PageFactory.initElements(driver,this);
    }
    @Step("Input Pricefrom parametr")
    public void PriceFrom(String parametr) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("glf-pricefrom-var")));
        Thread.sleep(3000);
        PriceFrom.sendKeys(parametr);
    }
    @Step("Input Priceto parametr")
    public void PriceTo(String parametr) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("glf-priceto-var")));
        Thread.sleep(3000);
        PriceTo.sendKeys(parametr);
    }
    @Step("Click HP")
    public void ClickHPIcon() throws InterruptedException {
        HP.click();
        Thread.sleep(2000);
    }
    @Step("Click Lenovo")
    public  void ClickLenovoIcon() throws InterruptedException {
        Lenovo.click();
        Thread.sleep(2000);
    }
    @Step("Click Acer")
    public void ClickAcerIcon() throws InterruptedException {
        Acer.click();
        Thread.sleep(2000);
    }
    @Step("Click Dell")
    public void ClickDellIcon() throws InterruptedException {
        Thread.sleep(2000);
        Dell.click();

    }
    @Step("Click button-more")
    public void ClickButtonMore() throws InterruptedException {
        MoreButton.click();
        Thread.sleep(2000);

    }
    @Step("Input Dell")
    public void WriteText(String parametr){
        InputDell.sendKeys(parametr);
    }

    public void ClickApplay() throws InterruptedException {
        Thread.sleep(2000);
        Apply.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class='snippet-card__header-link shop-history__link link i-bem link_js_inited']")));
        Thread.sleep(3000);

    }
    @Step("Remember first element")
    public String RememderElement() throws InterruptedException {

        Thread.sleep(3000);
        return FirstElement.getText();

    }
    @Step("Seacrh first element")
    public void Search(String parametr) throws InterruptedException {
        Thread.sleep(3000);
        Search.sendKeys(parametr);
        SearchButton.click();
    }
}
