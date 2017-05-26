package ua.training.chef;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import ua.training.chef.model.ingredient.Vegetable;
import ua.training.chef.model.ingredient.VegetableType;
import ua.training.chef.model.salad.Salad;

public class SaladTest {

	private static final TestingSaladSubclass TEST_SALAD_SUBCLASS = new TestingSaladSubclass();

	@Test
	public void testGetSortedSaladVegetables() {
		Salad salad = new TestingSaladSubclass();

		Map<Vegetable, Double> expectedSaladVegetables = TEST_SALAD_SUBCLASS.getSortedSaladVegetables();
		Map<Vegetable, Double> actualSaladVegetables = salad.getSortedSaladVegetables();

		assertEquals(expectedSaladVegetables, actualSaladVegetables);
	}

	@Test
	public void testGetVegetablesInCaloriesRange() {
		Salad salad = new TestingSaladSubclass();

		double minCaloriesValue = 14.7;
		double maxCaloriesValue = 17.99;

		Map<Vegetable, Double> saladVegetables = salad.getVegetablesInCaloriesRange(minCaloriesValue, maxCaloriesValue);

		boolean expected = true;
		boolean actual = isVegetablesInRange(saladVegetables, minCaloriesValue, maxCaloriesValue);

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSaladCalories() {
		Salad salad = new TestingSaladSubclass();

		Double expected = TEST_SALAD_SUBCLASS.getSaladCalories();
		Double actual = salad.getSaladCalories();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSaladPrice() {
		Salad salad = new TestingSaladSubclass();

		BigDecimal expected = TEST_SALAD_SUBCLASS.getSaladPrice();
		BigDecimal actual = salad.getSaladPrice();

		assertEquals(expected, actual);
	}

	private boolean isVegetablesInRange(Map<Vegetable, Double> saladVegetables, double minCaloriesValue,
			double maxCaloriesValue) {
		boolean isInRange = true;

		for (Vegetable saladVegetable : saladVegetables.keySet()) {
			if (saladVegetable.getCalories() >= minCaloriesValue && saladVegetable.getCalories() <= maxCaloriesValue) {
			} else {
				isInRange = false;
				break;
			}
		}

		return isInRange;
	}

	private static class TestingSaladSubclass extends Salad {

		@Override
		protected Map<Vegetable, Double> prepareSaladVegetables() {
			Map<Vegetable, Double> testSaladIngredients = new HashMap<>();

			testSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
					.setSubType("Cherry tomato").setCalories(18).setPrice(new BigDecimal(80)).build(), 85.0);
			testSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE)
					.setSubType("Black olive").setCalories(115).setPrice(new BigDecimal(180)).build(), 40.0);
			testSaladIngredients.put(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
					.setSubType("Iceberg lettuce").setCalories(14.8).setPrice(new BigDecimal(80)).build(), 80.0);

			return testSaladIngredients;
		}

		@Override
		public Map<Vegetable, Double> getSortedSaladVegetables() {
			Map<Vegetable, Double> sortedVegetables = new LinkedHashMap<>();

			sortedVegetables.put(new Vegetable.VegetableBuilder().setType(VegetableType.LETTUCE)
					.setSubType("Iceberg lettuce").setCalories(14.8).setPrice(new BigDecimal(80)).build(), 80.0);
			sortedVegetables.put(new Vegetable.VegetableBuilder().setType(VegetableType.TOMATO)
					.setSubType("Cherry tomato").setCalories(18).setPrice(new BigDecimal(80)).build(), 85.0);
			sortedVegetables.put(new Vegetable.VegetableBuilder().setType(VegetableType.OLIVE).setSubType("Black olive")
					.setCalories(115).setPrice(new BigDecimal(180)).build(), 40.0);

			return sortedVegetables;
		}

		@Override
		public BigDecimal getSaladPrice() {
			return new BigDecimal("50.70");
		}

		@Override
		public double getSaladCalories() {
			return 338.35;
		}
	}
}
