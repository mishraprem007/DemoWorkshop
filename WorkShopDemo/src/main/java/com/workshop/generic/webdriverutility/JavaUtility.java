package com.workshop.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(99999);
		return ranDomNumber;
	}
	
	public String getOrderNumber(String text) {
		return text.split(": ")[1];
	}

}
