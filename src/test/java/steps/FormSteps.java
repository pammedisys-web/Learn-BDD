package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.methods.FormMethods;

import java.util.Map;

public class FormSteps {

    private WebDriver driver;

    public FormSteps() {
      driver = Hooks.driver;

    }
    @Given("I navigate to the form page {string}")
    public void i_navigate_to_the_form_page(String url) {
        FormMethods.enterURL(url, driver);

    }
    @When("I fill the form with following details")
    public void i_fill_the_form_with_following_details(DataTable dataTable) {
        Map<String, String> formdata = dataTable.asMaps(String.class, String.class).get(0);
        FormMethods.fillForm(driver, formdata);


    }
    @And("I submit the form")
    public void i_submit_the_form() {
        FormMethods.submitForm(driver);

    }
    @Then("I should see the form submitted successfully")
    public void i_should_see_the_form_submitted_successfully() {

        System.out.println("Form is submitted successfuly");

    }

}
