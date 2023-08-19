package com.qa.pages.web;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ObservatoryWebModel {

    private final WebDriver driver;

    String Url = "https://www.hko.gov.hk";

    public ObservatoryWebModel() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
    }

    public void getUrl() {
        driver.get(Url);
    }

    public String checkForHomePage() {
        return driver.findElement(By.tagName("img")).getAttribute("alt");
    }

    public void clickOnLink(String linkToClick) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='" + linkToClick + "']")).click();
    }

    public void clickOnLinkOnClimatePage(String linkToClick) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.linkText(linkToClick)).click();
    }

    public boolean checkForClimateChangeinHongKongPage() {
        return driver.findElement(By.xpath("//*[text()='Temperature']")).isDisplayed();
    }

    public void enterInvalidText() throws InterruptedException {
        driver.findElement(By.name("any_q")).sendKeys(RandomStringUtils.randomAlphabetic(10));
        driver.findElement(By.name("any_q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public String noResultsAreFound() {
        return driver.findElement(By.xpath("//div[@class='errorMsgPanel']")).getText();
    }

    public void quitDriver() {
        driver.quit();
    }
}
