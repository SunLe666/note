package com.sl.design.proxy;

public class Station implements TicketService{

	@Override
	public void sellTicket() {
		System.out.println("售票");
	}

	@Override
	public void consultaction() {
		System.out.println("咨询");
	}

	@Override
	public void returnTicket() {
		System.out.println("退票");
	}

}
