package ua.training.chef.view;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Vegetable;

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

	/**
	 * Shows information about wrong input
	 */

	public void printGreeting() {
		printMessage(ViewMessage.GREETING, ViewMessage.NEW_LINE);
	}

	public void printSearchVegetablesInCaloriesRangeMessage() {
		printMessage(ViewMessage.NEW_LINE, ViewMessage.VEGETABLES_SEARCH_MESSAGE);
	}

	public void printWrongInput() {
		printMessage(ViewMessage.WRONG_INPUT);
	}

	public void printSaladMenu() {
		printMessage(getSaladMenu());
	}

	public String getSaladMenu() {
		String menu = generateMessageFromParts(ViewMessage.MENU, ViewMessage.NEW_LINE, ViewMessage.FIRST_MENU_ITEM,
				ViewMessage.NEW_LINE, ViewMessage.SECOND_MENU_ITEM, ViewMessage.NEW_LINE, ViewMessage.THIRD_MENU_ITEM);
		return menu;
	}

	public void printSaladDetails(final Salad salad) {
		Objects.requireNonNull(salad);

		printReadyInfo(salad.getClass().getSimpleName());
		printSaladCalories(salad.getSaladCalories());
		printSaladPrice(salad.getSaladPrice());
		printSaladVegetables(ViewMessage.SORTED_VEGETABLES, salad.getSortedSaladVegetables());
		printSaladDressings(ViewMessage.DRESSINGS, salad.getDressings());
	}

	private void printReadyInfo(String saladName) {
		printMessage(saladName, ViewMessage.READY_INFO, (ViewMessage.NEW_LINE));
	}

	private void printSaladCalories(double saladCaloric) {
		printMessage(ViewMessage.SALAD_CALORIFIC_VALUE, Double.toString(saladCaloric));
	}

	private void printSaladPrice(BigDecimal saladPrice) {
		printMessage(ViewMessage.SALAD_PRICE, saladPrice.toString());
	}

	public void printSaladVegetables(String message, Set<SortableSaladIngredient<Vegetable>> saladVegetables) {
		StringBuilder stringBuilder = new StringBuilder();

		for (SortableSaladIngredient<Vegetable> vegetable : saladVegetables) {
			stringBuilder.append(vegetable.toString()).append(ViewMessage.NEW_LINE);
		}

		printMessage(message, ViewMessage.NEW_LINE, stringBuilder.toString());
	}

	private void printSaladDressings(String message, Set<SaladIngredient<Dressing>> saladDressings) {
		StringBuilder stringBuilder = new StringBuilder();

		for (SaladIngredient<Dressing> dressing : saladDressings) {
			stringBuilder.append(dressing.toString()).append(ViewMessage.NEW_LINE);
		}
		
		printMessage(message, ViewMessage.NEW_LINE, stringBuilder.toString());
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
