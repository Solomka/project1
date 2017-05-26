package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

import ua.training.chef.model.vegetable.characteristic.CarrotSize;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class Carrot extends Vegetable {

	private CarrotSize size;

	private boolean isGrated = false;

	public Carrot(double calories, BigDecimal price, CarrotSize size) {
		super(calories, price);

		this.size = size;
	}

	@Override
	public void prepareForSalad() {
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

	@Override
	public String toString() {

		return new StringBuilder(super.toString()).append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.SIZE)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getSize()).append(ViewMessageUtils.COMMA)
				.append(ViewMessageUtils.EMPTY_STR).append(ViewLocale.BUNDLE.getString(ViewMessage.IS_GRATED))
				.append(ViewMessageUtils.COLON).append(ViewMessageUtils.EMPTY_STR).append(isGrated()).toString();
	}

}
