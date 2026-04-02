package implementations;

import utilities.ListADT;

import java.util.NoSuchElementException;

import java.util.Iterator;

/**
 * Doubly Linked List implementation of the ListADT interface.
 *
 * This class supports insertion, removal, and traversal of elements
 * using a doubly linked structure with head and tail references.
 *
 * @param <T> the type of elements stored in the list
 */

public class MyDLL<T> implements ListADT<T> {

      private MyDLLNode<T> head;

      private MyDLLNode<T> tail;

      private int size;

      public MyDLL() {

            head = null;

            tail = null;

            size = 0;

      }

      /**
       * Adds an element to the end of the list.
       *
       * @param element the element to be added
       * @throws NullPointerException if the element is null
       */

      @Override

      public void add(T element) {

            if (element == null)
                  throw new NullPointerException("Cannot add null element");

            MyDLLNode<T> newNode = new MyDLLNode<>(element);

            if (isEmpty()) {

                  head = tail = newNode;

            } else {

                  tail.setNext(newNode);

                  newNode.setPrev(tail);

                  tail = newNode;

            }

            size++;

      }

      /**
       * Inserts an element at a specified position in the list.
       *
       * @param index   the position to insert the element
       * @param element the element to be added
       * @throws NullPointerException      if the element is null
       * @throws IndexOutOfBoundsException if index is invalid
       */

      @Override

      public void add(int index, T element) {

            if (element == null)
                  throw new NullPointerException("Cannot add null element");

            if (index < 0 || index > size)
                  throw new IndexOutOfBoundsException();

            MyDLLNode<T> newNode = new MyDLLNode<>(element);

            if (index == size) {

                  add(element);

                  return;

            }

            if (index == 0) {

                  newNode.setNext(head);

                  if (head != null)
                        head.setPrev(newNode);

                  head = newNode;

                  if (tail == null)
                        tail = head;

            } else {

                  MyDLLNode<T> current = getNodeAt(index);

                  MyDLLNode<T> prev = current.getPrev();

                  prev.setNext(newNode);

                  newNode.setPrev(prev);

                  newNode.setNext(current);

                  current.setPrev(newNode);

            }

            size++;

      }

      /**
       * Removes and returns the element at the specified position.
       *
       * @param index the position of the element to remove
       * @return the removed element
       * @throws NoSuchElementException    if the list is empty
       * @throws IndexOutOfBoundsException if index is invalid
       */

      @Override

      public T remove(int index) {

            if (isEmpty())
                  throw new NoSuchElementException("List is empty");

            if (index < 0 || index >= size)
                  throw new IndexOutOfBoundsException();

            MyDLLNode<T> current = getNodeAt(index);

            T removed = current.getElement();

            if (current == head && current == tail) {

                  head = tail = null;

            } else if (current == head) {

                  head = head.getNext();

                  head.setPrev(null);

            } else if (current == tail) {

                  tail = tail.getPrev();

                  tail.setNext(null);

            } else {

                  MyDLLNode<T> prev = current.getPrev();

                  MyDLLNode<T> next = current.getNext();

                  prev.setNext(next);

                  next.setPrev(prev);

            }

            size--;

            return removed;

      }

      /**
       * Removes the first occurrence of the specified element.
       *
       * @param element the element to remove
       * @return true if the element was found and removed, false otherwise
       */

      @Override

      public boolean remove(T element) {

            if (isEmpty())
                  return false;

            MyDLLNode<T> current = head;

            while (current != null) {

                  if ((element == null && current.getElement() == null) ||
                              (element != null && element.equals(current.getElement()))) {

                        if (current == head) {

                              head = head.getNext();

                              if (head != null)
                                    head.setPrev(null);

                        } else if (current == tail) {

                              tail = tail.getPrev();

                              if (tail != null)
                                    tail.setNext(null);

                        } else {

                              current.getPrev().setNext(current.getNext());

                              current.getNext().setPrev(current.getPrev());

                        }

                        size--;

                        return true;

                  }

                  current = current.getNext();

            }

            return false;

      }

      /**
       * Returns the element at the specified position.
       *
       * @param index the position of the element
       * @return the element at the given index
       * @throws IndexOutOfBoundsException if index is invalid
       */

      @Override

      public T get(int index) {

            if (index < 0 || index >= size)
                  throw new IndexOutOfBoundsException();

            return getNodeAt(index).getElement();

      }

      private MyDLLNode<T> getNodeAt(int index) {

            MyDLLNode<T> current;

            if (index < size / 2) {

                  current = head;

                  for (int i = 0; i < index; i++)
                        current = current.getNext();

            } else {

                  current = tail;

                  for (int i = size - 1; i > index; i--)
                        current = current.getPrev();

            }

            return current;

      }

      /**
       * Checks if the list is empty.
       *
       * @return true if the list contains no elements
       */

      @Override

      public boolean isEmpty() {

            return size == 0;

      }

      /**
       * Returns the number of elements in the list.
       *
       * @return the size of the list
       */

      @Override

      public int size() {

            return size;

      }

      /**
       * Removes all elements from the list.
       */

      @Override

      public void clear() {

            head = tail = null;

            size = 0;

      }

      @Override

      public String toString() {

            StringBuilder sb = new StringBuilder("[");

            MyDLLNode<T> current = head;

            while (current != null) {

                  sb.append(current.getElement());

                  if (current.getNext() != null)
                        sb.append(", ");

                  current = current.getNext();

            }

            sb.append("]");

            return sb.toString();

      }

      /**
       * Returns an iterator over the elements in the list.
       *
       * @return an iterator for the list
       */
      @Override

      public Iterator<T> iterator() {

            return new Iterator<T>() {

                  private MyDLLNode<T> current = head;

                  @Override

                  public boolean hasNext() {

                        return current != null;

                  }

                  @Override

                  public T next() {

                        if (!hasNext())
                              throw new NoSuchElementException();

                        T data = current.getElement();

                        current = current.getNext();

                        return data;

                  }

            };

      }

}