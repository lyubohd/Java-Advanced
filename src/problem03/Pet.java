package problem03;

public class Pet implements Animal, Birthable {
    //Pet
    //-	name: String
    //-	birthDate: String
    //+	Pet(Stirng, String)
    //+	getName(): String
    //+	getBirthDate(): String

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
