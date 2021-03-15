package logger.api;


import logger.enums.ReportLevel;

public interface Appender {
    void appendMessage(String datetime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
