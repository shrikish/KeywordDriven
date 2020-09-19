package config;

public class Constants {

	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value
	
	public static final String FirefoxDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver_0.27.0.exe";
	public static final String ChromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\ChromeDriver_85.0.4183.87.exe";
	
	public static final String URL = "https://demoqa.com/login";
	public static final String Path_TestData = System.getProperty("user.dir") + "\\src\\main\\resources\\TestCases.xlsx";
	public static final String File_TestData = "TestCases.xlsx";

	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	public static final int Col_ActionKeyword =3 ;
	public static final int Col_RunMode =2 ;

	//List of Data Engine Excel sheets
	public static final String Sheet_TestCases = "TestCases";
	public static final String Sheet_TestSteps = "TestSteps";

	// List of Test Data
	public static final String UserName = "toolsqa";
	public static final String Password = "Toolsqa@2020";

}