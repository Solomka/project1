package ua.training.chef.model.saladfactory;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;

public class PeasantSaladFactory implements SaladFactory {
	
	private PeasantSaladFactory(){
		
	}
	
	private static PeasantSaladFactory peasantSaladFactoryInstance;
	
	public static PeasantSaladFactory getPeasantSaladFactoryInstance() {
		if (peasantSaladFactoryInstance == null) {
			peasantSaladFactoryInstance = new PeasantSaladFactory();
		}

		return peasantSaladFactoryInstance;
	}

	@Override
	public Salad createSalad() {
		return new PeasantSalad();
	}
}
