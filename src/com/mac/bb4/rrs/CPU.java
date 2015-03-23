package com.mac.bb4.rrs;

public class CPU {
	
	private int timeQuantum;
	
	
	/**
	 * Class constructor
	 * 
	 * @param timeQuantum time in milliseconds that the CPU will
	 * work on a process
	 * 
	 * */
	public CPU(int timeQuantum) {
		this.timeQuantum = timeQuantum;
	}

	public int getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(int timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	
	
	
	

}
