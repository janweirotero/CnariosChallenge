package EcomProductListingandPagination;
import WaitFolder.waitingCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ListingAndPaginationCall extends waitingCall {

    public WebDriver driver;

    public ListingAndPaginationCall(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='View Challenge'])[1]")
    WebElement firstChallenge;

    @FindBy(xpath = "//div[@class=\"MuiCardContent-root flex flex-col space-y-3 css-15q2cw4\"]/h6[@class=\"MuiTypography-root MuiTypography-h6 font-semibold css-1imvwru\"]")
    List<WebElement> prodNames;

    @FindBy(xpath = "//ul[@class=\"MuiPagination-ul css-51eq8m\"]/li")
    List<WebElement> paginationCounts;

    @FindBy(xpath = "//div[@class=\"MuiCardContent-root flex flex-col space-y-3 css-15q2cw4\"]/h6[@class=\"MuiTypography-root MuiTypography-h6 font-semibold css-1imvwru\"]/following-sibling::p[1]")
    List<WebElement> getCategoryList;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "(//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 w-full max-w-6xl'])[1]")
    WebElement loadPage;

    @FindBy(xpath = "//button[normalize-space()='5']")
    WebElement lastButton;

   // By loadPage = By.xpath("");


    public void PLP_02() {

        String prodNameToLookFor = "WH-1000XM5";
        firstChallenge.click();
        int count = paginationCounts.size()-1;

        int x, countPage = 0;

        for (x =2; x<=count; x++) {

            WebElement paginationNum = driver.findElement(By.xpath("//ul[@class=\"MuiPagination-ul css-51eq8m\"]/li[" + x + "]"));
            paginationNum.click();

            //.map is to List of the strings you want to get
            //.filter is to filter the text you want
            //scan every page if there is a product name that contains prodtolookfor then get it real name
            Optional<String> getRealName = prodNames.stream()
                    .map(WebElement::getText)
                    .filter(text -> text.contains(prodNameToLookFor))
                    .findFirst();

            //you can get the value of 1 result only if there is orElse() condition
            /*String getRealName =  prodNames.stream()
                    .map(WebElement::getText)
                    .filter(text->text.contains(prodNameToLookFor))
                    .findFirst().orElse(null)*/
            countPage++;
            if (getRealName.isPresent()) {
                System.out.println("The product we're looking is " + getRealName.get() + " and it is under page " + countPage);
            }
        }

    }


    public void PLP_03(){

        int x, books=0, clothing=0,home=0,sports=0,electronics=0;
        String[] categoryNames = {"Books","Clothing","Home","Sports","Electronics"};

        firstChallenge.click();
        int count = paginationCounts.size()-1;

        for (x =2; x<=count; x++) {

            WebElement paginationNum = driver.findElement(By.xpath("//ul[@class=\"MuiPagination-ul css-51eq8m\"]/li[" + x + "]"));
            paginationNum.click();

            for (WebElement category : getCategoryList) {

                waitingCall waitObject = new waitingCall(driver);
                waitObject.waitForThePageToLoad(loadPage);

                String[] getTextCategory = category.getText().split(":");
                String wordPerCategory = getTextCategory[1].trim();

                if (categoryNames[0].equalsIgnoreCase(wordPerCategory)) {
                    books++;
                } else if (categoryNames[1].equalsIgnoreCase(wordPerCategory)) {
                    clothing++;
                } else if (categoryNames[2].equalsIgnoreCase(wordPerCategory)) {
                    home++;
                } else if (categoryNames[3].equalsIgnoreCase(wordPerCategory)) {
                    sports++;
                } else if (categoryNames[4].equalsIgnoreCase(wordPerCategory)) {
                    electronics++;
                }

            }

        }

        Assert.assertEquals(books,10);
        Assert.assertEquals(clothing, 10);
        Assert.assertEquals(home, 10);
        Assert.assertEquals(sports, 10);
        Assert.assertEquals(electronics, 10);

        System.out.println("number of books "+books);
        System.out.println("number of clothing "+clothing);
        System.out.println("number of home "+home);
        System.out.println("number of sports "+sports);
        System.out.println("number of electronics "+electronics);




    }


}
