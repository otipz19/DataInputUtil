package DataInputUtil.tests;

import DataInputUtil.main.StreamDataReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class DataInputTests {
    @Test
    public void getLineReturnsLine() {
        String text = "text";
        StreamDataReader dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertEquals(text, line);
    }

    @Test
    public void getLineReturnsOnlyOneLine() {
        String firstLine = "first line";
        String secondLine = "Second line";
        String text = firstLine + "\n" + secondLine;
        StreamDataReader dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertEquals(firstLine, line);
    }

    @Test
    public void getLineReadsToLastLine(){
        String firstLine = "first";
        String secondLine = "second";
        String thirdLine = "third";
        String text = String.join("\n", firstLine, secondLine, thirdLine);
        StreamDataReader dataInput = getDataInput(text);

        String line = null;
        for(int i = 0; i < 3; i++){
            line = dataInput.getLine();
        }

        assertEquals(thirdLine, line);
    }

    @Test
    public void getLineReturnsNullOnEmptyStream() {
        String text = "";
        StreamDataReader dataInput = getDataInput(text);

        String line = dataInput.getLine();

        assertNull(line);
    }

    @Test
    public void getIntReturnsIntOnValidInput(){
        String text = "123";
        StreamDataReader dataInput = getDataInput(text);

        int n = dataInput.getInt();

        assertEquals(123, n);
    }

    @Test
    public void getIntReadsUntilValidInput(){
        String text = "bla\nbla\nbla\n123";
        StreamDataReader dataInput = getDataInput(text);

        int n = dataInput.getInt();

        assertEquals(123, n);
    }

    @Test
    public void getCharReturnsCharOnValidString(){
        String text = "Abc";
        StreamDataReader dataInput = getDataInput(text);

        char actual = dataInput.getChar();

        assertEquals('A', actual);
    }

    @Test
    public void getCharReadsUntilValidInput(){
        String text = "\n\n\nA";
        StreamDataReader dataInput = getDataInput(text);

        char actual = dataInput.getChar();

        assertEquals('A', actual);
    }

    @Test
    public void getDoubleReadsUntilValidInput(){
        double expected = 12.345;
        String text = "\nbla\nbla\nbla\n" + expected;
        StreamDataReader dataInput = getDataInput(text);

        double actual = dataInput.getDouble();

        assertEquals(expected, actual);
    }

    @Test
    public void getDoubleReturnsDoubleOnValidInput(){
        double expected = 12.345;
        String text = Double.toString(expected);
        StreamDataReader dataInput = getDataInput(text);

        double actual = dataInput.getDouble();

        assertEquals(expected, actual);
    }

    @Test
    public void getLongReadsUntilValidInput(){
        long expected = -12345;
        String text = "\nbla\nbla\nbla\n" + expected;
        StreamDataReader dataInput = getDataInput(text);

        long actual = dataInput.getLong();

        assertEquals(expected, actual);
    }

    @Test
    public void getLongReturnsDoubleOnValidInput(){
        long expected = -12345;
        String text = Long.toString(expected);
        StreamDataReader dataInput = getDataInput(text);

        double actual = dataInput.getLong();

        assertEquals(expected, actual);
    }

    @Test
    public void getNotNegativeNumberReadsUntilValidInput(){
        double expected = 1;
        String text = "bla\n-2\nwww\n-7\n" + expected;
        StreamDataReader dataInput = getDataInput(text);

        double actual = dataInput.getNotNegativeNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void getNegativeNumberReadsUntilValidInput(){
        double expected = -1;
        String text = "bla\n2\nwww\n7\n" + expected;
        StreamDataReader dataInput = getDataInput(text);

        double actual = dataInput.getNegativeNumber();

        assertEquals(expected, actual);
    }

    private StreamDataReader getDataInput(String str){
        InputStream stream = getInputStreamFromString(str);
        return new StreamDataReader(stream);
    }

    private InputStream getInputStreamFromString(String str) {
        byte[] stringBytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(stringBytes);
    }
}