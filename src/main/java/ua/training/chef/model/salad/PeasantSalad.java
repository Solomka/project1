package ua.training.chef.model.salad;

import java.util.Map;
import java.util.TreeMap;

import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Radish;
import ua.training.chef.model.vegetable.Vegetable;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Map<Vegetable, Double> prepareSaladVegetables() {
		Map<Vegetable, Double> greekSaladIngredients = new TreeMap<>();
		greekSaladIngredients.put(new Radish("Red radish", 19), 7.0);
		greekSaladIngredients.put(new Lettuce("Ordinar lettuce", 34), 2.0);
		greekSaladIngredients.put(new Onion("White onion", 67), 1.0);	
		return greekSaladIngredients;
	}

}
