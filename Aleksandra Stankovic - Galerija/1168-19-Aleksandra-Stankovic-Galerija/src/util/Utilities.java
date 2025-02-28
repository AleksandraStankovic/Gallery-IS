package util;


import data.DataAccessFactory;
import data.DataAccessFactoryType;//whatever the fuck je ovo :)

public class Utilities {
	
	private static DataAccessFactory factory;

	public static DataAccessFactory getDataAccessFactory() {
		if (factory == null) {
			factory = DataAccessFactory.getFactory(DataAccessFactoryType.MySQL);
		}
		return factory;
	}

	public static final String[] YES_NO_OPTIONS = new String[] {
			"   Da   ",
			"   Ne   "
	};

	
	
	public static final String IMAGE_RESOURCES_PATH = "/img/";


public static boolean isSearchPatternValid(String pattern) {
	boolean retVal = true;
	for (int i = 0; i < pattern.length(); i++) {
		char c = pattern.charAt(i);
		if (!(Character.isLetterOrDigit(c) || c == '-' || c == '_'
				|| c == ' ' || c == '.' || c == ',' || c == '?' || c == '*')) {
			retVal = false;
			break;
		}
	}
	return retVal;
}

public static boolean isTextValid(String text) {
	boolean retVal = true;
	for (int i = 0; i < text.length(); i++) {
		char c = text.charAt(i);
		if (!(Character.isLetterOrDigit(c) || c == '-' || c == '_'
				|| c == ' ' || c == '.' || c == ',')) {
			retVal = false;
			break;
		}
	}
	return retVal;
}

public static boolean tryParseInt(String s) {
	boolean retVal = false;
	try {
		Integer.valueOf(s);
		retVal = true;
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	return retVal;
}

public static boolean tryParseShort(String s) {
	boolean retVal = false;
	try {
		Short.valueOf(s);
		retVal = true;
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	return retVal;
}

public static boolean tryParseFloat(String s) {
    try {
        Float.valueOf(s);  
        return true;      
    } catch (NumberFormatException e) {
        return false;      
    }
}




}