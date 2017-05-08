package ua.training.chef.model.salad;

public class SaladIngredient<T> {

	private T ingredient;
	private double quantity;

	public SaladIngredient(T ingredient, double quantity) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	public T getIngredient() {
		return ingredient;
	}

	public void setIngredient(T ingredient) {
		this.ingredient = ingredient;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
