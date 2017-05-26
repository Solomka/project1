package ua.training.chef.controller;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.service.SaladCreationService;
import ua.training.chef.view.View;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class SaladController {

	private SaladCreationService saladCreationService;
	private View view;
	private Scanner scanner;

	public SaladController(SaladCreationService saladCreationService, View view) {
		this.saladCreationService = Objects.requireNonNull(saladCreationService);
		this.view = Objects.requireNonNull(view);
		this.scanner = new Scanner(System.in);
	}

	public void processUser() {
		LocaleController.processUserLanguageChoice(scanner, view);

		view.printGreeting();

		processUserSaladSelection();
	}

	private void processUserSaladSelection() {
		int userSaladSelection = Integer.parseInt(UserInputProcessUtility.readUserInput(scanner, view,
				ViewLocale.BUNDLE.getString(ViewMessage.INSTRUCTION) + ViewMessageUtils.NEW_LINE + view.getSaladMenu(),
				RegexContainer.SALAD_NUMBER_REGEX));

		Salad salad = saladCreationService.createSalad(SaladType.getSaladTypeByValue(userSaladSelection));

		showSaladDetails(salad);
		findSaladVegetablesInCaloriesRange(salad);
		orderAnotherSalad();
	}

	private void showSaladDetails(Salad salad) {
		view.printSaladDetails(salad);
	}

	public void findSaladVegetablesInCaloriesRange(Salad salad) {
		view.printSearchVegetablesInCaloriesRangeMessage();

		String minCaloriesValue, maxCaloriesValue;

		while (!checkVegetablesCaloricRange(
				(Double.parseDouble(minCaloriesValue = UserInputProcessUtility.readUserInput(scanner, view,
						ViewLocale.BUNDLE.getString(ViewMessage.MIN_CALORIC_VALUE),
						RegexContainer.CALORIC_RANGE_REGEX))),
				(Double.parseDouble(maxCaloriesValue = UserInputProcessUtility.readUserInput(scanner, view,
						ViewLocale.BUNDLE.getString(ViewMessage.MAX_CALORIC_VALUE),
						RegexContainer.CALORIC_RANGE_REGEX))))) {
			view.printWrongInput();
		}
		List<SaladIngredient> vegetablesInCaloricRange = salad.getVegetablesInCaloriesRange(
				Double.parseDouble(minCaloriesValue), Double.parseDouble(maxCaloriesValue));

		view.printSaladVegetables(ViewLocale.BUNDLE.getString(ViewMessage.VEGETABLES), vegetablesInCaloricRange);
	}

	private boolean checkVegetablesCaloricRange(double minRangeValue, double maxRangeValue) {
		if (minRangeValue >= maxRangeValue) {
			return false;
		}
		return true;
	}

	public void orderAnotherSalad() {
		String userChoise = UserInputProcessUtility.readUserInput(scanner, view,
				ViewLocale.BUNDLE.getString(ViewMessage.TRY_AGAIN), RegexContainer.TRY_AGAIN_REGEX);
		checkUserDecision(userChoise);
	}

	private void checkUserDecision(String userChoise) {
		switch (userChoise) {
		case "y":
			processUserSaladSelection();
			break;
		case "n":
			view.printMessage(ViewLocale.BUNDLE.getString(ViewMessage.BYE));
			break;
		}
	}
}
