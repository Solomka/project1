package ua.training.chef.model.salad.ingredient;

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
}
