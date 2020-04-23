/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.navigation;

import java.awt.AWTException;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Peter
 */
public class WebGetter {

    WebDriver driverFondListan;
    WebDriver driverFondSida;
    ArrayList<String> listOfETFs;
    ArrayList<WebDriver> listOfWebDrivers;
    HashMap<String, WebElement> listOfElements;

    public WebGetter() throws AWTException {

        listOfETFs = new ArrayList<String>();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
        driverFondListan = new ChromeDriver();
        driverFondSida = new ChromeDriver();
        listOfElements = new HashMap<String, WebElement>();
        listOfWebDrivers = new ArrayList<WebDriver>();

    }

    public void openHttmlWithThisWebdriver(String htmlAdress, WebDriver thisDriver) throws InterruptedException {

        connectToThisSiteWithThisWebdriver(htmlAdress, thisDriver);
        Thread.sleep(1000); // TODO? How Much sleep and where to put it?
    }

    public void addThisWebElementByCssSelectorAndGiveItThisName(String cssSelector, String thisName) {
        WebElement thisElement = this.getWebDriver().findElement(By.cssSelector(cssSelector));
        listOfElements.put(thisName, thisElement);

    }

    public WebDriver getWebDriver() {
        return this.listOfWebDrivers;
    }

    public void run() throws InterruptedException {
        connectToThisSiteWithThisWebdriver(fondlistanAvanza(), driverFondListan); //öppnar avanza fondlista
        Thread.sleep(2000);
        WebElement fondlistanWebelement = driverFondListan.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card > table > tbody"));
        WebElement listElement = getWebElementWithThisNumberFromThisList(2, fondlistanWebelement);
        //  System.out.println(listElement.getText());
        clickThisElementWithThisDrive(listElement, driverFondListan);
        driverFondListan.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement buttonToETFPage = driverFondListan.findElement(By.cssSelector("body > aza-app > aza-right-overlay-area > aside > ng-component > aza-fund-guide-sidebar > aza-fund-guide-sidebar-container > aza-right-overlay-template > main > aza-fund-guide-embedded > div.fund-guide-button-wrapper > a.hidden-wv.aza-button.size-small.cta-discreet"));
        String ETFPageHTML = buttonToETFPage.getAttribute("href");
        connectToThisSiteWithThisWebdriver(ETFPageHTML, driverFondSida);
        Thread.sleep(2000);
        WebElement fondName = driverFondSida.findElement(By.tagName("h1"));
        System.out.println(fondName.getText());
        driverFondListan.close();
        driverFondSida.close();

        // System.out.println(ETFPageHTML);
        // openNewTab();
        // goThroughWebElementWithThisWebdriverAndAddValuesToThisStringArray(fondlistanWebelement, driver, listOfETFs);
        //   WebElement element = driver.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card.fund-list-card.ng-tns-c43-4.rounded.ng-star-inserted > table > tbody"));
        // String tagName = element.getText();
        //  System.out.println(tagName);
        //  clickThisElementWithThisDrive(nextElement, driver);
        //    nextElement = driver.findElement(By.cssSelector("body > aza-app > aza-right-overlay-area > aside > ng-component > aza-fund-guide-sidebar > aza-fund-guide-sidebar-container > aza-right-overlay-template > main > aza-fund-guide-embedded > div.fund-guide-button-wrapper > a.hidden-wv.aza-button.size-small.cta-discreet"));
        //  clickThisElementWithThisDrive(nextElement, driver);
        //    String test = nextElement.getAttribute("href");
        //    System.out.println(test);
        //    connectToThisSiteWithThisWebdriver(test, driver);
        Thread.sleep(2000);

        // nextElement = driver.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-guide > aza-subpage > div > div > div > aza-fund-sustainability-card > aza-card > div > div.sustainability-allocations > div > aza-responsive-overlay-button:nth-child(2) > button"));
        // clickThisElementWithThisDrive(nextElement, driver);
    }

    public void connectToThisSiteWithThisWebdriver(String site, WebDriver thisDriver) {
        thisDriver.navigate().to(site);

    }

    public String fondlistanAvanza() {
        return "https://www.avanza.se/fonder/lista.html?fundType=Blandfond|Aktiefond&sortField=name&sortDirection=ASCENDING&selectedTab=overview";
    }

    public void clickThisElementWithThisDrive(WebElement thisElement, WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);

        action.click(thisElement).perform();
    }

    private void goThroughWebElementWithThisWebdriverAndAddValuesToThisStringArray(WebElement fondlistan, WebDriver thisDriver, ArrayList<String> thisStringList) {

    }

    public WebElement getWebElementWithThisNumberFromThisList(int numberInList, WebElement list) { //TODO returns full list

        WebElement returnWebelement = driverFondListan.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card > table > tbody > tr:nth-child(" + numberInList + ") > td.name.is-neutral.ng-star-inserted > aza-fund-list-table-data > div > button > span"));
        return returnWebelement;
    }

    private WebElement getWebElementFromThisCss(String url, String css) {
        if (isAWebDriverConnectedToThisSite(url)) {
            return this.getWebDriverConnectedToThisSite(url).findElement(By.cssSelector(css));
        } else {
            this.addNewWebDriver();
        }
        WebElement elementToGetTextFrom = listOfWebDrivers.findElement(By.cssSelector(css));
        return elementToGetTextFrom;
    }

    ////////////////////////////////////////////
    public void connectWebDriverCurrentlyConnectedToThisSiteToThisSite(String urlCurrentlyConnectedTo, String urlToConnectTo) {
        this.getWebDriverConnectedToThisSite(urlToConnectTo).navigate().to(urlToConnectTo);
    }

    public void connectUnusedWebDriverToThisSite(String url) {
        this.getUnusedWebDriver().navigate().to(url);
    }

    public boolean isAWebDriverConnectedToThisSite(String url) {
        for (WebDriver checker : listOfWebDrivers) {
            if (checker.getCurrentUrl().equals(url)) {
                return true;
            }
        }
        return false;
    }

    private WebDriver getWebDriverConnectedToThisSite(String url) {
        for (WebDriver checker : listOfWebDrivers) {
            if (checker.getCurrentUrl().equals(url)) {
                return checker;
            }
        }
        return null;
    }

    public void closeWebDriverConnectedToThisSite(String url) {
        this.getWebDriverConnectedToThisSite(url).close();
    }

    private WebDriver getUnusedWebDriver() {
        if (isThereAnUnusedWebDriver()) {
            for (WebDriver checker : listOfWebDrivers) {
                if (checker.getCurrentUrl().equals("data:,")) {
                    return checker;
                }
            }

        }
        WebDriver returndriver = new ChromeDriver();
        return returndriver;
    }

    public void closeWebDrivers() {
        for (WebDriver checker : listOfWebDrivers) {
            checker.close();
        }
    }

    private void addNewWebDriver() {
        listOfWebDrivers.add(new ChromeDriver());
    }

    private boolean isThereAnUnusedWebDriver() {
        for (WebDriver checker : listOfWebDrivers) {
            if (checker.getCurrentUrl().equals("data:,")) {
                return true;
            }
        }
        return false;
    }
}
