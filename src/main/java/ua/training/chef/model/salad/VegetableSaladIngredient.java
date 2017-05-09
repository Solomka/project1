package ua.training.chef.model.salad;

import ua.training.chef.model.vegetable.Vegetable;

public class VegetableSaladIngredient implements Comparable<VegetableSaladIngredient> {

	private Vegetable ingredient;
	private double weight;

	public VegetableSaladIngredient(Vegetable ingredient, double weight) {

		this.ingredient = ingredient;
		this.weight = weight;
	}

	public Vegetable getIngredient() {
		return ingredient;
	}

	public void setIngredient(Vegetable ingredient) {
		this.ingredient = ingredient;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(VegetableSaladIngredient vegetableSaladIngredient) {
		return getIngredient().compareTo(vegetableSaladIngredient.getIngredient());
	}

	@Override
	public String toString() {
		return "VegetableSaladIngredient [\ningredient=" + ingredient + ", \nweight=" + weight + "]";
	}
	
	

}
