package Practice_Buttons;

import Basefile.BrowserConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons_Test_Cases extends BrowserConfiguration {

    ButtonsCall buttonsObj;

    @Test
    public void BTN_001() {

        buttonsObj = new ButtonsCall(driver);
        boolean check = buttonsObj.button_001();
        Assert.assertTrue(check);

    }

    @Test
    public void BTN_002() {

        buttonsObj = new ButtonsCall(driver);
        buttonsObj.button_002();

    }

    @Test
    public void BTN_003() {

        buttonsObj = new ButtonsCall(driver);
        buttonsObj.button_003();


    }

    @Test
    public void BTN_004() {

        buttonsObj = new ButtonsCall(driver);
        buttonsObj.button_004();

    }

    @Test
    public void BTN_005() {

        buttonsObj = new ButtonsCall(driver);
        buttonsObj.button_005();

    }


}
