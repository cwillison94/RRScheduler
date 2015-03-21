package com.mac.bb4.rrs;

public class Process {
	private int ID;
	private int executionTime;
	private int timeRemaining;

	public Process(int ID, int executionTime) {
		this.ID = ID;
		this.executionTime = this.timeRemaining = executionTime;
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
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public void decrementTime() {
		timeRemaining--;
	}

	public boolean isDone() {
		if (timeRemaining <= 0)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return String.format("Process ID: %d Execeution Time: %d Time Remaining: %d \n isDone: %b",
				ID, executionTime, timeRemaining, isDone());
	}
}
