package ua.training.chef.model.ingredient;

import java.math.BigDecimal;

public class Lettuce extends Vegetable {

	private boolean isCut = false;

	public Lettuce(double calories, BigDecimal price) {
		super(calories, price);
	}

	public boolean isCut() {
		return isCut;
	}

	@Override
	protected void prepareForSalad() {
		isCut = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isCut ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettuce other = (Lettuce) obj;
		if (isCut != other.isCut)
			return false;
		return true;
	}
}
