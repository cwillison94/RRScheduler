package com.mac.bb4.rrs;

public class CPU {

	private int timeQuantum;

	/**
	 * Class constructor
	 * 
	 * @param timeQuantum
	 *            time in milliseconds that the CPU will work on a process
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

	public Process work(Process p) throws InterruptedException {

		if (p.hasStarted())
			p.resumeThread();
		else
			p.start();

		if (p.getTimeRemaining() < timeQuantum)
			Thread.sleep(p.getTimeRemaining());
		else
			Thread.sleep(timeQuantum);
		
		p.suspendThread();

		return p;

	}
}
