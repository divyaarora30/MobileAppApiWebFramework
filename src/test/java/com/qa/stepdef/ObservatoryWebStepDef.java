package com.qa.stepdef;

import com.qa.pages.web.ObservatoryWebModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ObservatoryWebStepDef {

    ObservatoryWebModel observatoryWebModel = new ObservatoryWebModel();

    @Given("I want to search in Google")
    public void iWantToSearchInGoogle() {
        observatoryWebModel.getUrl();
    }

    @Given("the user navigates to hk observatory website")
    public void theUserNavigatesToHkObservatoryWebsite() {
        observatoryWebModel.getUrl();
    }

    @Then("the home page is displayed")
    public void theHomePageIsDisplayed() {
        String actual = observatoryWebModel.checkForHomePage();
        String expected = "Hong Kong Observatory";
        Assert.assertEquals("incorrect page", expected, actual);
    }

    @When("the user clicks on {string} link")
    public void theUserClicksOnLink(String linkToClick) throws InterruptedException {
        observatoryWebModel.clickOnLink(linkToClick);
    }

    @When("the user clicks on {string} link on climate page")
    public void theUserClicksOnLinkOnClimatePage(String linkToClick) throws InterruptedException {
        observatoryWebModel.clickOnLinkOnClimatePage(linkToClick);
    }

    @Then("climate change in Hong kong page is displayed")
    public void climateChangeInHongKongPageIsDisplayed() {
        boolean actual = observatoryWebModel.checkForClimateChangeinHongKongPage();
        boolean expected = true;
        Assert.assertEquals("incorrect page", expected, actual);
    }

    @When("the user enters invalid character in search box")
    public void theUserEntersInvalidCharacterInSearchBox() throws InterruptedException {
        observatoryWebModel.enterInvalidText();
    }

    @Then("no results found page is displayed")
    public void noResultsFoundPageIsDisplayed() {
        String actual = observatoryWebModel.noResultsAreFound();
        String expected = "We cannot find any results that match your keyword(s): ";
        Assert.assertTrue("Incorrect page is displayed", actual.contains(expected));
    }
}
