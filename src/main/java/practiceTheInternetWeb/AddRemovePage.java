package practiceTheInternetWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {
	
	WebDriver driver;
	public AddRemovePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href=\"/add_remove_elements/\"]") WebElement addRemove;
	@FindBy(xpath = "//button[@onclick=\"addElement()\"]") WebElement addElement;
	@FindBy(xpath = "//button[@class=\"added-manually\"]") WebElement delete;
	
	public void clickOnAddRemBtn() {
		addRemove.click();
	}
	public void clickOnAddElement() {
		for(int i=1;i<=20;i++) {
			addElement.click();
		}
	}
	public void clickOnDelete() {
		for(int i=0;i<=20;i++) {
			delete.click();
		}
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		AddRemovePage ob = new AddRemovePage(driver);
		ob.clickOnAddRemBtn();
		ob.clickOnAddElement();
		ob.clickOnDelete();
	}

}
