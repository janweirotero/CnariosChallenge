package EcomProductFiltering;

import Basefile.BrowserConfigurationForChallenges;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilteringTestCases extends BrowserConfigurationForChallenges {

    FilteringCall FilObject;

    @Test
    public void callPLP_01(){

    FilObject = new FilteringCall(driver);
    FilObject.PLP_01();

    }

    @Test
    public void callPLP_02(){
        FilObject = new FilteringCall(driver);
        FilObject.PLP_02();

    }

    @Test
    public void callPLP_03(){
        FilObject = new FilteringCall(driver);
        FilObject.PLP_03();

    }

    @Test
    public void callPLP_04(){
        FilObject = new FilteringCall(driver);
        FilObject.PLP_04();

    }

    @Test
    public void callPLP_05(){
        FilObject = new FilteringCall(driver);
        FilObject.PLP_05();

    }

    @Test
    public void callPLP_06(){
        FilObject = new FilteringCall(driver);
        FilObject.PLP_06();

    }

}
