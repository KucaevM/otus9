package blazzedemo.pages;

import blazzedemo.entities.Card;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.web.matcher.testng.Assert.areEquals;
import static com.epam.web.matcher.testng.ScreenAssert.assertEquals;

public class PurchaseForm extends Form<Card> {

    @FindBy(css = "#inputName")                         public Input InputName;
    @FindBy(css = "#address")                           public Input Address;
    @FindBy(css = "#city")                              public Input City;
    @FindBy(css = "#state")                             public Input State;
    @FindBy(css = "#zipCode")                           public Input ZipCode;
    @FindBy(css = "#cardType")                          public Dropdown СardType;
    @FindBy(css = "#creditCardNumber")                  public Input CreditCardNumber;
    @FindBy(css = "#creditCardMonth")                   public Input CreditCardMonth;
    @FindBy(css = "#creditCardYear")                    public Input CreditCardYear;
    @FindBy(css = "#nameOnCard")                        public Input NameOnCard;
    @FindBy(css = "div [class = 'btn btn-primary']")    public Button EnterBtn;

    @FindBy(css = "div.container > h2")                public Text TextContainer;
    @FindBy(css = "div.container p:nth-child(2)")      public Text TextAirline;
    @FindBy(css = "div.container p:nth-child(3)")      public Text TextFlight;
    @FindBy(css = "div.container p:nth-child(4)")      public Text TextPrice;


    public String getTextPage(){
        String TextPage = TextAirline.getText() + "; "
                + TextFlight.getText() + "; "
                + TextPrice.getText();
        return TextPage;
    }
     public void checkTextContainer(String FromCity, String ToCity){
            assertEquals(TextContainer.getText(),  "Your flight from " + FromCity + " to " + ToCity + " has been reserved.");
    }


}
