package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

import ua.training.chef.model.vegetable.characteristic.Color;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class Pepper extends Vegetable {

	private Color color;

	private boolean isCut = false;

	public Pepper(double calories, BigDecimal price, Color color) {
		super(calories, price);

		this.color = color;
	}

	@Override
	public void prepareForSalad() {
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
		Pepper other = (Pepper) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (isCut != other.isCut)
			return false;
		return true;
	}

	@Override
	public String toString() {

		return new StringBuilder(super.toString()).append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.COLOR)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getColor()).append(ViewMessageUtils.COMMA)
				.append(ViewMessageUtils.EMPTY_STR).append(ViewLocale.BUNDLE.getString(ViewMessage.IS_CUT))
				.append(ViewMessageUtils.COLON).append(ViewMessageUtils.EMPTY_STR).append(isCut()).toString();
	}

}
