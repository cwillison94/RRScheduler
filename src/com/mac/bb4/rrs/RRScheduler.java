package com.mac.bb4.rrs;

public class RRScheduler {
	
	public static void main(String[] args) {
		ReadyQueue queue = new ReadyQueue();
		Generator generator = new Generator(queue);
		GrimReaper reaper = new GrimReaper(queue);
		CPU cpu = new CPU(5000, reaper);
		Dispatcher dispatcher = new Dispatcher(queue, cpu);
		
		
		generator.start();
		dispatcher.start();
				
	}

}
