package ua.training.chef.service;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.saladfactory.SaladFactory;

public class SaladCreationServiceImpl implements SaladCreationService {

	public SaladCreationServiceImpl() {
	}

	public Salad createSalad(int userSaladSelection) {
		SaladFactory saladFactory = FactoryManager.configureSaladFactory(userSaladSelection);
		return saladFactory.createSalad();
	}

}
