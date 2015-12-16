package com.WVA.selenium.WeaveHTML5Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * *** BEGIN LICENSE BLOCK *****
 * <p/>
 * This file is part of WeaveHTML5SeleniumTests.
 * <p/>
 * The Initial Developer of WeaveHTML5SeleniumTests is Weave Visual Analytics.
 * Portions created by the Initial Developer are Copyright (C) 2015-present
 * the Initial Developer. All Rights Reserved.
 * <p/>
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 * <p/>
 * **** END LICENSE BLOCK *****
 * <p/>
 * Created by Zach on 12/15/15.
 */
public class LowellHousingTransactionsPage {
    final private String dashboardXPath = "//div[@id='dashboard']";
    final private String firstVisualizationRelativeXPath = "/div/div/div[@data-reactid='.0.0.2:$0']";
    final private String secondVisualizationRelativeXPath = "/div/div/div[@data-reactid='.0.0.2:$1']";
    final private String thirdVisualizationRelativeXPath = "/div/div/div[@data-reactid='.0.0.2:$2']";
    final private String hamburgerMenuRelativeXPath = "/div/div/div/div/div/button[@style='border:0;background:rgba(0,0,0,0);']";
    //TODO: When Menu actually does something, find better xpath selectors for identifying proper menu functionality
    /*final private String hamburgerClickStyleOverlayRelativeXPath = "/div/div[1]/div[1]/div[1]/div[@style='background: rgba(0, 0, 0, 0.3) none repeat scroll 0% 0%; position: fixed; top: 0px; left: 0px; width: 100%; height: 100%; transition: background-color 300ms linear 0s; z-index: 201;']";
    final private String hamburgerNoClickStyleOverlayRelativeXPath = "/div/div[1]/div[1]/div[1]/div[@style='background-attachment: scroll; background-clip: border-box; background-origin: padding-box; background-size: auto auto;']";
    final private String hamburgerStyleOverlayRelativeXPath = "/div/div[1]/div[1]/div[1]/div[@data-reactid='.0.0.0.0.2']";*/

    private String baseUrl;
    private WebDriver driver;
    private WebElement dashboard,visualizationOne,visualizationTwo,visualizationThree,hamburgerMenu;

    public LowellHousingTransactionsPage(){
        baseUrl = "http://example.iweave.com/weave-html5/lowelltrans.html?file=lowelltrans.weave";
        driver = new FirefoxDriver() ;
        driver.get(baseUrl);
        dashboard = driver.findElement(By.id("dashboard"));
        hamburgerMenu = (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardXPath + hamburgerMenuRelativeXPath)));
        visualizationOne = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardXPath + firstVisualizationRelativeXPath)));
        visualizationTwo = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardXPath + secondVisualizationRelativeXPath)));
        visualizationThree = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardXPath + thirdVisualizationRelativeXPath)));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quit(){
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebElement getVisualizationOne(){
        return visualizationOne;
    }

    public WebElement getVisualizationTwo() {
        return visualizationTwo;
    }

    public WebElement getVisualizationThree() {
        return visualizationThree;
    }

    public void selectHamburgerMenu() {
        hamburgerMenu.click();
        //TODO: Actually check menu interaction
        /*// Ideally here, if the menu was not already toggled we would wait for the visibility of an item, but because the menu doesn't do anything there is nothing to test
        if(menuToBeOpened) {
            //Wait for visibility of the menu
            (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardXPath + hamburgerClickStyleOverlayRelativeXPath)));
        } else {
            //Wait for menu to be no longer visible
            (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hamburgerNoClickStyleOverlayRelativeXPath)));
        }*/
    }
}
