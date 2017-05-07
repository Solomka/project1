package ua.training.chef.model.vegetable;

public abstract class Vegetable implements Comparable<Vegetable> {

	private String type;
	private double caloric;

	public Vegetable(String type, double caloric) {
		this.type = type;
		this.caloric = caloric;
	}

	public String getType() {
		return type;
	}

	public double getCaloric() {
		return caloric;
	}

	public int compareTo(Vegetable another) {
		if (caloric == another.caloric) {
			return 0;
		}
		return (caloric > another.caloric) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Vegetable {\ntype=" + type + ", \ncaloric=" + caloric + "}";
	}
	
	
}
