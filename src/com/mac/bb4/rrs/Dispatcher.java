package com.mac.bb4.rrs;

import java.util.concurrent.Semaphore;

public class Dispatcher extends Thread {

	private ReadyQueue queue;

	private CPU cpu;
	private GrimReaper reaper;


	public Dispatcher(ReadyQueue queue, CPU cpu) {
		this.queue = queue;
		this.cpu = cpu;
		this.reaper = new GrimReaper(queue);
	}

	@Override
	public void run() {
		while (true) {
			try {
				dispatchToCPU();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private synchronized void dispatchToCPU() throws InterruptedException {

		if (queue.getSize() != 0) {
			// cpuLock.acquire();

			Process toLoad;

			toLoad = queue.dequeue();
			System.out.println("Dispatcher:Loaded into CPU:\t" + toLoad.toString());
			Process p = cpu.work(toLoad);

			// call grimreaper put back in if not finished
			// do this in the reaper

			reaper.reap(p);

		}
	}
}
