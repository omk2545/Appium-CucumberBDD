package com.stepdefn;

import com.pages.HomePage;
import com.utils.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorSteps {

    Context context;
    HomePage homePage;
    public CalculatorSteps(Context context) {
        this.context=context;
        homePage = context.getHomePage();
    }

    @Given("Launch Calculator Application")
    public void launch_calculator_application(){
        System.out.println("Application Launched");
    }

    @When("Select a number {string}")
    public void select_a_number(String string) {
        System.out.println("Select a number "+string);
        homePage.clickOnElement(string);
    }

    @Then("perform addition")
    public void perform_addition() {
        // Write code here that turns the phrase above into concrete actions
        homePage.performAddition();
    }

    @Then("verify result {string}")
    public void verify_result(String excpectedValue) {
        String value= homePage.equals_get_resuls();
        Assert.assertEquals(excpectedValue,value);
    }
}
