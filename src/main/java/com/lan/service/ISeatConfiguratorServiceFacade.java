package com.lan.service;

public interface ISeatConfiguratorServiceFacade {

	boolean isSeatTaken(Integer id);

	boolean isSeatTaken(Integer row, Character letter,String cab);

	void takeSeat(Integer id);

	void takeSeat(Integer row, Character letter,String cab);

}
