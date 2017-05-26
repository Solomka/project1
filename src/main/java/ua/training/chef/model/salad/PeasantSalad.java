package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Radish;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.characteristic.Color;
import ua.training.chef.model.vegetable.characteristic.CucumberType;
import ua.training.chef.model.vegetable.characteristic.OnionType;
import ua.training.chef.model.vegetable.characteristic.TomatoType;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	protected void addSaladVegetables() {
		List<SaladIngredient> peasantSaladVegetables = new ArrayList<>();

		peasantSaladVegetables.add(new SaladIngredient(new Radish(15.8, new BigDecimal(60), Color.RED), 100.0));
		peasantSaladVegetables.add(new SaladIngredient(new Lettuce(14, new BigDecimal(75)), 60.0));
		peasantSaladVegetables.add(new SaladIngredient(new Onion(65, new BigDecimal(10), OnionType.ORIDNAR), 25.0));
		peasantSaladVegetables
				.add(new SaladIngredient(new Cucumber(15.5, new BigDecimal(30), CucumberType.ORDINAR), 50.0));
		peasantSaladVegetables.add(new SaladIngredient(new Tomato(17, new BigDecimal(55), TomatoType.ORDINAR), 50.0));

		vegetables = peasantSaladVegetables;
	}

}
