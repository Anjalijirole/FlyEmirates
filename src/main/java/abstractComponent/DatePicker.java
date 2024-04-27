package abstractComponent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

	public WebDriver datePicker(WebDriver driver,String inputDate) {
		
		String year = getYear(inputDate);
	    String month = getMonth(inputDate);
	    String date = getDay(inputDate);
		boolean isRequiredYearSet =  NavigateToRequiredYear(year);
		boolean isRequiredMonthSet = NavigateToRequiredMonth(month); 
		if(isRequiredYearSet && isRequiredMonthSet)
		{	
			WebElement dateSelected = driver.findElement(By.xpath("//button[contains(@aria-label,'"+ date +"  "+month+ " " + year +"')]"));
			dateSelected.click();
		}
		return driver;
	}
	
	
	public String convertToLongFormat(String inputDate) {
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.ENGLISH);
	        String longFormatDate = date.format(outputFormatter);
	        String[] dateParts = longFormatDate.split(", ");
	        String dayOfWeek = dateParts[0];
	        String day = dateParts[1].split(" ")[0];
	        String month = dateParts[1].split(" ")[1];
	        String year = dateParts[1].split(" ")[2];
	        return  dayOfWeek + ", " + day +" " + month + " " + year;
	    }
	
	private String getDay(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return String.valueOf(date.getDayOfMonth());
    }

	public static String getMonth(String inputDate) {
	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate date = LocalDate.parse(inputDate, inputFormatter);
	    String month = date.getMonth().toString();
	    return month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
	}

	private String getYear(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return String.valueOf(date.getYear());
    }
	
	private boolean NavigateToRequiredMonth(String month)
	{
		List<WebElement> currentMonthsDisplayed = driver.findElements(By.xpath("//div[contains(@class,'label-month')]"));
		for(WebElement currentMonth:currentMonthsDisplayed)
		{
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
