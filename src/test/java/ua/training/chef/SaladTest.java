package ua.training.chef;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.characteristic.Color;
import ua.training.chef.model.vegetable.characteristic.TomatoType;

public class SaladTest {

	private static TestingSaladSubclass TEST_SALAD_SUBCLASS = new TestingSaladSubclass();

	@BeforeClass
	public static void prepareTestVegetables() {
		TEST_SALAD_SUBCLASS.prepareSaladVegetables();
	}

	@Test
	public void testGetSortedSaladVegetables() {
		Salad salad = new TestingSaladSubclass();

		List<SaladIngredient> expectedSaladVegetables = TEST_SALAD_SUBCLASS.getSortedSaladVegetables();
		List<SaladIngredient> actualSaladVegetables = salad.getSortedSaladVegetables();

		assertEquals(expectedSaladVegetables, actualSaladVegetables);
	}

	@Test
	public void testGetVegetablesInCaloriesRange() {
		Salad salad = new TestingSaladSubclass();

		double minCaloriesValue = 14.7;
		double maxCaloriesValue = 17.99;

		List<SaladIngredient> saladVegetables = salad.getVegetablesInCaloriesRange(minCaloriesValue, maxCaloriesValue);

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

	private boolean isVegetablesInRange(List<SaladIngredient> saladVegetables, double minCaloriesValue,
			double maxCaloriesValue) {
		boolean isInRange = true;

		for (SaladIngredient saladVegetable : saladVegetables) {
			if (saladVegetable.getVegetable().getCalories() >= minCaloriesValue
					&& saladVegetable.getVegetable().getCalories() <= maxCaloriesValue) {
			} else {
				isInRange = false;
				break;
			}
		}

		return isInRange;
	}

	private static class TestingSaladSubclass extends Salad {

		@Override
		protected void addSaladVegetables() {
			List<SaladIngredient> testSaladIngredients = new ArrayList<>();

			testSaladIngredients.add(new SaladIngredient(new Tomato(18, new BigDecimal(80), TomatoType.CHERRY), 85.0));
			testSaladIngredients.add(new SaladIngredient(new Olive(115, new BigDecimal(180), Color.BLACK), 40.0));
			testSaladIngredients.add(new SaladIngredient(new Lettuce(14.8, new BigDecimal(80)), 80.0));

			vegetables = testSaladIngredients;
		}

		@Override
		public List<SaladIngredient> getSortedSaladVegetables() {
			List<SaladIngredient> sortedVegetables = new ArrayList<>();

			sortedVegetables.add(new SaladIngredient(new Lettuce(14.8, new BigDecimal(80)), 80.0));
			sortedVegetables.add(new SaladIngredient(new Tomato(18, new BigDecimal(80), TomatoType.CHERRY), 85.0));
			sortedVegetables.add(new SaladIngredient(new Olive(115, new BigDecimal(180), Color.BLACK), 40.0));

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
