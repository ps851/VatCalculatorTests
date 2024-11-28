package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManager;

import static utils.CheckboxHandler.checkCheckbox;

public class VatCalculatorPageElements {

    private final WebDriver pageDriver;

    public VatCalculatorPageElements() {
        this.pageDriver = DriverManager.getDriver("chrome");
    }

    public String getPageHeading() {
        return pageDriver.findElement(By.xpath("//h1[contains(@class, 'heading1')]")).getText();
    }

    public String getCalculatorHeading() {
        return pageDriver.findElement(By.xpath("//h2[contains(@class, 'toc-input')]")).getText();
    }

    public String getCalculatorCountryLabel() {
        return pageDriver.findElement(By.xpath("//div[@class='col-sm-4 col-12 p-0 m-0' and contains(text(), 'Country')]")).getText();
    }

    public WebElement getCalculatorCountryDropdown() {
        return pageDriver.findElement(By.xpath("//select[@class='select150' and @name='Country']"));
    }

    public void selectCountryFromDropdown(String country) {
        new Select(getCalculatorCountryDropdown()).selectByVisibleText(country);
    }

    public String getVATRateLabel() {
        return pageDriver.findElement(By.xpath("//div[@class='col-sm-4 col-12 p-0 m-0' and contains(text(), 'VAT rate')]")).getText();
    }

    public WebElement getVATRateCheckboxes(String vatValue) {
        String xpath = String.format("//label[@class='css-label' and contains(@for, 'VAT_%s')]", vatValue);
        return pageDriver.findElement(By.xpath(xpath));
    }

    public void selectVATRateCheckbox(String vatValue) {
        String xpath = String.format("//input[@id='VAT_%s']", vatValue);
        checkCheckbox(pageDriver, xpath);
    }

    public String getCalculatorPriceWithoutVATLabel() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F1']")).getText();
    }

    public void enterPriceWithoutVAT(String price) {
        pageDriver.findElement(By.xpath("//*[@id='NetPrice']")).clear();
        pageDriver.findElement(By.xpath("//*[@id='NetPrice']")).sendKeys(price);
    }

    public String getCalculatorValueAddedTaxLabel() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F2']")).getText();
    }

    public String getVAT() {
        WebElement shadowHost = pageDriver.findElement(By.cssSelector("#VATsum"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("div"));

        return shadowContent.getText();
    }

    public String getCalculatorPriceVATLabel() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F3']")).getText();
    }

    public String getPriceWithVAT() {
        WebElement shadowHost = pageDriver.findElement(By.cssSelector("#Price"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("div"));

        return shadowContent.getText();
    }

    public WebElement getCalculatorPriceWithoutVATCheckbox() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F1']"));
    }

    public WebElement getCalculatorValueAddedTaxCheckbox() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F2']"));
    }

    public WebElement getCalculatorPriceVATCheckbox() {
        return pageDriver.findElement(By.xpath("//label[@class='css-label' and @for='F3']"));
    }

    public WebElement getCalculatorResetButton() {
        return pageDriver.findElement(By.xpath("//input[@class='btn btn-sm btn-outline-danger']"));
    }

    public WebElement getPieChart() {
        return pageDriver.findElement(By.xpath("//*[@id='chart_div']"));
    }

    public String getErrorMsg() {
        WebElement spanElement = pageDriver.findElement(By.xpath("//*[@id='chart_div']//div[contains(@id, 'google-visualization-errors')]/span"));

        return spanElement.getText().replace("×", "").trim();
    }

}
