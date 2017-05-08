package ua.training.chef.service;

import java.util.Map;

import ua.training.chef.model.factory.SaladFactory;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.vegetable.Vegetable;

public class SaladCreationServiceImpl implements SaladCreationService {

	public SaladCreationServiceImpl() {
	}

	public Salad createSalad(int userSaladSelection) {
		SaladFactory saladFactory = FactoryManager.configureSaladFactory(userSaladSelection);
		return saladFactory.createSalad();
	}

	@Override
	public Map<Vegetable, Double> findVegetablesInCaloricRange(Salad salad, double minCaloricValue,
			double maxCaloricValue) {

		return salad.getVegetablesInCaloricRange(minCaloricValue, maxCaloricValue);
	}

}
