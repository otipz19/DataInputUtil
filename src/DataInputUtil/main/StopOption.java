package DataInputUtil.main;

public class StopOption extends Option{
    private Runnable stopReader;

    public StopOption(String prompt){
        super(prompt, () -> {});
    }

    public StopOption(String prompt, Runnable action) {
        super(prompt, action);
    }

    void setStopReader(Runnable stopReader){
        this.stopReader = stopReader;
    }

    @Override
    public void run(){
        super.run();
        stopReader.run();
    }
}
