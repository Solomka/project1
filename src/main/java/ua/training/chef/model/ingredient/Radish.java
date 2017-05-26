package ua.training.chef.model.ingredient;

import java.math.BigDecimal;

import ua.training.chef.model.ingredient.characteristic.Color;

public class Radish extends Vegetable {

	private Color color;
	private boolean isCut = false;

	public Radish(double calories, BigDecimal price, Color color) {
		super(calories, price);

		this.color = color;
	}

	@Override
	protected void prepareForSalad() {
		isCut = true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isCut() {
		return isCut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Radish other = (Radish) obj;
		if (color != other.color)
			return false;
		if (isCut != other.isCut)
			return false;
		return true;
	}

}
