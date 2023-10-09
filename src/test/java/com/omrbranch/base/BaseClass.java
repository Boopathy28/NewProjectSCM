package com.omrbranch.base;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Return;

public class BaseClass {
	public static WebDriver driver;
	Select select;
	Robot robot;

	public void parentWindow() {
		driver.switchTo().parentFrame();

	}

	public void visibilityOf(WebElement element) {

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void sendkeysJs(WebElement element, String data) {

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + data + "';", element);

	}

	public String readCellData(String sheetName, int rownum, int cellnum) throws IOException {

		String res = "";
		// path of Excel C:\Users\Hp\eclipse-workspace\FrameWork\Excelsheet\Excel
		// Data.xlsx
		File file = new File("C:\\Users\\Hp\\eclipse-workspace\\FrameWork\\Excelsheet\\ExcelData.xlsx");
		// Read the Objects
		FileInputStream stream = new FileInputStream(file);
		// create the workbook --> collections of sheets
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				java.util.Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				res = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
		default:

			break;
		}

		return res;

	}

	public String getProjectPath() {
		String path = System.getProperty("user,dir");
		return path;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		java.util.Properties properties = new java.util.Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\Hp\\eclipse-workspace\\OMRBranchHotelAutomation\\config\\config.prope" + "rties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "Chrome":
			driver = new ChromeDriver();

			break;
		case "Edge":
			driver = new EdgeDriver();

			break;
		case "Internet Explorer":
			driver = new InternetExplorerDriver();

			break;
		case "FireFox":
			driver = new FirefoxDriver();

			break;

		default:
			break;
		}

	}

	public void replaceCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		// path of Excel C:\Users\Hp\eclipse-workspace\FrameWork\Excelsheet\Excel
		// Data.xlsx
		File file = new File("C:\\Users\\Hp\\eclipse-workspace\\FrameWork\\Excelsheet\\ExcelData.xlsx");
		// Read the Objects
		FileInputStream stream = new FileInputStream(file);
		// create the workbook --> collections of sheets
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	public void insertCellinValue(String sheetName, int rownum, int cellnum, String data) throws IOException {

		// path of Excel C:\Users\Hp\eclipse-workspace\FrameWork\Excelsheet\Excel
		// Data.xlsx
		File file = new File("C:\\Users\\Hp\\eclipse-workspace\\FrameWork\\Excelsheet\\ExcelData.xlsx");
		// Read the Objects
		FileInputStream stream = new FileInputStream(file);
		// create the workbook --> collections of sheets
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell createCell = row.createCell(cellnum);
		createCell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public void pressKey(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(key);

	}

	public void releaseKey(int key) throws AWTException {

		Robot robot = new Robot();
		robot.keyRelease(key);

	}
	
	public void tabKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

	}

	public void enterKey() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void maxmizeWindow() {
		driver.manage().window().maximize();
	}

	public static void enterUrl(String url) {
		driver.get(url);
	}

	public WebElement elementSendkeys(WebElement element, String data) {
		visibilityOf(element);
		element.sendKeys(data);
		return element;
	}

	public void elementSendkeysJs(WebElement element, String data) {
		visibilityOf(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribue('value','" + data + "')", element);
	}

	public String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void elementClick(WebElement element) {
		visibilityOf(element);
		element.click();
	}
	public void elementClickWithkyes(WebElement element,Keys tab,Keys enter) {
		visibilityOf(element);
		element.click();
	}
	public void elementClickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void scrlDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public String elementGetText(WebElement element) {
		visibilityOf(element);
		String text = element.getText();
		return text;
	}

	public String getInsertedText(WebElement element, String attributeName) {
		visibilityOf(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public void closeCurrentWindow() {
		driver.close();

	}

	public static void closeAllWindow() {
		driver.quit();
	}

	public String getCurrentAppUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String getUrlTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement findLocatorByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	public WebElement findLocatorByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;

	}

	public List<WebElement> findelementsbyxpath(String xpathExpression) {
		List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
		return elements;

	}

	public void getAllElements(List<WebElement> webElement) {
		for (WebElement element : webElement) {
			System.out.println(element.getText());

		}
	}

	// public List<String> getTextFromWebElements(List<WebElement> elements) {
	// List<String> textList = new ArrayList<>();
	// for (WebElement element : elements) {
	// textList.add(getTextFromWebElement(element));
	// }
	// return textList;
	// }
	//

	public WebElement findLocatorByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;

	}

	public void selectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionByIndex(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);

	}

	public void switchToChildWindow() {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String eachWindowId : allWindowsId) {
			if (!parentWindowId.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);

			}
		}
	}

	public void switchframeelement(WebElement element) {
		visibilityOf(element);
		driver.switchTo().frame(element);

	}

	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrameByFrameId(String frameId) {
		driver.switchTo().frame(frameId);
	}

	public List<String> dropDownGetAllOptionsText(WebElement element) {
		List<String> listText = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement eachElement : options) {
			String text = eachElement.getText();
			listText.add(text);
		}
		return listText;
	}

	public List<String> dropDownGetAllSelectedOptions(WebElement element) {
		List<String> listText = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement eachOption : allSelectedOptions) {
			String text = eachOption.getText();
			listText.add(text);

		}
		return listText;
	}

	public String dropDownFirstSelectedOption(WebElement element) {
		select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		return text;

	}

	public boolean dropDownIsMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public static void implicityWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void explicityWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;

	}

	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public void deselectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectOptionByAttribute(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
	}

	public void deselectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}

	public Set<String> getAllWindowsId() {
		Set<String> allWindowsId = driver.getWindowHandles();
		return allWindowsId;
	}

	public String getParentWindowId() {
		String parentWindowId = driver.getWindowHandle();
		return parentWindowId;
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void screenShot(WebElement element, String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Hp\\eclipse-workspace\\FrameWork\\ScreenShot\\" + name + ".png");
		FileUtils.copyFile(source, dest);
	}

	public void elementScreenShot(WebElement element, String name) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Hp\\eclipse-workspace\\FrameWork\\ScreenShot\\" + name + ".png");
		FileUtils.copyFile(source, dest);

	}

	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement dest) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, dest).perform();

	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void sendkeysAndEnter(WebElement element, String textValue) {
		element.sendKeys("" + textValue + "", Keys.ENTER);

	}

	public void refreshPage() {
		Navigation navigation = driver.navigate();
		navigation.refresh();

	}

	public void keyPress(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(key);

	}

	public void keyRelease(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(key);
	}

}

// fluent Wait & All Windows ID & TakeScreenShot on particular element