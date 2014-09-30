package com.lan.service.impl;

import com.lan.domain.Seat;
import com.lan.exception.BusinessException;
import com.lan.repository.ISeatRepository;
import com.lan.service.ISeatConfiguratorServiceFacade;

public class SeatConfiguratorServiceFacadeImpl implements ISeatConfiguratorServiceFacade{

	private ISeatRepository repository;
	
	public void takeSeat(Integer row ,Character letter,String cab) {
		Integer id = row * letter;
		takeSeat(id);
	}
	
	public void takeSeat(Integer id) {
		
		Seat seat = repository.getSeat(id);
		
		if (seat.isTaken()){
			throw new BusinessException("Seat " + id +" already taken");
		}
		seat.take();
		
		repository.takeSeat(seat);
	}
	
	public boolean isSeatTaken(Integer row, Character letter,String cab){
		Integer id = row * letter;
		return isSeatTaken(id);
	}
	
	public boolean isSeatTaken(Integer id){
		Seat seat = repository.getSeat(id);
		return seat.isTaken();
	}

	/**
	 * Only for testing purpose
	 * @param repository
	 */
	public void setRepository(ISeatRepository repository) {
		this.repository = repository;
	}
	
}
