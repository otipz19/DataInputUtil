package DataInputUtil.main;

import java.util.Arrays;

public class OptionsReader {
    private boolean isStopped;
    private Option[] options;
    private Runnable prefix;

    public OptionsReader(Option... options) {
        processStopOptions(options);
    }

    public OptionsReader(Runnable prefix, Option... options) {
        processStopOptions(options);
        this.prefix = prefix;
    }

    private void processStopOptions(Option[] options) {
        for (Option o : options) {
            if (o instanceof StopOption so) {
                so.setStopReader(() -> isStopped = true);
            }
        }
        this.options = Arrays.copyOf(options, options.length);
    }

    public void readUntilStop() {
        readUntilStop(null);
    }

    public void readUntilStop(String title) {
        while (!isStopped) {
            if(title != null){
                System.out.println(title);
            }
            if (prefix == null) {
                ConsoleUtils.readOptions(options);
            } else {
                ConsoleUtils.readOptions(prefix, options);
            }
        }
    }
}
