package ua.training.chef.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import ua.training.chef.model.ingredients.Vegetable;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.view.utils.ViewMessageUtils;

/**
 * 
 * Class that represents View and provides main user interface displaying all of
 * the user actions' related messages
 * 
 * 
 * @author Solomka
 *
 */
public class View {

	public void printGreeting() {
		printMessage(ViewLocale.BUNDLE.getString(ViewMessage.GREETING), ViewMessageUtils.NEW_LINE);
	}

	public void printSearchVegetablesInCaloriesRangeMessage() {
		printMessage(ViewMessageUtils.NEW_LINE, ViewLocale.BUNDLE.getString(ViewMessage.VEGETABLES_SEARCH_MESSAGE));
	}

	public void printWrongInput() {
		printMessage(ViewLocale.BUNDLE.getString(ViewMessage.WRONG_INPUT));
	}

	public void printSaladMenu() {
		printMessage(getSaladMenu());
	}

	public String getSaladMenu() {
		String menu = generateMessageFromParts(ViewLocale.BUNDLE.getString(ViewMessage.MENU), ViewMessageUtils.NEW_LINE,
				ViewLocale.BUNDLE.getString(ViewMessage.FIRST_MENU_ITEM), ViewMessageUtils.NEW_LINE,
				ViewLocale.BUNDLE.getString(ViewMessage.SECOND_MENU_ITEM), ViewMessageUtils.NEW_LINE,
				ViewLocale.BUNDLE.getString(ViewMessage.THIRD_MENU_ITEM));
		return menu;
	}

	public void printSaladDetails(final Salad salad) {
		Objects.requireNonNull(salad);

		printReadyInfo(salad.getClass().getSimpleName());
		printSaladCalories(salad.getSaladCalories());
		printSaladPrice(salad.getSaladPrice());
		printSaladVegetables(ViewLocale.BUNDLE.getString(ViewMessage.SORTED_VEGETABLES),
				salad.getSortedSaladVegetables());
	}

	private void printReadyInfo(String saladName) {
		printMessage(saladName, ViewLocale.BUNDLE.getString(ViewMessage.READY_INFO), (ViewMessageUtils.NEW_LINE));
	}

	private void printSaladCalories(double saladCaloric) {
		printMessage(ViewLocale.BUNDLE.getString(ViewMessage.SALAD_CALORIFIC_VALUE), Double.toString(saladCaloric));
	}

	private void printSaladPrice(BigDecimal saladPrice) {
		printMessage(ViewLocale.BUNDLE.getString(ViewMessage.SALAD_PRICE), saladPrice.toString());
	}

	public void printSaladVegetables(String message, Map<Vegetable, Double> saladVegetables) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Vegetable vegetable : saladVegetables.keySet()) {
			stringBuilder.append(ViewMessageUtils.LEFT_PARENTHESIS).append(vegetable.toString())
					.append(ViewMessageUtils.VERT_LINA).append(ViewLocale.BUNDLE.getString(ViewMessage.WEIGHT))
					.append(ViewMessageUtils.COLON).append(saladVegetables.get(vegetable))
					.append(ViewMessageUtils.EMPTY_STR).append(ViewMessage.MEASURE).append(ViewMessageUtils.EMPTY_STR)
					.append(ViewMessageUtils.RIGHT_PARANTHESIS).append(ViewMessageUtils.NEW_LINE);
		}

		printMessage(message, ViewMessageUtils.NEW_LINE, stringBuilder.toString());
	}

	/**
	 * Shows constructed message
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 */
	public void printMessage(String... messages) {
		String resultedMessage = generateMessageFromParts(messages);
		System.out.println(resultedMessage);
	}

	/**
	 * Generates one message from its parts (one or many)
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 * @return constructed message
	 */
	private String generateMessageFromParts(String... messages) {
		StringBuilder builder = new StringBuilder();

		for (String mgs : messages) {
			builder.append(mgs);
		}
		return builder.toString();
	}

}
