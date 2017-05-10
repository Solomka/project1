package ua.training.chef.controller;

import java.util.Scanner;

import ua.training.chef.view.View;

/**
 * Utility class that provides methods for validated user's input from console
 * 
 * @author Solomka
 *
 */
 final class UserInputProcessUtility {

	private UserInputProcessUtility() {
		throw new RuntimeException();
	}

	static String readUserInput(Scanner scanner, View view, String message, String regex) {
		view.printMessage(message);

		String res = "";
		while (!(scanner.hasNextLine() && (res = scanner.nextLine()).matches(regex))) {
			view.printWrongInput();
			view.printMessage(message);
		}

		return res;
	}
}
