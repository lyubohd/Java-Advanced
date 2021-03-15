package logger.api;

public interface File {
    int getSize();

    void write(String message);
}
