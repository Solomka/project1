package ua.training.chef.controller;

/**
 * Interface that contains all regex for console user's input validation
 * 
 * @author Solomka
 *
 */
public interface RegexContainer {

	String LANGUAGE_REGEX = "^(en|ua)$";
	String SALAD_NUMBER_REGEX = "^[1-3]{1}$";
	String CALORIC_RANGE_REGEX = "^([1-9]+(\\.\\d+)?)$";
	String TRY_AGAIN_REGEX = "^[yn]{1}$";
}
