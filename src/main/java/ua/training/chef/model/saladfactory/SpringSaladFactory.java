package ua.training.chef.model.saladfactory;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SpringSalad;

public class SpringSaladFactory implements SaladFactory {

	private SpringSaladFactory() {

	}

	private static SpringSaladFactory springSaladFactoryInstance;

	public static SpringSaladFactory getSpringSaladFactoryInstance() {
		if (springSaladFactoryInstance == null) {
			springSaladFactoryInstance = new SpringSaladFactory();
		}

		return springSaladFactoryInstance;
	}

	@Override
	public Salad createSalad() {
		return new SpringSalad();
	}

}
