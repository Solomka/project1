package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.SourCream;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Radish;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	public Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> peasantSaladIngredients = new HashSet<>();

		peasantSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Radish("Red radish", 15.8, new BigDecimal(60)), 100));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Lettuce("Seed lettuce", 14, new BigDecimal(75)), 60));
		peasantSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Onion("White onion", 65, new BigDecimal(10)), 25));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Cucumber("Ordinar cucumber", 15.5, new BigDecimal(30)), 50));
		peasantSaladIngredients
		.add(new SortableSaladIngredient<Vegetable>(new Tomato("Red tomato", 17, new BigDecimal(55)), 50));

		return peasantSaladIngredients;
	}

	@Override
	public Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> peasantSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		peasantSaladDressings.add(
				new SaladIngredient<Dressing>(new SourCream("Clotted sour cream", 192.4, new BigDecimal(30), 20), 40));

		return peasantSaladDressings;
	}

}
