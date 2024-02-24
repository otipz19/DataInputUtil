package DataInputUtil.main;

public class ConsoleUtils {
    public static void runProcessUntilStop(String stopWord, Runnable process){
        while(true){
            process.run();
            String input = ConsoleDataReader.getLineLn("Input '" + stopWord + "' to stop");
            if(input.equals(stopWord)){
                break;
            }
        }
    }

    public static void readOptions(Option... options){
        printPrompts(options);
        while(true){
            int inputIndex = ConsoleDataReader.getInt("Choose option: ");
            if(inputIndex <= 0 || inputIndex > options.length){
                System.out.println("Invalid option!");
            }
            else{
                options[inputIndex - 1].run();
                return;
            }
        }
    }

    public static <T> T readOptions(ReturnableOption<T>... options){
        printPrompts(options);
        while(true){
            int inputIndex = ConsoleDataReader.getInt("Choose option: ");
            if(inputIndex <= 0 || inputIndex > options.length){
                System.out.println("Invalid option!");
            }
            else{
                return options[inputIndex - 1].run();
            }
        }
    }

    private static void printPrompts(IOption[] options) {
        for(int i = 0; i < options.length; i++){
            System.out.println((i+1) + ". " + options[i].getPrompt());
        }
    }
}
