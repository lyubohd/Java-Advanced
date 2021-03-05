package javaOOP.InterfacesAndAbstractionLab.p02_CarShopExtend;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, Integer minRentDay,
                Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String result = String.format("%s%nMinimum rental period of %d days. Price per day %f",
                super.toString(),
                this.getMinRentDay(),
                this.getPricePerDay());
        return result;
    }
}
