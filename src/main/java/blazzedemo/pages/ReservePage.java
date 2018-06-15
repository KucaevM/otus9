package blazzedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.epam.web.matcher.testng.Assert.areEquals;
import static com.epam.web.matcher.testng.ScreenAssert.assertEquals;

@JPage(url = "/reserve.php")
public class ReservePage extends WebPage {
   // @JFindBy(xpath = "//div[2]/table")
   // public Table TableFlights;

   @JTable(
          root = @FindBy(xpath = "//div[2]/table"),
          row = @FindBy(xpath = ".//tr[%s]/td"),
          column = @FindBy(xpath = ".//tr/td[%s]"),
          header = {"Choose", "Flight", "Airline", "Departs", "Arrives","Prise"})
    public Table TableFlights;

   @FindBy (css = "div.container h3")
   public Text TextContainer;


   public void checkPage(String FromCity, String ToCity){
       assertEquals(TextContainer.getText(), "Flights from " + FromCity + " to " + ToCity + ":");
       TableFlights.isDisplayed();
       areEquals(TableFlights.columns().size(), 6);
       areEquals(TableFlights.rows().size(), 5);

   }

   public String clikcToChoose(int Num){
       //TableFlights.row(Num).get("Choose").click();
       //Вот так не получилось.. кликает по самой ячейке
       //В ячейке надо сначала найти кнопку, а потом ее кликнуть
       //Не нашел как это сделать

       By Locator = By.xpath("/html/body/div[2]/table/tbody/tr["+Num+"]/td[1]/input");
       Button ButtonChoose = new Button(Locator);

       String TextPage = "Airline: " + getAirlineRow(Num) + "; "
               + "Flight Number: " + getFightNumberRow(Num) + "; "
               + "Price: " + getPriseRow(Num).substring(1);

       ButtonChoose.click();

       return TextPage;
   }


    public String getTextRowTable(int Num,String ColumnName) {
        return TableFlights.row(Num).get(ColumnName).getText();
    }

    public String getAirlineRow(int Num) {
        return getTextRowTable(Num,"Airline");
    }

    public String getFightNumberRow(int Num) {
        return getTextRowTable(Num,"Flight");
    }

    public String getPriseRow(int Num) {
        return getTextRowTable(Num,"Prise");
    }
}
