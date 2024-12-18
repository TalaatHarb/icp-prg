package pages.locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElementsLocator {

	@FindBy(xpath = "//*[@id=\"search-bar\"]")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"search-button\"]")
	public WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"toggle-dropdown\"]")
	public WebElement versionsMenu;

	@FindBy(xpath = "//*[@id=\"versions-menu\"]/button")
	public List<WebElement> versions;

	public HomePageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
