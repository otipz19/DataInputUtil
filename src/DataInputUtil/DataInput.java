package DataInputUtil;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class DataInput {
    private BufferedReader reader;

    public DataInput(){
        this(System.in);
    }

    public DataInput(InputStream inputStream){
        InputStreamReader isr = new InputStreamReader(inputStream);
        reader = new BufferedReader(isr);
    }

    public long getLong() throws IOException{
        String s = getLine();
        Long value = Long.valueOf(s);
        return value;
    }

    public char getChar() throws IOException{
        String s = getLine();
        return s.charAt(0);
    }

    public int getInt(){
        int value;
        while(true){
            try{
                String line = getLine();
                value = Integer.valueOf(line);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("\nInteger expected. Input valid line:");
            }
        }
        return value;
    }

    public String getLine(){
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unexpected error, while reading line, occurred:\n" + e.getMessage());
        }

        return str;
    }
}
