package ua.training.chef.model.salad;

import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Pepper;
import ua.training.chef.model.vegetable.Tomato;

public class GreekSalad extends Salad {

	public GreekSalad() {
		super();

	}

	@Override
	protected Set<VegetableSaladIngredient> prepareSaladVegetables() {
		Set<VegetableSaladIngredient> greekSaladIngredients = new HashSet<>();

		greekSaladIngredients.add(new VegetableSaladIngredient(new Cucumber("Ordinar cucumber", 15.5, 10), 70));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Tomato("Cherry tomatoes", 18, 30), 85));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Olive("Black olive", 115, 80), 100));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Pepper("Green bell pepper", 20.1, 25), 45));

		return greekSaladIngredients;
	}
}
