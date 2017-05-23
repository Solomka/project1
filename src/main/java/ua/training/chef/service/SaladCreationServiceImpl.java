package ua.training.chef.service;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.saladfactory.SaladFactory;
import ua.training.chef.model.saladfactory.SaladFactoryImpl;

public class SaladCreationServiceImpl implements SaladCreationService {

	private SaladFactory saladFactory;

	public SaladCreationServiceImpl() {
		this.saladFactory = new SaladFactoryImpl();
	}

	public Salad createSalad(SaladType saladType) {
		return saladFactory.createSalad(saladType);
	}

}
