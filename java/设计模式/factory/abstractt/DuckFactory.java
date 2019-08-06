package com.sl.design.factory.abstractt;

import com.sl.design.factory.Duck;
import com.sl.design.factory.Resaurant;

public class DuckFactory extends CookFactory{

	@Override
	public Resaurant createRestaurant() {
		return new Duck();
	}


}
