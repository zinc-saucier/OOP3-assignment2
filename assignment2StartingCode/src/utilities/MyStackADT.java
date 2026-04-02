package utilities;


import exceptions.*;

/**
 * MyStackADT.java
 * 
 * @author Tessa Unrau
 * @version 1.1
 * @created March 16, 2026
 * @updated March 22, 2026 with additional documentation and more complete comparison methods
 * 
 * <p>
 * The <code>MyStackADT</code> interface is an iterable stack for use with <code>MyArrayList</code> as 
 * part of assignment 2 of CPRG 304-A winter 2026
 * </p>
 * <p>
 * <code>MyStackADT</code> represents a First In Last Out(FILO) stack of objects. It extends class Iterator with 10 methods 
 * allowing Iterator to be treated as a stack. Modification methods include push and pop to add and remove elements from 
 * the top of the stack respectively, clear to remove all elements from the stack, toArray to return a printable array
 * representation of the stack contents. Query methods include peek to view the top element, equals for comparing the stack
 * to another stack object, isEmpty and stackOverflow to test if the stack is empty or full respectively, size to test the 
 * number of elements contained in the stack and contains to assess the presence of an element and its relative position in
 * the stack. 
 * </p>
 * 
 * @param <E> the elements the stack contains.
 * 
 **/

public interface MyStackADT<E> extends Iterator<E> {
	
	
	// Constructor methods
	
	/**
	 * creates an empty MyStack object.
	 * 
	 * precondition: none.
	 * 
	 * postCondition: an empty MyStack object is created.
	 * 
	 * */
	public void stack();
	
	
//-----------------------------------------------------------------------------------------------
	
	// Query operations
	
	/**
	 * tests this stack's composition against a second stack to determine if it contains identical 
	 * elements in the same order.
	 * 
	 * precondition: two valid Stack objects exist.
	 * 
	 * postCondition: a boolean value representing the condition of the tested stacks.
	 * @param 
	 * 
	 * @param Object the second MyStack object this stack is being tested against.  
	 * @return true if the two objects are of identical composition, otherwise false.
	 * @exception InvalidArgumentException if Object argument is not of class MyStack.
	 * 
	 * */
	public boolean equals(Object stack);
	
	/**
	 * tests for and returns the position of the queried element relative to the top of this stack, with the top element 
	 * being assigned '1'. '-1' is returned if the queried element does not exist within this stack.
	 * 
	 * precondition: an existing MyStack object containing at least one element. 
	 * 
	 * postCondition: an integer value representing the stack position of the queried element.
	 * 
	 * @param E the element object whose presence and position are being tested.
	 * @return the stack position of the queried element as an integer value.
	 * 
	 * */
	public boolean contains(E element);
	
	
	/**
	 * tests if this stack contains no elements.
	 * 
	 * precondition: a valid MyStack object exists.
	 * 
	 * postCondition: condition of tested Stack.
	 * 
	 * @return true if no elements are contained in this stack, otherwise false.
	 * */
	public boolean isEmpty();
	
	
	/**
	 * returns the number of elements contained in this stack.
	 * 
	 * precondition: a valid MyStack object exists.
	 * 
	 * postCondition: an integer value representing the number of elements in the Stack object.
	 * 
	 * @return the number of stack elements as an integer value.
	 * 
	 * */
	public int size();
	
	/**
	 * returns the identity of the topmost element in this stack without removing it.
	 * 
	 * precondition: a valid MyStack object exists with at least one element in it.
	 * 
	 * postCondition: the element at the top of the stack.
	 * 
	 * @return an object representation of the element at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 * 
	 * */
	public E peek();
	
	/**
	 * tests if this stack is of fixed size and at capacity.
	 * 
	 * precondition: a valid Stack object exists.
	 * 
	 * postCondition: a boolean value representing the stack's capacity compared to its size().
	 * 
	 * @return true if this stack cannot accept additional elements, otherwise false.
	 * */
	public boolean stackOverflow();
	
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
	 * adds a new not-null element to the top of this stack.
	 * 
	 * precondition: a valid MyStack object exists.
	 * 
	 * postCondition: element E is now at the top of the stack.
	 * 
	 * @param E the element object to be added to the top of the stack.
	 * @throws NullPointerException if element is null.
	 * 
	 * */
	public void push(E element);
	
	/**
	 * removes the topmost element in the stack and returns its identity.
	 * 
	 * precondition: a valid MyStack object exists with at least one element.
	 * 
	 * postCondition: the element at the top of the stack.
	 * 
	 * @return an object representation of the element at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 * 
	 **/
	public E pop();
	
	/**
	 * returns an array object representing the elements in this stack in sequential order from the top.
	 * 
	 * precondition: a valid MyStack object exists.
	 * 
	 * postCondition: an array containing the stack elements with the topmost stack element in index [0].
	 * 
	 * @return an array object representing this stack in its current sequential order from top down.
	 * @throws EmptyStackException if the stack is empty.
	 * */
	public Object[] toArray();
	
	

}
