package Basefile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfigurationForChallenges {

    public WebDriver driver;


    public void initializedDrivers() throws IOException {

        Properties prop = new Properties();
        FileInputStream location = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Cnarios\\src\\test\\java\\Basefile\\Browser Name");
        prop.load(location);

        //prop.getProperty to get the value in Browser Name file
        //System.getProperty to get the value in the system
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();


    }

    @BeforeMethod(alwaysRun = true)
    public void getStarted() throws IOException {

        initializedDrivers();
        driver.get("https://www.cnarios.com/challenges");


    }

    /*@AfterMethod
    public void closeBrowser(){

        driver.quit();
    }*/




}
