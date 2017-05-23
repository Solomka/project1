package ua.training.chef.model.saladfactory;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;

public interface SaladFactory {
	Salad createSalad(SaladType saladType);
}
