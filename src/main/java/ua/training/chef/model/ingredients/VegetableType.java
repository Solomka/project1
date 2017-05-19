package ua.training.chef.model.ingredients;

import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;

public enum VegetableType {
	CARROT(ViewLocale.BUNDLE.getString(ViewMessage.CARROT)), CUCUMBER(
			ViewLocale.BUNDLE.getString(ViewMessage.CUCUMBER)), LETTUCE(
					ViewLocale.BUNDLE.getString(ViewMessage.LETTUCE)), OLIVE(
							ViewLocale.BUNDLE.getString(ViewMessage.OLIVE)), ONION(
									ViewLocale.BUNDLE.getString(ViewMessage.ONION)), PEPPER(
											ViewLocale.BUNDLE.getString(ViewMessage.PEPPER)), RADISH(
													ViewLocale.BUNDLE.getString(ViewMessage.RADISH)), TOMATO(
															ViewLocale.BUNDLE.getString(ViewMessage.TOMATO));

	private String value;

	VegetableType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public VegetableType getVegetableTypeByValue(String value) {
		for (VegetableType vegetableType : values()) {
			if (vegetableType.getValue().equals(value)) {
				return vegetableType;
			}
		}
		throw new IllegalArgumentException("VegetableType with such value doesn't exist");
	}

}
