package com.mac.bb4.rrs;

public class Process extends Thread {
	private int ID;
	private int executionTime;
	private int timeRemainingMs;

	private boolean run = false;
	private Long startTime = 0L;

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
		this.timeRemainingMs = 0;
	}

	@Override
	public synchronized void start() {
		startTime = System.currentTimeMillis();
		run = true;
		super.start();
	}

	@Override
	public void interrupt() {
		run = false;
		super.interrupt();
	}

	@Override
	public void run() {
		while (run && timeRemainingMs < executionTime) {
			timeRemainingMs = (int) (System.currentTimeMillis() - startTime);

			if (timeRemainingMs % 100 == 0)
				System.out.println(this.toString());
		}
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
		return timeRemainingMs;
	}

	public boolean isDone() {
		if (timeRemainingMs >= executionTime)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return String.format("Process ID: %d\tExecTime: %d\tTimeRemaining: %d\tisDone: %b", ID,
				executionTime, executionTime - timeRemainingMs, isDone());
	}

	/*
	public static void main(String[] args) {

		Process p1 = new Process(10, 1000);
		Process p2 = new Process(11, 2000);

		
		p1.start();
		while (p1.isAlive());

		p2.start();

	}*/
}
