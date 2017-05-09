package ua.training.chef.model.salad;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ua.training.chef.constants.IngredientConstant;
import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Vegetable;

public abstract class Salad {

	private Set<SortableSaladIngredient<Vegetable>> vegetables;
	private Set<SaladIngredient<Dressing>> dressings;

	public Salad() {
		this.vegetables = prepareSaladVegetables();
		this.dressings = prepareSaladDressings();
	}

	abstract Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables();

	abstract Set<SaladIngredient<Dressing>> prepareSaladDressings();
	
	public Set<SortableSaladIngredient<Vegetable>> getVegetables() {
		return vegetables;
	}
	
	public Set<SortableSaladIngredient<Vegetable>> getSortedSaladVegetables() {		
		return new TreeSet<>(vegetables);
	}
	
	public Set<SortableSaladIngredient<Vegetable>> getVegetablesInCaloriesRange(double minCaloriesValue,
			double maxCaloriesValue) {
		Set<SortableSaladIngredient<Vegetable>> vegetablesInCaloriesRange = new HashSet<>();

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			if (vegetable.getIngredient().getCalories() >= minCaloriesValue
					&& vegetable.getIngredient().getCalories() <= maxCaloriesValue) {
				vegetablesInCaloriesRange.add(vegetable);
			}
		}
		return vegetablesInCaloriesRange;
	}

	public Set<SaladIngredient<Dressing>> getDressings() {
		return dressings;
	}	
	
	public double getSaladCalories() {
		double generalSaladCalories = 0.0;
		
		generalSaladCalories += getGeneralVegetablesCalories();
		generalSaladCalories += getGeneralDressingsCalories();		

		return Math.floor(generalSaladCalories * 100) / 100;
	}
	
	private double getGeneralVegetablesCalories(){
		double vegetablesCalories = 0.0;

		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			vegetablesCalories += (vegetable.getIngredient().getCalories() * vegetable.getWeight())
					/ IngredientConstant.CALORIC_VALUE_GRAM_MEASURE;
		}
		
		return vegetablesCalories;		
	}
	
	private double getGeneralDressingsCalories(){
		double dressingsCalories = 0.0;
		
		for (SaladIngredient<Dressing> dressing : dressings) {
			dressingsCalories += (dressing.getIngredient().getCalories() * dressing.getWeight())
					/ IngredientConstant.CALORIC_VALUE_MILLILITER_MEASURE;
		}
		
		return dressingsCalories;		
	}

	public BigDecimal getSaladPrice() {
		BigDecimal generalSaladPrice = BigDecimal.ZERO;		
		
	    generalSaladPrice = generalSaladPrice.add(getGeneralVegetablesPrice()).add(getGeneralDressingsPrice());
	    BigDecimal restaurantExtra = generalSaladPrice.multiply(IngredientConstant.SALAD_EXTRA_PRICE, MathContext.DECIMAL64);
	    generalSaladPrice = generalSaladPrice.add(restaurantExtra);
	
		return generalSaladPrice;
	}
	
	private BigDecimal getGeneralVegetablesPrice(){
		BigDecimal vegetablesPrice = BigDecimal.ZERO;
		
		for (SortableSaladIngredient<Vegetable> vegetable : vegetables) {
			vegetablesPrice = vegetablesPrice.add((vegetable.getIngredient().getPrice()
					.multiply(new BigDecimal(vegetable.getWeight()), MathContext.DECIMAL64))
							.divide(new BigDecimal(IngredientConstant.PRICE_GRAM_MEASURE), MathContext.DECIMAL64));
		}		
		return vegetablesPrice;		
	}
	
	private BigDecimal getGeneralDressingsPrice(){		
		BigDecimal dressingsPrice = BigDecimal.ZERO;
		
		for (SaladIngredient<Dressing> dreesing : dressings) {
			dressingsPrice = dressingsPrice.add((dreesing.getIngredient().getPrice()
					.multiply(new BigDecimal(dreesing.getWeight()), MathContext.DECIMAL64)).divide(
							new BigDecimal(IngredientConstant.PRICE_MILLILITER_MEASURE), MathContext.DECIMAL64));
		}		
		return dressingsPrice;		
	}	
}
