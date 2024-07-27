package frameHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.GenericUtilities;

public class Ex1 {

	public static void main(String[] args) {
		System.out.println("program start");
		
		GenericUtilities gu = new GenericUtilities();
		WebDriver driver = gu.startup("ch", "https://demoqa.com/frames");
		WebElement ele = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(ele);
		WebElement ele1 = driver.findElement(By.id("sampleHeading"));
		System.out.println("Frame text = "+ele1.getText());
		driver.switchTo().defaultContent();
		System.out.println("program end");
	}
}
