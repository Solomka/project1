package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.model.salad.ingredient.SaladIngredient;

public abstract class Salad {

	protected List<SaladIngredient> vegetables;

	public Salad() {
		vegetables = new ArrayList<>();

		addSaladVegetables();

	}

	protected abstract void addSaladVegetables();

	public void prepareSaladVegetables() {
		for (SaladIngredient vegetable : vegetables) {
			vegetable.getVegetable().prepareForSalad();
		}
	}

	public List<SaladIngredient> getVegetables() {
		return vegetables;
	}

	public List<SaladIngredient> getSortedSaladVegetables() {

		List<SaladIngredient> sortedList = new ArrayList<>(vegetables);
		Collections.sort(sortedList);

		return sortedList;
	}

	public List<SaladIngredient> getVegetablesInCaloriesRange(double minCaloriesValue, double maxCaloriesValue) {
		List<SaladIngredient> vegetablesInCaloriesRange = new ArrayList<>();

		for (SaladIngredient vegetable : vegetables) {
			if (vegetable.getVegetable().getCalories() >= minCaloriesValue
					&& vegetable.getVegetable().getCalories() <= maxCaloriesValue) {
				vegetablesInCaloriesRange.add(vegetable);
			}
		}

		return vegetablesInCaloriesRange;
	}

	public double getSaladCalories() {
		double generalSaladCalories = 0.0;

		for (SaladIngredient vegetable : vegetables) {
			generalSaladCalories += vegetable.getVegetable().calculateCaloriesPerWeight(vegetable.getWeight());
		}

		return Math.floor(generalSaladCalories * GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT)
				/ GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT;
	}

	public BigDecimal getSaladPrice() {
		BigDecimal generalSaladPrice = BigDecimal.ZERO;

		for (SaladIngredient vegetable : vegetables) {
			generalSaladPrice = generalSaladPrice
					.add(vegetable.getVegetable().calculatePricePerWeight(vegetable.getWeight()));
		}

		BigDecimal restaurantExtra = generalSaladPrice.multiply(GlobalConstants.SALAD_EXTRA_PRICE,
				MathContext.DECIMAL64);

		generalSaladPrice = generalSaladPrice.add(restaurantExtra);

		return generalSaladPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (vegetables == null) {
			if (other.vegetables != null)
				return false;
		} else if (!vegetables.equals(other.vegetables))
			return false;
		return true;
	}

}
