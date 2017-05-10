package ua.training.chef.view;

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
	String DRESSINGS = "chef.input.dressings";

	String VEGETABLES_SEARCH_MESSAGE = "chef.input.searchCondition";
	String MIN_CALORIC_VALUE = "chef.input.minCaloriesValue";
	String MAX_CALORIC_VALUE = "chef.input.maxCaloriesValue";

	String FIRST_MENU_ITEM = "chef.input.firstMenuItem";
	String SECOND_MENU_ITEM = "chef.input.seconMenuItem";
	String THIRD_MENU_ITEM = "chef.input.thirdMenuItem";

	String WRONG_INPUT = "chef.input.wrongInput";
	String SALAD_FACTORY_ERROR_MSG = "Such salad is not served in our salad restaurant";

	String TYPE = "chef.input.type";
	String CALORIES = "chef.input.calories";
	String PRICE = "chef.input.price";
	String FAT = "chef.input.fat";
	String WEIGHT = "chef.input.weight";
	String PER = "per";
	String MEASURE = "g/ml";

	/* Utility strings */
	String LEFT_PARENTHESIS = "{ ";
	String RIGHT_PARANTHESIS = " }";
	String COMMA = ", ";
	String FULL_STOP = ".";
	String COLON = ": ";
	String EMPTY_STR = " ";
	String NEW_LINE = "\n";
	String BACKSLASH = "/";
	String SEMICOLON = ";";
	String VERT_LINA = " |";
	String EQUALITY_SIGN = " = ";

	static String getUnitOfMeasurement(int measurementValue) {
		return new StringBuilder(PER).append(EMPTY_STR).append(measurementValue).append(MEASURE).toString();
	}

}
