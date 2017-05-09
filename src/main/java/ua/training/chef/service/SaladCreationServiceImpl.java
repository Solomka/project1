package ua.training.chef.service;

import ua.training.chef.model.factory.SaladFactory;
import ua.training.chef.model.salad.Salad;

public class SaladCreationServiceImpl implements SaladCreationService {

	public SaladCreationServiceImpl() {
	}

	public Salad createSalad(int userSaladSelection) {
		SaladFactory saladFactory = FactoryManager.configureSaladFactory(userSaladSelection);
		return saladFactory.createSalad();
	}

}
