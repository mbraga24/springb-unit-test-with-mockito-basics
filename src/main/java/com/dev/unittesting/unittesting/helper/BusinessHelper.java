package com.dev.unittesting.unittesting.helper;

import java.text.DecimalFormat;

public class BusinessHelper {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	static public double roundTwoDecimals(double percDiscount, double price) {
		double newPrice = (price - (price / 100.0) * percDiscount);
		return Double.parseDouble(df.format(newPrice));
	}
	
}
