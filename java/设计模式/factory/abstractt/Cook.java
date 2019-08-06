package com.sl.design.factory.abstractt;

import com.sl.design.factory.Resaurant;

public class Cook {
	public static void main(String[] args) {
		Resaurant duck = new DuckFactory().createRestaurant();
		duck.cook();
		
		Resaurant fish = new FishFactory().createRestaurant();
		fish.cook();
	}
}
