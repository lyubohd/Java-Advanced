package models.layouts;

import interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
