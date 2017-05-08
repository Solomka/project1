package ua.training.chef.model.salad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ua.training.chef.model.vegetable.Vegetable;
import ua.training.chef.model.vegetable.VegetableConstant;

public abstract class Salad {

	private Set<SaladIngredient<Vegetable>> vegetables;

	public Salad() {
		this.vegetables = prepareSaladVegetables();
	}

	abstract protected Set<SaladIngredient<Vegetable>> prepareSaladVegetables();

	public List<SaladIngredient<Vegetable>> getSortedSaladVegetables() {

		List<SaladIngredient<Vegetable>> vegetablesList = new ArrayList<>(vegetables);
		Collections.sort(vegetablesList);

		return vegetablesList;
	}

	public double getSaladCaloric() {
		double generalSaladCaloric = 0.0;

		for (SaladIngredient<Vegetable> vegetable : vegetables) {
			generalSaladCaloric += (vegetable.getIngredient().getCaloric() * vegetable.getWeight())
					/ VegetableConstant.VEG_CALORIC_VALUE_PRICE_GRAM_MEASURE;
		}
		return generalSaladCaloric;
	}

	public List<Vegetable> getVegetablesInCaloricRange(double minCaloricValue, double maxCaloricValue) {
		List<Vegetable> vegetablesList = new ArrayList<>();

		for (SaladIngredient<Vegetable> vegetable : vegetables) {
			if (vegetable.getIngredient().getCaloric() >= minCaloricValue
					&& vegetable.getIngredient().getCaloric() <= maxCaloricValue) {
				vegetablesList.add(vegetable.getIngredient());
			}
		}
		return vegetablesList;
	}
}
