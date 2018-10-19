package com.qa.TaskOneCucumber;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class TaskOneTest {
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Test Results");
	
    static ArrayList<String[]> testResults = new ArrayList<String[]>();
    
	public WebDriver driver = null;
	static ExtentReports extent = new ExtentReports(Constants.reportAdd,true);
	ExtentTest test = extent.startTest("Testing User Creation");
	
	@Before
	public void setup() {
		System.setProperty(Constants.webDriver, Constants.drivePath);
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
		test.log(LogStatus.INFO, "Starting the test");
	}
	
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		
		ManagePage man = PageFactory.initElements(driver, ManagePage.class);
		CreatePage create = PageFactory.initElements(driver, CreatePage.class);
		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		MainPage main = PageFactory.initElements(driver, MainPage.class);


		test.log(LogStatus.INFO, "Entering Login details");
		log.login();
		main.userCreation();
		man.clickUsers();
		create.clickCreate();	
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		test.log(LogStatus.INFO, "Filling in new user information");
		CreateUserPage register = PageFactory.initElements(driver, CreateUserPage.class);
		register.fillUserInformation("admin", "1234", "Mr. Admin","admin@admin.ru");
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		CreateUserPage register = PageFactory.initElements(driver, CreateUserPage.class);
		register.submitUserInfo();
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		PostRegisterPage post = PageFactory.initElements(driver, PostRegisterPage.class);
		String userCreated = post.checkUser();
		if("admin".equals(userCreated)) {
			test.log(LogStatus.PASS, "User succesfully created");
		}else {
			test.log(LogStatus.INFO, "User creation unsuccessful");
		}
		assertEquals("admin",userCreated);
		String[] toAdd = {"testing manual user addition", "admin", userCreated};
		TaskOneTest.testResults.add(toAdd);
	}

	
	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		test.log(LogStatus.INFO, "Filling in new user information");
		CreateUserPage register = PageFactory.initElements(driver, CreateUserPage.class);
		register.fillUserInformation(arg1, arg2, arg3, arg4);

	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Checking wheter username is visible");
		CreatePage post = PageFactory.initElements(driver, CreatePage.class);
		String userCreated = post.checkForUsers(driver, arg1);
		
		if(userCreated.equals(arg1)) {
			test.log(LogStatus.PASS, "User succesfully created");
		}else {
			test.log(LogStatus.INFO, "User creation unsuccessful");
		}
		assertEquals(arg1,userCreated);
	
		String[] toAdd = {"testing automatic user addition", arg1, userCreated};
		TaskOneTest.testResults.add(toAdd);
	}

	
	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		ManagePage man = PageFactory.initElements(driver, ManagePage.class);
		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		MainPage main = PageFactory.initElements(driver, MainPage.class);
		CreatePage create = PageFactory.initElements(driver, CreatePage.class);

		test.log(LogStatus.INFO, "Checking for name");
		log.login();
		main.userCreation();
		man.clickUsers();
		create.checkForUsers(driver, arg1);
			
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Clicking the appropriate entry");
		CreatePage create = PageFactory.initElements(driver, CreatePage.class);
		create.checkForUsers(driver, arg1);
		create.displayDetails();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	   AccountInfoPage info = PageFactory.initElements(driver, AccountInfoPage.class);
	   String name = info.checkName();
	   boolean isCorrectName = name.equals(arg1)? true: false; 
	   if(isCorrectName) {
		   test.log(LogStatus.PASS, "Record succesfully located");
	   }else {
		   test.log(LogStatus.PASS, "Record not found");
	   }
	   assertEquals(arg1,name);
	   
		String[] toAdd = {"testing whether the  crect profile was displayed", arg1, name};
		TaskOneTest.testResults.add(toAdd);
	}

	
	
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		ManagePage man = PageFactory.initElements(driver, ManagePage.class);
		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		MainPage main = PageFactory.initElements(driver, MainPage.class);
		CreatePage create = PageFactory.initElements(driver, CreatePage.class);

		test.log(LogStatus.INFO, "Checking for name");
		log.login();
		main.userCreation();
		man.clickUsers();
		create.checkForUsers(driver, arg1);
		create.displayDetails();
		
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		test.log(LogStatus.INFO,"clicking the configure button");
		AccountInfoPage info = PageFactory.initElements(driver, AccountInfoPage.class);
		info.clickConfigure();
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		test.log(LogStatus.INFO,"Changing the name to: "+arg1);
		ConfigurePage config = PageFactory.initElements(driver, ConfigurePage.class);
		config.changeName(arg1);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		ConfigurePage config = PageFactory.initElements(driver, ConfigurePage.class);
		config.saveChanges();
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		ChangedNamePage changed = PageFactory.initElements(driver,ChangedNamePage.class);
		String isCorrectName = changed.checkName();	
	   if(isCorrectName.equals(arg1)) {
		   test.log(LogStatus.PASS, "Record succesfully located");
	   }else {
		   test.log(LogStatus.PASS, "Record not found");
	   }
	   assertEquals(arg1,isCorrectName);
		String[] toAdd = {"testing whether the name was changed ", arg1, isCorrectName};
		TaskOneTest.testResults.add(toAdd);
		
		

	}
	
	@After
	public void teardown() throws FileNotFoundException, IOException {
		driver.close();
		extent.flush();
        int rowCount = 0;
        
        for (int i=0; i< testResults.size(); i ++) {
            Row row = sheet.createRow(rowCount);
            rowCount++;
            int columnCount = 0;
             System.out.println("HERE");
            for (int j=0; j< testResults.get(i).length; j ++) {
            	System.out.println(testResults.get(i).length);
                Cell cell = row.createCell(columnCount);
                columnCount++;
                cell.setCellValue(testResults.get(i)[j]);
            }
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream(Constants.excelPath)) {
            workbook.write(outputStream);
        }
	}
	
	
}
