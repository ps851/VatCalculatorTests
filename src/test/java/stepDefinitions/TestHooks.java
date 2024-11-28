package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;

public class TestHooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // Default to Chrome
        DriverManager.getDriver(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}