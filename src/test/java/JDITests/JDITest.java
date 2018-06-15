package JDITests;

import blazzedemo.entities.Card;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;
import static blazzedemo.BlazzedemoSite.*;


public class JDITest extends BaseTest {

    @Test
    public void TestJDI(){

        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/FirstTest/chromedriver.exe");

        String FromCity = "Boston";
        String ToCity = "Rome";
        int NumRow = 4;
        Card CardInfo = new Card();

        homePage.open();
        homePage.chooseFromPortToPort(FromCity,ToCity);

        reservePage.checkPage(FromCity,ToCity);
        String TextReservePage = reservePage.clikcToChoose(NumRow);

        purchaseForm.checkTextContainer(FromCity,ToCity);
        Assert.assertContains(purchaseForm.getTextPage(),TextReservePage);
        purchaseForm.submit(CardInfo,"btn btn-primary");

        confirmationPage.checkTextRowTable(CardInfo);

    }


}

