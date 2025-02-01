package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void launch() {
		Reporter.log("Sample Class executed", true);
		Reporter.log("Modified in github", true);
		Reporter.log("Modified in eclipse", true);
	}

}
