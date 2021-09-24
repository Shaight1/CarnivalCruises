package stepDefinitions;

import Tasks.SmokeTestingTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import util.JsonReader;

public class SmokeTestingStepsDefinitions {
    private String carnival = "Carnival Cruise";
    private JSONObject jsonObjectValidInfo;
    private SmokeTestingTasks smoketestingTasks;

    @Given("^The user gets into \"(.*?)\" page$")
    public void theUserGetsIntoCarnivalCruisePage(String page) {
        jsonObjectValidInfo = JsonReader.getInfoPackage("Valid Information");
        smoketestingTasks = new SmokeTestingTasks(Hook.driver);
        smoketestingTasks.getInto(jsonObjectValidInfo, page);
    }

    @When("The user enters the needed information")
    public void theUserEntersTheNeededInformation() {
        smoketestingTasks.enterTheSearchInformation(jsonObjectValidInfo);
    }

    @When("Click on \"(.*?)\" button")
    public void clickOnSearchCruisesButton(String button) {
        smoketestingTasks.clickOn(button);
    }

    //<editor-fold desc="User Story #1">
    @Given("User is  redirected to result page")
    public void theUserIsRedirectedToTheResultPage() {
        smoketestingTasks.theUserIsRedirected(JsonReader.getValueFromPackage(jsonObjectValidInfo, carnival));
        smoketestingTasks.goToCurrentPage();
    }

    @When("user see result")
    public void theUserVisualizesTheResults() {
        smoketestingTasks.waitForTheResultToBeShown();
    }

    @Then("results are shown in a grid")
    public void theseAreShownAsAGrid() {
        smoketestingTasks.theResultsAreShownAsAGrid();
    }

    @Given("results are shown")
    public void theResultAreAlreadyShown() {
        smoketestingTasks.waitForTheResultToBeShown();
        smoketestingTasks.theResultsAreShownAsAGrid();
    }

    @Given("user use slider bar")
    public void theUserFiltersByPriceUsingTheSlideBar() {
        smoketestingTasks.theUserFilterUsingTheSlideBar(jsonObjectValidInfo);
    }

    @Then("results varies in the range")
    public void theResultsChangeIntoTheRange() {
        smoketestingTasks.theResultsChangeIntoTheRange();
    }

    @When("The user clicks on \"(.*?)\" button")
    public void theUserClicksOnButton(String button) {
        smoketestingTasks.clickOn(button);
    }

    @Then("default value will be the cheapest")
    public void theDefaultValueWillBeTheCheapestFirst() {
    }
    //</editor-fold>

    //<editor-fold desc="User Story#2">
    @Given("The user select a result from the list")
    public void theUserSelectsOneOfTheCruiseOfTheResultSet() {
        smoketestingTasks.waitForTheResultToBeShown();
        smoketestingTasks.theResultsAreShownAsAGrid();
        smoketestingTasks.theUserClickOnTheFirstResult();
    }

    @Then("^The user see \"(.*?)\" page loads$")
    public void theUserIsRedirectedTowardsTheItineraryPage(String page) {
        smoketestingTasks.theUserIsRedirected(page);
    }

    @When("The user clicks on \"Learn More\" button of each day")
    public void theUserClickOnLearnMoreButtonOfADay() {
    }

    @Then("The information of each day is displayed when clicked.")
    public void theInformationOfThatDayIsDisplayed() {
        smoketestingTasks.goToCurrentPage();
        smoketestingTasks.waitForBanner();
        smoketestingTasks.theInformationIsDisplayed();
    }

    @Then("An \"(.*?)\" button is  displayed.")
    public void anInformationOfThatDayIsDisplayed(String button) {
        smoketestingTasks.waitForBanner();
        smoketestingTasks.theElementIsDisplayed(button);
    }
    //</editor-fold>

}
