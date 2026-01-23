package EcomProductFiltering;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import WaitFolder.waitingCall;
import org.testng.annotations.Test;

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

    @FindBy(xpath = "//div[@role='combobox']")
    WebElement clickTheDropdown;

    @FindBy(xpath = "//li[normalize-space()='Electronics']")
    WebElement clickElectronics;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 font-medium css-1o5u7u9']")
    List<WebElement> countItems;

    @FindBy(xpath = "//span[@class='MuiSlider-rail css-1m3hq23']")
    WebElement priceRange;

    @FindBy(xpath = "//div[@class='border p-3 rounded-lg shadow-sm MuiBox-root css-0']")
    List<WebElement> productResults;

    @FindBy(xpath = "//input[@value='5']")
    WebElement selectStars;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkbox;

    @FindBy(xpath = "//button[normalize-space()='Reset Filters']")
    WebElement resetButton;

    @FindBy(xpath = "//div[normalize-space()=\"All\"]")
    WebElement comboBoxDefault;

    @FindBy(xpath = "//input[@type='range'][@data-index=1]")
    WebElement priceRangeLine;




    public void PLP_01(){

        secondChallenge.click();
        waitForThePageToLoad(clickTheDropdown);
        clickTheDropdown.click();
        clickElectronics.click();

        int count = countItems.size();

        System.out.print("\n");

        for (int x =1 ; x<= count; x++){
            WebElement getNames = driver.findElement(By.xpath("//div[@class='space-y-3 overflow-y-auto MuiBox-root css-0']//div["+x+"]"));

                String [] nameOfTheItem = getNames.getText().split(" • ₹");
                String cutName = nameOfTheItem[0].trim();
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

        System.out.print("\n");

        for (WebElement newPriceRange : productResults){

            String [] itemNames = newPriceRange.getText().split("\n");
            String [] itemPrice = itemNames[1].split("•");
            String [] itemPrice2 = itemPrice[1].split("₹");
            String finalItemPrice = itemPrice2[1].trim();
            int price = Integer.parseInt(finalItemPrice);

            if (price <= 28000){
                System.out.println("The item "+itemNames[0]+ " is "+ price+" and it is below/equal to 28000");
            }else {
                System.out.println("The"+itemNames[0]+ "'s price is above the selected price");
            }

        }


    }
    public void PLP_03(){
        secondChallenge.click();

        Actions action = new Actions(driver);
        action.moveToElement(selectStars).click().build().perform();

        System.out.print("\n");

        for (WebElement newResultsCount : productResults)
        {
            String [] getTheText = newResultsCount.getText().split("\n");
            String getTheItemName = getTheText[0];
            String [] getStarValue = getTheText[1].split("⭐");
            String getStarValueFinal = getStarValue[1].trim();
            int valueOfStars = Integer.parseInt(getStarValueFinal);

            if (valueOfStars >=4){
                System.out.println("The item " + getTheItemName+ "'s rating is "+getStarValueFinal);
            }
            else {
                System.out.println("The"+ getTheItemName +"'s rating is below the selected rating");
            }


        }

    }
    public void PLP_04(){

        secondChallenge.click();
        checkbox.click();

        System.out.print("\n");

        for (WebElement newResultsCount : productResults)
        {
            String [] getTheText = newResultsCount.getText().split("\n");
            String getTheItemName = getTheText[0];
            String getTheItemStatus = getTheText[2].trim();

            if (getTheItemStatus.equalsIgnoreCase("in stock")){
                System.out.println("The item " + getTheItemName+ "'s status is "+getTheItemStatus);
            }
            else {
                System.out.println("The"+ getTheItemName +" does not has a stock");
            }


        }



    }

    public void PLP_05(){

        secondChallenge.click();

        //click the category dropdown
        //waitForThePageToLoad(clickTheDropdown);
        clickTheDropdown.click();
        clickElectronics.click();

        //select price range
        Actions act = new Actions(driver);
        act.dragAndDropBy(priceRange,0,35).build().perform();

        //click stock button
        checkbox.click();

        //click the reset button
        resetButton.click();

        comboBox();
        checkBox();
        priceValue();


    }

        void comboBox(){
        String getTheComboBoxValue = comboBoxDefault.getText();
        Assert.assertEquals(getTheComboBoxValue, "All");

       }

        void checkBox(){

            //check if the checkbox is selected
            boolean tru = checkbox.isSelected();
            Assert.assertFalse(tru);

        }

        void priceValue(){

            String getValueOfPrice = priceRangeLine.getAttribute("aria-valuenow");
            int priceValue = Integer.parseInt(getValueOfPrice);
            Assert.assertEquals(priceValue, 80000);

        }

        public void PLP_06(){

            secondChallenge.click();
            //waitForThePageToLoad(clickTheDropdown);
            clickTheDropdown.click();
            clickElectronics.click();

            System.out.print("\n");

            for (WebElement newResultsCount : productResults)
            {
                String [] getTheText = newResultsCount.getText().split("\n");
                String getTheItemName = getTheText[0];
                String [] getOtherValues = getTheText[1].split("•");
                String getPrice = getOtherValues[1].trim();
                String getLabel = getOtherValues[0].trim();
                String getRate = getOtherValues[2].trim();

                System.out.println("The Item name: "+ getTheItemName + "\n" +
                                     "The price: " + getPrice + "\n" +
                                     "The label: " +getLabel + "\n" +
                                     "The rate: " + getRate);
            }

        }



}
