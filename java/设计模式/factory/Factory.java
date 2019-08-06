package com.sl.design.factory;

public class Factory {
	public static void main(String[] args) {
		Resaurant resaurant = Wait.getMean(Wait.MEAN_DUCK);
		resaurant.cook();
	}
}
