package ua.training.chef.model.vegetable;

import java.math.BigDecimal;
import java.math.MathContext;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.model.vegetable.characteristic.VegetableType;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public abstract class Vegetable implements Comparable<Vegetable> {

	private double calories;
	private BigDecimal price;

	public Vegetable(double calories, BigDecimal price) {
		this.calories = calories;
		this.price = price;
	}

	public abstract void prepareForSalad();

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double calculateCaloriesPerWeight(double weight) {

		return (getCalories() * weight) / GlobalConstants.CALORIC_VALUE_GRAM_MEASURE;
	}

	public BigDecimal calculatePricePerWeight(double weight) {
		BigDecimal pricePerWeight = BigDecimal.ZERO;

		pricePerWeight = pricePerWeight.add(getPrice().multiply(new BigDecimal(weight), MathContext.DECIMAL64))
				.divide(new BigDecimal(GlobalConstants.PRICE_GRAM_MEASURE), MathContext.DECIMAL64);

		return pricePerWeight;
	}

	@Override
	public int compareTo(Vegetable another) {
		if (calories == another.calories) {
			return 0;
		}
		return (calories > another.calories) ? 1 : -1;
	}

	/*
	 * price is not included in hashCode/equals calculation 'cause it's
	 * frequently changeable parameter
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Vegetable other = (Vegetable) obj;
		if (Double.doubleToLongBits(calories) != Double.doubleToLongBits(other.calories))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return new StringBuilder(ViewMessage.getLocaleVegetableName(VegetableType.getVegetableTypeByValue(getClass().getSimpleName())))
				.append(ViewMessageUtils.EQUALITY_SIGN).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.CALORIES)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getCalories()).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.CALORIC_VALUE_GRAM_MEASURE))
				.append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.PRICE)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getPrice()).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.PRICE_GRAM_MEASURE)).toString();
	}

}
