package DataInputUtil;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class DataInputTests {

    @Test
    public void getLineReturnsLine() {
        String text = "text";
        InputStream stream = getInputStreamFromString(text);
        DataInput dataInput = new DataInput(stream);

        String line = dataInput.getLine();

        assertEquals(text, line);
    }

    @Test
    public void getLineReturnsOnlyOneLine() {
        String firstLine = "first line";
        String secondLine = "Second line";
        String text = firstLine + "\n" + secondLine;
        InputStream stream = getInputStreamFromString(text);
        DataInput dataInput = new DataInput(stream);

        String line = dataInput.getLine();

        assertEquals(firstLine, line);
    }

    @Test
    public void getLineReturnsNullOnEmptyStream() {
        String text = "";
        InputStream stream = getInputStreamFromString(text);
        DataInput dataInput = new DataInput(stream);

        String line = dataInput.getLine();

        assertNull(line);
    }

    private InputStream getInputStreamFromString(String str) {
        byte[] stringBytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(stringBytes);
    }
}