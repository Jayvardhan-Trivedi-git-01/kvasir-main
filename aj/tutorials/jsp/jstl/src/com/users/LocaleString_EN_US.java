package com.users;
import java.util.ListResourceBundle;

public class LocaleString_EN_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		  return contents;
	}
	 static final Object[][] contents = {
			  {"user.goodLogin", "Welcome Jay!"},
			  {"user.badLogin", "Please Try again!"},
			  };

}

