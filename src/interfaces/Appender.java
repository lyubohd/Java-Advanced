package interfaces;

import enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
