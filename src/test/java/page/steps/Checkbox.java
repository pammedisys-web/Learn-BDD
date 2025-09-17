package page.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLInputElement;

public class Checkbox {

    // xPath =  //p[ text() = 'Single Checkbox Demo']
    //a[text() = 'CheckBox']
//input[ @id = "myCheckbox"]


    @Given("I am on Dashboard page {string}")
    public void i_am_on_dashboard_page(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testing.qaautomationlabs.com/form.php");

    }
    @When("I hover mouse to the Checkbox page and click on it")
    public void i_hover_mouse_to_the_checkbox_page_and_click_on_it() {

      //  driver.findElement(By.xpath("//a[text() = 'CheckBox']");
    }


    @Then("it get checked successfully on single click")
    public void it_get_checked_successfully_on_single_click() {

        System.out.println("checked");

    }



}
