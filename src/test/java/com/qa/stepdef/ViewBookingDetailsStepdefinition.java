package com.qa.stepdef;

import com.qa.apiUtils.ResponseHandler;
import com.qa.apiUtils.TestContext;
import com.qa.pages.api.BookingID;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewBookingDetailsStepdefinition {
    private static final Logger LOG = LogManager.getLogger(ViewBookingDetailsStepdefinition.class);
    private TestContext context;

    public ViewBookingDetailsStepdefinition(TestContext context) {
        this.context = context;
    }

    @Given("user has access to endpoint {string}")
    public void userHasAccessToEndpoint(String endpoint) {
        context.session.put("endpoint", endpoint);
    }

    @When("user makes a request to view booking IDs")
    public void userMakesARequestToViewBookingIDs() {
        context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
        int bookingID = context.response.getBody().jsonPath().getInt("[0].bookingid");
        LOG.info("Booking ID: " + bookingID);
        assertNotNull("Booking ID not found!", bookingID);
        context.session.put("bookingID", bookingID);
    }

    @Then("user should get the response code {int}")
    public void userShpuldGetTheResponseCode(Integer statusCode) {
        assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
    }

    @Then("user should see all the booking IDs")
    public void userShouldSeeAllTheBookingIDS() {
        BookingID[] bookingIDs = ResponseHandler.deserializedResponse(context.response, BookingID[].class);
        assertNotNull("Booking ID not found!!", bookingIDs);
    }

    @Then("user validates the response with JSON schema {string}")
    public void userValidatesResponseWithJSONSchema(String schemaFileName) {
        context.response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaFileName));
        LOG.info("Successfully Validated schema from " + schemaFileName);
    }
}
