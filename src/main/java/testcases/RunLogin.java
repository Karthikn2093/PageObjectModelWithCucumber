package testcases;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethods;
import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/main/resources/features", 
					glue="pages",
					monochrome = true)
public class RunLogin extends ProjectSpecificMethods {

	@BeforeTest
	public void setDetails() {
		testName = "LoginAndLogout";
		testDesc = "LeafTaps login and logout functionality";
		testAuthor = "Hari";
		testCategory = "Smoke";

	}
	
}
