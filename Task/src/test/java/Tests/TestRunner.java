package Tests;

import org.testng.TestNG;

public class TestRunner {
	static TestNG testNg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testNg= new TestNG();
		
		testNg.setPreserveOrder(true);
		
		testNg.setTestClasses(new Class[] {Hotel_Reserve.class});
	
		
		testNg.run();
		


	}

}
