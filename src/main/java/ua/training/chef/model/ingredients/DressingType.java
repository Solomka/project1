package ua.training.chef.model.ingredients;

import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;

public enum DressingType {
	OIL(ViewLocale.BUNDLE.getString(ViewMessage.OIL)), VINEGAR(
			ViewLocale.BUNDLE.getString(ViewMessage.VINEGAR)), SOURCREAM(
					ViewLocale.BUNDLE.getString(ViewMessage.SOURCREAM));

	private String value;

	DressingType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public DressingType getDressingTypeByValue(String value) {
		for (DressingType dressingType : values()) {
			if (dressingType.getValue().equals(value)) {
				return dressingType;
			}
		}
		throw new IllegalArgumentException("DressingType with such value doesn't exist");
	}
}
