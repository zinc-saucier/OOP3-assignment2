package implementations;

import utilities.Iterator;
import java.util.NoSuchElementException;

import utilities.ListADT;

public class MyDLL<E> implements ListADT<E> {

      private static class Node<E> {
            E data;
            Node<E> next;
            Node<E> prev;

            Node(E data) {
                  this.data = data;
            }
      }

      private Node<E> head;
      private Node<E> tail;
      private int size;

      public MyDLL() {
            head = null;
            tail = null;
            size = 0;
      }

      // =========================
      // HELPER METHODS
      // =========================

      private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                  throw new IndexOutOfBoundsException();
            }
      }

      private void checkIndexAdd(int index) {
            if (index < 0 || index > size) {
                  throw new IndexOutOfBoundsException();
            }
      }

      private Node<E> getNode(int index) {
            checkIndex(index);

            Node<E> current;

            if (index < size / 2) {
                  current = head;
                  for (int i = 0; i < index; i++) {
                        current = current.next;
                  }
            } else {
                  current = tail;
                  for (int i = size - 1; i > index; i--) {
                        current = current.prev;
                  }
            }

            return current;
      }

      // =========================
      // CORE METHODS
      // =========================

      @Override
      public int size() {
            return size;
      }

      @Override
      public void clear() {
            head = null;
            tail = null;
            size = 0;
      }

      @Override
      public boolean add(E data) {
            if (data == null)
                  throw new NullPointerException();

            Node<E> newNode = new Node<>(data);

            if (isEmpty()) {
                  head = tail = newNode;
            } else {
                  tail.next = newNode;
                  newNode.prev = tail;
                  tail = newNode;
            }

            size++;
            return true;
      }

      @Override
      public boolean add(int index, E data) {
            if (data == null)
                  throw new NullPointerException();
            checkIndexAdd(index);

            if (index == size) {
                  return add(data);
            }

            Node<E> newNode = new Node<>(data);

            if (index == 0) {
                  newNode.next = head;
                  head.prev = newNode;
                  head = newNode;
            } else {
                  Node<E> current = getNode(index);
                  Node<E> prev = current.prev;

                  newNode.next = current;
                  newNode.prev = prev;

                  prev.next = newNode;
                  current.prev = newNode;
            }

            size++;
            return true;
      }

      @Override
      public boolean addAll(ListADT<? extends E> toAdd) {
            if (toAdd == null)
                  throw new NullPointerException();

            Iterator<? extends E> it = toAdd.iterator();
            while (it.hasNext()) {
                  add(it.next());
            }
            return true;
      }

      @Override
      public E get(int index) {
            return getNode(index).data;
      }

      @Override
      public E remove(int index) {
            Node<E> node = getNode(index);
            E data = node.data;

            Node<E> prev = node.prev;
            Node<E> next = node.next;

            if (prev == null)
                  head = next;
            else
                  prev.next = next;

            if (next == null)
                  tail = prev;
            else
                  next.prev = prev;

            size--;
            return data;
      }

      @Override
      public E remove(E data) {
            if (data == null)
                  throw new NullPointerException();

            Node<E> current = head;
            int index = 0;

            while (current != null) {
                  if (current.data.equals(data)) {
                        return remove(index);
                  }
                  current = current.next;
                  index++;
            }

            return null;
      }

      @Override
      public E set(int index, E data) {
            if (data == null)
                  throw new NullPointerException();

            Node<E> node = getNode(index);
            E old = node.data;
            node.data = data;
            return old;
      }

      @Override
      public boolean isEmpty() {
            return size == 0;
      }

      @Override
      public boolean contains(E data) {
            if (data == null)
                  throw new NullPointerException();

            Node<E> current = head;
            while (current != null) {
                  if (current.data.equals(data))
                        return true;
                  current = current.next;
            }
            return false;
      }

      // =========================
      // EXTRA METHODS (IMPORTANT)
      // =========================

      public void addFirst(E data) {
            add(0, data);
      }

      public void addLast(E data) {
            add(data);
      }

      public E removeFirst() {
            return remove(0);
      }

      public E removeLast() {
            return remove(size - 1);
      }

      public E getFirst() {
            return get(0);
      }

      public E getLast() {
            return get(size - 1);
      }

      public int indexOf(E data) {
            if (data == null)
                  throw new NullPointerException();

            Node<E> current = head;
            int index = 0;

            while (current != null) {
                  if (current.data.equals(data))
                        return index;
                  current = current.next;
                  index++;
            }

            return -1;
      }

      // =========================
      // ARRAY METHODS
      // =========================

      @Override
      public Object[] toArray() {
            Object[] arr = new Object[size];

            Node<E> current = head;
            int i = 0;

            while (current != null) {
                  arr[i++] = current.data;
                  current = current.next;
            }

            return arr;
      }

      @SuppressWarnings("unchecked")
      @Override
      public E[] toArray(E[] holder) {
            if (holder == null)
                  throw new NullPointerException();

            if (holder.length < size) {
                  holder = (E[]) java.lang.reflect.Array
                              .newInstance(holder.getClass().getComponentType(), size);
            }

            Node<E> current = head;
            int i = 0;

            while (current != null) {
                  holder[i++] = current.data;
                  current = current.next;
            }

            return holder;
      }

      // =========================
      // ITERATOR
      // =========================

      @Override
      public Iterator<E> iterator() {
            return new Iterator<E>() {

                  private Node<E> current = head;

                  @Override
                  public boolean hasNext() {
                        return current != null;
                  }

                  @Override
                  public E next() {
                        if (!hasNext()) {
                              throw new NoSuchElementException();
                        }

                        E data = current.data;
                        current = current.next;
                        return data;
                  }
            };
      }
}