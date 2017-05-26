package ua.training.chef.view;

import ua.training.chef.view.utils.ViewMessageUtils;

/**
 * interface that represents messages and its parts that are shown to the user
 * 
 * @author Solomka
 *
 */
public interface ViewMessage {

	String LANGUAGE_CHOICE = "Choose GUI language(ua/en):";
	String GREETING = "chef.input.greeting";
	String INSTRUCTION = "chef.input.instruction";
	String MENU = "chef.input.menu";
	String TRY_AGAIN = "chef.input.tryAgain";
	String BYE = "chef.input.bye";

	String READY_INFO = "chef.input.readyInfo";
	String SALAD_CALORIFIC_VALUE = "chef.input.generalSaladCalories";
	String SALAD_PRICE = "chef.input.generalSaladPrice";
	String VEGETABLES = "chef.input.vegetables";
	String SORTED_VEGETABLES = "chef.input.sortedVegetables";
	
	String VEGETABLES_SEARCH_MESSAGE = "chef.input.searchCondition";
	String MIN_CALORIC_VALUE = "chef.input.minCaloriesValue";
	String MAX_CALORIC_VALUE = "chef.input.maxCaloriesValue";

	String FIRST_MENU_ITEM = "chef.input.firstMenuItem";
	String SECOND_MENU_ITEM = "chef.input.secondMenuItem";
	String THIRD_MENU_ITEM = "chef.input.thirdMenuItem";

	String WRONG_INPUT = "chef.input.wrongInput";
	String SALAD_FACTORY_ERROR_MSG = "Such salad is not served in our salad restaurant";
	String SALAD_TYPE_VALUE_ERROR_MSG = "Salad type with such value doesn't exist";

	String CALORIES = "chef.input.calories";
	String PRICE = "chef.input.price";
	String WEIGHT = "chef.input.weight";
	String TYPE = "chef.input.type";
	String SIZE = "chef.input.size";
	String IS_GRATED = "chef.input.isGrated";
	String IS_CUT = "chef.input.isCut";
	String COLOR = "chef.input.color";
	String IS_CUTABLE = "chef.input.isCutable";
	String IS_PEELED = "chef.input.isPeeled";
	
	
	String PER = "per";
	String MEASURE = "g";

	/* Vegetables */
	
	String CARROT = "chef.input.carrot";
	String CUCUMBER = "chef.input.cucumber";
	String LETTUCE = "chef.input.lettuce";
	String OLIVE = "chef.input.olive";
	String ONION = "chef.input.onion";
	String PEPPER = "chef.input.pepper";
	String RADISH = "chef.input.radish";
	String TOMATO = "chef.input.tomato";

	static String getUnitOfMeasurement(int measurementValue) {
		return new StringBuilder(PER).append(ViewMessageUtils.EMPTY_STR).append(measurementValue).append(MEASURE).toString();
	}

}
