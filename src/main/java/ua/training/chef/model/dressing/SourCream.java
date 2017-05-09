package ua.training.chef.model.dressing;

import java.math.BigDecimal;

public class SourCream extends Dressing {

	double fat;

	public SourCream(String type, double caloric, BigDecimal price, double fat) {
		super(type, caloric, price);
		this.fat = fat;
	}

	public double getFat() {
		return fat;
	}

}
