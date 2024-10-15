package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;
import cucumber.api.java.en.Then;

public class HomePage extends ProjectSpecificMethods{
	
	
	
	public LoginPage clickLogout() throws IOException {
		try {

			driver.findElementByClassName("decorativeSubmit").click();
			reportStep("Logout button clicked successfully", "pass");
		} catch (Exception e) {
			reportStep("Logout button not clicked successfully", "fail");
		}
		
		return new LoginPage();
	}
	
	@Then("homepage should display")
	public void verifyHomePage() {
		
		boolean displayed = driver.findElementByLinkText("CRM/SFA").isDisplayed();
		
		if(displayed) {
			
			System.out.println("homepage is displayed");
		}
		else {
			System.out.println("homepage is not displayed");
		}

	}

}
