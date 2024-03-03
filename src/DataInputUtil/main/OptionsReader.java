package DataInputUtil.main;

import java.util.Arrays;

public class OptionsReader {
    private boolean isStopped;
    private final Option[] options;

    public OptionsReader(Option... options){
        for(Option o: options){
            if(o instanceof StopOption so){
                so.setStopReader(() -> isStopped = true);
            }
        }
        this.options = Arrays.copyOf(options, options.length);
    }

    public void readUntilStop(){
        while(!isStopped){
            ConsoleUtils.readOptions(options);
        }
    }

    public void readUntilStop(String title){
        System.out.println(title);
        readUntilStop();
    }
}
