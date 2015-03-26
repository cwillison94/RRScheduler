package com.mac.bb4.rrs;

public class Process extends Thread {
	private int ID;
	private int executionTime;
	private int timeDiff;

	private boolean run = false;
	private boolean suspend = false;
	private Long startTime = 0L;

	private boolean started = false;

	/**
	 * Class constructor
	 * 
	 * @param ID
	 *            process identifier
	 * @param executionTimeMs
	 *            time in milliseconds that the process needs to finish
	 * 
	 * */
	public Process(int ID, int executionTimeMs) {
		this.ID = ID;
		this.executionTime = executionTimeMs;
		this.timeDiff = 0;
	}

	@Override
	public synchronized void start() {
		startTime = System.currentTimeMillis();
		run = true;
		started = true;
		super.start();
	}

	@Override
	public void interrupt() {
		run = false;
		super.interrupt();
	}

	@Override
	public void run() {
		while (run && timeDiff < executionTime) {
			if (suspend)
				continue;
			timeDiff = (int) (System.currentTimeMillis() - startTime);

		}
	}

	public boolean isSuspended() {
		return suspend;
	}

	public void suspendThread() {
		this.suspend = true;
	}

	public void resumeThread() {
		startTime = System.currentTimeMillis();
		this.suspend = false;
	}

	public boolean isRunning() {
		return run;
	}

	public void setRunning(boolean run) {
		this.run = run;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public int getTimeRemaining() {
		int diff = executionTime - timeDiff;
		if (diff < 0)
			return 0;
		else
			return diff;
	}

	public boolean hasStarted() {
		return started;
	}

	public boolean isDone() {
		if (timeDiff >= executionTime)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return String.format("Process ID: %d\tExecTime: %d\tTimeRemaining: %d\tisDone: %b", ID,
				executionTime, getTimeRemaining(), isDone());
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Process p1 = new Process(10, 1000); Process p2 = new Process(11, 2000);
	 * 
	 * p1.start(); try { Thread.sleep(500); p1.suspendThread(); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * p2.start();
	 * 
	 * while (p2.isAlive());
	 * 
	 * p1.resumeThread();
	 * 
	 * }
	 */
}
