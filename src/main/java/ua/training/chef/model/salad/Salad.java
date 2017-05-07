package ua.training.chef.model.salad;

import java.util.Map;
import java.util.TreeMap;

import ua.training.chef.model.vegetable.Vegetable;

public abstract class Salad {

	private Map<Vegetable, Double> vegetables;

	public Salad() {
		this.vegetables = prepareSaladIngredients();
	}

	abstract protected Map<Vegetable, Double> prepareSaladIngredients();

	public Map<Vegetable, Double> getSortedSaladVegetables() {
		return vegetables;
	}

	public double getSaladCaloric() {
		double generalSaladCaloric = 0.0;

		for (Vegetable vegetable : vegetables.keySet()) {
			generalSaladCaloric += (vegetable.getCaloric() * vegetables.get(vegetable));
		}
		return generalSaladCaloric;
	}

	public Map<Vegetable, Double> getVegetablesInCaloricRange(double minCaloricValue, double maxCaloricValue) {
		Map<Vegetable, Double> vegetablesInCalloricRange = new TreeMap<Vegetable, Double>();
		
		for (Vegetable vegetable : vegetables.keySet()) {
			if (vegetable.getCaloric() >= minCaloricValue && vegetable.getCaloric() <= maxCaloricValue) {
				vegetablesInCalloricRange.put(vegetable, vegetables.get(vegetable));
			}
		}
		return vegetablesInCalloricRange;
	}
}
