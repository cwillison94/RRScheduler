package com.mac.bb4.rrs;

import java.sql.Time;

/**
 * TODO: make this class a singleton
 * 
 * */
public class CPU {

	private int timeQuantum;

	private GrimReaper reaper;

	/**
	 * Class constructor
	 * 
	 * @param timeQuantum
	 *            time in milliseconds that the CPU will work on a process
	 * 
	 * */
	public CPU(int timeQuantum, GrimReaper reaper) {
		this.timeQuantum = timeQuantum;
		this.reaper = reaper;
	}

	public int getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(int timeQuantum) {
		this.timeQuantum = timeQuantum;
	}

	/**
	 * This process simulates a CPU doing work on a process. If the process has
	 * been suspended it resumes it and does work till is is finished or for a
	 * defined timeQuanta.
	 * 
	 * @param p
	 *            Process to be worked on
	 * @return void
	 * 
	 * @exception InterruptedException
	 * 
	 * */
	public void work(Process p) throws InterruptedException {

		if (p.hasStarted())
			p.resumeThread();
		else
			p.start();

		if (p.getTimeRemaining() >= 0 && p.getTimeRemaining() < timeQuantum) {
			int timeRemaining = p.getTimeRemaining();
			p.join(timeRemaining);
			// Thread.sleep(timeRemaining);
			System.out.format("CPU:Process:%d Executed for: %d seconds \n", p.getID(),
					timeRemaining);
		} else {
			p.join(timeQuantum);
			// Thread.sleep(timeQuantum);
			System.out.format("CPU:Process:%d Executed for: %d seconds \n", p.getID(), timeQuantum);
		}

		p.suspendThread();
		
		reaper.reap(p);
	}


}
