package com.mac.bb4.rrs;

import java.util.Random;

public class Generator extends Thread {
	private static final int PROCESS_MIN_TIME = 5;
	private static final int PROCESS_MAX_TIME = 30;
	
	private boolean run = false;
	private int idCounter =  0;
	
	private ReadyQueue queue;
	private Random rGen;
	
	
	
	public Generator() {
		queue = new ReadyQueue();
		rGen = new Random();
	}
	
	@Override
	public synchronized void start() {
		run = true;
		System.out.println("Generator started!");
		super.start();
				
	}

	@Override
	public void run() {
		while(run){
			
			Process p = new Process(idCounter, getRandProcessTime());
			System.out.println(p.toString());
			queue.enqueue(p);
			
			//TODO add code to add processes at random times
			//this should probably be changed
			try {
				sleep(10000 + rGen.nextInt(35000-10000 + 1)); //sleep for 10 to 35 seconds -should probably change
				//sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void interrupt() {
		super.interrupt();
		run = false;
	}
	
	/**
	 * Returns a random integer between the static class variable
	 * PROCESS_MIN_TIME and PROCESS_MAX_TIME
	 * 
	 * */
	private int getRandProcessTime() {
		return rGen.nextInt((PROCESS_MAX_TIME-PROCESS_MIN_TIME) + 1) + PROCESS_MIN_TIME;
	}
	
	public static void main(String[] args) {
		Generator generator = new Generator();
		
		generator.start();
	}
	

	

}
