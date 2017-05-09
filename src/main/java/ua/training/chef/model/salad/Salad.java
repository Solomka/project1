package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ua.training.chef.constants.IngredientConstant;
import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Vegetable;

public abstract class Salad {

	private Set<SortableSaladIngredient<Vegetable>> vegetables;
	private Set<SaladIngredient<Dressing>> dressings;

	public Salad() {
		this.vegetables = prepareSaladVegetables();
		this.dressings = prepareSaladDressings();
	}

	abstract Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables();

	abstract Set<SaladIngredient<Dressing>> prepareSaladDressings();

	public List<SortableSaladIngredient<Vegetable>> getSortedSaladVegetables() {

		List<SortableSaladIngredient<Vegetable>> vegetablesList = new ArrayList<>(vegetables);
		Collections.sort(vegetablesList);

		return vegetablesList;
	}

	public double getSaladCaloric() {
		double generalSaladCaloric = 0.0;

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			generalSaladCaloric += (vegetable.getIngredient().getCaloric() * vegetable.getWeight())
					/ IngredientConstant.CALORIC_VALUE_GRAM_MEASURE;
		}

		for (SaladIngredient<Dressing> dressing : dressings) {
			generalSaladCaloric += (dressing.getIngredient().getCaloric() * dressing.getWeight())
					/ IngredientConstant.CALORIC_VALUE_MILLILITER_MEASURE;

		}
		return generalSaladCaloric;
	}

	public BigDecimal getSaladPrice() {

		BigDecimal generalSaladPrice = BigDecimal.ZERO;

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			generalSaladPrice.add((vegetable.getIngredient().getPrice()
					.multiply(new BigDecimal(vegetable.getWeight(), MathContext.DECIMAL64)))
							.divide(new BigDecimal(IngredientConstant.PRICE_GRAM_MEASURE, MathContext.DECIMAL64)));

		}
		
		for (SaladIngredient<Dressing> dreesing : dressings) {
			generalSaladPrice.add((dreesing.getIngredient().getPrice()
					.multiply(new BigDecimal(dreesing.getWeight(), MathContext.DECIMAL64)))
							.divide(new BigDecimal(IngredientConstant.PRICE_MILLILITER_MEASURE, MathContext.DECIMAL64)));

		}
		
		generalSaladPrice.add(generalSaladPrice.multiply(IngredientConstant.SALAD_EXTRA_PRICE));
		
		return generalSaladPrice;
	}

	public List<SortableSaladIngredient<Vegetable>> getVegetablesInCaloricRange(double minCaloricValue,
			double maxCaloricValue) {
		List<SortableSaladIngredient<Vegetable>> vegetablesList = new ArrayList<>();

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			if (vegetable.getIngredient().getCaloric() >= minCaloricValue
					&& vegetable.getIngredient().getCaloric() <= maxCaloricValue) {
				vegetablesList.add(vegetable);
			}
		}
		return vegetablesList;
	}

	@Override
	public String toString() {
		return "Salad [\n vegetables=" + vegetables + "]";
	}
}
