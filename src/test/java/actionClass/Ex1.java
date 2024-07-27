package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.GenericUtilities;

public class Ex1 {

	public static void main(String[] args) {

      System.out.println("program start");
      GenericUtilities gu = new GenericUtilities();
      WebDriver driver = gu.startup("ch", "https://github.com/");
      Actions act = new Actions(driver);
//      WebElement src =driver.findElement(By.id("draggable"));
//      WebElement dec =driver.findElement(By.id("droppable"));
     // act.dragAndDrop(src, dec).perform();
    //  act.moveToElement(src).clickAndHold(src).moveToElement(dec).release().build().perform();
      WebElement src =driver.findElement(By.xpath("//span[text()=\"New\"]"));
      act.doubleClick(src);
      System.out.println("program end");

	}

}
