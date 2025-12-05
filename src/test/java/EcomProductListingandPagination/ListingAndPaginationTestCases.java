package EcomProductListingandPagination;

import Basefile.BrowserConfigurationForChallenges;

import org.testng.annotations.Test;

public class ListingAndPaginationTestCases extends BrowserConfigurationForChallenges {

    ListingAndPaginationCall LPLObject;

    @Test
    public void PLP_02() {

        LPLObject = new ListingAndPaginationCall(driver);
        LPLObject.PLP_02();

    }




}
