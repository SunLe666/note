package com.sl.design.proxy;


/**
 什么是代理模式？
 抽象点说是一个类代表另一个类的功能，或者说一个对象为另一个对象提供一个代理或者占位符以控制对这个对象的访问。
同样我也会举例子来说明，这里我举一个买车票的例子。
通常我们我们买车票需要去车站买，但是这样会很麻烦，可能要坐很久的车去车站，然后在排队买票。
但是如果我们去一个卖车票的代理点买车票可能就会省去这么多的事情。这样车票售卖处就代理你购买车票。*/
public class ProxyTest {
	public static void main(String[] args) {
		Station station = new Station();
		StationProxy proxy = new StationProxy(station);
		proxy.sellTicket();
	}
}
