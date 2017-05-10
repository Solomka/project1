package ua.training.chef;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.training.chef.salad.SaladTest;

@RunWith(Suite.class)
@SuiteClasses({ RegexContainerTest.class, SaladCreationServiceImplTest.class, SaladTest.class })
public class TestSuite {

	/*
	 * empty class
	 */
}
