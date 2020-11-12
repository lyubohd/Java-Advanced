package problem06.inputOutput;

import problem06.application.Army;
import problem06.interfaces.Soldier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriter {
    private BufferedWriter writer;

    public OutputWriter(OutputStreamWriter streamWriter) {
        this.writer = new BufferedWriter(streamWriter);
    }

    public void writeAll(Army army) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Soldier soldier : army.getSoldiers()) {
            sb.append(soldier.toString()).append(System.lineSeparator());
        }
        this.writer.write(sb.toString());
        this.writer.close();
    }
}
