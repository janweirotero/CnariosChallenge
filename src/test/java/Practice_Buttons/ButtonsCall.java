package Practice_Buttons;

import WaitFolder.waitingCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;

public class ButtonsCall extends waitingCall {

    WebDriver driver;

    public ButtonsCall(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[1]/div[1]")
    WebElement clickTheButtonCard;
    @FindBy(xpath = "//button[normalize-space()=\"Try It Yourself\"]")
    WebElement clickTheTIYTab;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Follow'])[2]")
    WebElement getTheSecondCardFollowButton;
    @FindBy(xpath = "//button[normalize-space()='Following']")
    WebElement getTheFollowingButtonLabel;
    By unfollowButton = By.xpath("//span[@aria-label=\"Unfollow\"]");
    @FindBy(css = ".done-icon ")
    WebElement getDoneIcon;
    @FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall close css-vh810p'])[1]")
    WebElement clickFirstCloseButton;
    @FindBy(xpath = "//h6[@class=\"MuiTypography-root MuiTypography-subtitle1 css-3knznt\"]")
    List<WebElement> getTheNameList;


    public boolean button_001() {

        String text = "Following";
        clickTheButtonCard.click();
        clickTheTIYTab.click();
        getTheSecondCardFollowButton.click();
        waitForTheFollowButton(getDoneIcon);
        String getTheText = getTheFollowingButtonLabel.getText();
        Assert.assertTrue(getTheText.equalsIgnoreCase(text));

        return getDoneIcon.isDisplayed();
    }

    public void button_002() {

        String textValue = "Unfollow";

        clickTheButtonCard.click();
        clickTheTIYTab.click();
        getTheSecondCardFollowButton.click();
        waitForTheUnfollowButton(unfollowButton);
        Actions act = new Actions(driver);
        act.moveToElement(getTheFollowingButtonLabel).build().perform();

        //get the value of class aria-label which is Unfollow
        String getTextValue = driver.findElement(unfollowButton).getAttribute("aria-label");
        Assert.assertEquals(getTextValue, textValue);


    }

    public void button_003() {

        String text = "Following";
        clickTheButtonCard.click();
        clickTheTIYTab.click();
        getTheSecondCardFollowButton.click();
        waitForTheFollowButton(getDoneIcon);
        String getTheText = getTheFollowingButtonLabel.getText();
        Assert.assertTrue(getTheText.equalsIgnoreCase(text));

    }

    public void button_004() {

        String text = "Follow";
        clickTheButtonCard.click();
        clickTheTIYTab.click();
        getTheSecondCardFollowButton.click();
        waitForTheFollowButton(getTheFollowingButtonLabel);
        getTheFollowingButtonLabel.click();
        waitForTheFollowButton(getTheSecondCardFollowButton);
        String getTheText = getTheSecondCardFollowButton.getText();
        Assert.assertTrue(getTheText.equalsIgnoreCase(text));


    }


    public void button_005() {

        String[] name = {"Unknown", "Anjali Sharma", "Ravi Kumar", "Neha Verma", "Ram"};
        clickTheButtonCard.click();
        clickTheTIYTab.click();
        clickFirstCloseButton.click();

        int getCount = getTheNameList.size() - 1;

        for (int x = 0; x <= getCount; x++) {

            String userName = getTheNameList.get(x).getText();
            List<String> getName = Arrays.asList(name);
            if (getName.contains(userName)) {

                System.out.println(userName + " is still on the list");

            } else {

                break;
            }

        }

        int remainingCardCound = getCount + 1;

        System.out.println("The remaining suggestion card count is " + remainingCardCound);
        Assert.assertEquals(remainingCardCound, 4);


    }


}
