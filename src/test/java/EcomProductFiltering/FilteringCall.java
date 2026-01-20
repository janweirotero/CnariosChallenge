package EcomProductFiltering;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import WaitFolder.waitingCall;

import java.util.List;

public class FilteringCall extends waitingCall{

    public WebDriver driver;

    public FilteringCall(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='View Challenge'])[2]")
    WebElement secondChallenge;

    @FindBy(xpath = "//div[@role=\"combobox\"]")
    WebElement clickTheDropdown;

    @FindBy(xpath = "//li[normalize-space()=\"Electronics\"]")
    WebElement clickElectronics;

    @FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 font-medium css-1o5u7u9\"]")
    List<WebElement> countItems;

    @FindBy(xpath = "//span[@class='MuiSlider-rail css-1m3hq23']")
    WebElement priceRange;

    @FindBy(xpath = "//div[@class=\"border p-3 rounded-lg shadow-sm MuiBox-root css-0\"]")
    List<WebElement> priceRangeResult;



    public void PLP_01(){

        secondChallenge.click();
        waitForThePageToLoad(clickTheDropdown);
        clickTheDropdown.click();
        clickElectronics.click();

        int count = countItems.size();


        for (int x =1 ; x<= count; x++){

            WebElement getNames = driver.findElement(By.xpath("//div[@class='space-y-3 overflow-y-auto MuiBox-root css-0']//div["+x+"]"));

                String [] nameOfTheItem = getNames.getText().split(" • ₹");
                String  cutName = nameOfTheItem[0].trim();
                String [] cutNameFinal = cutName.split("\n");
                String finalNameofItem = cutNameFinal[0].trim();
                String finalCategory = cutNameFinal[1].trim();
                Assert.assertEquals(cutNameFinal[1], "Electronics");
                System.out.println("The item "+finalNameofItem+ " is under "+finalCategory+" category");



        }

    }


    public void PLP_02(){

        secondChallenge.click();

        Actions act = new Actions(driver);
        act.dragAndDropBy(priceRange,0,35).build().perform();

        for (WebElement newPriceRange : priceRangeResult){

            String [] itemNames = newPriceRange.getText().split("\n");
            String [] itemPrice = itemNames[1].split("•");
            String [] itemPrice2 = itemPrice[1].split("₹");
            String finalItemPrice = itemPrice2[1].trim();
            int price = Integer.parseInt(finalItemPrice);

            if (price <= 28000){

                System.out.println("The item "+itemNames[0]+ " is "+ price+" and it is below/equal the price range");
            }

        }


    }



}
