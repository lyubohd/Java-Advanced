package javaAdvanced.definingClassesExercises.p04RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tier[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public boolean hasTierWithLessPressureThanOne() {
        for (Tier tier : tiers) {
            if (tier.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
