package JDITests;

import blazzedemo.BlazzedemoSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeClass;

public class BaseTest extends TestNGBase {
    @BeforeClass()
    public static void SetUp(){

        WebSite.init(BlazzedemoSite.class);
    }
}
