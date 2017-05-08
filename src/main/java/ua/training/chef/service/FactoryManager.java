package ua.training.chef.service;

import ua.training.chef.model.factory.GreekSaladFactory;
import ua.training.chef.model.factory.PeasantSaladFactory;
import ua.training.chef.model.factory.SaladFactory;
import ua.training.chef.model.factory.VitaminSaladFactory;

final class FactoryManager {

	private FactoryManager() {

	}

	static SaladFactory configureSaladFactory(int userSaladSelection) {
		switch (userSaladSelection) {
		case 1:
			return  GreekSaladFactory.getGreekSaladFactory();
		case 2:
			return new VitaminSaladFactory();
		case 3:
			return new PeasantSaladFactory();
		default:
			throw new IllegalArgumentException("Such salad is not served in our salad restaurant");
		}
	}
}