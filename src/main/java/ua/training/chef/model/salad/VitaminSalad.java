package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.Oil;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Carrot;
import ua.training.chef.model.vegetable.Cucumber;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

public class VitaminSalad extends Salad {

	public VitaminSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> vitaminSaladIngredients = new HashSet<>();

		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Carrot("Flaccus carrot", 65.2, new BigDecimal(20)), 50));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Cucumber("Ordinar cucumber", 15.5, new BigDecimal(30)), 60));
		vitaminSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Lettuce("Iceberg lettuce", 14.8, new BigDecimal(80)), 80));
		vitaminSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Onion("Leek onion", 60.9, new BigDecimal(100)), 20));
		vitaminSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Tomato("Pink tomato", 17.7, new BigDecimal(60)), 80));

		return vitaminSaladIngredients;
	}

	@Override
	protected Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> vitaminSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		vitaminSaladDressings.add(new SaladIngredient<Dressing>(new Oil("Olive oil", 884, new BigDecimal(230)), 15));
		vitaminSaladDressings
				.add(new SaladIngredient<Dressing>(new Oil("Sunflower oil", 884.1, new BigDecimal(100)), 15));

		return vitaminSaladDressings;
	}
}
