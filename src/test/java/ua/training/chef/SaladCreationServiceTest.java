package ua.training.chef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad.SpringSalad;
import ua.training.chef.model.salad.VitaminSalad;
import ua.training.chef.service.SaladCreationService;
import ua.training.chef.service.SaladCreationServiceImpl;

public class SaladCreationServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSaladIllegalArgumentException() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();
		saladCreationService.createSalad(SaladType.getSaladTypeByValue(12));
	}

	@Test
	public void testCreateSaladSpringSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		SpringSalad expectedSalad = new SpringSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladCreationService.createSalad(SaladType.getSaladTypeByValue(1));

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladVitaminSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		VitaminSalad expectedSalad = new VitaminSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladCreationService.createSalad(SaladType.getSaladTypeByValue(2));

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladPeasantSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		PeasantSalad expectedSalad = new PeasantSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladCreationService.createSalad(SaladType.getSaladTypeByValue(3));

		assertEquals(expectedSalad, actualSalad);

	}

}
