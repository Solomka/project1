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

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> peasantSaladIngredients = new HashSet<>();

		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.RADISH)
						.setSubType("Red radish").setCalories(15.8).setPrice(new BigDecimal(60)).build(), 100));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
						.setSubType("Seed lettuce").setCalories(14).setPrice(new BigDecimal(75)).build(), 60));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.ONION)
						.setSubType("White onion").setCalories(65).setPrice(new BigDecimal(10)).build(), 25));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.CUCUMBER)
						.setSubType("Ordinar cucumber").setCalories(15.5).setPrice(new BigDecimal(30)).build(), 50));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
						.setSubType("Red tomato").setCalories(17).setPrice(new BigDecimal(55)).build(), 50));

		return peasantSaladIngredients;
	}

	@Override
	protected Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> peasantSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		peasantSaladDressings
				.add(new SaladIngredient<Dressing>(new Dressing.DressingBuilder().setType(DressingType.SOURCREAM)
						.setSubType("Clotted sour cream").setCalories(192.4).setPrice(new BigDecimal(30)).build(), 40));

		return peasantSaladDressings;
	}

}
