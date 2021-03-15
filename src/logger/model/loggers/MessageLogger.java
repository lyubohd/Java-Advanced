package logger.model.loggers;

import logger.api.Appender;
import logger.api.Logger;
import logger.enums.ReportLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new Appender[appenders.length];
        for (int i = 0; i < appenders.length; i++) {
            this.appenders[i] = appenders[i];
        }
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.FATAL, message);
    }

    private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, reportLevel, message);
        }
    }

    @Override
    public String getLogInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            sb.append(appender).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
