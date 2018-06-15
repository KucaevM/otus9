package blazzedemo.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/")
public class HomePage extends WebPage {

    @FindBy(name = "fromPort")           public Menu ElementFromPort;
    @FindBy(name = "toPort")             public Menu ElementToPort;
    @FindBy(css = "body div > input")    public Button EnterToFind;

    public void chooseFromPort (String value){
        ElementFromPort.select(value);
    }

    public void chooseToPort (String value){
        ElementToPort.select(value);
    }

    public void enterToFindClick (){
        EnterToFind.click();
    }

    public void chooseFromPortToPort (String fromValue,String toValue){
        chooseFromPort(fromValue);
        chooseToPort(toValue);
        enterToFindClick ();

    }

}
