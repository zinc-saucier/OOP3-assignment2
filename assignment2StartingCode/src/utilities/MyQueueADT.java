package utilities;

import java.util.Arrays;

import exceptions.*;

/**
 * MyQueueADT.java
 * 
 * @author Tessa Unrau
 * @version 1.0
 * @created March 16, 2026
 * 
 * <p>
 * The <code>MyQueueADT</code> interface is an iterable queue for use with <code>MyDLL</code> as 
 * part of assignment 2 of CPRG 304-A winter 2026
 * </p>
 * 
 * @param <E> the elements the queue contains.
 * 
 * 
 **/

public interface MyQueueADT<E> extends Iterator<E> {
	
	
	// Constructor methods
	
	/**
	 * creates an empty queue.
	 * 
	 * precondition: none.
	 * 
	 * postCondition: a Queue object is created and size is initialized to the value provided, or no size specified if value is 0.
	 * 
	 * @param size optional: new size, default is 0. 
	 * @exception InvalidQueueException if negative value is passed.
	 * 
	 * */
	public void queue(int size);
	
//-----------------------------------------------------------------------------------------------

	// Query operations
	
	/**
	 * returns the first element in the queue and returns its identity without removing it.
	 * 
	 * precondition: a valid Queue object exists with at least one element.
	 * 
	 * postCondition: an object representing the element at the front of the queue.
	 * 
	 * @return an object representation of the element at the front of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 * 
	 * */
	public E peek();
	
	/**
	 * tests if the queue is at capacity.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: a boolean value representing the queue's count() compared to its size().
	 * 
	 * @return True if the queue cannot accept additional elements, otherwise False. 
	 * 
	 * */
	public boolean isFull();
	
	/**
	 * tests if the queue is empty
	 * 
	 * precondition: a valid queue object exists.
	 * 
	 * postCondition: condition of tested Queue object.
	 * 
	 * @return true if no elements are contained in the queue, otherwise false.
	 * 
	 * */
	public boolean isEmpty();
	
	/**
	 * tests if the composition of two Queue objects contain identical elements in the same order.
	 * 
	 * precondition: two existing Queue objects.
	 * 
	 * postCondition: condition of tested queues.
	 * 
	 * @return true if the two objects are of identical composition, otherwise false.
	 * */
	public boolean equals();
	
	/**
	 * tests the queue for the presence of specified element E
	 * 
	 * precondition: an valid Queue object exists containing at least one element. 
	 * 
	 * postCondition: a boolean value representing the the queried element.
	 * 
	 * @param element the Element whose presence is to be tested
	 * @return True if the specified element is within the queue, otherwise False.
	 * 
	 * */
	public boolean contains(E element);
	
	/**
	 * returns the element at the specified queue index. 
	 * 
	 * precondition: an valid Queue object exists containing at least one element. 
	 * 
	 * postCondition: an object representing the element currently at the specified index position in the queue.
	 * 
	 * @param index the integer value of the index to return the element of. 
	 * @return an object representation of the element at the specified integer index value
	 * @throws NullPointerException if no such index exists in the queue.
	 * 
	 * */
	public E search(int index);
	
	/**
	 * returns the total capacity of the queue.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: an integer value current Queue capacity.
	 * 
	 * @return the number of stack elements as an integer value.
	 * */
	public int size();
	
	/**
	 * returns the count of elements contained in the Queue object.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: an integer value representing the current element count.
	 * 
	 * @return the count value as an integer value.
	 * 
	 * */
	int count();
	
	
//-----------------------------------------------------------------------------------------------	
	
	// Modification operations
	
	/**
	 * appends a new element E to the end of the queue.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: element E is now the last element in the queue. If the queue != full, increment size.
	 * 
	 * @param element the object to be added to the end of the queue.
	 * 
	 * */
	public void enqueue(E element);
	
	/**
	 * removes the first element in the queue and returns its identity. Does not affect the size of the queue.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: the element at the front of the queue.
	 * 
	 * @return an object representation of the element at the front of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 * 
	 * */
	public E dequeue();
	
	/**
	 * removes all elements from the queue without changing the size of the queue.
	 * 
	 * precondition: a valid Queue object exists with at least one element.
	 * 
	 * postCondition: an empty Queue object.
	 * 
	 * */
	public void dequeueAll();
	
	
	/**
	 * returns an array object representing the elements in the queue in order from the start of the queue.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: an array representation of the queue with the front element in index [1].
	 * 
	 * @return an Array object representing the queue in its current order.
	 * @throws EmptyQueueException if the queue is empty.
	 * */
	public Arrays toArray();
	
	
	

}
