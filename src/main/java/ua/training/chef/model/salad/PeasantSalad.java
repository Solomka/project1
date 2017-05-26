package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ua.training.chef.model.ingredient.Vegetable;
import ua.training.chef.model.ingredient.VegetableType;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	protected Map<Vegetable, Double> prepareSaladVegetables() {
		Map<Vegetable, Double> peasantSaladIngredients = new HashMap<>();

		peasantSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.RADISH)
				.setSubType("Red radish").setCalories(15.8).setPrice(new BigDecimal(60)).build(), 100.0);
		peasantSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
				.setSubType("Seed lettuce").setCalories(14).setPrice(new BigDecimal(75)).build(), 60.0);
		peasantSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.ONION)
				.setSubType("White onion").setCalories(65).setPrice(new BigDecimal(10)).build(), 25.0);
		peasantSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
				.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 50.0);
		peasantSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
				.setSubType("Red tomato").setCalories(17).setPrice(new BigDecimal(55)).build(), 50.0);

		return peasantSaladIngredients;
	}

}
