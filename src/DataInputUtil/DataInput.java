package DataInputUtil;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class DataInput {
    private InputStream inputStream;

    public DataInput(){
        this.inputStream = System.in;
    }

    public DataInput(InputStream inputStream){
        this.inputStream = inputStream;
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
        String s = "";
        s = getLine();
        Integer value = Integer.valueOf(s);
        return value;
    }

    public String getLine(){
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String str = null;

        try {
            str = br.readLine();
        } catch (IOException e) {
            System.out.println("Unexpected error, while reading line, occurred:\n" + e.getMessage());
        }

        return str;
    }
}
