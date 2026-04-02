package implementations;

import java.util.Arrays;
import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * MyQueue is an implementation of QueueADT using MyDLL as the
 * underlying data structure. Elements are enqueued at the tail
 * and dequeued from the head, giving FIFO ordering.
 *
 * Pre-conditions:  Elements enqueued must not be null.
 * Post-conditions: Follows FIFO order. iterator() and toArray()
 *                  return elements from front (head) to back (tail).
 *
 * @param <E> the type of elements stored in this queue
 * @author Assignment 2 Group - Person 3
 * @version 1.0
 */
public class MyQueue<E> implements QueueADT<E>
{
	/** The backing doubly linked list */
	private MyDLL<E> list;

	/**
	 * Constructs an empty queue.
	 */
	public MyQueue()
	{
		list = new MyDLL<>();
	}

	/**
	 * Adds an element to the tail (back) of the queue.
	 *
	 * Pre-condition:  toAdd is not null.
	 * Post-condition: toAdd is at the back; size increases by 1.
	 *
	 * @param toAdd the element to enqueue
	 * @throws NullPointerException if toAdd is null
	 */
	@Override
	public void enqueue( E toAdd ) throws NullPointerException
	{
		if ( toAdd == null )
			throw new NullPointerException( "Cannot enqueue null into the queue." );
		list.add( toAdd );
	}

	/**
	 * Removes and returns the element at the front (head) of the queue.
	 *
	 * Pre-condition:  Queue is not empty.
	 * Post-condition: Front element is removed; size decreases by 1.
	 *
	 * @return the element that was at the front
	 * @throws EmptyQueueException if the queue is empty
	 */
	@Override
	public E dequeue() throws EmptyQueueException
	{
		if ( isEmpty() )
			throw new EmptyQueueException( "Cannot dequeue from an empty queue." );
		return list.remove( 0 );
	}

	/**
	 * Returns the front element without removing it.
	 *
	 * Pre-condition:  Queue is not empty.
	 * Post-condition: Queue is unchanged.
	 *
	 * @return the element at the front
	 * @throws EmptyQueueException if the queue is empty
	 */
	@Override
	public E peek() throws EmptyQueueException
	{
		if ( isEmpty() )
			throw new EmptyQueueException( "Cannot peek at an empty queue." );
		return list.get( 0 );
	}

	/**
	 * Removes all elements from the queue.
	 *
	 * Post-condition: Queue is empty.
	 */
	@Override
	public void dequeueAll()
	{
		list.clear();
	}

	/**
	 * Returns true if the queue contains no elements.
	 *
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	/**
	 * Returns true if the queue contains the specified element.
	 *
	 * @param toFind the element to search for; must not be null
	 * @return true if found
	 * @throws NullPointerException if toFind is null
	 */
	@Override
	public boolean contains( E toFind ) throws NullPointerException
	{
		if ( toFind == null )
			throw new NullPointerException( "Cannot search for null in the queue." );
		return list.contains( toFind );
	}

	/**
	 * Returns the 1-based position from the front of the queue.
	 * The front element is at position 1.
	 *
	 * @param toFind the element to locate
	 * @return 1-based distance from the front, or -1 if not found
	 */
	@Override
	public int search( E toFind )
	{
		for ( int i = 0; i < list.size(); i++ )
		{
			if ( list.get( i ).equals( toFind ) )
				return i + 1; // 1-based from front
		}
		return -1;
	}

	/**
	 * Returns an iterator over elements from front to back.
	 * The first call to next() returns the front element.
	 *
	 * @return Iterator from front to back
	 */
	@Override
	public Iterator<E> iterator()
	{
		return list.iterator();
	}

	/**
	 * Two queues are equal if they contain the same elements in the same order.
	 *
	 * @param that the queue to compare against
	 * @return true if both queues are equal
	 */
	@Override
	public boolean equals( QueueADT<E> that )
	{
		if ( that == null )
			return false;
		if ( this.size() != that.size() )
			return false;
		Iterator<E> thisIt = this.iterator();
		Iterator<E> thatIt = that.iterator();
		while ( thisIt.hasNext() )
		{
			if ( !thisIt.next().equals( thatIt.next() ) )
				return false;
		}
		return true;
	}

	/**
	 * Returns an Object array of all elements from front to back.
	 *
	 * @return Object array, front to back
	 */
	@Override
	public Object[] toArray()
	{
		return list.toArray();
	}

	/**
	 * Returns a typed array of all elements from front to back.
	 *
	 * @param toHold the target array; a new array is allocated if too small
	 * @return typed array, front to back
	 * @throws NullPointerException if toHold is null
	 */
	@Override
	public E[] toArray( E[] toHold ) throws NullPointerException
	{
		if ( toHold == null )
			throw new NullPointerException( "Holder array cannot be null." );
		return list.toArray( toHold );
	}

	/**
	 * Always returns false — this queue has no fixed capacity.
	 *
	 * @return false
	 */
	@Override
	public boolean isFull()
	{
		return false;
	}

	/**
	 * Returns the number of elements in the queue.
	 *
	 * @return element count
	 */
	@Override
	public int size()
	{
		return list.size();
	}
}