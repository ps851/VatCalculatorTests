package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxHandler {

    // Method to check the checkbox using WebDriver
    public static void checkCheckbox(WebDriver driver, String xpath) {
        // Locate the checkbox using the provided XPath
        WebElement checkbox = driver.findElement(By.xpath(xpath));
        // Check if the checkbox is not already selected
        if (!checkbox.isSelected()) {
            checkbox.click(); // Click the checkbox to select it
        }
    }
}