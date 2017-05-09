package ua.training.chef.model.salad.ingredient;

public class SortableSaladIngredient<T extends Comparable<T>> extends SaladIngredient<T>
		implements Comparable<SortableSaladIngredient<T>> {

	public SortableSaladIngredient(T ingredient, double weight) {
		super(ingredient, weight);
	}

	@Override
	public int compareTo(SortableSaladIngredient<T> o) {
		return getIngredient().compareTo(o.getIngredient());
	}

}
