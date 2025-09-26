package groupingAnnotations;

import org.testng.annotations.Test;

public class SearchTest {
	@Test(priority = 1, groups = {"smoke","sanity","regression","search","all"})
	public void searchForValidProduct() {
		System.out.println("Search for valid Product - Search!!");
	}
	
	@Test(priority = 2, groups = {"sanity","regression","search","all"})
	public void searchForInvalidProduct() {
		System.out.println("Search for Invalid Product -Search!!");
	}
	
	@Test(priority = 3, groups = {"sanity","regression","search","all"})
	public void searchWithoutAnySearchTeam() {
		System.out.println("Search without any Search Team- Search!!");
	}

}
