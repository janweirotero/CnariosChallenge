package EcomProductFiltering;

import Basefile.BrowserConfigurationForChallenges;
import org.testng.annotations.Test;

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




}
