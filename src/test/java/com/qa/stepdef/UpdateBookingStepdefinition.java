package com.qa.stepdef;

import com.qa.apiUtils.ExcelUtils;
import com.qa.apiUtils.JsonReader;
import com.qa.apiUtils.ResponseHandler;
import com.qa.apiUtils.TestContext;
import com.qa.pages.api.BookingDetailsDTO;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class UpdateBookingStepdefinition {
    private static final Logger LOG = LogManager.getLogger(UpdateBookingStepdefinition.class);
    private TestContext context;

    public UpdateBookingStepdefinition(TestContext context) {
        this.context = context;
    }

    @When("user creates a auth token with credential {string} & {string}")
    public void userCreatesAAuthTokenWithCredential(String username, String password) {
        JSONObject credentials = new JSONObject();
        credentials.put("username", username);
        credentials.put("password", password);
        context.response = context.requestSetup().body(credentials.toString())
                .when().post(context.session.get("endpoint").toString());
        String token = context.response.path("token");
        LOG.info("Auth Token: " + token);
        context.session.put("token", "token=" + token);
    }

    @When("user updates the booking details using data {string} from Excel")
    public void userUpdatesTheBookingDetailsUsingDataFromExcel(String dataKey) throws Exception {
        Map<String, String> excelDataMap = ExcelUtils.getData(dataKey);
        context.response = context.requestSetup()
                .header("Cookie", context.session.get("token").toString())
                .pathParam("bookingID", context.session.get("bookingID"))
                .body(excelDataMap.get("requestBody"))
                .when().put(context.session.get("endpoint") + "/{bookingID}");

        BookingDetailsDTO bookingDetailsDTO = ResponseHandler.deserializedResponse(context.response, BookingDetailsDTO.class);
        assertNotNull("Booking not created", bookingDetailsDTO);
        context.session.put("excelDataMap", excelDataMap);
    }

    @When("user updates the booking details using data {string} from JSON file {string}")
    public void userUpdatesTheBookingDetailsUsingDataFromJSONFile(String dataKey, String JSONFile) {
        context.response = context.requestSetup()
                .header("Cookie", context.session.get("token").toString())
                .pathParam("bookingID", context.session.get("bookingID"))
                .body(JsonReader.getRequestBody(JSONFile, dataKey))
                .when().put(context.session.get("endpoint") + "/{bookingID}");

        BookingDetailsDTO bookingDetailsDTO = ResponseHandler.deserializedResponse(context.response, BookingDetailsDTO.class);
        assertNotNull("Booking not created", bookingDetailsDTO);
    }
}
