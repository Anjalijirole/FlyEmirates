package abstractComponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker {
public static WebDriver driver;
	
public DatePicker(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}


@FindBy(xpath="//div[contains(@class,'label-year')]")
private WebElement currentYearsDisplayed;

@FindBy(xpath="//button[contains(@class,'ek-datepicker__button ek-datepicker__button--next icon-arrow-right')]")
private WebElement nextMonthButton;

	public WebDriver datePicker(WebDriver driver,String date,String month, String year) {
		
		boolean isRequiredYearSet =  NavigateToRequiredYear(year);
		boolean isRequiredMonthSet = NavigateToRequiredMonth(month); 
		System.out.println("Month:" + isRequiredMonthSet );
		System.out.println("Year:" + isRequiredYearSet );
		if(isRequiredYearSet && isRequiredMonthSet)
		{
			System.out.println("Here");
			WebElement dateSelected = driver.findElement(By.xpath("//button[contains(@aria-label,'"+date +"  "+month+ " " + year +"')]"));
			dateSelected.click();
		}
		

		return driver;
	}
	
	
	private boolean NavigateToRequiredMonth(String month)
	{
		List<WebElement> currentMonthsDisplayed = driver.findElements(By.xpath("//div[contains(@class,'label-month')]"));
		
		for(WebElement currentMonth:currentMonthsDisplayed)
		{
			System.out.println(currentMonth.getText());
			System.out.println("RequiredMonth"+month);
			if(currentMonth.getText().equalsIgnoreCase(month))
			{
				return true;
			}	
		}
		nextMonthButton.click();
		return NavigateToRequiredMonth(month);
		 
	}
	
	private boolean NavigateToRequiredYear(String year)
	{
		List<WebElement> currentYearsDisplayed = driver.findElements(By.xpath("//div[contains(@class,'label-year')]"));
		 
		for(WebElement currentYear:currentYearsDisplayed)
		{
			System.out.println(currentYear.getText());
			if(currentYear.getText().equalsIgnoreCase(year))
			{
				return true;
			}	
		}
		nextMonthButton.click();
		return NavigateToRequiredYear(year);
	
	}


}
