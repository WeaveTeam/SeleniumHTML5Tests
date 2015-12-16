package com.WVA.selenium.WeaveHTML5Tests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.WVA.selenium.WeaveHTML5Pages.LowellHousingTransactionsPage;
import com.WVA.selenium.WeaveHTML5Utils.BufferedImageResize;
import com.WVA.selenium.WeaveHTML5Utils.ImagePercentDifference;
import com.WVA.selenium.WeaveHTML5Utils.ScreenshotHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import javax.imageio.ImageIO;

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
 * Created by ZMaybury on 12/15/15.
 */


public class LowellHousingTransactionsTests {
    private LowellHousingTransactionsPage lowellHousingTransactionsPage;
    private ScreenshotHelper screenshotHelper;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void openBrowser() {
        //Initial setup for tests goes here, by convention @Before (junit) is run before each test
        lowellHousingTransactionsPage = new LowellHousingTransactionsPage();
        screenshotHelper = new ScreenshotHelper();
    }

    @After
    public void saveScreenshotAndCloseBrowser() throws IOException {
        //Subsequent cleanup for tests goes here, by convention @After (junit) is run after each test
        screenshotHelper.saveScreenshot(lowellHousingTransactionsPage.getDriver(),"out/com/WVA/selenium/WeaveHTML5Tests/"+testName.getMethodName()+".jpg");
        lowellHousingTransactionsPage.quit();
        File runFile = new File("out/com/WVA/selenium/WeaveHTML5Tests/"+testName.getMethodName()+".jpg");
        File testFile = new File("data/com/WVA/selenium/WeaveHTML5Tests/"+testName.getMethodName()+".jpg");
        BufferedImage img2 = ImageIO.read(testFile);
        BufferedImage img1 = BufferedImageResize.resize(ImageIO.read(runFile), img2.getWidth(), img2.getHeight());
        double percentDiff = ImagePercentDifference.calculateImagePercentDifference(img1, img2);
        assertTrue("Percent difference should be less than 5%.",percentDiff < 5.0);
    }

    @Test
    public void lowellHousingTransactionsHomePageLoadedCorrectly(){
        assertTrue(lowellHousingTransactionsPage != null);
        assertEquals("The page title should equal Lowell Housing Transactions.", "Lowell Housing Transactions", lowellHousingTransactionsPage.getTitle());
        assertTrue(lowellHousingTransactionsPage.getVisualizationOne() != null);
        assertTrue(lowellHousingTransactionsPage.getVisualizationTwo() != null);
        assertTrue(lowellHousingTransactionsPage.getVisualizationThree() != null);
    }

    /*@Test
    public void lowellHousingTransactionsHamburgerMenuStyleDisplayedCorrectly(){
        assertTrue(lowellHousingTransactionsPage != null);
        lowellHousingTransactionsPage.selectHamburgerMenu();
    }*/
}
