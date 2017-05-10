package ua.training.chef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.training.chef.controller.RegexContainer;

public class RegexContainerTest {
	
	@Test
	public void testLanguageRegex() {
		String language = "en";

		boolean actual = language.matches(RegexContainer.LANGUAGE_REGEX);
		boolean expected = true;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testLanguageRegexEmpty() {
		String language = " ";

		boolean actual = language.matches(RegexContainer.LANGUAGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testLanguageRegexWrong() {
		String language = "enua";

		boolean actual = language.matches(RegexContainer.LANGUAGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}
	@Test
	public void testLanguageRegexInteger() {
		String language = "1";

		boolean actual = language.matches(RegexContainer.LANGUAGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testSaladNumberRegexEmptyStr() {
		String saladNumber = " ";

		boolean actual = saladNumber.matches(RegexContainer.SALAD_NUMBER_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testSaladNumberRegex() {
		String saladNumber = "3";

		boolean actual = saladNumber.matches(RegexContainer.SALAD_NUMBER_REGEX);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void testSaladNumberRegexString() {
		String saladNumber = "dfg";

		boolean actual = saladNumber.matches(RegexContainer.SALAD_NUMBER_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testSaladNumberRegexWrongSaladValue() {
		String saladNumber = "12";

		boolean actual = saladNumber.matches(RegexContainer.SALAD_NUMBER_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testCaloricRangeRegex() {
		String caloricRange = "17.3";

		boolean actual = caloricRange.matches(RegexContainer.CALORIC_RANGE_REGEX);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void testCaloricRangeEmpty() {
		String caloricRange = " ";

		boolean actual = caloricRange.matches(RegexContainer.CALORIC_RANGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testCaloricRangeRegexNegativeNumber() {
		String caloricRange = "-1.1";

		boolean actual = caloricRange.matches(RegexContainer.CALORIC_RANGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testCaloricRangeRegexZero() {
		String caloricRange = "0";

		boolean actual = caloricRange.matches(RegexContainer.CALORIC_RANGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testCaloricRangeRegexString() {
		String caloricRange = "xcv";

		boolean actual = caloricRange.matches(RegexContainer.CALORIC_RANGE_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testTryAgainRegex() {
		String tryAgain = "y";

		boolean actual = tryAgain.matches(RegexContainer.TRY_AGAIN_REGEX);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void testTryAgainRegexEmpty() {
		String tryAgain = " ";

		boolean actual = tryAgain.matches(RegexContainer.TRY_AGAIN_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testTryAgainRegexWrongStringValue() {
		String tryAgain = "dfg";

		boolean actual = tryAgain.matches(RegexContainer.TRY_AGAIN_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void testTryAgainRegexIntegerValue() {
		String tryAgain = "-1";

		boolean actual = tryAgain.matches(RegexContainer.TRY_AGAIN_REGEX);
		boolean expected = false;

		assertEquals(expected, actual);
	}
}
