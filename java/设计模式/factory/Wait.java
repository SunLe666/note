package com.sl.design.factory;

public class Wait {
	public static final int MEAN_DUCK = 1;
	public static final int MEAN_FISH = 2;

	public static Resaurant getMean(int MeanType) {
		switch (MeanType) {
		case MEAN_DUCK:
			return new Duck();
		case MEAN_FISH:
			return new Fish();
		default:
			return null;
		}

	}
}
