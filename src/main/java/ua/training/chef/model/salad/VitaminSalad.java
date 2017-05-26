package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.vegetable.Carrot;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.characteristic.CarrotSize;
import ua.training.chef.model.vegetable.characteristic.CucumberType;
import ua.training.chef.model.vegetable.characteristic.OnionType;
import ua.training.chef.model.vegetable.characteristic.TomatoType;

public class VitaminSalad extends Salad {

	public VitaminSalad() {
		super();
	}

	@Override
	protected void addSaladVegetables() {
		List<SaladIngredient> vitaminSaladVegetables = new ArrayList<>();

		vitaminSaladVegetables.add(new SaladIngredient(new Carrot(65.2, new BigDecimal(20), CarrotSize.ORDINAR), 50.0));
		vitaminSaladVegetables
				.add(new SaladIngredient(new Cucumber(15.5, new BigDecimal(30), CucumberType.ORDINAR), 60.0));
		vitaminSaladVegetables.add(new SaladIngredient(new Lettuce(14.8, new BigDecimal(80)), 80.0));
		vitaminSaladVegetables.add(new SaladIngredient(new Onion(60.9, new BigDecimal(100), OnionType.LEEK), 20.0));
		vitaminSaladVegetables.add(new SaladIngredient(new Tomato(17.7, new BigDecimal(60), TomatoType.CHERRY), 80.0));

		vegetables = vitaminSaladVegetables;
	}

}
