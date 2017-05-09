package ua.training.chef.model.factory;

import ua.training.chef.model.salad.GreekSalad;
import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.VitaminSalad;

public class SaladFactoryImpl implements SaladFactory{
	
	@Override
	public Salad createSalad(int userSaladSelection) {
		
		switch (userSaladSelection) {
		case 1:			
			return  new GreekSalad();
		case 2:			
			return new VitaminSalad();
		case 3:
			return new PeasantSalad();
		default:
			throw new IllegalArgumentException("Such salad is not served in our salad restaurant");
		}
	}

}
