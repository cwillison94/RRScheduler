package com.mac.bb4.rrs;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * This class implements a FIFO QUEUE using LinkedList's
 * 
 * @see {@link LinkedList}
 * 
 * */
public class ReadyQueue {
	private LinkedList<Process> list;

	/**
	 * Class constructor, creates a new LinkedList of Process's
	 * 
	 * */
	public ReadyQueue() {
		list = new LinkedList<Process>();
	}

	/**
	 * Returns true if the list is empty, otherwise false
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * Add item to the back of the QUEUE
	 * 
	 * @param process
	 *            The Process to be added
	 * @return void
	 * 
	 * */
	public void enqueue(Process process) {
		list.add(process);
	}

	/**
	 * Return the head of the QUEUE and REMOVE it from the QUEUE
	 * 
	 * @return void
	 * 
	 * @exception EmptyStackException
	 * @see {@link EmptyStackException}
	 * 
	 * */
	public Process dequeue() {
		if (isEmpty())
			throw new EmptyStackException();

		Process process = list.get(1);
		list.remove(1);

		return process;
	}

	/**
	 * Return the head of the QUEUE but DOES NOT remove it
	 * 
	 * @return void
	 * 
	 * @exception EmptyStackException
	 * @see {@link EmptyStackException}
	 * 
	 * */
	public Process peek() {
		if (isEmpty())
			throw new EmptyStackException();

		return list.get(1);
	}
	
	public int getSize() {
		return list.size();
	}

}
