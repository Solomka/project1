package ua.training.chef.model.factory;

import ua.training.chef.model.salad.GreekSalad;
import ua.training.chef.model.salad.Salad;

public class GreekSaladFactory implements SaladFactory {

	private GreekSaladFactory() {

	}

	private static GreekSaladFactory greekSaladFactoryInstance;

	public static GreekSaladFactory getGreekSaladFactory() {
		if (greekSaladFactoryInstance == null) {
			greekSaladFactoryInstance = new GreekSaladFactory();
		}

		return greekSaladFactoryInstance;
	}

	@Override
	public Salad createSalad() {
		return new GreekSalad();
	}

}
