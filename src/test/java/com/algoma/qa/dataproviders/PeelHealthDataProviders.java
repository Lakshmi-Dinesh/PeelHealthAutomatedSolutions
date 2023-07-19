package com.algoma.qa.dataproviders;

import org.testng.annotations.DataProvider;

public class PeelHealthDataProviders {

	@DataProvider
	public static Object[][] incorrectSubscribeEmailIds() {
		return new Object[][] { { "abc" }, { "a b" }, { "@" }, { ".xyz" } };
	}
}
