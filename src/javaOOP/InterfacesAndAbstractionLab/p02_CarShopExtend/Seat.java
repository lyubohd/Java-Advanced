package javaOOP.InterfacesAndAbstractionLab.p02_CarShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String result = String.format("%s%n%s sells for %f", super.toString(), this.getModel(), this.getPrice());
        return result;
    }
}
