package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers implements Wrappers {
	RemoteWebDriver driver;
	WebDriverWait wait;
	public void invokeApp(String browser, String url) {

		// TODO Auto-generated method stub
		try {
			if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			if (browser.equals("firefox")) {
				System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browser.equals("IE")) {
				System.setProperty("webdriver.internetexplorer.driver", "./drivers/internetexplorerdriver.exe");
				driver = new InternetExplorerDriver();
			}
			wait =   new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.get(url);
		} catch (NoSuchSessionException e) {

			System.err.println("The browser is not launvhed successfully");

		} catch (SessionNotCreatedException e) {
			System.err.println("The browser session is not created");
		} catch (WebDriverException e) {
			System.err.println("The browser not launched because of webdriver exception");
		}finally {
			takeSnap();
		}

	}

	public void enterById(String idValue, String data) {
		try {
			WebElement a = driver.findElementById(idValue);
			wait.until(ExpectedConditions.visibilityOf(a));
			a.sendKeys(data);
		} catch (NoSuchElementException e) {
			System.err.println("The id locator " + idValue + " is not available in DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + idValue + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id locator " + idValue + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + idValue + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The data is not entered in  element with id locator " + idValue );

		}finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			WebElement a = driver.findElementByName(nameValue);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByName(nameValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The name locator " + nameValue + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with name locator " + nameValue + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name locator " + nameValue + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name locator " + nameValue + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The data is not entered in  element with name locator " + nameValue );

		}finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByXPath(xpathValue);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByXPath(xpathValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpathValue + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpathValue + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath locator " + xpathValue + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpathValue + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The data is not entered in  element with name locator " + xpathValue );

		}finally {
			takeSnap();
		}

	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.getTitle();
			if (title.equals(actual)) {
				System.out.println("Title is correct");
			} else {
				System.out.println("Tiles i not correct");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The title is not captured");
		}finally {
			takeSnap();
		}

	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.findElementById(id).getText();

			if (text.equals(actual)) {
				System.out.println("Text matches");
			} else {
				System.out.println("Text not matches");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + id + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + id + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + id + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + id + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The text is not captured with id locator " + id );

		}finally {
			takeSnap();
		}

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.findElementByXPath(xpath).getText();

			if (text.equals(actual)) {
				System.out.println("Text matches");
			} else {
				System.out.println("Text not matches");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpath + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpath + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath locator " + xpath + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpath + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The text is not captured with xpath locator " + xpath );

		}finally {
			takeSnap();
		}

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.findElementByXPath(xpath).getText();

			if (actual.contains(text)) {
				System.out.println("Text matches");
			} else {
				System.out.println("Text not matches");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpath + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpath + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath locator " + xpath + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpath + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The text is not captured with xpath locator " + xpath );

		}finally {
			takeSnap();
		}

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementById(id);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementById(id).click();
		} 
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + id + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + id + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id locator " + id + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + id + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with id locator " + id + "is not clickable");

		}finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByName(classVal);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByClassName(classVal).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The classname locator " + classVal + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with classname locator " + classVal + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with classname locator " + classVal + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with classname locator " + classVal + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with classname locator " + classVal + "is not clickable");

		}finally {
			takeSnap();
		}

	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByName(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByName(name).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The classname locator " + name + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with name locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with name locator " + name + "is not clickable");

		}finally {
			takeSnap();
		}

	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByLinkText(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The linktext locator " + name + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with linktext locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with linktext locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with linktext locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with linktext locator " + name + "is not clickable");

		}finally {
			takeSnap();
		}

	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByLinkText(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The linktext locator " + name + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with linktext locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with linktext locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with linktext locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with linktext locator " + name + "is not clickable");

		}


	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByXPath(xpathVal);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpathVal + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with xpath locator " + xpathVal + "is not clickable");

		}finally {
			takeSnap();
		}


	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByXPath(xpathVal);
			wait.until(ExpectedConditions.visibilityOf(a));
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpathVal + " is not available in DOM");
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpathVal + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The element with xpath locator " + xpathVal + "is not clickable");

		}

	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String text=null;
		try {
			 text=driver.findElementById(idVal).getText();
			
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + idVal + " is not available in DOM");
			
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + idVal + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + idVal + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + idVal + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The text is not captured with id locator " + idVal );

		}finally {
			takeSnap();
		}
		
		return text;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String text=null;
		try {
			 text = driver.findElementByXPath(xpathVal).getText();
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + xpathVal + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + xpathVal + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + xpathVal + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + xpathVal + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The text is not captured with id locator " + xpathVal );

		}finally {
			takeSnap();
		}
		return text;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementById(id);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementById(id);
			Select obj1 = new Select(obj);
			obj1.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + id + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + id + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + id + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + id + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with id locator " + id );

		}finally {
			takeSnap();
		}

	}
	
	
	public void selectByvalue(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByXPath(xpath);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementByXPath(xpath);
			Select obj1 = new Select(obj);
			obj1.selectByValue(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpath + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpath + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + xpath + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpath + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with xpath locator " + xpath );

		}finally {
			takeSnap();
		}

	}
	
	
	public void selectByvalueName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByName(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementByName(name);
			Select obj1 = new Select(obj);
			obj1.selectByValue(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The name locator " + name + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with name locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with name locator " + name );

		}finally {
			takeSnap();
		}

	}
	
	
	
	public void selectvisibletextByxpath(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByXPath(xpath);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementByXPath(xpath);
			Select obj1 = new Select(obj);
			obj1.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The xpath locator " + xpath + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath locator " + xpath + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + xpath + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath locator " + xpath + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with xpath locator " + xpath );

		}finally {
			takeSnap();
		}
	}
	
	
	public void selectvisibletextByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByName(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementByName(name);
			Select obj1 = new Select(obj);
			obj1.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The name locator " + name + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with name locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with name locator " + name );

		}finally {
			takeSnap();
		}
	}
	
	

	

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementById(id);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementById(id);
			Select obj1 = new Select(obj);
			obj1.selectByIndex(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The id locator " + id + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with id locator " + id + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpidath locator " + id + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id locator " + id + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with id locator " + id );

		}finally {
			takeSnap();
		}
	}

	
	public void selectIndexByName(String name, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement a = driver.findElementByName(name);
			wait.until(ExpectedConditions.visibilityOf(a));
			WebElement obj = driver.findElementByName(name);
			Select obj1 = new Select(obj);
			obj1.selectByIndex(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The name locator " + name + " is not available in DOM");
			
		}
		
		catch (ElementNotVisibleException e) {
			System.err.println("The element with name locator " + name + " is not available in Application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name locator " + name + " is not interactable in application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name locator " + name + " is not stable in Application");
		}catch (WebDriverException e) {
			System.err.println("The dropdown is not selected with name locator " + name );
			
		}finally {
			takeSnap();
		}
	}

	
	
	
	
	
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> win = driver.getWindowHandles();
			ArrayList<String> windows = new ArrayList<String>(win);
			driver.switchTo().window(windows.get(0));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("The window is not available");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The parent window is not opened");
		}finally {
			takeSnap();
		}

	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> win = driver.getWindowHandles();
			ArrayList<String> windows = new ArrayList<String>(win);
			int size = windows.size();
			driver.switchTo().window(windows.get(size - 1));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("The window is not available");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The last window is not opened");
		}finally {
			takeSnap();
		}

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present");
		}catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not accepted");
		}finally {
			takeSnap();
		}

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present");
		}catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not dismissed");
		}finally {
			takeSnap();
		}

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String altertext=null;
		try {
			altertext = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present");
		}catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Alerttext is not captured");
		}
		return altertext;
	}

	public void takeSnap() {
		try {
		File screen = driver.getScreenshotAs(OutputType.FILE);
		//long name = System.currentTimeMillis();
		//0.1245214521552 * 100000000 = 12452145215.52
		long name  = Math.round( (Math.random()*100000000l));
		File dest = new File("./screenshots/"+name+".jpeg");
		
			FileUtils.copyFile(screen, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void ThreadWait(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();

	}

}
