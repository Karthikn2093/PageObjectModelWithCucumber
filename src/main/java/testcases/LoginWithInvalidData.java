package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginWithInvalidData extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setDetails() {
		testName = "LoginWithInvalidData";
		testDesc = "LeafTaps login with invalied data";
		testAuthor = "Hari";
		testCategory = "Smoke";

	}

	@Test
	public void loginwithInvalidData() throws InterruptedException, IOException {

	//	LoginPage lp = new LoginPage();

		new LoginPage()
		.enterUserName("demo123")
		.enterPassword("crmsfa")
		.clickLoginForInvalidData()
		.verifyErrorMessage();

	}

}
