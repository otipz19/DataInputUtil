package DataInputUtil.main;

import java.util.function.Supplier;

public class ReturnableOption<T> implements IOption{
    private String prompt;
    private Supplier<T> action;

    public ReturnableOption(String prompt, Supplier<T> action) {
        this.prompt = prompt;
        this.action = action;
    }

    public T run(){
        return action.get();
    }

    public String getPrompt() {
        return prompt;
    }
}
