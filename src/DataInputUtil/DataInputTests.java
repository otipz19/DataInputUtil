package DataInputUtil;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class DataInputTests {

    @Test
    public void getLineReturnsLine() {
        String text = "text";
        DataInput dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertEquals(text, line);
    }

    @Test
    public void getLineReturnsOnlyOneLine() {
        String firstLine = "first line";
        String secondLine = "Second line";
        String text = firstLine + "\n" + secondLine;
        DataInput dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertEquals(firstLine, line);
    }

    @Test
    public void getLineReadsToLastLine(){
        String firstLine = "first";
        String secondLine = "second";
        String thirdLine = "third";
        String text = String.join("\n", firstLine, secondLine, thirdLine);
        DataInput dataInput = getDataInput(text);

        String line = null;
        for(int i = 0; i < 3; i++){
            line = dataInput.getLine();
        }

        assertEquals(thirdLine, line);
    }

    @Test
    public void getLineReturnsNullOnEmptyStream() {
        String text = "";
        DataInput dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertNull(line);
    }

    @Test
    public void getIntReturnsIntOnValidInput(){
        String text = "123";
        DataInput dataInput = getDataInput(text);

        int n = dataInput.getInt();

        assertEquals(123, n);
    }

    @Test
    public void getIntReadsUntilValidInput(){
        String text = "bla\nbla\nbla\n123";
        DataInput dataInput = getDataInput(text);

        int n = dataInput.getInt();

        assertEquals(123, n);
    }

    private DataInput getDataInput(String str){
        InputStream stream = getInputStreamFromString(str);
        return new DataInput(stream);
    }

    private InputStream getInputStreamFromString(String str) {
        byte[] stringBytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(stringBytes);
    }
}