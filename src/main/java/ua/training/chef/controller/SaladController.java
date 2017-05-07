package ua.training.chef.controller;

import java.util.Map;
import java.util.Scanner;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.vegetable.Vegetable;
import ua.training.chef.service.SaladCreationServiceImpl;
import ua.training.chef.view.View;
import ua.training.chef.view.ViewMessage;

public class SaladController {

	private SaladCreationServiceImpl saladCreationService;
	private View view;
	private Scanner scanner;

	public SaladController(SaladCreationServiceImpl saladCreationService, View view) {
		this.saladCreationService = saladCreationService;
		this.view = view;
		this.scanner = new Scanner(System.in);
	}

	public void processUserSaladSelection() {
		view.printMessage(ViewMessage.GREETING);

		int userSaladSelection = Integer.parseInt(
				readUserInput(ViewMessage.INSTRUCTION + view.getSaladMenu(), RegexContainer.SALAD_NUMBER_REGEX));

		Salad salad = saladCreationService.createSalad(userSaladSelection);
		showSaladInfo(salad);
		findSaladVegetablesInCaloricRange(salad);
		orderAnotherSalad();
	}

	private void showSaladInfo(Salad salad) {
		view.printSaladInfo(salad);

	}

	public void findSaladVegetablesInCaloricRange(Salad salad) {
		String minCaloricValue, maxCaloricValue;

		while (!checkVegetablesCaloricRange((Double.parseDouble(
				minCaloricValue = readUserInput(ViewMessage.MIN_CALORIC_VALUE, RegexContainer.CALORIC_RANGE_REGEX))),
				Double.parseDouble((maxCaloricValue = readUserInput(ViewMessage.MAX_CALORIC_VALUE,
						RegexContainer.CALORIC_RANGE_REGEX))))) {
			view.printWrongInput();
		}
		Map<Vegetable, Double> vegetablesInCaloricRange = saladCreationService.findVegetablesInCaloricRange(salad,
				Double.parseDouble(minCaloricValue), Double.parseDouble(maxCaloricValue));
		view.printSaladVegetables(vegetablesInCaloricRange);
	}

	public void orderAnotherSalad() {
		String userChoise = readUserInput(ViewMessage.TRY_AGAIN, RegexContainer.TRY_AGAIN_REGEX);
		checkUserDecision(userChoise);
	}

	private void checkUserDecision(String userChoise) {
		switch (userChoise) {
		case "y":
			processUserSaladSelection();
			break;
		case "n":
			view.printMessage(ViewMessage.BYE);
			break;
		}
	}

	private String readUserInput(String message, String regex) {
		view.printMessage(message);

		String res = "";
		while (!(scanner.hasNextLine() && (res = scanner.nextLine()).matches(regex))) {
			view.printWrongInput();
			view.printMessage(message);
		}

		return res;
	}

	private boolean checkVegetablesCaloricRange(double minRangeValue, double maxRangeValue) {
		if (minRangeValue >= maxRangeValue) {
			return false;
		}
		return true;

	}
}
