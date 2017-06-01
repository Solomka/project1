package ua.training.chef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.training.chef.model.salad.PeasantSalad;
import ua.training.chef.model.salad.Salad;
import ua.training.chef.model.salad.SaladType;
import ua.training.chef.model.salad.SpringSalad;
import ua.training.chef.model.salad.VitaminSalad;
import ua.training.chef.model.salad_factory.SaladFactory;
import ua.training.chef.model.salad_factory.SaladFactoryImpl;

public class SaladFactoryTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSaladIllegalArgumentException() {
		SaladFactory saladFactory = SaladFactoryImpl.getSaladFactoryImplInstance();
		saladFactory.createSalad(SaladType.getSaladTypeByValue(12));
	}

	@Test
	public void testCreateSaladSpringSalad() {
		SaladFactory saladFactory = SaladFactoryImpl.getSaladFactoryImplInstance();

		SpringSalad expectedSalad = new SpringSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladFactory.createSalad(SaladType.getSaladTypeByValue(1));

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladVitaminSalad() {
		SaladFactory saladFactory = SaladFactoryImpl.getSaladFactoryImplInstance();

		VitaminSalad expectedSalad = new VitaminSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladFactory.createSalad(SaladType.getSaladTypeByValue(2));

		assertEquals(expectedSalad, actualSalad);

	}

	@Test
	public void testCreateSaladPeasantSalad() {
		SaladFactory saladFactory = SaladFactoryImpl.getSaladFactoryImplInstance();

		PeasantSalad expectedSalad = new PeasantSalad();
		expectedSalad.prepareSaladVegetables();

		Salad actualSalad = saladFactory.createSalad(SaladType.getSaladTypeByValue(3));

		assertEquals(expectedSalad, actualSalad);

	}

}
