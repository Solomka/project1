package ua.training.chef.model.cache;

import ua.training.chef.model.salad.Salad;

public class SaladCache {

	private Salad salad;

	public SaladCache() {
	}

	public SaladCache(Salad salad) {
		this.salad = salad;
	}

	public Salad getSalad() {
		return salad;
	}

	public void setSalad(Salad salad) {
		this.salad = salad;
	}

}
