package com.base;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

	public static WebDriver driver;

// Browser Launch Methods
	protected static void browserLaunch(String browserName) { // why static keyword use panirukom
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS IN BROWSER LAUNCH"); // why Assert.fail use panirukom
		}
		
		driver.manage().window().maximize();
	}

// Browser URL Launch Methods

	protected static void launchUrl(String url) {
		try {
			if (url.equalsIgnoreCase(url)) {
				driver.get(url);
			} else if (url.equalsIgnoreCase(url)) {
				driver.getCurrentUrl();
			} else if (url.equalsIgnoreCase(url)) {
				driver.getTitle();
			} else if (url.equalsIgnoreCase(url)) {
				driver.getPageSource();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS IN URL LAUNCH");
		}

	}

// Browser Close & Quit Methods

	protected static void closeBrowser(String type) {
		try {
			if (type.equalsIgnoreCase(type)) {
				driver.close();
			} else if (type.equalsIgnoreCase(type)) {
				driver.quit();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS WHILE CLOSING BROWSER");
		}
	}

// Browser Navigation Methods	

	protected static void navigationMethods(String navigations) {
		try {
			if (navigations.equalsIgnoreCase("To")) {
				driver.navigate().to(navigations); // why only in navigat.to we give inside the ()
			} else if (navigations.equalsIgnoreCase("Back")) {
				driver.navigate().back(); // why not support inside the back()
			} else if (navigations.equalsIgnoreCase("Forward")) {
				driver.navigate().forward();
			} else if (navigations.equalsIgnoreCase("Refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS WHILE NAVIGATING BROWSER");
		}

	}

// Implicit & Explicit Wait Methods

	protected static void waitmethods(WebElement element, String option, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 											// why we use this method?
			if (option.equalsIgnoreCase("implictWait")) {
				int seconds = Integer.parseInt(value); 																			// why we use this method? -- to pass/call value
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			} else if (option.equalsIgnoreCase("explicitWait")) {
				wait.until(ExpectedConditions.visibilityOf(element));  														  	// here we have class and interface in --- expectedconditon doubt
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS WHILE USING WAIT CONCEPT");
		}
	}

// Alert -- Accept & Dismiss Methods

	protected static void alertOptions(String type) { 																				// why string type in ()?
		try {
			Alert alert = driver.switchTo().alert();
			if (type.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (type.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS IN ALERT ACCEPT & DISMISS");
		}
	}

// Alert -- Prompt Input SendKeys Methods

	protected static void alertInput(WebElement element, String input) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS IN ALERT INPUT");
		}
	}

// Alert -- GetText Methods		
	protected static void getALertText() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.getText();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS IN GETTING ALERT GETTEXT");
		}
	}

//	 	Passing Input/SendKeys Methods

	protected static void passInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS WHILE PASSING THE INPUT VALUES");
		}
	}

// WebElement Click, Check Box, Radio Button Methods

	protected static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING CLICK ON WEBELEMENT");
		}
	}

	protected static void elementVisibilty(WebElement element, String type) {
		try {
			if (type.equalsIgnoreCase("enabled")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
			} else if (type.equalsIgnoreCase("selected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			} else if (type.equalsIgnoreCase("displayed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SELECTING THE OPTIONS ON WEBELEMENT");
		}
	}

//DropDown Select options Method 	

	protected void selectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element); // doubt why create method
			if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value)); // why here use (Integer.parseInt(value)
			} else if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SELECTING VALUE,INDEX,TEXT");
		}
	}

//DropDown De-select options Method 	

	protected void deselectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING DESELECTING VALUE,INDEX,TEXT");
		}

	}
// Action Class -- Drag Drop  Method		

	protected static void dragAndDropAction(WebElement element, WebElement element1) { // why we also use  this(WebElement source, WebElement target)
		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(element, element1).click().perform(); // why we use this .click().build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING ACTION DRAG AND DROP");
		}
	}

