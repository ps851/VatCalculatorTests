package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.VatCalculatorPageElements;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;

public class VATCalculatorSteps {

    VatCalculatorPageElements vatCalculatorPageElements = new VatCalculatorPageElements();

    @Given("I am on the VAT Calculator page")
    public void loadPage() {
        DriverManager.getDriver("chrome");
    }

    @Then("Page elements are displayed as expected")
    public void itShouldLoadCorrectly() {
        Assert.assertTrue(vatCalculatorPageElements.getPageHeading().contains("Value Added Tax Calculator"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorHeading().contains("Initial Data"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorCountryLabel().contains("Country"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorCountryDropdown().isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getVATRateLabel().contains("VAT rate"));
        Assert.assertTrue(vatCalculatorPageElements.getVATRateCheckboxes("5").isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getVATRateCheckboxes("20").isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorPriceWithoutVATLabel().contains("Price without VAT"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorValueAddedTaxLabel().contains("Value-Added Tax"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorPriceVATLabel().contains("Price incl. VAT"));
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorPriceWithoutVATCheckbox().isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorValueAddedTaxCheckbox().isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorPriceVATCheckbox().isDisplayed());
        Assert.assertTrue(vatCalculatorPageElements.getCalculatorResetButton().isDisplayed());
    }

    @When("I select {string} as the country")
    public void selectCountry(String country) {
        vatCalculatorPageElements.selectCountryFromDropdown(country);
    }

    @Then("I select {string} as the VAT rate")
    public void selectVATRate(String vatRate) {
        vatCalculatorPageElements.selectVATRateCheckbox(vatRate);
    }

    @Then("I enter {string} as the net amount")
    public void enterNetAmount(String netAmount) {
        vatCalculatorPageElements.enterPriceWithoutVAT(netAmount);
    }

    @Then("the gross amount should be {string}")
    public void verifyGrossAmount(String expectedGrossAmount) {
        assertEquals(expectedGrossAmount, vatCalculatorPageElements.getPriceWithVAT());
    }

    @Then("the VAT amount should be {string}")
    public void verifyVATAmount(String expectedVATAmount) {
        assertEquals(expectedVATAmount, vatCalculatorPageElements.getVAT());
    }

    @Then("the Pie Chart is visible")
    public void verifyPieChart() {
        Assert.assertTrue(vatCalculatorPageElements.getPieChart().isDisplayed());
    }

    @Then("the error message should be {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, vatCalculatorPageElements.getErrorMsg());
    }

}
