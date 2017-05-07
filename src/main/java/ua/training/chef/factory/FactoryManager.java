package ua.training.chef.factory;

public class FactoryManager {

	public static SaladFactory configureSaladFactory(int userSaladSelection) {
		switch (userSaladSelection) {
		case 1:
			return new GreekSaladFactory();
		case 2:
			return new VitaminSaladFactory();
		case 3:
			return new PeasantSaladFactory();
		default:
			throw new RuntimeException("Such salad is not served in our salad restaurant");
		}
	}
}