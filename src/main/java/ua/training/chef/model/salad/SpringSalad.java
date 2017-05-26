package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ua.training.chef.model.ingredient.Vegetable;
import ua.training.chef.model.ingredient.VegetableType;

public class SpringSalad extends Salad {

	public SpringSalad() {
		super();
	}

	@Override
	protected Map<Vegetable, Double> prepareSaladVegetables() {
		Map<Vegetable, Double> greekSaladIngredients = new HashMap<>();

		greekSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
				.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 50.0);
		greekSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
				.setSubType("Cherry tomato").setCalories(18).setPrice(new BigDecimal(80)).build(), 85.0);
		greekSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE)
				.setSubType("Black olive").setCalories(115).setPrice(new BigDecimal(180)).build(), 40.0);
		greekSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.PEPPER)
				.setSubType("Green Bell pepper").setCalories(20.1).setPrice(new BigDecimal(80)).build(), 50.0);
		greekSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE).setSubType("Leek onion")
				.setCalories(60.9).setPrice(new BigDecimal(100)).build(), 15.0);

		return greekSaladIngredients;
	}

}
