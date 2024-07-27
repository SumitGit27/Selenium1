package windowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.GenericUtilities;

public class Ex2 {

	public static void main(String[] args) {
		System.out.println("program start");
		
		GenericUtilities gu = new GenericUtilities();
		WebDriver driver = gu.startup("ch", "https://demoqa.com/browser-windows");
		String pwinId = driver.getWindowHandle();
		
		driver.findElement(By.id("tabButton")).click();
		
		Set<String> allwinId = driver.getWindowHandles();
		Iterator<String> itr = allwinId.iterator();
		
		while(itr.hasNext()) {
			String id = itr.next();
			if(id.equals(pwinId)) {
				id = itr.next();
			}
			driver.switchTo().window(id);
			try {
				WebElement ele = driver.findElement(By.id("sampleHeading"));
				System.out.println("  Text = "+ele.getText());
				
			}catch(Exception e) {
				driver.close();
				continue;
			}
		}
		driver.switchTo().window(pwinId);
		driver.quit();
		System.out.println("program end");
	}

}
