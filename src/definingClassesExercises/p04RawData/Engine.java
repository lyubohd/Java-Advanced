package definingClassesExercises.p04RawData;

public class Engine {
    // <EngineSpeed> <EnginePower>
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return this.enginePower;
    }
}
