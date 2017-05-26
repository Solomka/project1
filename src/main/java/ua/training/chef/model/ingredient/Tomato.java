package ua.training.chef.model.ingredient;

import java.math.BigDecimal;

import ua.training.chef.model.ingredient.characteristic.TomatoType;

public class Tomato extends Vegetable {

	private TomatoType type;
	private boolean isCut = false;

	public Tomato(double calories, BigDecimal price, TomatoType type) {
		super(calories, price);

		this.type = type;
	}

	public void setCut(boolean isCut) {
		if (type == TomatoType.ORDINAR) {
			isCut = true;
		}
	}

	@Override
	protected void prepareForSalad() {
		isCut = true;
	}

	public TomatoType getType() {
		return type;
	}

	public void setType(TomatoType type) {
		this.type = type;
	}

	public boolean isCut() {
		return isCut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isCut ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tomato other = (Tomato) obj;
		if (isCut != other.isCut)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
