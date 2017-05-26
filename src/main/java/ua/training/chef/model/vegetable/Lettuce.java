package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class Lettuce extends Vegetable {

	private boolean isCut = false;

	public Lettuce(double calories, BigDecimal price) {
		super(calories, price);
	}

	@Override
	public void prepareForSalad() {
		isCut = true;
	}

	public boolean isCut() {
		return isCut;
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

	@Override
	public String toString() {

		return new StringBuilder(super.toString()).append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.IS_PEELED)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(isCut()).toString();
	}
}
