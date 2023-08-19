package com.qa.apiUtils;

import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static final String CONTENT_TYPE = PropertiesFileManager.getProperty("content.type");
    public Response response;
    public Map<String, Object> session = new HashMap<String, Object>();

    public RequestSpecification requestSetup() {
        RestAssured.reset();
        Options options = Options.builder().logStacktrace().build();
        RestAssuredConfig config = CurlRestAssuredConfigFactory.createConfig(options);
        RestAssured.baseURI = PropertiesFileManager.getProperty("baseURL");
        return RestAssured.given()
                .config(config)
                .filter(new RestAssuredRequestFilter())
                .contentType(CONTENT_TYPE)
                .accept(CONTENT_TYPE);
    }
}
