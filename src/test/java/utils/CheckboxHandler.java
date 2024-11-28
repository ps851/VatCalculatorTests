package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxHandler {

    public static void checkCheckbox(WebDriver driver, String xpath) {
        WebElement checkbox = driver.findElement(By.xpath(xpath));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}