package problem06.models;


import problem06.interfaces.LeutenantGeneral;
import problem06.interfaces.Private;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Set<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);

        this.privates = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private first, Private second) {
                return second.getId() - first.getId();
            }
        });
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Privates:");

        for (Private priv : this.privates) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(priv.toString());
        }

        return sb.toString();
    }
}
