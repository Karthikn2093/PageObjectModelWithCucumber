package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.ProjectSpecificMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPage extends ProjectSpecificMethods {

	

	// actionElementName
	@Given("enter username as (.*)")
	public LoginPage enterUserName(String username) throws InterruptedException, IOException {
		try {
			driver.findElementById("username").sendKeys(username);
			reportStep(username + " entered successfully", "pass");
		} catch (Exception e) {
			reportStep(username + " not entered successfully", "fail");
		}

		return this;
	}

	@Given("enter password as (.*)")
	public LoginPage enterPassword(String password) throws IOException {
		try {
			driver.findElementById("password").sendKeys(password);
			reportStep(password + " entered successfully", "pass");
		} catch (Exception e) {
			reportStep(password + " not entered successfully", "fail");
		}

		return this;
	}

	@When("click login button")
	public HomePage clickLoginButton() throws IOException {
		try {

			driver.findElementByClassName("decorativeSubmit").click();
			reportStep("Login button clicked successfully", "pass");
		} catch (Exception e) {
			reportStep("Login button not clicked successfully", "fail");
		}

		return new HomePage();
	}

	public LoginPage clickLoginForInvalidData() throws IOException {

		try {

			driver.findElementByClassName("decorativeSubmit").click();
			reportStep("Login button clicked successfully", "pass");
		} catch (Exception e) {
			reportStep("Login button not clicked successfully", "fail");
		}

		return this;
	}

	public void verifyErrorMessage() throws IOException {
		try {
			boolean displayed = driver.findElementByXPath("//p[text()='The Following Errors Occurred:']").isDisplayed();
			Assert.assertTrue(displayed);
			reportStep("Error message displayed successfully", "pass");
		} catch (Exception e) {
			reportStep("Error message not displayed successfully", "fail");
		}
		

		
	}

}
