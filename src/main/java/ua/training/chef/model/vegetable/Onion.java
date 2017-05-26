package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

import ua.training.chef.model.vegetable.characteristic.OnionType;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;
import ua.training.chef.view.utils.ViewMessageUtils;

public class Onion extends Vegetable {

	private OnionType type;

	private boolean isCut;
	private boolean isPeeled;

	public Onion(double calories, BigDecimal price, OnionType type) {
		super(calories, price);

		this.type = type;
	}

	@Override
	public void prepareForSalad() {
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

	@Override
	public String toString() {

		return new StringBuilder(super.toString()).append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.TYPE)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(getType()).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(ViewLocale.BUNDLE.getString(ViewMessage.IS_CUT))
				.append(ViewMessageUtils.COLON).append(ViewMessageUtils.EMPTY_STR).append(isCut())
				.append(ViewMessageUtils.COMMA).append(ViewMessageUtils.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.IS_PEELED)).append(ViewMessageUtils.COLON)
				.append(ViewMessageUtils.EMPTY_STR).append(isPeeled()).toString();
	}

}
