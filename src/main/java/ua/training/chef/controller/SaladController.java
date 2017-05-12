package ua.training.chef.controller;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Vegetable;
import ua.training.chef.service.SaladCreationService;
import ua.training.chef.view.View;
import ua.training.chef.view.ViewMessage;

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
		chooseLanguage();
		view.printGreeting();

		processUserSaladSelection();
	}

	private void chooseLanguage() {
		String userSaladSelection = UserInputProcessUtility.readUserInput(scanner, view, ViewMessage.LANGUAGE_CHOICE,
				RegexContainer.LANGUAGE_REGEX);

		View.setResourceBundleLocale(userSaladSelection);
	}

	private void processUserSaladSelection() {
		int userSaladSelection = Integer.parseInt(UserInputProcessUtility.readUserInput(scanner, view,
				View.BUNDLE.getString(ViewMessage.INSTRUCTION) + ViewMessage.NEW_LINE + view.getSaladMenu(),
				RegexContainer.SALAD_NUMBER_REGEX));

		Salad salad = saladCreationService.createSalad(userSaladSelection);

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
						View.BUNDLE.getString(ViewMessage.MIN_CALORIC_VALUE), RegexContainer.CALORIC_RANGE_REGEX))),
				(Double.parseDouble(maxCaloriesValue = UserInputProcessUtility.readUserInput(scanner, view,
						View.BUNDLE.getString(ViewMessage.MAX_CALORIC_VALUE), RegexContainer.CALORIC_RANGE_REGEX))))) {
			view.printWrongInput();
		}
		Set<SortableSaladIngredient<Vegetable>> vegetablesInCaloricRange = salad.getVegetablesInCaloriesRange(
				Double.parseDouble(minCaloriesValue), Double.parseDouble(maxCaloriesValue));

		view.printSaladVegetables(View.BUNDLE.getString(ViewMessage.VEGETABLES), vegetablesInCaloricRange);
	}

	private boolean checkVegetablesCaloricRange(double minRangeValue, double maxRangeValue) {
		if (minRangeValue >= maxRangeValue) {
			return false;
		}
		return true;
	}

	public void orderAnotherSalad() {
		String userChoise = UserInputProcessUtility.readUserInput(scanner, view,
				View.BUNDLE.getString(ViewMessage.TRY_AGAIN), RegexContainer.TRY_AGAIN_REGEX);
		checkUserDecision(userChoise);
	}

	private void checkUserDecision(String userChoise) {
		switch (userChoise) {
		case "y":
			processUserSaladSelection();
			break;
		case "n":
			view.printMessage(View.BUNDLE.getString(ViewMessage.BYE));
			break;
		}
	}

}
