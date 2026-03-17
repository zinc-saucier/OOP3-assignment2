package utilities;


import java.util.Arrays;

import exceptions.*;

/**
 * MyStackADT.java
 * 
 * @author Tessa Unrau
 * @version 1.0
 * @created March 16, 2026
 * 
 * <p>
 * The <code>MyStackADT</code> interface is an iterable stack for use with <code>MyArrayList</code> as 
 * part of assignment 2 of CPRG 304-A winter 2026
 * </p>
 * 
 * @param <E> the elements the stack contains.
 * 
 **/

public interface MyStackADT<E> extends Iterator<E> {
	
	
	// Constructor methods
	
	/**
	 * creates an empty stack.
	 * 
	 * precondition: none.
	 * 
	 * postCondition: an empty Stack object is created.
	 * 
	 * */
	public void stack();
	
	
//-----------------------------------------------------------------------------------------------
	
	// Query operations
	
	/**
	 * tests if the composition of two Stack objects contain identical elements in the same order.
	 * 
	 * precondition: two valid Stack objects exist.
	 * 
	 * postCondition: a boolean value representing the condition of the tested stacks.
	 * 
	 * @return true if the two objects are of identical composition, otherwise false.
	 * */
	public boolean equals();
	
	/**
	 * returns the position of the queried element from the top of the stack, with the top element being assigned '1'. 
	 * '-1' is returned if the queried element does not exist within the stack
	 * 
	 * precondition: an existing Stack object containing at least one element. 
	 * 
	 * postCondition: an integer value representing the stack position of the queried element.
	 * 
	 * @param 
	 * @return the stack position of the queried element as an integer value.
	 * 
	 * */
	public boolean contains(E element);
	
	
	/**
	 * tests if the stack is empty
	 * 
	 * precondition: a valid Stack object exists.
	 * 
	 * postCondition: condition of tested Stack.
	 * 
	 * @return true if no elements are contained in the stack, otherwise false.
	 * */
	public boolean isEmpty();
	
	
	/**
	 * returns the number of elements contained in the stack.
	 * 
	 * precondition: a valid Stack object exists.
	 * 
	 * postCondition: an integer value representing the number of elements in the Stack object.
	 * 
	 * @return the number of stack elements as an integer value.
	 * 
	 * */
	public int size();
	
	/**
	 * returns the identity of the topmost element in the stack without removing it.
	 * 
	 * precondition: a valid Stack object exists with at least one element in it.
	 * 
	 * postCondition: the element at the top of the stack.
	 * 
	 * @return an object representation of the element at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 * 
	 * */
	public E peek();
	
//-----------------------------------------------------------------------------------------------	
	
	// Modification operations
	
	/**
	 * removes all elements from the stack.
	 * 
	 * precondition: a valid Stack object exists with at least one element.
	 * 
	 * postCondition: an empty Stack object.
	 * 
	 * */
	public void clear();
	
	/**
	 * adds a new element E to the top of the stack.
	 * 
	 * precondition: a valid Stack object exists.
	 * 
	 * postCondition: element E is now at the top of the stack.
	 * 
	 * @param element the object to be added to the top of the stack.
	 * 
	 * */
	public void push(E element);
	
	/**
	 * removes the topmost element in the stack and returns its identity.
	 * 
	 * precondition: a valid Stack object exists with at least one element.
	 * 
	 * postCondition: the element at the top of the stack.
	 * 
	 * @return an object representation of the element at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 * */
	public E pop();
	
	/**
	 * returns an array object representing the elements in the stack in order from the top
	 * 
	 * precondition: a valid Stack object exists.
	 * 
	 * postCondition: an array containing the stack elements with the topmost stack element in index [1].
	 * 
	 * @return an Array object representing the stack in its current order from top down.
	 * @throws EmptyStackException if the stack is empty.
	 * */
	public Arrays toArray();
	
	/**
	 * ??
	 * 
	 * precondition: an existing Stack object
	 * 
	 * postCondition: 
	 * 
	 * @return 
	 * @throws
	 * */
	public void stackOverflow();

}
