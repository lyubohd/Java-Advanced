package javaAdvanced.genericsExercises.p11Threeuple;

public class Threeuple<K, V, V1> {
    private K firstElement;
    private V secondElement;
    private V1 thirdElement;

    public Threeuple(K firstElement, V secondElement, V1 thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstElement, this.secondElement, this.thirdElement);
    }
}
