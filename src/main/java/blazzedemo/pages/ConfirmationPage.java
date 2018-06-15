package blazzedemo.pages;

import blazzedemo.entities.Card;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;

import org.openqa.selenium.support.FindBy;
import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.Column.inColumn;
import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.WithValue.withValue;
import static com.epam.web.matcher.testng.Assert.areEquals;


@JPage(url = "/confirmation.php")
public class ConfirmationPage extends WebPage {

    @FindBy(css = "div.container h1")       public Text ActualText;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")  public Text Id;
    @FindBy(xpath = "//tbody/tr[2]/td[2]")  public Text Status;
    @FindBy(xpath = "//tbody/tr[3]/td[2]")  public Text Amount;
    @FindBy(xpath = "//tbody/tr[4]/td[2]")  public Text CardNumber;
    @FindBy(xpath = "//tbody/tr[5]/td[2]")  public Text Expiration;
    @FindBy(xpath = "//tbody/tr[6]/td[2]")  public Text AuthCode;
    @FindBy(xpath = "//tbody/tr[7]/td[2]")  public Text Date;

    @JTable(
            root = @FindBy(xpath = "//div[2]/div/table"),
            row = @FindBy(xpath = ".//tr[%s]/td"),
            column = @FindBy(xpath = ".//tr/td[%s]"),
            header = {"Col", "Cool"})
    public Table tableConfirmation;

    public void checkTextRowTable(Card CardInfo){

        tableConfirmation.isDisplayed();
        areEquals(getTextRowTable("Status"),"PendingCapture");
        areEquals(getTextRowTable("Amount"),"USD");
        areEquals(getTextRowTable("Expiration"),CardInfo.CreditCardMonth + " /" + CardInfo.CreditCardYear);
        areEquals(getTextRowTable("Card Number"), getShortCardNumber(CardInfo.CreditCardNumber));

    }
    private String getTextRowTable(String NameSearch){
       return tableConfirmation.row(withValue(NameSearch),inColumn("Col")).get("Cool").getText();
     }

    private String getShortCardNumber(String CardNumber){

       String  ShortCardNumber = "xxxxxxxxxxxx";
       if (CardNumber.length()<4) {
            ShortCardNumber = ShortCardNumber + CardNumber;
        }
        else{
            ShortCardNumber = ShortCardNumber + CardNumber.substring(CardNumber.length()-4);
        }
       return ShortCardNumber;


    }
}
