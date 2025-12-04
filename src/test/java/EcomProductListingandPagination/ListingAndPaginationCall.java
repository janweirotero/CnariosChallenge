package EcomProductListingandPagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListingAndPaginationCall {

    public WebDriver driver;

    public ListingAndPaginationCall(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='View Challenge'])[1]")
        WebElement firstChallenge;

    @FindBy(xpath = "//div[@class=\"MuiCardContent-root flex flex-col space-y-3 css-15q2cw4\"]")
        List<WebElement> cardContents;

    //By prodNames = By.cssSelector("h6");

    @FindBy(xpath = "//div[@class=\"MuiCardContent-root flex flex-col space-y-3 css-15q2cw4\"]/h6[@class=\"MuiTypography-root MuiTypography-h6 font-semibold css-1imvwru\"]")
        List<WebElement> prodNames;

    By getProdNames = By.xpath("//div[@class=\"MuiCardContent-root flex flex-col space-y-3 css-15q2cw4\"]/h6[@class=\"MuiTypography-root MuiTypography-h6 font-semibold css-1imvwru\"]");

    @FindBy(xpath = "//ul[@class=\"MuiPagination-ul css-51eq8m\"]/li")
        List<WebElement> paginationCounts;



    public void PLP_02(){

        String prodNameToLookFor = "WH-1000XM5";
        firstChallenge.click();
        int count = paginationCounts.size();

        int x, countPage=0;

        for (x =2; x<=6; x++) {

            WebElement paginationNum= driver.findElement(By.xpath("//ul[@class=\"MuiPagination-ul css-51eq8m\"]/li["+x+"]"));
            paginationNum.click();

            //.map is to List of the strings you want to get
            //.filter is to filter the text you want
            //scan every page if there is a product name that contains prodtolookfor then get it real name
            Optional<String> getRealName =  prodNames.stream()
                    .map(WebElement::getText)
                    .filter(text->text.contains(prodNameToLookFor))
                    .findFirst();

            //you can get the value of 1 result only if there is orElse() condition
            /*String getRealName =  prodNames.stream()
                    .map(WebElement::getText)
                    .filter(text->text.contains(prodNameToLookFor))
                    .findFirst().orElse(null)*/

            countPage++;

            /*if (getRealName != null && getRealName.contains(prodNameToLookFor)){

                System.out.println("The product we're looking is "+getRealName + " and it is under page "+countPage);
            }*/

            if (getRealName.isPresent()){
                System.out.println("The product we're looking is "+getRealName.get() + " and it is under page "+countPage);
            }
        }

    }

}
