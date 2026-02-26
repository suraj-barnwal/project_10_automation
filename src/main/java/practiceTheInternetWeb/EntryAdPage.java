package practiceTheInternetWeb;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public EntryAdPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href=\"/entry_ad\"]") WebElement entryAd;
	@FindBy(xpath = "//p[text()='Close']") WebElement ad;
	@FindBy(xpath = "//a[@id=\"restart-ad\"]") WebElement restartAd;
	
	public void clickOnEntryAd() {
		entryAd.click();
	}
	public void clicOnCloseAd() {
		waitForVisibility(ad);
		ad.click();
	}
	public void clickOnRestartAd() {
		waitForVisibility(restartAd);
		restartAd.click();
	}
	public void reStart() {
		waitForVisibility(ad);
		ad.click();
	}
	public void waitForVisibility(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		EntryAdPage ob = new EntryAdPage(driver);
		ob.clickOnEntryAd();
		ob.clicOnCloseAd();
		ob.clickOnRestartAd();
		ob.reStart();
	}
}
