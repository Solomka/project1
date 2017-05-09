package ua.training.chef.model.dressing;

import java.math.BigDecimal;

public abstract class Dressing {

	private String type;
	private double caloric;
	private BigDecimal price;

	public Dressing(String type, double caloric, BigDecimal price) {
		super();
		this.type = type;
		this.caloric = caloric;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public double getCaloric() {
		return caloric;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Dressing [\ntype=" + type + ",\n caloric=" + caloric + ",\n price=" + price + "]";
	}
}
