package implementations;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * @author Tessa Unrau
 * @version 1.0
 * 
 * Class description: Implementation of ListADT interface as an ArrayList.
 * */

public class MyArrayList<E> implements ListADT<E>{
	
	private E[] list;
	
	/**
	 * Main constructor method for initializing a new MyArrayList.
	 * */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		super();
		this.list = (E[]) new Object[0];
	}

	/**
	 * The size method will return the current element count contained in the list.
	 * 
	 * @return The current element count.
	 */
	@Override
	public int size() {
		
		return list.length;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() { 
		this.list = (E[]) new Object[0];
	}

	/**
	 * Method to add an element to a specific index in a list. If the index is an
	 * index outside of the bounds of the list an exception is thrown
	 *
	 * @param toAdd element to be added to the list.
	 * @param index position that the element should be placed at.
	 * @return true if the element is added successfully.
	 * @throws IndexOutOfBoundsException when the index is
	 *                                   <code>(index < 0 || index > size)</code>
	 * @throws NullPointerException if the element to be added is null
	 */
	
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		boolean status = false;
		if( toAdd == null )
		{
			throw new NullPointerException( "Cannot store an null" );
		}
		if( index < 0 || index > size() )
		{
			throw new IndexOutOfBoundsException( "Index is outside current list boundary '" + index + "'" );
		}

			list[index] = toAdd;
			status=true;
		return status;
	}

	/**
	 * Method to add an element to the end of a List. If the list is empty the
	 * element will be added to the first position.
	 *
	 * @param toAdd - element to be added to the list
	 * @return <code>true</code> if the element is appended successfully.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		
		if( toAdd == null )
		{
			throw new NullPointerException( "Cannot store an null" );
		}
		//increase size of array by 1, add new element to final index position
		E[] temp = (E[]) new Object[size()+1];
		for (int i = 0 ; i < size() ; i++) {
			temp[i] = list[i];
		}
		this.list = temp;
		return add( size()-1, toAdd);
		
	}

	/**
	 * Appends all of the elements in the specified <code>java.utilCollection</code>
	 * to the end of this list, in the order that they are returned by the specified
	 * collection's <code>Iterator</code>. The behaviour of this operation is
	 * unspecified if the specified collection is modified while the operation is in
	 * progress. (Note that this will occur if the specified collection is this
	 * list, and it's nonempty.)
	 * 
	 * @param toAdd The new sub list to be added.
	 * @return true If the operation is successful.
	 * @throws NullPointerException If the specified element is <code>null</code>
	 *                              and the list implementation does not support
	 *                              having <code>null</code> elements.
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		
		if( toAdd == null )
		{
			throw new NullPointerException( "Cannot add a null list" );
		}

		for( int i = 0; i < toAdd.size(); i++ )
		{
			this.add( toAdd.get( i ) );
		}
		return true;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index Index of element to return.
	 * @return The element at the specified position in this list.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e.
	 *                                   (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		return this.list[index];
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 * 
	 * @param index The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e.
	 *                                   (<code>index < 0 || index >= size()</code>).
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if( index < 0 || index >= size() )
		{
			throw new IndexOutOfBoundsException(
					"The index is outside the bounds of the current list : index = " + index );
		}
		E deleted = list[index];
		E[] temp = (E[]) new Object[size()-1]; 
		for (int i =0 ; i< index ; i++) {
			
			temp[i] = list[i];
			
		}
		for (int i = index; i < temp.length ; i++) {
			temp[i] = list[i+1];
		}
		
		this.list = temp;
		
		return deleted;
	}

	/**
	 * Removes the first occurrence in this list of the specified element. If this
	 * list does not contain the element, it is unchanged. More formally, removes
	 * the element with the lowest index <code>i</code> such that
	 * <code>o.equals(get(i))</code> (if such an element exists).
	 * 
	 * @param toRemove The element to be removed from this list.
	 * @return The element which is being removed, or null if the list does not
	 *         contain the element.
	 * @throws NullPointerException If the specified element is <code>null</code>
	 *                              and the list implementation does not support
	 *                              having <code>null</code> elements.
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		
		if( toRemove == null )
		{
			throw new NullPointerException( "Cannot remove null target from list" );
		}
		if (contains(toRemove)) {
			for (int i = 0 ; i < size() ; i++) {
				if(list[i] == toRemove) {
					return remove(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index    The index of the element to replace.
	 * @param toChange Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException      If the specified element is
	 *                                   <code>null</code> and the list
	 *                                   implementation does not support having
	 *                                   <code>null</code> elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e.
	 *                                   (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if( toChange == null )
		{
			throw new NullPointerException( "Cannot store an null" );
		}
		if( index < 0 || index >= size() )
		{
			throw new IndexOutOfBoundsException(
					"The index is outside the bounds of the current list : index = " + index );
		}
		E old = list[index];

		if( !isEmpty() )
		{
			list[index] = toChange;
		}
		else
		{
			old = null;
		}
		return old;
	}
	
	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		
		return size() == 0;
	}
	
	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element
	 * <code>e</code> such that <code>toFind.equals(e)</code>.
	 * 
	 * @param toFind The element whose presence in this list is to be tested.
	 * @return <code>true</code> if this list contains the specified element.
	 * @throws NullPointerException If the specified element is <code>null</code>
	 *                              and the list implementation does not support
	 *                              having <code>null</code> elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException("Cannot search for null.");
		}
		for (E index : list) {
			if (index == toFind) {
				return true;
			}
		}
		return false;
		
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param toHold The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException If the specified array is <code>null</code>.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if( toHold == null )
		{
			throw new NullPointerException( "Cannot copy to a null array." );
		}

		if( toHold.length < this.size() )
		{
			toHold = Arrays.copyOf( toHold, this.size() );
		}
		for (int i = 0 ; i < size() ; i++) {
			toHold[i] = list[i];
		}
		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public Object[] toArray() {
		
		Object[] toReturn = new Object[this.size()];
		for (int i = 0 ; i < size() ; i++) {
			toReturn[i] = list[i];
		}
		return toReturn;
	}
	
	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence. NB:
	 *         The return is of type <code>linearUtilities.Iterator<E></code>, not
	 *         <code>java.util.Iterator</code>.
	 */
	@Override
	public Iterator<E> iterator() {
		
		return new MyArrayListIterator();
	}
	
	
	public void print() {
		for (int i = 0 ; i < list.length ; i++) {
			System.out.println("item in index " + i + " is: " + list[i]);
		}
	}

	/*******************************
	 * INNER CLASSES
	 *********************************/
	private class MyArrayListIterator implements Iterator<E>
	{
		// Attributes
		private E[] copyOfElements;
		private int pos;
		

		// Constructor
		@SuppressWarnings( "unchecked" )
		public MyArrayListIterator()
		{
			copyOfElements = (E[]) ( new Object[size()] );
		
			
			// "safe" implementation - snapshot of the list to be used for traversal
			for( int i = 0; i < list.length; i++ )
			{
				copyOfElements[i] = get(i);
			}
		}

		/**
		 * Returns <code>true</code> if the iteration has more elements. (In other
		 * words, returns <code>true</code> if <code>next()</code> would return an
		 * element rather than throwing an exception.)
		 * 
		 * @return <code>true</code> if the iterator has more elements.
		 */
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if( copyOfElements.length == 0 ) throw new NoSuchElementException();
			
			E toReturn = copyOfElements[pos];
			pos++;
			return toReturn;
		}
	}		
	

}
