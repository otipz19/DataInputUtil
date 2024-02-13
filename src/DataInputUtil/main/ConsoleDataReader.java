package DataInputUtil.main;

/**
 * Static adapter for StreamDataReader
 */
public class ConsoleDataReader {
    private static final StreamDataReader streamDataReader = new StreamDataReader(System.in);

    public static double getNotNegativeNumber(String prompt){
        System.out.println(prompt);
        return getNotNegativeNumber();
    }

    public static double getNegativeNumber(String prompt){
        System.out.println(prompt);
        return getNegativeNumber();
    }

    public static double getDouble(String prompt){
        System.out.println(prompt);
        return getDouble();
    }

    public static long getLong(String prompt) {
        System.out.println(prompt);
        return getLong();
    }

    public static char getChar(String prompt) {
        System.out.println(prompt);
        return getChar();
    }

    public static int getInt(String prompt) {
        System.out.println(prompt);
        return getInt();
    }

    public static String getLine(String prompt) {
        System.out.println(prompt);
        return getLine();
    }

    public static double getNotNegativeNumber(){
        return streamDataReader.getNotNegativeNumber();
    }

    public static double getNegativeNumber(){
        return streamDataReader.getNegativeNumber();
    }

    public static double getDouble(){
        return streamDataReader.getDouble();
    }

    public static long getLong() {
        return streamDataReader.getLong();
    }

    public static char getChar() {
        return streamDataReader.getChar();
    }

    public static int getInt() {
        return streamDataReader.getInt();
    }

    public static String getLine() {
        return streamDataReader.getLine();
    }
}
