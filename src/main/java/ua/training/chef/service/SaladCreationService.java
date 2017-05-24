package ua.training.chef.service;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;

public interface SaladCreationService {
	Salad createSalad(SaladType saladType);
}
