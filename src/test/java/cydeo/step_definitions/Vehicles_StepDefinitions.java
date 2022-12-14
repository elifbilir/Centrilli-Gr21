package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.pages.VehicleCostsPage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Vehicles_StepDefinitions {

    VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

    @Given(": user is already logged in and on main page")
    public void userIsAlreadyLoggedInAndOnMainPage() {

        // Getting our login method to log in to web table app
        Driver.getDriver().get(ConfigurationReader.getProperty("cent-url"));

        //Calling our login method to log in to web table app
        vehicleCostsPage.login();
        BrowserUtils.waitFor(2);
    }

    @When("user clicks on more button")
    public void userClicksOnMoreButton() {
        vehicleCostsPage.moreButton.click();
        BrowserUtils.waitFor(2);

    }

    @And("user clicks fleet button")
    public void userClicksFleetButton() {

        if (vehicleCostsPage.fleetButton.isDisplayed()){
            vehicleCostsPage.fleetButton.click();
        }else {
            vehicleCostsPage.moreButton.click();
          vehicleCostsPage.fleetButton.click();
        }

        BrowserUtils.waitFor(2);
    }

    @And("user clicks Vehicle Costs button")
    public void userClicksVehicleCostsButton() {
        vehicleCostsPage.vehicleCostsButton.click();
    }

    @And("user clicks create button")
    public void userClicksCreateButton() {
        vehicleCostsPage.createButton.click();
        BrowserUtils.waitFor(1);

    }

    @And("user sees the title New")
    public void userSeesTheTitleNew() {
        String expectedTitle="New";
        String actualTitle= vehicleCostsPage.title.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @And("user selects a vehicle")
    public void userSelectsAVehicle() {
       vehicleCostsPage.vehicleDropdown.click();
       BrowserUtils.waitFor(1);
      WebElement audi= Driver.getDriver().findElement(By.linkText("Audi/A1/"));
      audi.click();

    }


    @And("user selects a type")
    public void userSelectsAType() {
       vehicleCostsPage.typeDropdown.click();
       BrowserUtils.waitFor(1);
       WebElement snowTires= Driver.getDriver().findElement(By.linkText("Snow tires"));
       snowTires.click();
       BrowserUtils.waitFor(1);
    }

    @And("user selects a date")
    public void userSelectsADate() {
        vehicleCostsPage.dateInput.sendKeys("11/02/2022");

    }

    @And("user enters total price")
    public void userEntersTotalPrice() {

        vehicleCostsPage.inputTotalPrice.clear();
        vehicleCostsPage.inputTotalPrice.sendKeys("100.00");
        BrowserUtils.waitFor(1);
    }

    @And("user enters cost description")
    public void userEntersCostDescription() {
        vehicleCostsPage.inputCostDescription.sendKeys("snow tires");
        BrowserUtils.waitFor(1);
    }



    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        vehicleCostsPage.saveButton.click();
        BrowserUtils.waitFor(2);
    }



    @Then("title is changed to {string} and new table is created")
    public void titleIsChangedToFrom(String vehicle) {

        Assert.assertTrue(vehicleCostsPage.title.isDisplayed());
        BrowserUtils.waitFor(2);

    }

    @Then("user sees These fields are invalid error message")
    public void userSeesTheseFieldsAreInvalidErrorMessage() {
        Driver.getDriver().getWindowHandles();
        vehicleCostsPage.warningMessage.isDisplayed();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(vehicleCostsPage.warningMessage.isDisplayed());

    }


    @And("user clicks on discard button")
    public void userClicksOnDiscardButton() {
        vehicleCostsPage.discardButton.click();
        BrowserUtils.waitFor(2);


    }

    @And("user sees warning message")
    public void userSeesWarningMessage() {
        vehicleCostsPage.warningMessage.isDisplayed();
        Assert.assertTrue(vehicleCostsPage.warningMessage.isDisplayed());
        BrowserUtils.waitFor(2);


    }

    @And("user clicks on ok button")
    public void userClicksOnOkButton() {
        vehicleCostsPage.okButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("user is back to vehicle costs page")
    public void userIsBackToVehicleCostsPage() {
       vehicleCostsPage.title.isDisplayed();
       BrowserUtils.waitFor(2);

    }

    @Then("user sees the title is vehicle costs")
    public void userSeesTheTitleIsVehicleCosts() {
        Assert.assertTrue(vehicleCostsPage.title.isDisplayed());
        BrowserUtils.waitFor(2);

    }

    @Then("title is changed to {string} - Odoo")
    public void titleIsChangedToOdoo(String string) {
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);

        BrowserUtils.sleep(2);
        Assert.assertTrue(title.contains(string));
        BrowserUtils.sleep(2);

    }


    @Then("user sees Attachments and Action buttons")
    public void userSeesAttachmentSAndActionButtons() {
     vehicleCostsPage.attachmentButton.isDisplayed();
     vehicleCostsPage.actionButton.isDisplayed();
     Assert.assertTrue(vehicleCostsPage.attachmentButton.isDisplayed());
     Assert.assertTrue(vehicleCostsPage.actionButton.isDisplayed());
    }




}

