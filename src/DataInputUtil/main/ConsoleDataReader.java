package DataInputUtil.main;

/**
 * Static adapter for StreamDataReader
 */
public class ConsoleDataReader {
    private static final StreamDataReader streamDataReader = new StreamDataReader(System.in);

    //NotNegative
    public static double getNotNegativeNumber() {
        return getNotNegativeNumber("");
    }

    public static double getNotNegativeNumberLn() {
        return getNotNegativeNumberLn("");
    }

    public static double getNotNegativeNumberLn(String prompt) {
        return getNotNegativeNumber(prompt + "\n");
    }

    public static double getNotNegativeNumber(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getNotNegativeNumber();
    }

    //Negative
    public static double getNegativeNumberLn() {
        return getNegativeNumberLn("");
    }

    public static double getNegativeNumber() {
        return getNegativeNumber("");
    }

    public static double getNegativeNumberLn(String prompt) {
        return getNegativeNumber(prompt + "\n");
    }

    public static double getNegativeNumber(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getNegativeNumber();
    }

    //Double
    public static double getDouble() {
        return getDouble("");
    }

    public static double getDoubleLn() {
        return getDoubleLn("");
    }

    public static double getDoubleLn(String prompt) {
        return getDouble(prompt + "\n");
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getDouble();
    }

    //Long
    public static long getLong() {
        return getLong("");
    }

    public static long getLongLn() {
        return getLongLn("");
    }

    public static long getLongLn(String prompt) {
        return getLong(prompt + "\n");
    }

    public static long getLong(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getLong();
    }

    //Char
    public static char getChar() {
        return getChar("");
    }

    public static char getCharLn() {
        return getCharLn("");
    }

    public static char getCharLn(String prompt) {
        return getChar(prompt + "\n");
    }

    public static char getChar(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getChar();
    }

    //Int
    public static int getInt() {
        return getInt("");
    }

    public static int getIntLn() {
        return getIntLn("");
    }

    public static int getIntLn(String prompt) {
        return getInt(prompt + "\n");
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getInt();
    }

    //Line
    public static String getLine() {
        return getLine("");
    }

    public static String getLineLn() {
        return getLineLn("");
    }

    public static String getLineLn(String prompt) {
        return getLine(prompt + "\n");
    }

    public static String getLine(String prompt) {
        System.out.print(prompt);
        return streamDataReader.getLine();
    }
}
