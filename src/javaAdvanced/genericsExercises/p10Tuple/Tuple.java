package javaAdvanced.genericsExercises.p10Tuple;

public class Tuple<K, V> {
    private K firstElement;
    private V secondElement;

    public Tuple(K firstElement, V secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.firstElement, this.secondElement);
    }
}
