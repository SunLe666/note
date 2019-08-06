package com.sl.design.proxy;
//代理模式
//首先创建一个售票服务的接口，它有售票咨询和退票的业务可以供客户选择。
public interface TicketService {
	
	//购票
	void sellTicket();
	
	//咨询
	void consultaction();
	
	//退票
	void returnTicket();
	
	
}
