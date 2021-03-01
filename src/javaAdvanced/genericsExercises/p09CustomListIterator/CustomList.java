package javaAdvanced.genericsExercises.p09CustomListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public int size() {
        return this.data.size();
    }

    public E get(int index) {
        return this.data.get(index);
    }

    public void swap(int index1, int index2) {
        E firstEl = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, firstEl);
    }

    public long countGreaterThan(E element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public E getMax() {
        E maxEl = null;
        if (!this.data.isEmpty()) {
            maxEl = this.data.get(0);
            for (E datum : this.data) {
                if (datum.compareTo(maxEl) > 0) {
                    maxEl = datum;
                }
            }
        }
        return maxEl;
    }

    public E getMin() {
        E minEl = null;
        if (!this.data.isEmpty()) {
            minEl = this.data.get(0);
            for (E datum : this.data) {
                if (datum.compareTo(minEl) < 0) {
                    minEl = datum;
                }
            }
        }

        return minEl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E value : this.data) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                E element = data.get(index);
                index++;
                return element;
            }
        };
    }
}
