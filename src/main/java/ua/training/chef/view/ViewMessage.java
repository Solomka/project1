package ua.training.chef.view;

/**
 * interface that represents messages and its parts that are shown to the user
 * 
 * @author Solomka
 *
 */
public interface ViewMessage {

	public String GREETING = "Welcome to the salad restaurant!";
	public String INSTRUCTION = "Choose salad's number from the menu: ";
	public String MENU = "Salalds' menu: ";
	public String TRY_AGAIN = "Do you want to order another salad (y/n)?";
	public String BYE = "Come again! BYE!";
	
	public String READY_INFO = " salad is ready! Bon appetit!";
	public String CALORIFIC_VALUE = "General salad calorific value: ";
	
	public String MIN_CALORIC_VALUE = "Type min vegetable caloric value: ";
	public String MAX_CALORIC_VALUE = "Type max vegetable caloric value: ";
	
	public String FIRST_MENU_ITEM = "1. Greek salad;";
	public String SECOND_MENU_ITEM = "2. Vitamin salad;";
	public String THIRD_MENU_ITEM = "3. Peasant salad;";
	
	public String WRONG_INPUT = "Wrong input. Try again!";
	
	
	/* Utility strings */
	public String LEFT_PARENTHESIS = "[ ";
	public String RIGHT_PARANTHESIS = " ]";
	public String COMMA = ", ";
	public String FULL_STOP = ".";
	public String COLON = ": ";
	public String EMPTY_STR = " ";
	public String NEW_LINE = "\n";
	public String BACKSLASH = "/";
	public String SEMICOLON = ";";

}
