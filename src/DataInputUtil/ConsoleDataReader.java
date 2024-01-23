package DataInputUtil;

/**
 * Static adapter for StreamDataReader
 */
public class ConsoleDataReader {
    private static final StreamDataReader streamDataReader = new StreamDataReader(System.in);

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
