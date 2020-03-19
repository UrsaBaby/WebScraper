/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.navigator;

import java.awt.Desktop.Action;
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
public class Navigator {

    WebDriver driver;

    public Navigator() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void run() throws InterruptedException {
        connectToThisSiteWithThisWebdriver(siteToVisit(), driver);

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card.fund-list-card.ng-tns-c43-4.rounded.ng-star-inserted > table > tbody"));
        String tagName = element.getText();
        System.out.println(tagName);
        WebElement nextElement = driver.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card > table > tbody > tr:nth-child(1) > td.name.is-neutral.ng-star-inserted > aza-fund-list-table-data > div > button"));

        performThisElementWithThisDrive(nextElement);
        Thread.sleep(2000);
        nextElement = driver.findElement(By.cssSelector("body > aza-app > aza-right-overlay-area > aside > ng-component > aza-fund-guide-sidebar > aza-fund-guide-sidebar-container > aza-right-overlay-template > main > aza-fund-guide-embedded > div.fund-guide-button-wrapper > a.hidden-wv.aza-button.size-small.cta-discreet"));
        performThisElementWithThisDrive(nextElement);
    }

    public void connectToThisSiteWithThisWebdriver(String site, WebDriver thisDriver) {
        thisDriver.navigate().to(site);

    }

    public String siteToVisit() {
        return "https://www.avanza.se/fonder/lista.html?fundType=Blandfond|Aktiefond&sortField=name&sortDirection=ASCENDING&selectedTab=overview";
    }

    public void performThisElementWithThisDrive(WebElement thisElement) throws InterruptedException {
        Actions action = new Actions(driver);
        action.click(thisElement).perform();
    }

}
