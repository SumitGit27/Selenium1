package alertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.GenericUtilities;

public class Ex1 {

	public static void main(String[] args) {
		System.out.println("program start");
		
		GenericUtilities gu = new GenericUtilities();
		WebDriver driver = gu.startup("ch", "https://demoqa.com/alerts");
		driver.findElement(By.id("promtButton")).click();
		
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("This is Alert");
		alt.accept();
		
		System.out.println("program end");
		
	}

}
