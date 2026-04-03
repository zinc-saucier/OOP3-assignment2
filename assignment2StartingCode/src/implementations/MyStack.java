package implementations;

import java.util.EmptyStackException;

import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {

      private MyArrayList<E> list;

      public MyStack() {
            list = new MyArrayList<>();
      }

      @Override
      public void push(E toAdd) throws NullPointerException {
            if (toAdd == null)
                  throw new NullPointerException();
            list.add(toAdd);
      }

      @Override
      public E pop() throws EmptyStackException {
            if (isEmpty())
                  throw new EmptyStackException();
            return list.remove(size() - 1);
      }

      @Override
      public E peek() throws EmptyStackException {
            if (isEmpty())
                  throw new EmptyStackException();
            return list.get(size() - 1);
      }

      @Override
      public void clear() {
            list.clear();
      }

      @Override
      public boolean isEmpty() {
            return list.size() == 0;
      }

      @Override
      public Object[] toArray() {
          int n = list.size();
          Object[] result = new Object[n];
          for (int i = 0; i < n; i++)
              result[i] = list.get(n - 1 - i);
          return result;
      }
      
      @SuppressWarnings("unchecked")
      @Override
      public E[] toArray(E[] holder) throws NullPointerException {
          if (holder == null) throw new NullPointerException();
          int n = list.size();
          if (holder.length < n)
              holder = (E[]) java.util.Arrays.copyOf(holder, n, holder.getClass());
          for (int i = 0; i < n; i++)
              holder[i] = list.get(n - 1 - i);
          if (holder.length > n) holder[n] = null;
          return holder;
      }

      @Override
      public boolean contains(E toFind) throws NullPointerException {
            if (toFind == null)
                  throw new NullPointerException();
            return list.contains(toFind);
      }

      @Override
      public int search(E toFind) {
            if (toFind == null)
                  throw new NullPointerException();

            int position = 1;

            for (int i = size() - 1; i >= 0; i--) {
                  if (list.get(i).equals(toFind)) {
                        return position;
                  }
                  position++;
            }

            return -1;
      }

      @Override
      public Iterator<E> iterator() {
          return new MyStackIterator();
      }

      private class MyStackIterator implements Iterator<E> {
          private int cursor = list.size() - 1;

          @Override
          public boolean hasNext() { return cursor >= 0; }

          @Override
          public E next() {
              if (!hasNext()) throw new java.util.NoSuchElementException();
              return list.get(cursor--);
          }
      }

      @Override
      public boolean equals(StackADT<E> that) {
            if (that == null || this.size() != that.size())
                  return false;

            Iterator<E> it1 = this.iterator();
            Iterator<E> it2 = that.iterator();

            while (it1.hasNext()) {
                  if (!it1.next().equals(it2.next()))
                        return false;
            }

            return true;
      }

      @Override
      public int size() {
            return list.size();
      }

      @Override
      public boolean stackOverflow() {
            return false;
      }
}
