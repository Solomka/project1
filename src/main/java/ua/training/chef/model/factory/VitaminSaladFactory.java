package ua.training.chef.model.factory;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.VitaminSalad;

public class VitaminSaladFactory implements SaladFactory{

	@Override
	public Salad createSalad() {
		// TODO Auto-generated method stub
		return new VitaminSalad();
	}

}
