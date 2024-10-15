package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setDetails() {
		excelFileName = "Login";
		testName = "LoginAndLogout";
		testDesc = "LeafTaps login and logout functionality";
		testAuthor = "Hari";
		testCategory = "Smoke";
		

	}
	
	

	@Test(dataProvider = "fetchData")
	public void loginLogout(String username, String password) throws InterruptedException, IOException {

	//	LoginPage lp = new LoginPage();

		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogout();

	}

}
