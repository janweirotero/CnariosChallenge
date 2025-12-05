package WaitFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitingCall {

    WebDriver driver;
    WebDriverWait wait;

    public waitingCall(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void waitForTheFollowButton(WebElement followButton) {

        wait.until(ExpectedConditions.visibilityOf(followButton));

    }

    public void waitForTheUnfollowButton(By unfollowButton) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(unfollowButton));

    }

    public void waitForThePageToLoad(WebElement pageLoad){

        wait.until(ExpectedConditions.visibilityOf(pageLoad));
    }
}
