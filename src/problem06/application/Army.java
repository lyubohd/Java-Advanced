package problem06.application;

import problem06.interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(Soldier soldier) {
        this.soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return this.soldiers;
    }
}
