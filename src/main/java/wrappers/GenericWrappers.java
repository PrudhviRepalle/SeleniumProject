package wrappers;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {
	static RemoteWebDriver driver;
	static Properties prop;
	static JavascriptExecutor js;

	@Override
	public void invokeApp(String browser, String url, boolean flag) {

		if (flag) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setPlatform(Platform.WINDOWS);
			dc.setBrowserName(browser);
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.29.15:6666/wd/hub"), dc);
				driver.get(url);
				driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				} else if (browser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver", "./drivers/iedriver.exe");
					driver = new InternetExplorerDriver();
				}
				driver.get(url);
				driver.manage().window().maximize();

				// System.out.println("The browser launched successfully");
				logTestStatus_report("Pass", "The browser launched successfully", true);
			} catch (TimeoutException e) {
				logTestStatus_report("Fail", "The application is taking more time to load", true);
				/// System.err.println("The application is taking more time to load");
			} catch (NoSuchSessionException e) {
				System.err.println("No session  created, Check your browser versions");
				logTestStatus_report("Fail", "No session  created, Check your browser versions ", true);
			} catch (WebDriverException e) {
				System.err.println("The browser not launched due to webdriver exception");
				logTestStatus_report("Fail", "The browser not launched due to webdriver exception", true);
			}
		}

	}

	public void loadProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("./project_properties/Env.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).sendKeys(data);
			logTestStatus_report("info", "Data enterd Successfull", true);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			logTestStatus_report("Fail", "The element is not present to enter data", true);
			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("stale element error ,the element no longer appears on DOM");
			logTestStatus_report("Fail", "stale element error ,the element no longer appears on DOM can't enter data",
					true);
		}

	}

	@Override
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			logTestStatus_report("info", "Data enterd Successfull", true);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			logTestStatus_report("Fail", "The element is not present to  enter data", true);
			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("staleelement error ,the element no longer appears on DOM");
			logTestStatus_report("Fail", "stale element error ,the element no longer appears on DOM to enter data",
					true);
		}
	}

	@Override
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			logTestStatus_report("info", "Data enterd Successfull", true);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			logTestStatus_report("Fail", "The element is not present to enter data", true);

			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("staleelement error ,the element no longer appears on DOM");
			logTestStatus_report("Fail", "stale element error ,the element no longer appears on DOM to enter data",
					true);
		}
	}

	@Override
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String tit = driver.getTitle();
			if (tit.equals(title)) {
				System.out.println("Title is matching");
				logTestStatus_report("pass", "Title is matching", true);
			} else {
				System.out.println("Title is mismatched");
				logTestStatus_report("Fail", "Title is mismatched", true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logTestStatus_report("Fail", " exception occured while verifing title", true);
		}

	}

	@Override
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementById(id).getText();
			if (tex.equals(text)) {
				System.out.println("Text is matching");
				logTestStatus_report("pass", "Text is matching", true);
			} else {
				System.out.println("Text is mismatched");
				logTestStatus_report("Fail", "Text is mismatched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present can't verify", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception can't verify", true);
		}
	}

	@Override
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementByXPath(xpath).getText();
			if (tex.equals(text)) {
				System.out.println("Text is matching");
				logTestStatus_report("Pass", "Text is matching", true);
			} else {
				System.out.println("Text is mismatched");
				logTestStatus_report("Fail", "Text is mismatched", true);
			}

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present can't verify", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception can't verify", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception can't verify", true);
		}
	}

	@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementByXPath(xpath).getText();
			if (tex.contains(text)) {
				System.out.println("Text is present");
				logTestStatus_report("Pass", "Text is present", true);
			} else {
				System.out.println("Text is not present");
				logTestStatus_report("Fail", "Text is not present", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present can't verify", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception can't verify", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exceptioncan't get text", true);
		}

	}

	@Override
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			logTestStatus_report("Pass", "Clicked successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to click");
			logTestStatus_report("Fail", "Element is not present to click", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to click", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to click", true);
		}

	}

	@Override
	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(classVal).click();
			logTestStatus_report("Pass", "Clicked successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to perform click", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to perform click", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to perform click", true);
		}
	}

	@Override
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			logTestStatus_report("Pass", "Clicked Successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to clcik", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to click", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to click", true);
		}
	}

	@Override
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			logTestStatus_report("Pass", "Clicked Successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to click", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to click", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to click", true);
		}

	}

	@Override
	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			logTestStatus_report("Pass", "Clicked Successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to click", true);

		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to click", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to click", true);
		}
	}

	@Override
	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		try {
			String data = driver.findElementById(idVal).getText();
			logTestStatus_report("pass", "Text got from element", true);
			return data;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to get text", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to gettext", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to get text", true);
		}
		return idVal;

	}

	@Override
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String data = driver.findElementByXPath(xpathVal).getText();
			logTestStatus_report("Pass", "Text got from element", true);
			return data;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to get text", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception to get text", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception to get text", true);
		}
		return xpathVal;
	}

	@Override
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementById(id);
			Select sel = new Select(test);
			sel.selectByVisibleText(value);
			logTestStatus_report("Pass", " text got selected", true);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exceptio", true);
		}

	}

	public void selectValueByXpath(String Xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByValue(value);
			logTestStatus_report("Pass", " Selected successfully", true);

		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception", true);
		}
	}

	public void selectVisibileTextByXpath(String Xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByVisibleText(value);
			logTestStatus_report("Pass", "Selected from dropdown", true);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not visible to select from dropdown");
			logTestStatus_report("Fail", "Element is not visible to select from dropdown", true);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not selectable to select from dropdown", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception", true);
		}

	}

	@Override
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementById(id);
			Select sel = new Select(test);
			sel.selectByIndex(value);
			logTestStatus_report("Pass", "Selected from dropdown", true);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not visbile to select from dropdown", true);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not selectable to get text");
			logTestStatus_report("Fail", "Element is not selectable to select from dropdown", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
			logTestStatus_report("Fail", "Element is not present to select from dropdown", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception", true);
		}

	}

	public void selectIndexByXpath(String Xpath, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByIndex(value);
			logTestStatus_report("Pass", "Selected from dropdown", true);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not visible to select from dropdown");
			logTestStatus_report("Fail", "", true);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not selectable to select from dropdown");
			logTestStatus_report("Fail", "", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to select from dropdown ");
			logTestStatus_report("Fail", "Element is not present to select from dropdown ", true);
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
			logTestStatus_report("Fail", "stale element exception", true);
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
			logTestStatus_report("Fail", "WebDriver exception", true);
		}
	}

	@Override
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> window = driver.getWindowHandles();
			for (String windows : window) {
				driver.switchTo().window(windows);
				break;
			}
			logTestStatus_report("Pass", "Switched to parent window", true);
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");
			logTestStatus_report("Fail", "Window is not present", true);

		} catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
			logTestStatus_report("Fail", "Window cant switch webdriver exception", true);
		}

	}

	@Override
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> window = driver.getWindowHandles();
			for (String windows : window) {
				driver.switchTo().window(windows);
			}
			logTestStatus_report("Pass", "Switched to parent window", true);
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");
			logTestStatus_report("Fail", "Window is not present", true);

		} catch (WebDriverException e) {
			System.err.println("Window can't switch webdriver exception");
			logTestStatus_report("Fail", "Window can't switch webdriver exception", true);
		}

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			logTestStatus_report("Pass", "Alert accepted", true);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to accept alert");
			logTestStatus_report("Fail", "Alert is not present to accept alert", true);
		}

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			logTestStatus_report("Pass", "Alert is dismissed", true);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to dismiss");
			logTestStatus_report("Fail", "Alert is not present to accept alert", true);

		}

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
			logTestStatus_report("Pass", "Text got from the alert", false);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to get text");
			logTestStatus_report("Fail", "Alert is not present to get text", false);

		}
		return text;
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			logTestStatus_report("Pass", "Browser got closed", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logTestStatus_report("Fail", "Webdriver exception to close browser", false);
		}

	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			logTestStatus_report("Pass", "Browser is Quit", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logTestStatus_report("Fail", "Webdriver exception to Quit browser", false);
		}

	}

	public void threadWait(long time) {
		try {
			Thread.sleep(time);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverException e) {
			System.err.println("webdriver exception");
		}
	}

	public void switchtoWondowIndex(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> window = driver.getWindowHandles();
			ArrayList<String> windows = new ArrayList<String>(window);
			driver.switchTo().window(windows.get(index));
			logTestStatus_report("Pass", "Switched to window", true);
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");
			logTestStatus_report("Fail", "Window is not present", true);
		} catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
			logTestStatus_report("Fail", "Window cant switch webdriver exception", true);
		}
	}

	public void sendFile(String path) {
		try {
			StringSelection fi = new StringSelection(path);// path of the file to be selected to be given here
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fi, null);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			logTestStatus_report("Pass", "File is selected and sent", true);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logTestStatus_report("Fail", "Headless exception", true);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logTestStatus_report("Fail", "AWTException", true);
		}

	}

	public void moveToElementByXpath(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementByXPath(value);
			act.moveToElement(a).perform();
			logTestStatus_report("Pass", "Moved to specified location", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println(" element is not present");
			logTestStatus_report("Fail", " element is not present", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriverException");
			logTestStatus_report("Fail", "WebDriverException", true);
		}

	}

	public void moveToElementByID(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementById(value);
			act.moveToElement(a).perform();
			logTestStatus_report("Pass", "Moved to specified location", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("element is not present");
			logTestStatus_report("Fail", "element is not present", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WWebDriverException");
			logTestStatus_report("Fail", "WebDriverException", true);
		}
	}

	public void contextClickByID(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementById(value);
			act.contextClick(a).perform();
			logTestStatus_report("Pass", "Performed right click", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present");
			logTestStatus_report("Fail", "Element is not present to click", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriverException");
			logTestStatus_report("Fail", "WebDriverException", true);
		}
	}

	public void contextClickByXpath(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementByXPath(value);
			act.contextClick(a).perform();
			logTestStatus_report("Pass", "Performed Right Click", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present");
			logTestStatus_report("Fail", "Element is not present to click", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriverException");
			logTestStatus_report("Fail", "WebDriverException", true);
		}
	}

	public void doubleClickByXpath(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementByXPath(value);
			act.doubleClick(a).perform();
			logTestStatus_report("Pass", "Performed Double click", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to double click");
			logTestStatus_report("Fail", "Element is not present to double click", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriver Exception can't doubleClick");
			logTestStatus_report("Fail", "WebDriver Exception can't doubleClick", true);
		}
	}

	public void doubleClickById(String value) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementById(value);
			act.doubleClick(a).perform();
			logTestStatus_report("Fail", "", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to double click");
			logTestStatus_report("Fail", "Element is not present to double click", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriver Exception can't doubleClick");
			logTestStatus_report("Fail", "WebDriver Exception can't doubleClick", true);

		}
	}

	public void dragAndDropByXpath(String source, String dest) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementByXPath(source);
			WebElement b = driver.findElementByXPath(dest);
			act.dragAndDrop(a, b).perform();
			logTestStatus_report("Pass", "Performed Drag and drop successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to perform drag and drop");
			logTestStatus_report("Fail", "Element is not present to perform drag and drop", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriver exception  to perform drag and drop");
			logTestStatus_report("Fail", "WebDriver exception  to perform drag and drop", true);
		}
	}

	public void dragAndDropById(String source, String dest) {
		try {
			Actions act = new Actions(driver);
			WebElement a = driver.findElementById(source);
			WebElement b = driver.findElementById(dest);
			act.dragAndDrop(a, b).perform();
			logTestStatus_report("Pass", "Performed Drag and drop successfully", true);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to perform drag and drop");
			logTestStatus_report("Fail", "Element is not present to perform drag and drop", true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriver exception  to perform drag and drop");
			logTestStatus_report("Fail", "WebDriver exception  to perform drag and drop", true);
		}
	}

	@Override
	public long takeSnap() {

		// TODO Auto-generated method stub
		long name = 0;
		try {
			name = Math.round((Math.random() * 1000000l));
			File screen = driver.getScreenshotAs(OutputType.FILE);

			File dest = new File("./screenshots/" + name + ".jpeg");

			FileUtils.copyFile(screen, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;

	}

	public void webDriverWait() {

		WebElement we = driver.findElementById("");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(we)).sendKeys("");
	}

	public void fluentWaitZ() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.ignoring(StaleElementReferenceException.class);
		wait.pollingEvery(Duration.ofMillis(2));
		wait.withTimeout(Duration.ofSeconds(30));
	}

	public void selectingCalanderYearMonthDateWithoutSelect(String calenderXpath, String yeardrpdwnXpath,
			String value) {
		clickByXpath(calenderXpath);
		threadWait(1000);
		WebElement drpdn = driver.findElementByXPath(yeardrpdwnXpath);
		Select se = new Select(drpdn);

		List<WebElement> opt = se.getAllSelectedOptions();
		String firstText = opt.get(0).getText();

		while (!firstText.equalsIgnoreCase(yeardrpdwnXpath)) {
			clickByXpath("");
			firstText = opt.get(0).getText();
		}
//	return text;
	}

    public void scrolldown(int startvalue,int stopvalue) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy("+startvalue+","+stopvalue+")");
     }
     public void scrollUp(int startvalue,int stopvalue) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy("+startvalue+",-"+stopvalue+")");
      }

//public void ScrolldownUnitllElementFind(int startvalue,int stopvalue) {
////Locating element by link text and store in variable "Element"        		
//   WebElement Element = 
//// Scrolling down the page till the element is found		
//     js.executeScript("arguments[0].scrollIntoView();", Element);
   public void clickElementByXpathExplictwait(String xpath) {
	   WebDriverWait wait1 = new WebDriverWait(driver, 30);
	  
	   WebElement element1 = wait1.until(ExpectedConditions.visibilityOf( driver.findElementByXPath(xpath)));
	   element1.click();
   }
   
}

