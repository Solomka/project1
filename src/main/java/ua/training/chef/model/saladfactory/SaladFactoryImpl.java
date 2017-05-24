package ua.training.chef.model.saladfactory;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad.SpringSalad;
import ua.training.chef.model.salad.VitaminSalad;
import ua.training.chef.view.ViewMessage;

public class SaladFactoryImpl implements SaladFactory {

	@Override
	public Salad createSalad(SaladType saladType) {
		switch (saladType) {
		case SPRING_SALAD:
			return new SpringSalad();
		case VITAMIN_SALAD:
			return new VitaminSalad();
		case PEASANT_SALAD:
			return new PeasantSalad();
		default:
			throw new IllegalArgumentException(ViewMessage.SALAD_FACTORY_ERROR_MSG);

		}
	}

}
