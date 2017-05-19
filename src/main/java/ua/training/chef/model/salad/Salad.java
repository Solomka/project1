package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.model.salad.ingredient.Dressing;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.salad.ingredient.Vegetable;

public abstract class Salad {

	private Set<SortableSaladIngredient<Vegetable>> vegetables;
	private Set<SaladIngredient<Dressing>> dressings;

	public Salad() {
		this.vegetables = prepareSaladVegetables();
		this.dressings = prepareSaladDressings();
	}

	protected abstract Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables();

	protected abstract Set<SaladIngredient<Dressing>> prepareSaladDressings();

	public Set<SortableSaladIngredient<Vegetable>> getVegetables() {
		return vegetables;
	}

	public Set<SortableSaladIngredient<Vegetable>> getSortedSaladVegetables() {
		return new TreeSet<>(vegetables);
	}

	public Set<SortableSaladIngredient<Vegetable>> getVegetablesInCaloriesRange(double minCaloriesValue,
			double maxCaloriesValue) {
		Set<SortableSaladIngredient<Vegetable>> vegetablesInCaloriesRange = new HashSet<>();

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			if (vegetable.getIngredient().getCalories() >= minCaloriesValue
					&& vegetable.getIngredient().getCalories() <= maxCaloriesValue) {
				vegetablesInCaloriesRange.add(vegetable);
			}
		}
		return vegetablesInCaloriesRange;
	}

	public Set<SaladIngredient<Dressing>> getDressings() {
		return dressings;
	}

	public double getSaladCalories() {
		double generalSaladCalories = 0.0;

		generalSaladCalories += getGeneralVegetablesCalories();
		generalSaladCalories += getGeneralDressingsCalories();

		return Math.floor(generalSaladCalories * GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT)
				/ GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT;
	}

	private double getGeneralVegetablesCalories() {
		double vegetablesCalories = 0.0;

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			vegetablesCalories += (vegetable.getIngredient().getCalories() * vegetable.getWeight())
					/ GlobalConstants.CALORIC_VALUE_GRAM_MEASURE;
		}

		return vegetablesCalories;
	}

	private double getGeneralDressingsCalories() {
		double dressingsCalories = 0.0;

		for (SaladIngredient<Dressing> dressing : dressings) {
			dressingsCalories += (dressing.getIngredient().getCalories() * dressing.getWeight())
					/ GlobalConstants.CALORIC_VALUE_MILLILITER_MEASURE;
		}

		return dressingsCalories;
	}

	public BigDecimal getSaladPrice() {
		BigDecimal generalSaladPrice = BigDecimal.ZERO;

		generalSaladPrice = generalSaladPrice.add(getGeneralVegetablesPrice()).add(getGeneralDressingsPrice());
		BigDecimal restaurantExtra = generalSaladPrice.multiply(GlobalConstants.SALAD_EXTRA_PRICE,
				MathContext.DECIMAL64);
		generalSaladPrice = generalSaladPrice.add(restaurantExtra);

		return generalSaladPrice;
	}

	private BigDecimal getGeneralVegetablesPrice() {
		BigDecimal vegetablesPrice = BigDecimal.ZERO;

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			vegetablesPrice = vegetablesPrice.add((vegetable.getIngredient().getPrice()
					.multiply(new BigDecimal(vegetable.getWeight()), MathContext.DECIMAL64))
							.divide(new BigDecimal(GlobalConstants.PRICE_GRAM_MEASURE), MathContext.DECIMAL64));
		}
		return vegetablesPrice;
	}

	private BigDecimal getGeneralDressingsPrice() {
		BigDecimal dressingsPrice = BigDecimal.ZERO;

		for (SaladIngredient<Dressing> dreesing : dressings) {
			dressingsPrice = dressingsPrice.add((dreesing.getIngredient().getPrice()
					.multiply(new BigDecimal(dreesing.getWeight()), MathContext.DECIMAL64))
							.divide(new BigDecimal(GlobalConstants.PRICE_MILLILITER_MEASURE), MathContext.DECIMAL64));
		}
		return dressingsPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dressings == null) ? 0 : dressings.hashCode());
		result = prime * result + ((vegetables == null) ? 0 : vegetables.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salad other = (Salad) obj;
		if (dressings == null) {
			if (other.dressings != null)
				return false;
		} else if (!dressings.equals(other.dressings))
			return false;
		if (vegetables == null) {
			if (other.vegetables != null)
				return false;
		} else if (!vegetables.equals(other.vegetables))
			return false;
		return true;
	}
}
