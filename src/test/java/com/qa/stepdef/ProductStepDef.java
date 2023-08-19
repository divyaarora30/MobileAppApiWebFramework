package com.qa.stepdef;

import com.qa.pages.mobile.LoginPage;
import com.qa.pages.mobile.ProductDetailsPage;
import com.qa.pages.mobile.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("^I'm logged in$")
    public void iMLoggedIn() throws InterruptedException {
        new LoginPage().login("standard_user", "secret_sauce");
    }

    @When("^I click product title \"([^\"]*)\"$")
    public void iClickProductTitle(String title) throws Exception {
        new ProductsPage().pressProductTitle(title);
    }

    @Then("^I should be on product details page with title \"([^\"]*)\", price \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws Exception {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
        boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(description);
        boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
                titleCheck & descCheck & priceCheck);
    }
}
