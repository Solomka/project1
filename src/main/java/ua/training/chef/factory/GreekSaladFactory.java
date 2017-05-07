package ua.training.chef.factory;

import ua.training.chef.model.salad.GreekSalad;
import ua.training.chef.model.salad.Salad;

public class GreekSaladFactory implements SaladFactory {

	@Override
	public Salad createSalad() {
		return new GreekSalad();
	}

}
