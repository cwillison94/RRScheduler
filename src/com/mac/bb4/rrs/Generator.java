package com.mac.bb4.rrs;

import java.util.Random;

public class Generator extends Thread {
	private static final int PROCESS_MIN_TIME = 1000; // 1000ms = 1s
	private static final int PROCESS_MAX_TIME = 15000; // 15000ms = 15s

	private boolean run = false;
	private int idCounter = 0;

	private ReadyQueue queue;
	private Random rGen;


	public Generator(ReadyQueue queue) {
		this.queue = queue;
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
		while (run) {
			makeProcess();
		}
	}

	private synchronized void makeProcess() {
		Process p = new Process(idCounter, getRandProcessTime());
		System.out.println("Generator:Loaded into Queue:\t" + p.toString());
		queue.enqueue(p);

		try {
			sleep(5000 + rGen.nextInt(20000 - 5000 + 1)); // sleep for 5 to 20 should change

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		idCounter++;

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
		return rGen.nextInt((PROCESS_MAX_TIME - PROCESS_MIN_TIME) + 1) + PROCESS_MIN_TIME;
	}

	/*
	 * public static void main(String[] args) { Generator generator = new
	 * Generator();
	 * 
	 * generator.start(); }
	 */

}
