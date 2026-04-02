package utilities;

import exceptions.EmptyQueueException;

/**
 * This is the professional Queue Interface for Object-Oriented Programming 3
 * (CRPG 304) at the SAIT Polytechnic. This Queue embodies all the standard
 * Queue operations, and includes several helper methods that will give the data
 * structure more flexibility and use.
 */
public interface QueueADT<E> {

	public void enqueue(E toAdd) throws NullPointerException;

	public E dequeue() throws EmptyQueueException;

	public E peek() throws EmptyQueueException;

	public void dequeueAll();

	public boolean isEmpty();

	public boolean contains(E toFind) throws NullPointerException;

	public int search(E toFind);

	public Iterator<E> iterator(); // still works without import

	public boolean equals(QueueADT<E> that);

	public Object[] toArray();

	public E[] toArray(E[] holder) throws NullPointerException;

	public boolean isFull();

	public int size();
}