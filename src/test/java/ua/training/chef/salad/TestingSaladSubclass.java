package ua.training.chef.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.Oil;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

 class TestingSaladSubclass extends Salad {

	@Override
	public Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> testSaladIngredients = new HashSet<SortableSaladIngredient<Vegetable>>();

		testSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Tomato("Cherry tomato", 18, new BigDecimal(80)), 85));
		testSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Olive("Black olive", 115, new BigDecimal(180)), 40));
		testSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Lettuce("Iceberg lettuce", 14.8, new BigDecimal(80)), 80));

		return testSaladIngredients;
	}

	@Override
	public Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> testSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		testSaladDressings.add(new SaladIngredient<Dressing>(new Oil("Olive oil", 884, new BigDecimal(230)), 15));
		testSaladDressings.add(new SaladIngredient<Dressing>(new Oil("Sunflower oil", 884.1, new BigDecimal(100)), 15));

		return testSaladDressings;
	}
	
}
