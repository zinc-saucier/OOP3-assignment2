package implementations;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;

/**
 * MyStack is an implementation of StackADT using MyArrayList as the
 * underlying data structure. The top of the stack is the last element
 * in the list (highest index), giving O(1) push and pop.
 *
 * Pre-conditions:  Elements pushed onto the stack must not be null.
 * Post-conditions: Elements are returned in LIFO order. The stack grows
 *                  dynamically with no fixed capacity.
 *
 * @author Seksan Wangkhiree
 * @version 1.0
 * 
 * MyStack is an implementation of the StackADT interface using MyArrayList
 * as the underlying data structure. It follows LIFO (Last-In, First-Out)
 * ordering, where the last element pushed is the first element popped.
 *
 * In the XML parser, MyStack tracks opening tags as the document is read.
 * Opening tags are pushed onto the stack and compared against closing tags
 * by popping from the top, verifying the XML is properly nested.
 * 
 */
public class MyStack<E> implements StackADT<E>
{
	/** The backing list — top of stack = last element (index size-1) */
	private MyArrayList<E> list;

	/**
	 * Constructs an empty stack.
	 */
	public MyStack()
	{
		list = new MyArrayList<>();
	}

	/**
	 * Pushes an element onto the top of the stack.
	 * The element is appended to the end of the backing list.
	 *
	 * Pre-condition:  toAdd is not null.
	 * Post-condition: toAdd is at the top; size increases by 1.
	 *
	 * @param toAdd the element to push
	 * @throws NullPointerException if toAdd is null
	 */
	@Override
	public void push( E toAdd ) throws NullPointerException
	{
		if ( toAdd == null )
			throw new NullPointerException( "Cannot push null onto the stack." );
		list.add( toAdd );
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * The top is the last element in the backing list.
	 *
	 * Pre-condition:  Stack is not empty.
	 * Post-condition: Top element is removed; size decreases by 1.
	 *
	 * @return the element that was on top
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E pop() throws EmptyStackException
	{
		if ( isEmpty() )
			throw new EmptyStackException();
		return list.remove( list.size() - 1 );
	}

	/**
	 * Returns the top element without removing it.
	 *
	 * Pre-condition:  Stack is not empty.
	 * Post-condition: Stack is unchanged.
	 *
	 * @return the element at the top
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E peek() throws EmptyStackException
	{
		if ( isEmpty() )
			throw new EmptyStackException();
		return list.get( list.size() - 1 );
	}

	/**
	 * Removes all elements from the stack.
	 *
	 * Post-condition: Stack is empty.
	 */
	@Override
	public void clear()
	{
		list.clear();
	}

	/**
	 * Returns true if the stack contains no elements.
	 *
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	/**
	 * Returns an array of all elements ordered top to bottom.
	 * Index 0 holds the top element; last index holds the bottom.
	 *
	 * @return Object array from top to bottom
	 */
	@Override
	public Object[] toArray()
	{
		int n = list.size();
		Object[] result = new Object[n];
		for ( int i = 0; i < n; i++ )
			result[i] = list.get( n - 1 - i ); // reverse: top first
		return result;
	}

	/**
	 * Returns a typed array of all elements ordered top to bottom.
	 * Index 0 holds the top element; last index holds the bottom.
	 *
	 * @param toHold the target array; a new array is created if too small
	 * @return typed array from top to bottom
	 * @throws NullPointerException if toHold is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray( E[] toHold ) throws NullPointerException
	{
		if ( toHold == null )
			throw new NullPointerException( "Holder array cannot be null." );
		int n = list.size();
		if ( toHold.length < n )
			toHold = (E[]) Arrays.copyOf( toHold, n, toHold.getClass() );
		for ( int i = 0; i < n; i++ )
			toHold[i] = list.get( n - 1 - i ); // reverse: top first
		if ( toHold.length > n )
			toHold[n] = null;
		return toHold;
	}

	/**
	 * Returns true if the stack contains the specified element.
	 *
	 * @param toFind the element to search for; must not be null
	 * @return true if found
	 * @throws NullPointerException if toFind is null
	 */
	@Override
	public boolean contains( E toFind ) throws NullPointerException
	{
		if ( toFind == null )
			throw new NullPointerException( "Cannot search for null in the stack." );
		return list.contains( toFind );
	}

	/**
	 * Returns the 1-based position from the top of the stack.
	 * The top element is at position 1.
	 *
	 * @param toFind the element to locate
	 * @return 1-based distance from top, or -1 if not found
	 */
	@Override
	public int search( E toFind )
	{
		for ( int i = list.size() - 1; i >= 0; i-- )
		{
			if ( list.get( i ).equals( toFind ) )
				return list.size() - i; // 1-based from top
		}
		return -1;
	}

	/**
	 * Returns an iterator over elements from top to bottom.
	 * The first call to next() returns the top element.
	 *
	 * @return Iterator from top to bottom
	 */
	@Override
	public Iterator<E> iterator()
	{
		return new MyStackIterator();
	}

	/**
	 * Two stacks are equal if they contain the same elements in the same order.
	 *
	 * @param that the stack to compare against
	 * @return true if both stacks are equal
	 */
	@Override
	public boolean equals( StackADT<E> that )
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
	 * Returns the number of elements in the stack.
	 *
	 * @return element count
	 */
	@Override
	public int size()
	{
		return list.size();
	}

	/**
	 * Always returns false — this stack has no fixed capacity.
	 *
	 * @return false
	 */
	@Override
	public boolean stackOverflow()
	{
		return false;
	}

	/**
	 * Iterator that walks the stack from top to bottom.
	 * Starts at the last element of the backing list (top of stack)
	 * and moves toward index 0 (bottom of stack).
	 */
	private class MyStackIterator implements Iterator<E>
	{
		/** Current position; starts at top (size-1) and decrements */
		private int cursor;

		/**
		 * Constructs iterator starting at the top of the stack.
		 */
		public MyStackIterator()
		{
			cursor = list.size() - 1;
		}

		/**
		 * Returns true if there are more elements to visit.
		 *
		 * @return true if cursor is still within bounds
		 */
		@Override
		public boolean hasNext()
		{
			return cursor >= 0;
		}

		/**
		 * Returns the next element, moving from top toward bottom.
		 *
		 * @return the next element
		 * @throws NoSuchElementException if no more elements remain
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if ( !hasNext() )
				throw new NoSuchElementException( "No more elements in the stack." );
			return list.get( cursor-- );
		}
	}
}