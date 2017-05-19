package ua.training.chef.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class ViewLocale {

	public static final String MESSAGES_BUNDLE_NAME = "messages";

	// default Locale
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("en"));

	public static void setResourceBundleLocale(String locale) {
		BUNDLE = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(locale));
	}

}
