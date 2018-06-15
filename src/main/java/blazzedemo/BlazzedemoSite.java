package blazzedemo;

import blazzedemo.pages.ConfirmationPage;
import blazzedemo.pages.HomePage;
import blazzedemo.pages.PurchaseForm;
import blazzedemo.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite(value = "http://blazedemo.com")
public class BlazzedemoSite extends WebSite {
    public static HomePage homePage;
    public static ConfirmationPage confirmationPage;
    public static PurchaseForm purchaseForm;
    public static ReservePage reservePage;

}
