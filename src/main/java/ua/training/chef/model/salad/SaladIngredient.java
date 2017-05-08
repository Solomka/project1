package ua.training.chef.model.salad;

public class SaladIngredient<T extends Comparable<T>> implements Comparable<SaladIngredient<T>> {

	private T ingredient;
	private double weight;

	public SaladIngredient(T ingredient, double quantity) {
	
		this.ingredient = ingredient;
		this.weight = quantity;
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
	public int compareTo(SaladIngredient<T> o) {
		return ingredient.compareTo(o.getIngredient());
	}

}
