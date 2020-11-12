package problem07.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int MaxSize = 100;
    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<String>(MaxSize);
    }
}
