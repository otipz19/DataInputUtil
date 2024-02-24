package DataInputUtil.main;

public class Option implements IOption{
    private String prompt;
    private Runnable action;

    public Option(String prompt, Runnable action) {
        this.prompt = prompt;
        this.action = action;
    }

    public void run(){
        action.run();
    }

    public String getPrompt() {
        return prompt;
    }
}
