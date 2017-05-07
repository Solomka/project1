package ua.training.chef.view;

import java.util.List;
import java.util.Map;

import ua.training.chef.model.salad.Salad;
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

	public void printSaladInfo(Salad salad) {
		printReadyInfo(salad.getClass().getSimpleName());
		printSaladCaloric(salad.getSaladCaloric());
		printSaladVegetables(salad.getSortedSaladVegetables());
	}

	private void printReadyInfo(String saladName) {
		printMessage(saladName, ViewMessage.READY_INFO);
	}

	public void printSaladVegetables(Map<Vegetable, Double> saladVegetables) {
		printMessage(saladVegetables.toString());
	}

	private void printSaladCaloric(double saldCaloric) {
		printMessage(ViewMessage.CALORIFIC_VALUE, Double.toString(saldCaloric));
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
