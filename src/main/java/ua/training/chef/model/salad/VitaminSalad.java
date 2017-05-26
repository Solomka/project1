package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ua.training.chef.model.ingredient.Vegetable;
import ua.training.chef.model.ingredient.VegetableType;

public class VitaminSalad extends Salad {

	public VitaminSalad() {
		super();
	}

	@Override
	protected Map<Vegetable, Double> prepareSaladVegetables() {
		Map<Vegetable, Double> vitaminSaladIngredients = new HashMap<>();

		vitaminSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.CARROT)
				.setSubType("Flaccus carrot").setCalories(65.2).setPrice(new BigDecimal(20)).build(), 50.0);
		vitaminSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
				.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 60.0);
		vitaminSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
				.setSubType("Iceberg lettuce").setCalories(14.8).setPrice(new BigDecimal(80)).build(), 80.0);
		vitaminSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.ONION)
				.setSubType("Leek onion").setCalories(60.9).setPrice(new BigDecimal(100)).build(), 20.0);
		vitaminSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
				.setSubType("Pink tomato").setCalories(17.7).setPrice(new BigDecimal(60)).build(), 80.0);

		return vitaminSaladIngredients;
	}

}
