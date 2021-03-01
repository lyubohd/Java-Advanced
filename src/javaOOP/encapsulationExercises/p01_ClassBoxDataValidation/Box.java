package javaOOP.encapsulationExercises.p01_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isPositiveOrBiggerThanZero(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (isPositiveOrBiggerThanZero(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isPositiveOrBiggerThanZero(height)) {
            this.height = height;
        }
    }

    private boolean isPositiveOrBiggerThanZero(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        return true;
    }

    public double calculateSurfaceArea() {
        double surfaceArea = (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
        return surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        double lateralSurfaceArea = (2 * this.length * this.height) + (2 * this.width * this.height);
        return lateralSurfaceArea;
    }

    public double calculateVolume() {
        double volume = this.length * this.width * this.height;
        return volume;
    }
}
