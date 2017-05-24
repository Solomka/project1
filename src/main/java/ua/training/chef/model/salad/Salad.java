package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.model.ingredients.Vegetable;

public abstract class Salad {

	protected Map<Vegetable, Double> vegetables = new HashMap<>();

	public Salad() {
		vegetables = prepareSaladVegetables();
	}

	protected abstract Map<Vegetable, Double> prepareSaladVegetables();

	public Map<Vegetable, Double> getVegetables() {
		return vegetables;
	}

	public Map<Vegetable, Double> getSortedSaladVegetables() {
		return new TreeMap<>(vegetables);
	}

	public Map<Vegetable, Double> getVegetablesInCaloriesRange(double minCaloriesValue, double maxCaloriesValue) {
		Map<Vegetable, Double> vegetablesInCaloriesRange = new HashMap<>();

		for (Vegetable vegetable : vegetables.keySet()) {
			if (vegetable.getCalories() >= minCaloriesValue && vegetable.getCalories() <= maxCaloriesValue) {
				vegetablesInCaloriesRange.put(vegetable, vegetables.get(vegetable));
			}
		}

		return vegetablesInCaloriesRange;
	}

	public double getSaladCalories() {
		double generalSaladCalories = 0.0;

		for (Vegetable vegetable : vegetables.keySet()) {
			generalSaladCalories += vegetable.calculateCaloriesPerWeight(vegetables.get(vegetable));
		}

		return Math.floor(generalSaladCalories * GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT)
				/ GlobalConstants.TWO_DIGITS_AFTER_DECIMAL_POINT;
	}

	public BigDecimal getSaladPrice() {
		BigDecimal generalSaladPrice = BigDecimal.ZERO;

		for (Vegetable vegetable : vegetables.keySet()) {
			generalSaladPrice = generalSaladPrice.add(vegetable.calculatePricePerWeight(vegetables.get(vegetable)));
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
