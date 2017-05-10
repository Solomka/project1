package ua.training.chef.model.salad.ingredient;

import ua.training.chef.view.View;
import ua.training.chef.view.ViewMessage;

public class SaladIngredient<T> {

	private T ingredient;
	private double weight;

	public SaladIngredient(T ingredient, double weight) {

		this.ingredient = ingredient;
		this.weight = weight;
	}

	public T getIngredient() {
		return ingredient;
	}

	public void setIngredient(T ingredient) {
		this.ingredient = ingredient;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaladIngredient<T> other = (SaladIngredient<T>) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder(ViewMessage.LEFT_PARENTHESIS).append(ingredient.toString())
				.append(ViewMessage.VERT_LINA).append(View.BUNDLE.getString(ViewMessage.WEIGHT))
				.append(ViewMessage.COLON).append(getWeight()).append(ViewMessage.EMPTY_STR).append(ViewMessage.MEASURE)
				.append(ViewMessage.EMPTY_STR).append(ViewMessage.RIGHT_PARANTHESIS).toString();
	}

}
