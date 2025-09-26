package dataProvidersInTestNG;

import org.testng.annotations.DataProvider;

public class ProvideDataFromDiifClass {
	@DataProvider(name="getTestData")
	public String [][] dataSupplier() {
		String [][]data= {{"pixelMagic1952@gmail.com","Pixel@1952"},
				          {"pixelMagic1953@gmail.com","Pixel@1953"},
				          {"pixelMagic1954@gmail.com","Pixel@1954"}};
		return data;
	}
}
