package ua.training.chef.model.dressing;

import java.math.BigDecimal;

import ua.training.chef.view.View;
import ua.training.chef.view.ViewMessage;

public class SourCream extends Dressing {

	double fat;

	public SourCream(String type, double caloric, BigDecimal price, double fat) {
		super(type, caloric, price);
		this.fat = fat;
	}

	public double getFat() {
		return fat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SourCream other = (SourCream) obj;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append(ViewMessage.COMMA).append(ViewMessage.EMPTY_STR)
				.append(View.BUNDLE.getString(ViewMessage.FAT)).append(ViewMessage.COLON).append(ViewMessage.EMPTY_STR)
				.append(getFat()).toString();
	}
}
