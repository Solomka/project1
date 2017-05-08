package ua.training.chef.model.vegetable;

public abstract class Vegetable implements Comparable<Vegetable> {	

	private String type;
	private double caloric;
	private double price;

	public Vegetable(String type, double caloric, double price) {
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

	public double getPrice() {
		return price;
	}

	public int compareTo(Vegetable another) {
		if (caloric == another.caloric) {
			return 0;
		}
		return (caloric > another.caloric) ? 1 : -1;
	}

}
