package ua.training.chef.model.salad_factory;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad.SpringSalad;
import ua.training.chef.model.salad.VitaminSalad;
import ua.training.chef.view.ViewMessage;

public class SaladFactoryImpl implements SaladFactory {

	@Override
	public Salad createSalad(SaladType saladType) {

		Salad salad;

		switch (saladType) {
		case SPRING_SALAD:
			salad = new SpringSalad();
			break;
		case VITAMIN_SALAD:
			salad = new VitaminSalad();
			break;
		case PEASANT_SALAD:
			salad = new PeasantSalad();
			break;
		default:
			throw new IllegalArgumentException(ViewMessage.SALAD_FACTORY_ERROR_MSG);
		}
		salad.prepareSaladVegetables();

		return salad;
	}

}
