package ua.training.chef.service;

import java.util.Map;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.vegetable.Vegetable;

public interface SaladCreationService {

	Salad createSalad(int userSaladSelection);

	Map<Vegetable, Double> findVegetablesInCaloricRange(Salad salad, double minCaloricValue, double maxCaloricValue);

}
