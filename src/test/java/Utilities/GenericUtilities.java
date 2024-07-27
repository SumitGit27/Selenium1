package Utilities;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtilities {

	public void clickByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele).perform();
	}

	public void scrollByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}

	public void moveToElementByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void contextClickByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public void doubleClickByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public void clickAndHoldByActions(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele);
	}

	public void sendKeysByActions(WebDriver driver,WebElement ele,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(ele, "value");
	}


	public void dragAndDropByActions(WebDriver driver,WebElement src,WebElement des) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, des).perform();
	}

	public void waitForFrameToSwitchByEle(WebDriver driver,int time,WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	public void waitForFrameToSwitchByObj(WebDriver driver,int time, By Obj) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Obj));
	}

	public void waitForFrameToSwitch(WebDriver driver,int time, String type, String expression) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		if(type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id(expression))));
		}else if(type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath(expression))));
		}else if(type.equalsIgnoreCase("cssSelector")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(expression))));
		}else if(type.equalsIgnoreCase("className")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.className(expression))));
		}else if(type.equalsIgnoreCase("tagName")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.tagName(expression))));
		}else if(type.equalsIgnoreCase("name")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name(expression))));
		}else if(type.equalsIgnoreCase("linkText")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.linkText(expression))));
		}else if(type.equalsIgnoreCase("partialLinkText")) {
			wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.partialLinkText(expression))));
		}
	}

	public boolean isAlertPresent(WebDriver driver, int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectByText(WebElement ddlEle, String text) {
		Select sel = new Select(ddlEle);
		sel.selectByVisibleText(text);
	}

	public void selectByValue(WebElement ddlEle, String value) {
		Select sel = new Select(ddlEle);
		sel.selectByValue(value);
	}

	public void selectByIndex(WebElement ddlEle, int index) {
		Select sel = new Select(ddlEle);
		sel.selectByIndex(index);
	}

	public List<String> getAllDDLSelectedOptionText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		List<String> ar = new ArrayList<>();
		List<WebElement> allSelectedOption = sel.getAllSelectedOptions();
		for (int i = 0; i < sel.getAllSelectedOptions().size(); i++) {
			// WebElement ele = allSelectedOption.get(i);
			// String str = ele.getText();
			// ar.add(str);
			// OR
			ar.add(sel.getAllSelectedOptions().get(i).getText());
		}
		return ar;
	}

	public List<String> getAllDDLOptionsText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		List<String> ar = new ArrayList<>();
		// List<WebElement> allOptions = sel.getOptions();
		for (int i = 0; i < sel.getOptions().size(); i++) {
			ar.add(sel.getOptions().get(i).getText());
			// OR
			// WebElement ele = allOptions.get(i);
			// String str = ele.getText();
			// ar.add(str);
		}
		return ar;
	}

	public String getDDLSelectedOptionText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		// WebElement ele = sel.getFirstSelectedOption();
		// String str = ele.getText();
		// return str;
		// OR
		return sel.getFirstSelectedOption().getText();
	}

	public int getDDLDataCount(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		return sel.getOptions().size();
	}

	public int numOfListData(List<String> allEle) {
		return allEle.size();
	}

	public List<String> getAllTextOfList(List<WebElement> allEle) {
		List<String> ar = new ArrayList<>();
		for (int i = 0; i < allEle.size(); i++) {
			ar.add(allEle.get(i).getText());
		}
		return ar;
	}

	public boolean isElementDisplayed(WebDriver driver, WebElement ele) {
		try {
			return ele.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementEnabled(WebDriver driver, WebElement ele) {
		try {
			return ele.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementSelected(WebDriver driver, WebElement ele) {
		try {
			return ele.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	public void scrollByPageDown(WebDriver driver, int numOfScroll) {
		WebElement ele = driver.findElement(By.tagName("html"));
		for (int i = 1; i <= numOfScroll; i++) {
			ele.sendKeys(Keys.PAGE_DOWN);
		}
	}

	public void scrollByJs(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void clickByJs(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

	public void waitForTitleContains(WebDriver driver, int time, String partialTitle) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.titleContains(partialTitle));
	}

	public void waitForTitleIs(WebDriver driver, int time, String Title) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.titleIs(Title));
	}

	public void waitForUrlContains(WebDriver driver, int time, String partialurl) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(partialurl));
	}

	public void waitForUrlIs(WebDriver driver, int time, String url) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlToBe(url));
	}

	public void waitForVisibilityByObject(WebDriver driver, int time, By obj) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}

	// can be used at page object model.
	public void waitForVisibilityByEle(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForVisibilityByObjectType(WebDriver driver, int time, String type, String element) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		if (type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		} else if (type.equalsIgnoreCase("className")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
		} else if (type.equalsIgnoreCase("cssSelector")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
		} else if (type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} else if (type.equalsIgnoreCase("linkText")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
		} else if (type.equalsIgnoreCase("partialLinkText")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
		} else if (type.equalsIgnoreCase("tagName")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(element)));
		} else if (type.equalsIgnoreCase("name")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		}
	}

	public void waitforvisibilityByType(WebDriver driver, int time, String type, String expression) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		if (type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(expression))));
		} else if (type.equalsIgnoreCase("className")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(expression))));
		} else if (type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(expression))));
		} else if (type.equalsIgnoreCase("cssSelector")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(expression))));
		} else if (type.equalsIgnoreCase("linkText")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(expression))));
		} else if (type.equalsIgnoreCase("partialLinkText")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(expression))));
		} else if (type.equalsIgnoreCase("tagName")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(expression))));
		} else if (type.equalsIgnoreCase("name")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(expression))));
		}
	}

	public void blockAd(WebDriver driver) {
		String pId = driver.getWindowHandle();
		Set<String> allWinIds = driver.getWindowHandles();
		Iterator<String> itr = allWinIds.iterator();
		String id = itr.next();
		if (id.equals(pId)) {
			id = itr.next();
		}
		driver.switchTo().window(id);
		driver.close();
		driver.switchTo().window(pId);
	}

	public WebDriver startup(String bName, String url) {

		WebDriver driver = null;

		if (bName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");

			// options.addArguments("--headless");
			driver = new EdgeDriver(options);
		} else if (bName.equalsIgnoreCase("firefox")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver();
		} else if (bName.equalsIgnoreCase("ch")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.addExtensions(new File("./Extensions/AdBlocker Ultimate.crx"));
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Invalid Browser Name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		blockAd(driver);
		driver.get(url);

		return driver;
	}

}
