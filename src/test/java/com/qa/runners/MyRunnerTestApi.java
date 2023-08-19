package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/cucumber/cucumber-reporting"}
        , features = {"src/test/resources/FeatureFiles"}
        , glue = {"com.qa.stepdef"}
        , snippets = CAMELCASE
        , dryRun = false
        , monochrome = true
        , tags = "@Test_Api"

)

public class MyRunnerTestApi {
}
