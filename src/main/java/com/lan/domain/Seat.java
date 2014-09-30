package com.lan.domain;

/**
 * Abstraction of a single flight seat
 * @author nikolas
 *
 */
public class Seat {
	
	private String cab;
	
	private int id;
	
	private boolean taken;
	
	public Seat(Integer row, Character letter, String cab) {
		super();
		this.cab = cab;
		this.id = row * letter;
		this.taken = false;
	}
	
	public Seat(Integer id, String cab) {
		super();
		this.cab = cab;
		this.id = id;
		this.taken = false;
	}
	
	public int getId(int row, Character letter){
		int ascii = letter;
		return row * ascii;
	}
	
	public int getId(){
		return id;
	}
	
	public void take(){
		this.taken = true;
	}
	
	public boolean isTaken(){
		return taken;
	}

	/**
	 * @return the cab
	 */
	public String getCab() {
		return cab;
	}
}
