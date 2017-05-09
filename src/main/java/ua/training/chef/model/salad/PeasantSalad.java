package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.SourCream;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Onion;
import ua.training.chef.model.vegetable.Radish;
import ua.training.chef.model.vegetable.Vegetable;

public class PeasantSalad extends Salad {

	public PeasantSalad() {
		super();
	}

	@Override
	protected Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
		Set<SortableSaladIngredient<Vegetable>> peasantSaladIngredients = new HashSet<>();

		peasantSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Radish("Red radish", 15.8, new BigDecimal(15)), 45));
		peasantSaladIngredients.add(
				new SortableSaladIngredient<Vegetable>(new Lettuce("Iceberg lettuce", 14.8, new BigDecimal(20)), 180));
		peasantSaladIngredients
				.add(new SortableSaladIngredient<Vegetable>(new Onion("White onion", 65, new BigDecimal(10)), 25));

		return peasantSaladIngredients;
	}

	@Override
	Set<SaladIngredient<Dressing>> prepareSaladDressings() {
		Set<SaladIngredient<Dressing>> peasantSaladDressings = new HashSet<SaladIngredient<Dressing>>();

		peasantSaladDressings.add(
				new SaladIngredient<Dressing>(new SourCream("Clotted sour cream", 192.4, new BigDecimal(30), 20), 60));

		return peasantSaladDressings;
	}

}
