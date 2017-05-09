package ua.training.chef.model.salad;

import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Radish;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	protected Set<VegetableSaladIngredient> prepareSaladVegetables() {
		Set<VegetableSaladIngredient> greekSaladIngredients = new HashSet<>();

		greekSaladIngredients.add(new VegetableSaladIngredient(new Radish("Red radish", 15.8, 15.5), 30));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Lettuce("Iceberg lettuce", 14.8, 17), 120));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Onion("White onion", 65, 9.5), 25));

		return greekSaladIngredients;
	}

}
