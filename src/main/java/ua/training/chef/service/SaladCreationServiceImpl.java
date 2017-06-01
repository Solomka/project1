package ua.training.chef.service;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad_factory.SaladFactory;
import ua.training.chef.model.salad_factory.SaladFactoryImpl;

public class SaladCreationServiceImpl implements SaladCreationService {

	private SaladFactory saladFactory;

	public SaladCreationServiceImpl() {
		this.saladFactory = SaladFactoryImpl.getSaladFactoryImplInstance();
	}

	public Salad createSalad(SaladType saladType) {
		return saladFactory.createSalad(saladType);
	}

}
