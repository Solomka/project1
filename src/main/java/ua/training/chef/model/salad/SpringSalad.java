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

public class SpringSalad extends Salad {

	public SpringSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> greekSaladIngredients = new HashSet<SortableSaladIngredient<Vegetable>>();

		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
						.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 50));
		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
						.setSubType("Cherry tomato").setCalories(18).setPrice(new BigDecimal(80)).build(), 85));
		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE)
						.setSubType("Black olive").setCalories(115).setPrice(new BigDecimal(180)).build(), 40));
		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.PEPPER)
						.setSubType("Green Bell pepper").setCalories(20.1).setPrice(new BigDecimal(80)).build(), 50));
		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE)
						.setSubType("Leek onion").setCalories(60.9).setPrice(new BigDecimal(100)).build(), 15));

		return greekSaladIngredients;
	}

	@Override
	protected Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> greekSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		greekSaladDressings.add(new SaladIngredient<Dressing>(new Dressing.DressingBuilder().setType(DressingType.OIL)
				.setSubType("Olive oil").setCalories(884).setPrice(new BigDecimal(230)).build(), 30));

		return greekSaladDressings;
	}

}
