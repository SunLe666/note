package com.sl.design.factory.abstractt;

import com.sl.design.factory.Fish;
import com.sl.design.factory.Resaurant;

public class FishFactory extends CookFactory{

	@Override
	public Resaurant createRestaurant() {
		return new Fish();
	}

}
