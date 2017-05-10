package ua.training.chef.model.dressing;

import java.math.BigDecimal;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.view.View;
import ua.training.chef.view.ViewMessage;

public abstract class Dressing {

	private String type;
	private double calories;
	private BigDecimal price;

	public Dressing(String type, double calories, BigDecimal price) {
		super();
		this.type = type;
		this.calories = calories;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public double getCalories() {
		return calories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dressing other = (Dressing) obj;
		if (Double.doubleToLongBits(calories) != Double.doubleToLongBits(other.calories))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder(getClass().getSimpleName()).append(ViewMessage.EQUALITY_SIGN)
				.append(ViewMessage.EMPTY_STR).append(View.BUNDLE.getString(ViewMessage.TYPE)).append(ViewMessage.COLON)
				.append(ViewMessage.EMPTY_STR).append(getType()).append(ViewMessage.COMMA).append(ViewMessage.EMPTY_STR)
				.append(View.BUNDLE.getString(ViewMessage.CALORIES)).append(ViewMessage.COLON)
				.append(ViewMessage.EMPTY_STR).append(getCalories()).append(ViewMessage.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.CALORIC_VALUE_MILLILITER_MEASURE))
				.append(ViewMessage.COMMA).append(ViewMessage.EMPTY_STR)
				.append(View.BUNDLE.getString(ViewMessage.PRICE)).append(ViewMessage.COLON)
				.append(ViewMessage.EMPTY_STR).append(getPrice()).append(ViewMessage.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.PRICE_MILLILITER_MEASURE)).toString();
	}
}
