package EcomProductFiltering;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilteringCall {

    WebDriver driver;

    public FilteringCall(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='View Challenge'])[2]")
    WebElement secondChallenge;

    @FindBy(xpath = "//div[@role=\"combobox\"]")
    WebElement clickTheDropdown;

    @FindBy(xpath = "//li[normalize-space()=\"Electronics\"]")
    WebElement clickElectronics;


    public void PLP_01(){

        secondChallenge.click();
        clickTheDropdown.click();
        clickElectronics.click();

    }



}
