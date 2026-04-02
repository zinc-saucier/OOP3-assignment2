package implementations;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

public class MyQueue<E> implements QueueADT<E> {

      private MyDLL<E> list;

      public MyQueue() {
            list = new MyDLL<>();
      }

      @Override
      public void enqueue(E toAdd) throws NullPointerException {
            if (toAdd == null)
                  throw new NullPointerException();
            list.addLast(toAdd);
      }

      @Override
      public E dequeue() throws EmptyQueueException {
            if (isEmpty())
                  throw new EmptyQueueException();
            return list.removeFirst();
      }

      @Override
      public E peek() throws EmptyQueueException {
            if (isEmpty())
                  throw new EmptyQueueException();
            return list.getFirst();
      }

      @Override
      public void dequeueAll() {
            list.clear();
      }

      @Override
      public boolean isEmpty() {
            return list.size() == 0;
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

            int index = list.indexOf(toFind);
            return (index == -1) ? -1 : index + 1;
      }

      @Override
      public Iterator<E> iterator() {
            return list.iterator();
      }

      @Override
      public boolean equals(QueueADT<E> that) {
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
      public Object[] toArray() {
            return list.toArray();
      }

      @Override
      public E[] toArray(E[] holder) throws NullPointerException {
            return list.toArray(holder);
      }

      @Override
      public boolean isFull() {
            return false;
      }

      @Override
      public int size() {
            return list.size();
      }
}