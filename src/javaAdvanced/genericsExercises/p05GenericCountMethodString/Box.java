package javaAdvanced.genericsExercises.p05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public void swap(int index1, int index2) {
        T firstEl = this.values.get(index1);
        this.values.set(index1, this.values.get(index2));
        this.values.set(index2, firstEl);
    }

    public long countGreaterElements(T toCompare) {
        return this.values.stream().filter(e -> e.compareTo(toCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
