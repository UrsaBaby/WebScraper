/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.ports.NavigationPort.Interface.Webport;

import java.awt.AWTException;


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
public class WebPort {

    WebDriver webDriver;

    public WebPort() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void connectToThisSite(String url) {
        webDriver.navigate().to(url);
    }

    public String getSiteCurrentlyConnectedTo() {
        return getWebDriver().getCurrentUrl();
    }

    public void close() {
        this.getWebDriver().close();
    }

    public WebElement getElementAtThisCss(String cssSelector) throws InterruptedException {
        WebElement returnelement = null;
        returnelement = getWebDriver().findElement(By.cssSelector(cssSelector));
        return returnelement;
    }

    public void clickElementAtThisCss(String cssSelector) {
        Actions action = new Actions(webDriver);
        action.click(webDriver.findElement(By.cssSelector(cssSelector)));
    }
}
