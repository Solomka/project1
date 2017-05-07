package ua.training.chef.controller;

/**
 * Interface that contains all regex for console user's input validation
 * 
 * @author Solomka
 *
 */
public interface RegexContainer {

	String SALAD_NUMBER_REGEX = "^[1-3]{1}$";
	String CALORIC_RANGE_REGEX = "^(\\d+(\\.\\d+)?)$";
	//String CALORIC_RANGE_REGEX = "^[0-9]{1,}$";
	String TRY_AGAIN_REGEX = "^[yn]{1}$";
}
