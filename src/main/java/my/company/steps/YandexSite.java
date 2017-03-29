package my.company.steps;

import org.openqa.selenium.WebDriver;

public class YandexSite {
    WebDriver driver;

    public YandexSite(WebDriver webDriver){
        driver=webDriver;
    }
    public MainPage mainPage(){
        return new MainPage(driver);
    }
    public MarketPage marketPage(){
        return new MarketPage(driver);
    }
    public NotebooksPage notebooksPage(){
        return new NotebooksPage(driver);
    }
    public TabletsPage tabletsPage(){
        return new TabletsPage(driver);
    }
    public SearchPage searchPage(){
        return  new SearchPage(driver);
    }
    public SecondSearchPage secondSearchPage(){
        return new SecondSearchPage(driver);
    }
}
