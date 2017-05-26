package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Pepper;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.characteristic.Color;
import ua.training.chef.model.vegetable.characteristic.CucumberType;
import ua.training.chef.model.vegetable.characteristic.OnionType;
import ua.training.chef.model.vegetable.characteristic.TomatoType;

public class SpringSalad extends Salad {

	public SpringSalad() {
		super();
	}

	@Override
	protected void addSaladVegetables() {
		List<SaladIngredient> greekSaladVegetables = new ArrayList<>();

		greekSaladVegetables
				.add(new SaladIngredient(new Cucumber(15.5, new BigDecimal(30), CucumberType.ORDINAR), 50.0));
		greekSaladVegetables.add(new SaladIngredient(new Tomato(18, new BigDecimal(80), TomatoType.CHERRY), 85.0));
		greekSaladVegetables.add(new SaladIngredient(new Olive(115, new BigDecimal(180), Color.BLACK), 40.0));
		greekSaladVegetables.add(new SaladIngredient(new Pepper(20.1, new BigDecimal(80), Color.GREEN), 50.0));
		greekSaladVegetables.add(new SaladIngredient(new Onion(60.9, new BigDecimal(100), OnionType.LEEK), 15.0));

		vegetables = greekSaladVegetables;
	}

}
