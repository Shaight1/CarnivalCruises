package pageObjects;

import interactions.UserActions;
import interactions.Waits;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class HomePage extends PageModel {

    WebDriver driver;
    UserActions userActions;

    private String sails = "Sails";

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        userActions = new UserActions(webDriver);
    }

    /**
     * Enum with all dynamic xpath of the page's web elements. It returns the
     * xpath using an arbitrary name of the element.
     */
    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        BUTTON_SAIL_TO("Sail To", "//a[@id = 'cdc-destinations']"),
        BUTTON_SAIL_FROM("Sail From", "//a[@id = 'cdc-ports']"),
        BUTTON_DATES("Date", "//a[@id = 'cdc-dates']"),
        BUTTON_DURATION("Duration", "//a[@id = 'cdc-durations']"),
        COLLECTION_SAILS("Sails", "//div[contains(@class, 'cdc-filter-body')]"),
        BUTTON_SEARCH_CRUISES("SEARCH CRUISES", "//li//a[@class= 'cdc-filters-search-cta']"),
        BUTTON_6_9("6 - 9 Days", "//button[@aria-label= '6 - 9 Days ']"),
        BUTTON_JAN_2021("012021", "//button[@data-value = '012021']"),
        BUTTON_DEC_2021("122021", "//button[@data-value = '122021']"),
        BUTTON_THE_BAHAMAS("The Bahamas", "//button[@aria-label= 'The Bahamas ']"),
        BUTTON_THE_BALTIMORE("Baltimore, MD", "//button[contains(@aria-label, 'Baltimore, MD')]"),
        BUTTON_THE_CHARLESTON("Charleston, SC", "//button[contains(@aria-label, 'Charleston, SC')]");


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
            return Stream.of(EnumWebElement.values())
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
        return EnumWebElement.getXpathByButtonName(name);
    }

    /**
     * Using element's name to create WebElement with xpath
     *
     * @param name
     * @return A WebElement
     */
    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(EnumWebElement.getXpathByButtonName(name));
    }

    /**
     * Selecting value from each of field needed to search cruise with identifier
     *
     *
     * @param element
     * @param value
     */
    public void selectValueFrom(String element, String value) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getWebElementByName(element).click();
        Waits.waitUltilIsDisplayedxpathShort(getWebElementXpathByName(sails), driver);

        getWebElementByName(value).click();
    }

    public void closeSection(String element, String value){
        getWebElementByName(element).click();
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

    @Override
    public void waitForElement(String element) {
        Waits.waitUltilIsDisplayedXpath(getWebElementXpathByName(element), driver);
    }
}
