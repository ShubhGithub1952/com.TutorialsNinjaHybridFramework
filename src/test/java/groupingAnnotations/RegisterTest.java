package groupingAnnotations;

import org.testng.annotations.Test;


@Test(groups = {"all"})
public class RegisterTest {
	@Test(priority = 1, groups = {"smoke","sanity","register"})
	public void registerByProvidingOnlyMandatoryFields() {
		System.out.println("Providing only valid data for the mandatory fields -Register!!");
	}
	
	@Test(priority = 2, groups = {"smoke","sanity","register"})
	public void registerByProvidingAllFields() {
		System.out.println("Providing all data for all fields -Register!!");
	}
	
	@Test(priority = 3, groups = {"sanity","register"})
	 public void registerByNotProvidingAnyFields() {
		 System.out.println("Not Providing any data for any Fileds -Register!!");
	 }
	 
	@Test(priority = 4,groups = {"sanity","register"})
	 public void registerByProvidingDuplicateEmailAddress() {
		 System.out.println("Provide duplicate data for Email address -Register!!");
	 }

}
