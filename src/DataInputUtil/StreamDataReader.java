package DataInputUtil;gi

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class StreamDataReader {
    private final BufferedReader reader;

    public StreamDataReader(InputStream inputStream) {
        InputStreamReader isr = new InputStreamReader(inputStream);
        reader = new BufferedReader(isr);
    }

    public double getNotNegativeNumber(){
        double value;
        while(true){
            value = getDouble();
            if(value >= 0){
                return value;
            }
            else{
                printValidationErrorMessage("Not negative number");
            }
        }
    }

    public double getNegativeNumber(){
        double value;
        while(true){
            value = getDouble();
            if(value < 0){
                return value;
            }
            else{
                printValidationErrorMessage("Negative number");
            }
        }
    }

    public double getDouble(){
        double value;
        while (true) {
            try {
                String line = getLine();
                value = Double.valueOf(line);
                break;
            } catch (NumberFormatException e) {
                printValidationErrorMessage("Double");
            }
        }
        return value;
    }

    public long getLong() {
        long value;
        while (true) {
            try {
                String line = getLine();
                value = Long.valueOf(line);
                break;
            } catch (NumberFormatException e) {
                printValidationErrorMessage("Long");
            }
        }
        return value;
    }

    public char getChar() {
        while(true){
            String str = getLine();
            if(str != null && !str.isEmpty()){
                return str.charAt(0);
            }
            else{
                printValidationErrorMessage("Character");
            }
        }
    }

    public int getInt() {
        int value;
        while (true) {
            try {
                String line = getLine();
                value = Integer.valueOf(line);
                break;
            } catch (NumberFormatException e) {
                printValidationErrorMessage("Integer");
            }
        }
        return value;
    }

    public String getLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unexpected error, while reading line, occurred:\n" + e.getMessage());
        }
        return str;
    }

    private static void printValidationErrorMessage(String expectedType) {
        System.out.println("\n" + expectedType + " expected. Input valid line:");
    }
}
