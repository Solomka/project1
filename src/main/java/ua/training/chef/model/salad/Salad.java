package ua.training.chef.model.salad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ua.training.chef.model.vegetable.Vegetable;
import ua.training.chef.model.vegetable.VegetableConstant;

public abstract class Salad {

	private Set<VegetableSaladIngredient> vegetables;

	public Salad() {
		this.vegetables = prepareSaladVegetables();
	}

	abstract protected Set<VegetableSaladIngredient> prepareSaladVegetables();

	public List<VegetableSaladIngredient> getSortedSaladVegetables() {

		List<VegetableSaladIngredient> vegetablesList = new ArrayList<>(vegetables);
		Collections.sort(vegetablesList);

		return vegetablesList;
	}

	public double getSaladCaloric() {
		double generalSaladCaloric = 0.0;

		for (VegetableSaladIngredient vegetable : vegetables) {
			generalSaladCaloric += (vegetable.getIngredient().getCaloric() * vegetable.getWeight())
					/ VegetableConstant.VEG_CALORIC_VALUE_GRAM_MEASURE;
		}
		return generalSaladCaloric;
	}
	
	public double getSaladPrice(){
		double generalSaladPrice = 0.0;

		for (VegetableSaladIngredient vegetable : vegetables) {
			generalSaladPrice += (vegetable.getIngredient().getPrice() * vegetable.getWeight())
					/ VegetableConstant.VEG_PRICE_GRAM_MEASURE;
		}
		return generalSaladPrice;		
	}

	public List<VegetableSaladIngredient> getVegetablesInCaloricRange(double minCaloricValue, double maxCaloricValue) {
		List<VegetableSaladIngredient> vegetablesList = new ArrayList<>();

		for (VegetableSaladIngredient vegetable : vegetables) {
			if (vegetable.getIngredient().getCaloric() >= minCaloricValue
					&& vegetable.getIngredient().getCaloric() <= maxCaloricValue) {
				vegetablesList.add(vegetable);
			}
		}
		return vegetablesList;
	}

	@Override
	public String toString() {
		return "Salad [\n vegetables=" + vegetables + "]";
	}
	
	
	
}
