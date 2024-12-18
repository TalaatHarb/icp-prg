package steps;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pages.HomePageActions;

@RequiredArgsConstructor
@Slf4j
public class HomeSteps {

	private final HomePageActions homePage;

	@When("Looking into the list of available versions")
	public void lookingIntoTheListOfAvailableVersions() {
	    homePage.clickOnVersionsMenu();
	}
	@Then("I find the list of available versions")
	public void iFindTheListOfAvailableVersions() {
	    var versionsList = homePage.getVersions();
	    assertNotNull(versionsList);
	}
}
