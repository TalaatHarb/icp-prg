package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import hooks.GlobalHooks;
import pages.locators.HomePageElementsLocator;

public class HomePageActions {

	private final HomePageElementsLocator homePageElements;

	public HomePageActions(GlobalHooks globalHooks) {
		var webDriver = globalHooks.getWebDriver();
		this.homePageElements = new HomePageElementsLocator(webDriver);
	}

	public void enterSearchTerm(String searchTerm) {
		homePageElements.searchBox.sendKeys(searchTerm);
	}

	public void clickSearchButton() {
		homePageElements.searchButton.click();
	}

	public void clickOnVersionsMenu() {
		homePageElements.versionsMenu.click();
	}

	public void clickOnVersion(String category) {
		var categories = homePageElements.versions;

		for (var categoryElement : categories) {
			if (category.equals(categoryElement.getText())) {
				categoryElement.click();
				break;
			}
		}
	}
	
	public List<WebElement> getVersions(){
		return homePageElements.versions;
	}
}
