package ua.training.chef.model.salad.ingredient;

import ua.training.chef.model.vegetable.Vegetable;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class SaladIngredient implements Comparable<SaladIngredient> {

	private Vegetable vegetable;
	private double weight;

	public SaladIngredient(Vegetable vegetable, double weight) {

		this.vegetable = vegetable;
		this.weight = weight;
	}

	public Vegetable getVegetable() {
		return vegetable;
	}

	public void setVegetable(Vegetable ingredient) {
		this.vegetable = ingredient;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(SaladIngredient another) {
		return vegetable.compareTo(another.vegetable);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vegetable == null) ? 0 : vegetable.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
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
		SaladIngredient other = (SaladIngredient) obj;
		if (vegetable == null) {
			if (other.vegetable != null)
				return false;
		} else if (!vegetable.equals(other.vegetable))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder(ViewMessageUtils.LEFT_PARENTHESIS).append(vegetable.toString())
				.append(ViewMessageUtils.VERT_LINA).append(ViewLocale.BUNDLE.getString(ViewMessage.WEIGHT))
				.append(ViewMessageUtils.COLON).append(getWeight()).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewMessage.MEASURE).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewMessageUtils.RIGHT_PARANTHESIS).toString();
	}

}
