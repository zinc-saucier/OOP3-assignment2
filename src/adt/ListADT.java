package adt;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {

      void add(T element);

      void add(int index, T element);

      T remove(int index);

      boolean remove(T element);

      T get(int index);

      boolean isEmpty();

      int size();

      void clear();

      Iterator<T> iterator();
}