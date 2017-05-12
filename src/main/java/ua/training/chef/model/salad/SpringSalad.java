package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.Oil;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Pepper;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

public class SpringSalad extends Salad {

	public SpringSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> greekSaladIngredients = new HashSet<SortableSaladIngredient<Vegetable>>();

		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Cucumber("Ordinar cucumber", 15.5, new BigDecimal(30)), 50));
		greekSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Tomato("Cherry tomato", 18, new BigDecimal(80)), 85));
		greekSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Olive("Black olive", 115, new BigDecimal(180)), 40));
		greekSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Pepper("Green Bell pepper", 20.1, new BigDecimal(80)), 50));
		greekSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Onion("Leek onion", 60.9, new BigDecimal(100)), 15));

		return greekSaladIngredients;
	}

	@Override
	protected Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> greekSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		greekSaladDressings.add(new SaladIngredient<Dressing>(new Oil("Olive oil", 884, new BigDecimal(230)), 30));

		return greekSaladDressings;
	}

}
