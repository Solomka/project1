package ua.training.chef.model.salad.ingredient;

import java.math.BigDecimal;
import java.util.Objects;

import ua.training.chef.constants.GlobalConstants;
import ua.training.chef.utils.Builder;
import ua.training.chef.view.ViewLocale;
import ua.training.chef.view.ViewMessage;

public class Vegetable implements Comparable<Vegetable> {

	private VegetableType type;
	private String subType;
	private double calories;
	private BigDecimal price;

	public static class VegetableBuilder implements Builder<Vegetable> {

		private VegetableType type;
		private String subType;
		private double calories;
		private BigDecimal price;

		public VegetableBuilder() {

		}

		public VegetableType getType() {
			return type;
		}

		public VegetableBuilder setType(VegetableType type) {
			this.type = type;
			return this;
		}

		public String getSubType() {
			return subType;
		}

		public VegetableBuilder setSubType(String subType) {
			this.subType = subType;
			return this;
		}

		public double getCalories() {
			return calories;
		}

		public VegetableBuilder setCalories(double calories) {
			this.calories = calories;
			return this;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public VegetableBuilder setPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		@Override
		public Vegetable build() {
			return new Vegetable(this);
		}
	}

	private Vegetable(VegetableBuilder builder) {
		Objects.requireNonNull(builder);

		this.type = Objects.requireNonNull(builder.getType());
		this.subType = Objects.requireNonNull(builder.getSubType());
		this.calories = builder.getCalories();
		this.price = Objects.requireNonNull(builder.getPrice());
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public VegetableType getType() {
		return type;
	}

	public void setType(VegetableType type) {
		this.type = type;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int compareTo(Vegetable another) {
		if (calories == another.calories) {
			return 0;
		}
		return (calories > another.calories) ? 1 : -1;
	}

	/*
	 * price is not included in hashCode/equals calculation 'cause it's
	 * frequently changeable parameter
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((subType == null) ? 0 : subType.hashCode());
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
		Vegetable other = (Vegetable) obj;
		if (Double.doubleToLongBits(calories) != Double.doubleToLongBits(other.calories))
			return false;
		if (subType == null) {
			if (other.subType != null)
				return false;
		} else if (!subType.equals(other.subType))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {

		return new StringBuilder(getType().toString()).append(ViewMessage.EQUALITY_SIGN).append(ViewMessage.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.SUBTYPE)).append(ViewMessage.COLON)
				.append(ViewMessage.EMPTY_STR).append(getSubType()).append(ViewMessage.COMMA)
				.append(ViewMessage.EMPTY_STR).append(ViewLocale.BUNDLE.getString(ViewMessage.CALORIES))
				.append(ViewMessage.COLON).append(ViewMessage.EMPTY_STR).append(getCalories())
				.append(ViewMessage.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.CALORIC_VALUE_GRAM_MEASURE))
				.append(ViewMessage.COMMA).append(ViewMessage.EMPTY_STR)
				.append(ViewLocale.BUNDLE.getString(ViewMessage.PRICE)).append(ViewMessage.COLON)
				.append(ViewMessage.EMPTY_STR).append(getPrice()).append(ViewMessage.EMPTY_STR)
				.append(ViewMessage.getUnitOfMeasurement(GlobalConstants.PRICE_GRAM_MEASURE)).toString();
	}

}
