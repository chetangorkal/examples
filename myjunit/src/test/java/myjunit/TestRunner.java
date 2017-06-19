package myjunit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit1.class, TestJunit2.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());

		// suite
		TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class);
		TestResult testResult = new TestResult();
		suite.run(testResult);

	}
}