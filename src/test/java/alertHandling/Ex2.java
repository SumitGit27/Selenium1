package alertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.GenericUtilities;

public class Ex2 {

	public static void main(String[] args) {
		System.out.println("program start");
		GenericUtilities gu = new GenericUtilities();
		WebDriver driver = gu.startup("ch", "https://demoqa.com/alerts");
		driver.findElement(By.id("timerAlertButton")).click();
		gu.isAlertPresent(driver, 10);
		
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println("Alert Text = "+text );
		
		System.out.println("program end");

	}

}
