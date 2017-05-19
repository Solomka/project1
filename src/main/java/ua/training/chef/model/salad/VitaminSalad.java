package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.ingredients.Dressing;
import ua.training.chef.model.ingredients.DressingType;
import ua.training.chef.model.ingredients.Vegetable;
import ua.training.chef.model.ingredients.VegetableType;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;

public class VitaminSalad extends Salad {

	public VitaminSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> vitaminSaladIngredients = new HashSet<>();

		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.CARROT)
						.setSubType("Flaccus carrot").setCalories(65.2).setPrice(new BigDecimal(20)).build(), 50));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
						.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 60));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
						.setSubType("Iceberg lettuce").setCalories(14.8).setPrice(new BigDecimal(80)).build(), 80));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.ONION)
						.setSubType("Leek onion").setCalories(60.9).setPrice(new BigDecimal(100)).build(), 20));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
						.setSubType("Pink tomato").setCalories(17.7).setPrice(new BigDecimal(60)).build(), 80));

		return vitaminSaladIngredients;
	}

	@Override
	protected Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> vitaminSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		vitaminSaladDressings.add(new SaladIngredient<Dressing>(new Dressing.DressingBuilder().setType(DressingType.OIL)
				.setSubType("Olive oil").setCalories(884).setPrice(new BigDecimal(230)).build(), 15));
		vitaminSaladDressings.add(new SaladIngredient<Dressing>(new Dressing.DressingBuilder().setType(DressingType.OIL)
				.setSubType("Sunflower oil").setCalories(884.1).setPrice(new BigDecimal(100)).build(), 15));

		return vitaminSaladDressings;
	}
}
