package ua.training.chef.view;

/**
 * interface that represents messages and its parts that are shown to the user
 * 
 * @author Solomka
 *
 */
public interface ViewMessage {

	public String GREETING = "Welcome to the vegetable salad restaurant!";
	public String INSTRUCTION = "Choose vegetable salad's number from the menu: ";
	public String MENU = "Vegetable Salalds' menu: ";
	public String TRY_AGAIN = "Do you want to order another salad (y/n)?";
	public String BYE = "BYE! Come again!";

	public String READY_INFO = " salad is ready! Bon appetit!";
	public String SALAD_CALORIFIC_VALUE = "General salad calories: ";
	public String SALAD_PRICE = "General salad price: ";
	public String VEGETABLES = "Salad vegetables: ";
	public String SORTED_VEGETABLES = "Sorted salad vegetables by caloric value: ";	
	public String DRESSINGS = "Salad dressings: ";

	public String VEGETABLES_SEARCH_MESSAGE = "Search vegetables in the calories range: ";
	public String MIN_CALORIC_VALUE = "Type min vegetable's calories value: ";
	public String MAX_CALORIC_VALUE = "Type max vegetable's calories value: ";

	public String FIRST_MENU_ITEM = "1. Spring salad;";
	public String SECOND_MENU_ITEM = "2. Vitamin salad;";
	public String THIRD_MENU_ITEM = "3. Peasant salad;";

	public String WRONG_INPUT = "Wrong input. Try again!";
	public String SALAD_FACTORY_ERROR_MSG = "Such salad is not served in our salad restaurant";

	public String TYPE = "Type";
	public String CALORIES = "Calories";
	public String PRICE = "Price";
	public String FAT = "Fat";
	public String WEIGHT = "Weight";
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
