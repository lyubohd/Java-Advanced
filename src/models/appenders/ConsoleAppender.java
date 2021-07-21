package models.appenders;

import interfaces.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    protected void append(String text) {
        System.out.println(text);
    }
}
