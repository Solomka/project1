package ua.training.chef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SpringSalad;
import ua.training.chef.model.salad.VitaminSalad;
import ua.training.chef.service.SaladCreationService;
import ua.training.chef.service.SaladCreationServiceImpl;

public class SaladCreationServiceImplTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSaladIllegalArgumentException() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();
		saladCreationService.createSalad(12);
	}

	@Test
	public void testCreateSaladSpringSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		SpringSalad expectedSalad = new SpringSalad();
		Salad actualSalad = saladCreationService.createSalad(1);

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladVitaminSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		VitaminSalad expectedSalad = new VitaminSalad();
		Salad actualSalad = saladCreationService.createSalad(2);

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladPeasantSalad() {
		SaladCreationService saladCreationService = new SaladCreationServiceImpl();

		PeasantSalad expectedSalad = new PeasantSalad();
		Salad actualSalad = saladCreationService.createSalad(3);

		assertEquals(expectedSalad, actualSalad);

	}

}
