package ua.training.chef.model.salad;

import java.util.Map;
import java.util.TreeMap;

import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Pepper;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

public class GreekSalad extends Salad {

	public GreekSalad() {
		super();

	}

	@Override
	protected Map<Vegetable, Double> prepareSaladVegetables() {
		Map<Vegetable, Double> greekSaladIngredients = new TreeMap<>();
		
		greekSaladIngredients.put(new Tomato("Cherry tomato", 32), 5.0);
		greekSaladIngredients.put(new Pepper("Green pepper", 30), 2.0);
		greekSaladIngredients.put(new Olive("Green olive", 117), 100.0);
		greekSaladIngredients.put(new Cucumber("Ordinar cucumber", 16), 2.0);
		
		return greekSaladIngredients;
	}

}
