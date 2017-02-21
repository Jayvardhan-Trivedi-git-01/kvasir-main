package com.users;

import java.util.ListResourceBundle;

public class LocaleString_ES_FR extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		  return contents;
	}
	 static final Object[][] contents = {
			  {"user.goodLogin", "Bienvenue Jay!"},
			  {"user.badLogin", "s'il vous plaît !"},
			  };

}
