package ua.training.chef.model.ingredient;

import java.math.BigDecimal;

import ua.training.chef.model.ingredient.characteristic.CarrotSize;

public class Carrot extends Vegetable {

	private CarrotSize size;

	private boolean isGrated = false;

	public Carrot(double calories, BigDecimal price, CarrotSize size) {
		super(calories, price);

		this.size = size;
	}

	@Override
	protected void prepareForSalad() {
		if (size == CarrotSize.ORDINAR) {
			isGrated = true;
		}
	}

	public CarrotSize getSize() {
		return size;
	}

	public void setSize(CarrotSize size) {
		this.size = size;
	}

	public boolean isGrated() {
		return isGrated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isGrated ? 1231 : 1237);
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Carrot other = (Carrot) obj;
		if (isGrated != other.isGrated)
			return false;
		if (size != other.size)
			return false;
		return true;
	}

}
