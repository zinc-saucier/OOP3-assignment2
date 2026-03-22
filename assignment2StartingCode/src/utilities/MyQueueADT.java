package utilities;

import exceptions.*;

/**
 * MyQueueADT.java
 * 
 * @author Tessa Unrau
 * @version 1.1
 * @created March 16, 2026
 * @updated March 22, 2026 with updates to documentation and more complete comparison operations.
 * 
 * <p>
 * The <code>MyQueueADT</code> interface is an iterable queue for use with <code>MyDLL</code> as 
 * part of assignment 2 of CPRG 304-A winter 2026
 * </p>
 * <p>
 * <code>MyQueueADT</code> represents a First In Last Out(FILO) list of objects of an optionally fixed size. It extends class Iterator 
 * with 12 methods allowing Iterator to be treated as a queue. Modification methods include enqueue and dequeue to add and remove elements 
 * from the end and front of the queue respectively and dequeueAll to remove all elements from the queue. Query methods include peek 
 * to view the front element, equals for comparing the queue to another queue object, isEmpty and isFull to test if the queue 
 * is empty or full respectively, count to test the number of elements contained in the queue, size to test the queue capacity, contains 
 * to assess the presence of an element, search to return the index position of an element in the queue and toArray to return a printable 
 * array representation of the queue contents.  
 * </p>
 * 
 * @param <E> the elements the queue contains.
 * 
 * 
 **/

public interface MyQueueADT<E> extends Iterator<E> {
	
	
	// Constructor methods
	
	/**
	 * creates a queue of defined size. If no input is provided, default size is 0. Negative value inputs throw exception.
	 * 
	 * precondition: none.
	 * 
	 * postCondition: a MyQueue object is created and size is initialized to the value provided, or no size specified if value is 0.
	 * 
	 * @param size optional: new size, default is 0. 
	 * @exception InvalidQueueException if negative value is passed.
	 * 
	 * */
	public void queue(int size);
	
//-----------------------------------------------------------------------------------------------

	// Query operations
	
	/**
	 * returns the first element in this queue and returns its identity without removing it.
	 * 
	 * precondition: a valid MyQueue object exists with at least one element.
	 * 
	 * postCondition: an object representing the element at the front of the queue.
	 * 
	 * @return an object representation of the element at the front of this queue.
	 * @throws EmptyQueueException if the queue is empty.
	 * 
	 * */
	public E peek() throws EmptyQueueException;
	
	/**
	 * tests if this queue is at capacity.
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: a boolean value representing the queue's count() compared to its size().
	 * 
	 * @return true if this queue cannot accept additional elements, otherwise false. 
	 * 
	 * */
	public boolean isFull();
	
	/**
	 * tests if this queue contains no elements. References count to return a boolean value representing the
	 * current condition of the queue.
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: condition of tested queue object.
	 * 
	 * @return true if no elements are contained in this queue, otherwise false.
	 * 
	 * */
	public boolean isEmpty();
	
	/**
	 * tests this queue's composition against a second queue to determine if it contains identical 
	 * elements in the same order.
	 * 
	 * precondition: two existing MyQueue objects.
	 * 
	 * postCondition: condition of tested queues.
	 * 
	 * @param Object the second queue the queue is being tested against.
	 * @return true if the two objects are of identical composition, otherwise false.
	 * @exception InvalidArgumentException if Object argument is not of class MyQueue.
	 * 
	 * */
	public boolean equals(Object queue);
	
	/**
	 * tests this queue for the presence of specified element E.
	 * 
	 * precondition: an valid MyQueue object exists containing at least one element. 
	 * 
	 * postCondition: a boolean value representing the presence of the queried element.
	 * 
	 * @param element<E> whose presence is to be tested
	 * @return true if the specified element is within this queue, otherwise false.
	 * 
	 * */
	public boolean contains(E element);
	
	/**
	 * returns the element at the specified queue index. Can use contains() method for validation prior to return.
	 * 
	 * precondition: an valid MyQueue object exists containing at least one element. 
	 * 
	 * postCondition: an object representing the element currently at the specified index position in the queue.
	 * 
	 * @param index the integer value of the index to return the element of. 
	 * @return an object representation of the element at the specified integer index value of this queue.
	 * @throws NullPointerException if no such index exists in the queue.
	 * 
	 * */
	public E search(int index);
	
	/**
	 * returns the total capacity of the queue.
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: an integer value current Queue capacity.
	 * 
	 * @return the number of stack elements as an integer value.
	 * */
	public int size();
	
	/**
	 * returns the number of elements contained in this queue as an integer value.
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: an integer value representing the current element count.
	 * 
	 * @return the count value of this queue as an integer value.
	 * 
	 * */
	int count();
	
	/**
	 * returns an array object representing the elements in this queue in sequential order from index[0].
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: an array representation of the queue with the front element in index [0].
	 * 
	 * @return an array object representing this queue in its current sequential order.
	 * @throws EmptyQueueException if this queue is empty.
	 * */
	public Object[] toArray();
	
	
//-----------------------------------------------------------------------------------------------	
	
	// Modification operations
	
	/**
	 * appends a new element to the end of this queue. May affect the size of the queue.
	 * 
	 * precondition: a valid MyQueue object exists.
	 * 
	 * postCondition: element is now the last element in the queue, increment count.
	 * 
	 * @param element<E> the object to be added to the end of this queue.
	 * @exception IndexOutOfBoundsException optional: unless queue size is specifically restricted, enqueue may 
	 * increment size as well as count.
	 * 
	 * */
	public void enqueue(E element);
	
	/**
	 * removes the first element in this queue and returns its identity. Does not affect the size of the queue.
	 * 
	 * precondition: a valid Queue object exists.
	 * 
	 * postCondition: the element at the front of the queue, decrement count.
	 * 
	 * @return an object representation of the element at the front of this queue.
	 * @throws EmptyQueueException if the queue is empty.
	 * 
	 * */
	public E dequeue();
	
	/**
	 * removes all elements from the queue without affecting the size of the queue. May be run on an already empty queue 
	 * without throwing an exception. 
	 * 
	 * precondition: a valid MyQueue object exists with at least one element.
	 * 
	 * postCondition: an empty queue, count set to 0.
	 * 
	 * */
	public void dequeueAll();
	
	
	
	
	
	

}
