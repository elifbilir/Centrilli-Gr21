package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

LoginPage loginPage= new LoginPage();
    @Given("user is on the centrilli login page")
    public void user_is_on_the_centrilli_login_page() {
        String url= ConfigurationReader.getProperty("cent-url");
        Driver.getDriver().get(url);
    }
    @When("user enter valid email and password")
    public void user_enter_valid_email_and_password()  {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.btn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);

        Assert.assertTrue(title.equals("Odoo"));
        BrowserUtils.waitFor(2);
    }

    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        String username ="invalidUsername";
        String password = "invalidPassword";
        loginPage.login();
        BrowserUtils.waitFor(2);

    }

    @Then("user should see wrong login and password message displayed")
    public void userShouldSeeWrongLoginPasswordMessageDisplayed() {
        String message= loginPage.invalidMessage.getText();
        Assert.assertTrue(message.contains("Wrong login"));
        BrowserUtils.waitFor(2);

    }
}
