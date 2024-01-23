package DataInputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class DataInput {
    private final BufferedReader reader;

    public DataInput(InputStream inputStream) {
        InputStreamReader isr = new InputStreamReader(inputStream);
        reader = new BufferedReader(isr);
    }

    public double getDouble(){
        double value;
        while (true) {
            try {
                String line = getLine();
                value = Double.valueOf(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nDouble expected. Input valid line:");
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
                System.out.println("\nLong expected. Input valid line:");
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
                System.out.println("\nCharacter expected. Input valid line: ");
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
                System.out.println("\nInteger expected. Input valid line:");
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
}
