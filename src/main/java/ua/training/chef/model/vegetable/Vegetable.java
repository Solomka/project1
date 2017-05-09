package ua.training.chef.model.vegetable;

import java.math.BigDecimal;

public abstract class Vegetable implements Comparable<Vegetable> {

	private String type;
	private double caloric;
	private BigDecimal price;

	public Vegetable(String type, double caloric, BigDecimal price) {
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

	public int compareTo(Vegetable another) {
		if (caloric == another.caloric) {
			return 0;
		}
		return (caloric > another.caloric) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Vegetable [\ntype=" + type + ",\n caloric=" + caloric + ",\n price=" + price + "]";
	}
	
	
}
