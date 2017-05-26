package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

import ua.training.chef.model.vegetable.characteristic.Color;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class Olive extends Vegetable {

	private Color color;

	private boolean isCutable = false;
	private boolean isCut = false;

	public Olive(double calories, BigDecimal price, Color color) {
		super(calories, price);

		this.color = color;
	}

	public Olive(double calories, BigDecimal price, Color color, boolean isCutable) {
		super(calories, price);

		this.color = color;
		this.isCutable = isCutable;
	}

	@Override
	public void prepareForSalad() {
		if (isCutable) {
			isCut = true;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isCutable() {
		return isCutable;
	}

	public void setCutable(boolean isCutable) {
		this.isCutable = isCutable;
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
		result = prime * result + (isCutable ? 1231 : 1237);
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
		Olive other = (Olive) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (isCut != other.isCut)
			return false;
		if (isCutable != other.isCutable)
			return false;
		return true;
	}

	@Override
	public String toString() {

		return new StringBuilder(super.toString()).append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.COLOR)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getColor()).append(ViewMessageUtils.COMMA)
				.append(ViewMessageUtils.EMPTY_STR).append(ViewLocale.BUNDLE.getString(ViewMessage.IS_CUTABLE))
				.append(ViewMessageUtils.COLON).append(ViewMessageUtils.EMPTY_STR).append(isCutable())
				.append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.IS_CUT)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(isCut()).toString();
	}

}
