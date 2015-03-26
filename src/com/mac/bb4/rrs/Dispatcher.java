package com.mac.bb4.rrs;

/**
 * TODO Use a semaphore to lock the CPU and not keyword synchronized. The number
 * of permits the semaphore is the number of cores the CPU has.
 * 
 * 
 * */
public class Dispatcher extends Thread {

	private ReadyQueue queue;

	private CPU cpu;
	
	private GrimReaper reaper;

	public Dispatcher(ReadyQueue queue, CPU cpu) {
		this.queue = queue;
		this.cpu = cpu;
		reaper = new GrimReaper(queue);
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

			Process toLoad = queue.dequeue();
			System.out.println("Dispatcher:Loaded into CPU:\t" + toLoad.toString());
			cpu.work(toLoad);
		}
	}
}
