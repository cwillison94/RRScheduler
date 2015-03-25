package com.mac.bb4.rrs;

/**
 * TODO: make this class a singleton
 * 
 * */
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

		if (p.getTimeRemaining() >= 0 && p.getTimeRemaining() < timeQuantum) {
			int timeRemaining = p.getTimeRemaining();
			p.join(timeRemaining);
			//Thread.sleep(timeRemaining);
			System.out.format("CPU:Process:%d Executed for: %d seconds \n", p.getID(), timeRemaining);
		} else {
			p.join(timeQuantum);
			//Thread.sleep(timeQuantum);
			System.out.format("CPU:Process:%d Executed for: %d seconds \n", p.getID(), timeQuantum);
		}

		p.suspendThread();

		return p;

	}
}
