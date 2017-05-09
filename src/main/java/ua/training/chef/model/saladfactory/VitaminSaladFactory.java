package ua.training.chef.model.saladfactory;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.VitaminSalad;

public class VitaminSaladFactory implements SaladFactory {

	private static VitaminSaladFactory vitaminSaladFactoryInstance;
	
	private VitaminSaladFactory(){
		
	}

	public static VitaminSaladFactory getVitaminSaladFactoryInstance() {
		if (vitaminSaladFactoryInstance == null) {
			vitaminSaladFactoryInstance = new VitaminSaladFactory();
		}

		return vitaminSaladFactoryInstance;
	}

	@Override
	public Salad createSalad() {
		return new VitaminSalad();
	}

}
