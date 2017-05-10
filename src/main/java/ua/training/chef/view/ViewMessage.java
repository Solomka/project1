package ua.training.chef.view;

/**
 * interface that represents messages and its parts that are shown to the user
 * 
 * @author Solomka
 *
 */
public interface ViewMessage {

	public String LANGUAGE_CHOICE = "Choose GUI language(ua/en):";
	public String GREETING = "chef.input.greeting";
	public String INSTRUCTION = "chef.input.instruction";
	public String MENU = "chef.input.menu";
	public String TRY_AGAIN = "chef.input.tryAgain";
	public String BYE = "chef.input.bye";

	public String READY_INFO = "chef.input.readyInfo";
	public String SALAD_CALORIFIC_VALUE = "chef.input.generalSaladCalories";
	public String SALAD_PRICE = "chef.input.generalSaladPrice";
	public String VEGETABLES = "chef.input.vegetables";
	public String SORTED_VEGETABLES = "chef.input.sortedVegetables";	
	public String DRESSINGS = "chef.input.dressings";

	public String VEGETABLES_SEARCH_MESSAGE = "chef.input.searchCondition";
	public String MIN_CALORIC_VALUE = "chef.input.minCaloriesValue";
	public String MAX_CALORIC_VALUE = "chef.input.maxCaloriesValue";

	public String FIRST_MENU_ITEM = "chef.input.firstMenuItem";
	public String SECOND_MENU_ITEM = "chef.input.seconMenuItem";
	public String THIRD_MENU_ITEM = "chef.input.thirdMenuItem";

	public String WRONG_INPUT = "chef.input.wrongInput";
	public String SALAD_FACTORY_ERROR_MSG = "Such salad is not served in our salad restaurant";

	public String TYPE = "chef.input.type";
	public String CALORIES = "chef.input.calories";
	public String PRICE = "chef.input.price";
	public String FAT = "chef.input.fat";
	public String WEIGHT = "chef.input.weight";
	public String PER = "per";
	public String MEASURE = "g/ml";

	/* Utility strings */
	public String LEFT_PARENTHESIS = "{ ";
	public String RIGHT_PARANTHESIS = " }";
	public String COMMA = ", ";
	public String FULL_STOP = ".";
	public String COLON = ": ";
	public String EMPTY_STR = " ";
	public String NEW_LINE = "\n";
	public String BACKSLASH = "/";
	public String SEMICOLON = ";";
	public String VERT_LINA = " |";
	public String EQUALITY_SIGN = " = ";

	 static String getUnitOfMeasurement(int measurementValue) {
		return new StringBuilder(PER).append(EMPTY_STR).append(measurementValue).append(MEASURE).toString();
	}

}
