package models.layouts;

import interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String getLayout() {
        StringBuilder sb = new StringBuilder();

        sb.append("<log>")
                .append(System.lineSeparator())
                .append("<date>%s</date>")
                .append(System.lineSeparator())
                .append("<level>%s</level>")
                .append(System.lineSeparator())
                .append("<message>%s</message>")
                .append(System.lineSeparator())
                .append("</log>");

        return sb.toString();
    }
}
