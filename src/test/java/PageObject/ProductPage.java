package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver d){
        driver = d ;
        PageFactory.initElements(d, this);
    }

    @FindBy (xpath = "//input[@id=\"search_query_top\"]")
    WebElement SearchBox;

    @FindBy (css = "button[name=\"submit_search\"]")
    WebElement SearchSubmit;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
    WebElement SearchedProduct;


    public void setSearchBox(String Searchkey){
        SearchBox.sendKeys(Searchkey);
    }
    public void clickOnSubmitSearch() {
        SearchSubmit.click();
    }

    public String getSearchedProduct() {
        return SearchedProduct.getText();
    }


}
