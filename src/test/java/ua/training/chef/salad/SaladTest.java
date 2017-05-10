package ua.training.chef.salad;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ua.training.chef.constants.IngredientConstant;
import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Vegetable;

public class SaladTest {
	
	@Test
	public void testGetSortedSaladVegetables(){
		Salad salad = new TestingSaladSubclass();
		
		Set<SortableSaladIngredient<Vegetable>> expectedSaladVegetables = new TreeSet<>(salad.getVegetables());
		Set<SortableSaladIngredient<Vegetable>> actualSaladVegetables = salad.getSortedSaladVegetables();
		
		assertEquals(expectedSaladVegetables, actualSaladVegetables);		
	}

	@Test
	public void testGetVegetablesInCaloriesRange() {
		Salad salad = new TestingSaladSubclass();

		double minCaloriesValue = 14.7;
		double maxCaloriesValue = 17.99;

		Set<SortableSaladIngredient<Vegetable>> saladVegetables = salad.getVegetablesInCaloriesRange(minCaloriesValue,
				maxCaloriesValue);

		boolean expected = true;
		boolean actual = isVegetablesInRange(saladVegetables, minCaloriesValue, maxCaloriesValue);

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSaladCalories() {
		Salad salad = new TestingSaladSubclass();

		Double expected = getGeneralSaladCalories(salad);
		Double actual = salad.getSaladCalories();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSaladPrice() {
		Salad salad = new TestingSaladSubclass();

		BigDecimal expected = getGeneralSaladPrice(salad);
		BigDecimal actual = salad.getSaladPrice();

		assertEquals(expected, actual);
	}

	private boolean isVegetablesInRange(Set<SortableSaladIngredient<Vegetable>> saladVegetables,
			double minCaloriesValue, double maxCaloriesValue) {
		boolean isInRange = true;

		for (SortableSaladIngredient<Vegetable> saladVegetable : saladVegetables) {
			if (saladVegetable.getIngredient().getCalories() >= minCaloriesValue
					&& saladVegetable.getIngredient().getCalories() <= maxCaloriesValue) {
			} else {
				isInRange = false;
				break;
			}
		}

		return isInRange;
	}

	private double getGeneralSaladCalories(Salad salad) {

		double saladCalories = 0.0;

		for (SortableSaladIngredient<Vegetable> vegetable : salad.getVegetables()) {
			saladCalories += (vegetable.getIngredient().getCalories() * vegetable.getWeight())
					/ IngredientConstant.CALORIC_VALUE_GRAM_MEASURE;
		}

		for (SaladIngredient<Dressing> dressing : salad.getDressings()) {
			saladCalories += (dressing.getIngredient().getCalories() * dressing.getWeight())
					/ IngredientConstant.CALORIC_VALUE_MILLILITER_MEASURE;
		}

		return Math.floor(saladCalories * 100) / 100;

	}

	private BigDecimal getGeneralSaladPrice(Salad salad) {

		BigDecimal saladPrice = BigDecimal.ZERO;

		for (SortableSaladIngredient<Vegetable> vegetable : salad.getVegetables()) {
			saladPrice = saladPrice.add((vegetable.getIngredient().getPrice()
					.multiply(new BigDecimal(vegetable.getWeight()), MathContext.DECIMAL64))
							.divide(new BigDecimal(IngredientConstant.PRICE_GRAM_MEASURE), MathContext.DECIMAL64));
		}

		for (SaladIngredient<Dressing> dreesing : salad.getDressings()) {
			saladPrice = saladPrice.add((dreesing.getIngredient().getPrice()
					.multiply(new BigDecimal(dreesing.getWeight()), MathContext.DECIMAL64)).divide(
							new BigDecimal(IngredientConstant.PRICE_MILLILITER_MEASURE), MathContext.DECIMAL64));
		}

		saladPrice = saladPrice.add(saladPrice.multiply(IngredientConstant.SALAD_EXTRA_PRICE, MathContext.DECIMAL64));

		return saladPrice;

	}

}
