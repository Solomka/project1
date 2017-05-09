package ua.training.chef.model.salad;

import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.vegetable.Carrot;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;

public class VitaminSalad extends Salad {

	public VitaminSalad() {
		super();
	}

	@Override
	protected Set<VegetableSaladIngredient> prepareSaladVegetables() {
		Set<VegetableSaladIngredient> greekSaladIngredients = new HashSet<>();		
		
		greekSaladIngredients.add(new VegetableSaladIngredient(new Carrot("Flaccus carrot", 65.2, 20), 100));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Cucumber("Ordinar cucumber", 15.5, 10), 70));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Lettuce("Iceberg lettuce", 14.8, 17), 40));
		greekSaladIngredients.add(new VegetableSaladIngredient(new Onion("Leek onion", 60.9, 9.5), 15));
		
		return greekSaladIngredients;
	}
}
