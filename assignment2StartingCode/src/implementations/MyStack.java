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
            return list.toArray();
      }

      @Override
      public E[] toArray(E[] holder) throws NullPointerException {
            return list.toArray(holder);
      }

      @Override
      public boolean contains(E toFind) throws NullPointerException {
            if (toFind == null)
                  throw new NullPointerException();
            return list.contains(toFind);
      }

      // ✅ FIXED SEARCH METHOD (ONLY ONE)
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
            return list.iterator();
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