package ua.training.chef.model.factory;

import ua.training.chef.model.salad.Salad;

public interface SaladFactory {
	Salad createSalad(int userSaladSelection);
}
