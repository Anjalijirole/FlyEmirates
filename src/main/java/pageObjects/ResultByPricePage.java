package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class ResultByPricePage extends AbstractComponent{
	public ResultByPricePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement ContinueBttn;

	public void ClickOnContinue()
	{
		ContinueBttn.click();
	}
}
