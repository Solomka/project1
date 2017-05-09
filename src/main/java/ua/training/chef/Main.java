package ua.training.chef;

import ua.training.chef.controller.SaladController;
import ua.training.chef.service.SaladCreationServiceImpl;
import ua.training.chef.view.View;

public class Main {
	public static void main(String[] args) {

		SaladCreationServiceImpl saladCreationService = new SaladCreationServiceImpl();
		View view = new View();
		SaladController controller = new SaladController(saladCreationService, view);
		
		controller.processUserSaladSelection();
	}

	
}
