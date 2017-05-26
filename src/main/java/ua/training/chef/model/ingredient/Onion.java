package ua.training.chef.model.ingredient;

import java.math.BigDecimal;

import ua.training.chef.model.ingredient.characteristic.OnionType;

public class Onion extends Vegetable {

	private OnionType type;

	private boolean isCut;
	private boolean isPeeled;

	public Onion(double calories, BigDecimal price, OnionType type) {
		super(calories, price);

		this.type = type;
	}

	@Override
	protected void prepareForSalad() {
		setCut();
		setPeeled();
	}

	private void setCut() {
		this.isCut = true;
	}

	private void setPeeled() {
		if (type == OnionType.ORIDNAR) {
			isPeeled = true;
		}
	}

	public OnionType getType() {
		return type;
	}

	public void setType(OnionType type) {
		this.type = type;
	}

	public boolean isCut() {
		return isCut;
	}

	public boolean isPeeled() {
		return isPeeled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isCut ? 1231 : 1237);
		result = prime * result + (isPeeled ? 1231 : 1237);
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
		Onion other = (Onion) obj;
		if (isCut != other.isCut)
			return false;
		if (isPeeled != other.isPeeled)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
