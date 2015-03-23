package com.mac.bb4.rrs;

public class GrimReaper {
	
	private ReadyQueue queue;
	
	public GrimReaper(ReadyQueue queue) {
		this.queue = queue;
	}
	
	/**
	 * This method attempts to kill the thread if it done executing
	 * otherwise it puts it back in the ready queue;
	 * 
	 * */
	public void reap(Process p) {
		
		if (p.isDone()) {
			p.interrupt();
			System.out.println("Reaper:Finished/Killed Process:\t" + p.toString());
		} else {
			//put back in queue
			queue.enqueue(p);
			System.out.println("Reaper:Recycled into Queue:\t" + p.toString());
		}
		
		
	}

}
