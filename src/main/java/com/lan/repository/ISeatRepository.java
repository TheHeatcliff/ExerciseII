package com.lan.repository;

import com.lan.domain.Seat;

public interface ISeatRepository {

	Seat getSeat(Integer id);
	
	void takeSeat(Seat seat);
	

}
