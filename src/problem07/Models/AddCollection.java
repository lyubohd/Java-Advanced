package problem07.Models;

import problem07.Interfaces.Addable;

public class AddCollection extends Collection implements Addable {
    public int add(String item) {
        this.items.add(item);
        return this.items.size() - 1;
    }
}
