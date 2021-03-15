package logger.model.layouts;


import logger.api.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
