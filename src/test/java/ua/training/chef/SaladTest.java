package ua.training.chef;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ua.training.chef.model.dressing.Dressing;
import ua.training.chef.model.dressing.Oil;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.ingredient.SaladIngredient;
import ua.training.chef.model.salad.ingredient.SortableSaladIngredient;
import ua.training.chef.model.vegetable.Lettuce;
import ua.training.chef.model.vegetable.Olive;
import ua.training.chef.model.vegetable.Tomato;
import ua.training.chef.model.vegetable.Vegetable;

public class SaladTest {

	private static final TestingSaladSubclass testingSaladSubclass = new TestingSaladSubclass();

	@Test
	public void testGetSortedSaladVegetables() {
		Salad salad = new TestingSaladSubclass();

		Set<SortableSaladIngredient<Vegetable>> expectedSaladVegetables = testingSaladSubclass
				.getSortedSaladVegetables();
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

		Double expected = testingSaladSubclass.getSaladCalories();
		Double actual = salad.getSaladCalories();
		System.out.println(actual);

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSaladPrice() {
		Salad salad = new TestingSaladSubclass();

		BigDecimal expected = testingSaladSubclass.getSaladPrice();
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

	private static class TestingSaladSubclass extends Salad {

		@Override
		public Set<SortableSaladIngredient<Vegetable>> prepareSaladVegetables() {
			Set<SortableSaladIngredient<Vegetable>> testSaladIngredients = new HashSet<SortableSaladIngredient<Vegetable>>();

			testSaladIngredients.add(
					new SortableSaladIngredient<Vegetable>(new Tomato("Cherry tomato", 18, new BigDecimal(80)), 85));
			testSaladIngredients.add(
					new SortableSaladIngredient<Vegetable>(new Olive("Black olive", 115, new BigDecimal(180)), 40));
			testSaladIngredients.add(new SortableSaladIngredient<Vegetable>(
					new Lettuce("Iceberg lettuce", 14.8, new BigDecimal(80)), 80));

			return testSaladIngredients;
		}

		@Override
		public Set<SaladIngredient<Dressing>> prepareSaladDressings() {
			Set<SaladIngredient<Dressing>> testSaladDressings = new HashSet<SaladIngredient<Dressing>>();

			testSaladDressings.add(new SaladIngredient<Dressing>(new Oil("Olive oil", 884, new BigDecimal(230)), 15));
			testSaladDressings
					.add(new SaladIngredient<Dressing>(new Oil("Sunflower oil", 884.1, new BigDecimal(100)), 15));

			return testSaladDressings;
		}

		@Override
		public Set<SortableSaladIngredient<Vegetable>> getSortedSaladVegetables() {
			Set<SortableSaladIngredient<Vegetable>> sortedVegetables = new HashSet<>();

			sortedVegetables.add(new SortableSaladIngredient<Vegetable>(
					new Lettuce("Iceberg lettuce", 14.8, new BigDecimal(80)), 80));
			sortedVegetables.add(
					new SortableSaladIngredient<Vegetable>(new Tomato("Cherry tomato", 18, new BigDecimal(80)), 85));
			sortedVegetables.add(
					new SortableSaladIngredient<Vegetable>(new Olive("Black olive", 115, new BigDecimal(180)), 40));

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