// Action Class -- Click, ContextClick, DoubleClick, MoveToElement, ClickandHold, Release Methods 

	protected static void actionOptions(WebElement element, String type) {
		try {
			Actions actions = new Actions(driver);
			if (type.equalsIgnoreCase("click")) {
				actions.click(element).perform(); // why we use this .perform();
			} else if (type.equalsIgnoreCase("contextclick")) {
				actions.contextClick(element).perform();
			} else if (type.equalsIgnoreCase("doubleclick")) {
				actions.doubleClick(element).perform();
			} else if (type.equalsIgnoreCase("movetoelement")) {
				actions.moveToElement(element).perform();
			} else if (type.equalsIgnoreCase("clickandhold")) {
				actions.clickAndHold().perform(); // clickAndHold(element) -- element kudukalama kudakudatha?
			} else if (type.equalsIgnoreCase("release")) {
				actions.release().perform();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING ACTION CLASS OPTIONS");
		}
	}

//Get Window Handling

	protected static void getWindowHandles(int num) {
		try {
			List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(allWindows.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING GET WINDOW HANDLING");
		}
	}


	
// WebElement Select  GetOptions

	protected static void getOptions(WebElement element) {
		try {
			Select select = new Select(element); 														// why we send parameter as element?
			List<WebElement> getOptions = select.getOptions();
			for (WebElement webElement : getOptions) { 						   							// why we use return type> String text = webElement.getText();
				System.out.println(webElement.getText());												// why we use .gettext()?
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING GET OPTIONS");
		}
	}

// WebElement Select FirstSelectOptions		

	protected static void getFirestSelectedOptions(WebElement element) {
		try {
			Select select = new Select(element);
			WebElement getFirstElements = select.getFirstSelectedOption();
			System.out.println(getFirstElements.getText());
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING GET OPTIONS");
		}

	}

// WebElement Select  GetALLSelectedOptions

	protected static void getAllSelectedOptions(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> getAllSelectedOptions = select.getAllSelectedOptions();
			for (WebElement webElement : getAllSelectedOptions) {
				System.out.println(webElement.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING GET OPTIONS");
		}
	}
	
// WebElement DropDown IS MULTIPLE OR NOT
	
	protected static void dropDownIsMultiple(WebElement elements) {
		try {
			Select select = new Select(elements);
			System.out.println(select.isMultiple());
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING DROPDOWN ISMULTIPLE");
		}
	}

	
// WebElement GetText and GetAttribute
	
	protected static void getTextAndAttribute(WebElement element,String type,String value) {
		try {
			if (type.equalsIgnoreCase("getText")) {
				String text = element.getText();
				System.out.println(text);
			}else if (type.equalsIgnoreCase("attribute")) {
				String attribute = element.getAttribute(value);
				System.out.println(attribute);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WEBELEMENT AND GETATTRIBUTE");
		}
	}
	
	
// ROBOT Class
	
	protected static void keyBoardAction(String type) {
		try {
			Robot robot = new Robot();
			if (type.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING ROBOT KEYBOARD ACTION");
		}
	}

// Frame options --  Value, Index, FrameElement, ParentFrame
	
		protected static void frameOptions(WebElement element,String type,String value,int num) {
			try {
				if (type.equalsIgnoreCase("value")) {
					driver.switchTo().frame(value);
				}else if (type.equalsIgnoreCase("index")) {
					driver.switchTo().frame(num);
				}else if (type.equalsIgnoreCase("frameelement")) {
					driver.switchTo().frame(element);
				}
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURS DURING FRAME ACTIONS ");
			}
		}
		

// Frame Exit & Parent 
		
		protected static void framExitAndParent(WebElement element,String type) {
			try {
				if (type.equalsIgnoreCase("exitframe")) {
					driver.switchTo().defaultContent();
				}else if (type.equalsIgnoreCase("parentframe")) {
					driver.switchTo().parentFrame();
			    }
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURS DURING FRAME ACTIONS EXIT AND PARENT FRAME ");
			}
			
		}

		
//Screenshot Method


		protected static void screenshot() {
		    try {
		        // Ensure Screenshots folder exists
		        File screenshotFolder = new File("./Screenshots");
		        if (!screenshotFolder.exists()) {
		            screenshotFolder.mkdir();
		        }

		        TakesScreenshot ts = (TakesScreenshot) driver;
		        Date currentDate = new Date();
		        String datefile = currentDate.toString().replace(":", "_").replace(" ", "_");
		        File target = ts.getScreenshotAs(OutputType.FILE);
		        File outputScreenshot = new File("./Screenshots/" + datefile + ".png");
		        FileHandler.copy(target, outputScreenshot);

		        System.out.println("Screenshot saved at: " + outputScreenshot.getAbsolutePath());

		    } catch (Exception e) {
		        Assert.fail("ERROR: OCCURS DURING SCREENSHOT");
		    }
		}
	
		
	public static void extentRepor() {
		
	}	
}
		
		


	











