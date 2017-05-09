package ua.training.chef.service;

import ua.training.chef.model.saladfactory.PeasantSaladFactory;
import ua.training.chef.model.saladfactory.SaladFactory;
import ua.training.chef.model.saladfactory.SpringSaladFactory;
import ua.training.chef.model.saladfactory.VitaminSaladFactory;

final class FactoryManager {

	private FactoryManager() {

	}

	static SaladFactory configureSaladFactory(int userSaladSelection) {
		switch (userSaladSelection) {
		case 1:
			return SpringSaladFactory.getSpringSaladFactoryInstance();
		case 2:
			return VitaminSaladFactory.getVitaminSaladFactoryInstance();
		case 3:
			return  PeasantSaladFactory.getPeasantSaladFactoryInstance();
		default:
			throw new IllegalArgumentException("Such salad is not served in our salad restaurant");
		}
	}
}