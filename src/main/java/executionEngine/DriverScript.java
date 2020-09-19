package executionEngine;

import java.lang.reflect.Method;

import ActionKeywords.ActionKeywords;
import config.Constants;
import utility.Excel_RW;

public class DriverScript {

	 public static ActionKeywords actionKeywords;
	 public static String sActionKeyword;
	 public static Method method[];
	 
	 public static int iTestStep;
	 public static int iTestLastStep;
	 public static String sTestCaseID;
	 public static String sRunMode;

	public DriverScript() {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) { 
		try {
			Excel_RW.setExcelFile(Constants.Path_TestData);

			DriverScript startEngine = new DriverScript();
			startEngine.execute_TestCase();
		} catch(Exception e) {

		}

	}

	private void execute_TestCase() throws Exception {

		//This will return the total number of test cases mentioned in the Test cases sheet
		int iTotalTestCases = Excel_RW.getRowCount(Constants.Sheet_TestCases);
		
		//This loop will execute number of times equal to Total number of test cases
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
			
			//This is to get the Test case name from the Test Cases sheet
			sTestCaseID = Excel_RW.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
			
			//This is to get the value of the Run Mode column for the current test case
			sRunMode = Excel_RW.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			
			//This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")){
				
				//Only if the value of Run Mode is 'Yes', this part of code will execute
				iTestStep = Excel_RW.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
				iTestLastStep = Excel_RW.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				
				//This loop will execute number of times equal to Total number of test steps
				for (;iTestStep<iTestLastStep;iTestStep++){
					sActionKeyword = Excel_RW.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
					System.out.println("Executing : " + sTestCaseID + "\t" + sActionKeyword);
					execute_Actions();
				}
			}
		}
	}

	private static void execute_Actions() throws Exception {
		//This is a loop which will run for the number of actions in the Action Keyword class 
		//method variable contain all the method and method.length returns the total number of methods
		for(int i = 0;i < method.length;i++){
			
			//This is now comparing the method name with the ActionKeyword value got from excel
			if(method[i].getName().equals(sActionKeyword)){
				
				//In case of match found, it will execute the matched method
				method[i].invoke(actionKeywords);
				
				//Once any method is executed, this break statement will take the flow outside of for loop
				break;
			}
		}
	}
}