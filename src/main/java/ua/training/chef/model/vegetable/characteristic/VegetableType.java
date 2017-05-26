package ua.training.chef.model.vegetable.characteristic;

public enum VegetableType {
	CARROT("Carrot"), CUCUMBER("Cucumber"), LETTUCE("Lettuce"), OLIVE("Olive"), ONION("Onion"), PEPPER(
			"Pepper"), RADISH("Radish"), TOMATO("Tomato");

	private String value;

	VegetableType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static VegetableType getVegetableTypeByValue(String value) {
		for (VegetableType vegetableType : values()) {
			if (vegetableType.getValue().equals(value)) {
				return vegetableType;
			}
		}
		throw new IllegalArgumentException("VegetableType with such value doesn't exist");
	}
}
