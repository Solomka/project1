package ua.training.chef.model.salad;

import ua.training.chef.view.ViewMessage;

public enum SaladType {

	PEASANT_SALAD(1), SPRING_SALAD(2), VITAMIN_SALAD(3);

	private int value;

	SaladType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	/**
	 * Return salad type for a given int value
	 * 
	 * @param value
	 * @return
	 */

	public static SaladType getSaladTypeByValue(int value) {
		for (final SaladType type : SaladType.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException(ViewMessage.SALAD_TYPE_VALUE_ERROR_MSG);

	}

}
