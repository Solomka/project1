package ua.training.chef.controller;

import java.util.Scanner;

import ua.training.chef.view.View;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;

class LocaleController {

	private LocaleController() {
	}

	public static void processUserLanguageChoice(Scanner scanner, View view) {
		String userSaladSelection = UserInputProcessUtility.readUserInput(scanner, view, ViewMessage.LANGUAGE_CHOICE,
				RegexContainer.LANGUAGE_REGEX);

		ViewLocale.setResourceBundleLocale(userSaladSelection);
	}
}
