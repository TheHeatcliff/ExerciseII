package com.lan.service.impl;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.VerificationsInOrder;
import mockit.integration.junit4.JMockit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lan.domain.Seat;
import com.lan.exception.BusinessException;
import com.lan.repository.ISeatRepository;


@RunWith(JMockit.class)
public class SeatConfiguratorServiceFacadeImplTest {

	@Mocked 
	private Seat seat;
	
	@Mocked
	private ISeatRepository repository;
	
	//SUD
	private SeatConfiguratorServiceFacadeImpl facade;
	
	final private Integer seatId = new Integer(198);
	
	@Before
	public void setup() {
		facade = new SeatConfiguratorServiceFacadeImpl();
	}
	
	@Test(expected = BusinessException.class)
	public void testTakeAlreadyTakenSeat() {
		
		new Expectations() {{
			repository.getSeat(seatId); 
			result = seat;
			
			seat.isTaken();
			result = true;
		  }};
		
		  facade.setRepository(repository);
		  
		  facade.takeSeat(seatId);
	}
	
	@Test
	public void testTakeSeat() {
		
		new NonStrictExpectations() {{
			repository.getSeat(seatId); 
			result = seat;
			
			seat.isTaken();
			result = false;
		  }};
		
		  facade.setRepository(repository);
		  facade.takeSeat(seatId);
		  
		  new VerificationsInOrder() {{
			  repository.takeSeat(seat);
		  }};
	}
	
	@Test
	public void testIsSeatTakenUsingID() {
		
		new NonStrictExpectations() {{
			repository.getSeat(seatId); 
			result = seat;
			
			seat.isTaken();
			result = false;
		  }};
		
		  facade.setRepository(repository);
		  facade.isSeatTaken(seatId);
		  
		  new VerificationsInOrder() {{
			  repository.getSeat(seatId);
			  seat.isTaken();
		  }};
	}
	
	
	@Test
	public void testIsSeatTakenUsingRowAndLetter() {
		
		new NonStrictExpectations() {{
			repository.getSeat(seatId); 
			result = seat;
		  }};
		
		facade.setRepository(repository);
		facade.isSeatTaken(3,'B',"First Class");
		//3 * 'B' = 198
		 
		  new VerificationsInOrder() {{
			  repository.getSeat(seatId);
			  seat.isTaken();
		  }};
		
	}
	
	@Test
	public void testTakenUsingRowAndLetterCab() {
		
		new NonStrictExpectations() {{
			repository.getSeat(seatId); 
			result = seat;
		  }};
		
		facade.setRepository(repository);
		facade.takeSeat(3, 'B',"FirstClass");
		
		 
		  new VerificationsInOrder() {{
			  repository.getSeat(seatId);
			  seat.isTaken();
		  }};
		
	}

	
	
		
}
