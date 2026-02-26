package practiceTheInternetWeb;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public MultipleWindowPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href=\"/windows\"]") WebElement multipleWindows;
	@FindBy(xpath = "//a[text()='Click Here']") WebElement clickHereNew;
	
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void clickOnMultipleWindow() {
		multipleWindows.click();
	}
	public void clickOnNewWindow() throws InterruptedException{
		waitForClick(clickHereNew);
		Thread.sleep(1000);
		clickHereNew.click();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		MultipleWindowPage ob = new MultipleWindowPage(driver);
		ob.clickOnMultipleWindow();
		ob.clickOnNewWindow();
	}
}
