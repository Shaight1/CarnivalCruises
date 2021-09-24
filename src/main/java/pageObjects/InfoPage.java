package pageObjects;

import interactions.UserActions;
import interactions.Waits;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;


public class InfoPage extends PageModel {

    WebDriver driver;
    UserActions userActions;

    private String
            learnMore = "Learn More",
            learnMoreInfo = "Learn More Info";

    public InfoPage(WebDriver driver) {
        this.driver = driver;
        userActions = new UserActions(driver);
    }

    /**
     * Enum with all dynamic xpath of the page's web elements. It returns the
     * xpath using an arbitrary name of the element.
     */
    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        ROAD_MAP("Road Map", "//route-map[@class = 'cruise-map roundtrip']//div"),
        LIST_BUTTON_LEARN_MORE("Learn More", "//div[@class = 'tile']//button"),
        LEARN_MORE_INFO("Learn More Info", "//div[@class= 'slide ccl-negative-outline slick-slide slick-current slick-active']"),
        BUTTON_BOOKING("Book Now", "//li[@id = 'sm-booking-btn']/booking-button/div");

        private String name, xpath;

        EnumWebElement(String name, String xpath) {
            this.name = name;
            this.xpath = xpath;
        }

        private String getXpath() {
            return this.xpath;
        }

        private String getName() {
            return this.name;
        }

        static private String getXpathByButtonName(String name) {
            return Stream.of(InfoPage.EnumWebElement.values())
                    .filter(x -> x.getName().equals(name))
                    .findFirst()
                    .orElse(INPUT_NOT_FOUND)
                    .getXpath();
        }
    }

    /**
     *
     * Using element's name to get xpath
     * @param name
     * @return
     */
    public String getWebElementXpathByName(String name) {
        return InfoPage.EnumWebElement.getXpathByButtonName(name);
    }

    /**
     * Using element's name to create WebElement with xpath
     *
     * @param name
     * @return A WebElement
     */
    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(InfoPage.EnumWebElement.getXpathByButtonName(name));
    }

    /**
     * Verify if information to learn more is displayed
     *
     */
    public void theInformationIsDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        getWebElementByName(learnMore).click();
        Waits.waitUltilIsDisplayedxpathShort(getWebElementXpathByName(learnMoreInfo), driver);
        Assert.assertTrue(getWebElementByName(learnMoreInfo).isDisplayed());

    }

    /**
     * verifies if an specific element is displayed
     *
     * @param button
     */
    public void theElementIsDisplayed(String button) {
        Assert.assertTrue(getWebElementByName(button).isDisplayed());
    }

    @Override
    public void waitForElement(String element) {
        Waits.waitUltilIsDisplayedXpath(getWebElementXpathByName(element), driver);
    }

    @Override
    public void clickOn(String button) {
        getWebElementByName(button).click();
    }

    @Override
    public void theUserIsRedirectedFrom(String page) {
        Assert.assertTrue("The user was not redirected towards a new page and stay at: " + page
                , userActions.theUserIsRedirectedFrom(page));
    }
}
