package ua.training.chef.model.salad;

import java.util.Map;
import java.util.TreeMap;

import ua.training.chef.model.vegetable.Carrot;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Vegetable;

public class VitaminSalad extends Salad{

	public VitaminSalad() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Map<Vegetable, Double> prepareSaladIngredients() {
		Map<Vegetable, Double> greekSaladIngredients = new TreeMap<>();
		greekSaladIngredients.put(new Carrot("Ordinar carrot", 52), 2.0);
		greekSaladIngredients.put(new Cucumber("Ordinar cucumber", 16), 2.0);
		greekSaladIngredients.put(new Lettuce("Ordinar lettuce", 34), 2.0);
		greekSaladIngredients.put(new Onion("White onion", 67), 0.5);		
		return greekSaladIngredients;
	}

}
