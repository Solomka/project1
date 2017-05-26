package ua.training.chef.model.salad_factory;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;

public interface SaladFactory {
	Salad createSalad(SaladType saladType);
}
