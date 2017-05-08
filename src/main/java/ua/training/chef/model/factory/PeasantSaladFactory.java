package ua.training.chef.model.factory;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;

public class PeasantSaladFactory implements SaladFactory{

	@Override
	public Salad createSalad() {
		// TODO Auto-generated method stub
		return new PeasantSalad();
	}

}
