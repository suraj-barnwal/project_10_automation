package practiceTheInternetWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {
	
	WebDriver driver;   //Page class codes
	public DropDownHandle(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href=\"/dropdown\"]")
	WebElement dropdown;
	@FindBy(id = "dropdown")
	WebElement dropdownLink;
	
	public void clickOnDropdown() {
		dropdown.click();
	}
	public void clickOnLink() {
		dropdownLink.click();
	}
	public void selectOnVisibleText() {  //We can create this on utilities.
		Select sc = new Select(dropdownLink);
		sc.selectByVisibleText("Option 1");
		sc.selectByVisibleText("Option 2");
	}
	
	
	public static void main(String[] args) {   //Base Library Codes
		WebDriver driver = new ChromeDriver();         
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		
		
		DropDownHandle dh = new DropDownHandle(driver);  //Test class codes
		dh.clickOnDropdown();
		dh.clickOnLink();
		dh.selectOnVisibleText();
	}	
}
