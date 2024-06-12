package numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

class SummarizeNumbersTest {
	
	SummarizeNumbers summarize = new SummarizeNumbers();

	@Test
	void testCollect_ValidInput() 
	{
        String input = "1, 2, 3, 5, 6, 7, 8";
        Collection<Integer> result = summarize.collect(input);
        Collection<Integer> expected = new TreeSet<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8));
        assertEquals(expected, result);
	}
	
	@Test
	void testCollect_InvalidInput() 
	{
        String input = "1, 2,.........., 3, Hello World, 5";
        Collection<Integer> result = summarize.collect(input);
        Collection<Integer> expected = new TreeSet<>(Arrays.asList(1, 2, 3, 5));
        assertEquals(expected, result);
	}
	
    @Test
    public void testCollect_EmptyInput() {
        String input = "";
        Collection<Integer> result = summarize.collect(input);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testCollect_NullInput() {
        String input = null;
        Collection<Integer> result = summarize.collect(input);
        assertTrue(result.isEmpty());
    }
    //SummarizeCollection Method
    @Test
    public void testSummarizeCollection_SingleValue() {
        Collection<Integer> input = new TreeSet<>(Arrays.asList(1));
        String result = summarize.summarizeCollection(input);
        assertEquals("1", result);
    }
    @Test
    public void testSummarizeCollection_Empty() {
        Collection<Integer> input = new TreeSet<>();
        String result = summarize.summarizeCollection(input);
        assertEquals("", result);
    }
    @Test
    public void testSummarizeCollection_RangeOnly() {
        Collection<Integer> input = new TreeSet<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10));
        String result = summarize.summarizeCollection(input);
        assertEquals("1-3, 5-10", result);
    }
    //Append
    @Test
    public void testAppendRange_SingleValue() {
        StringBuilder sb = new StringBuilder();
        summarize.appendRange(sb, 7,7);
        assertEquals("7", sb.toString());
    }

    @Test
    public void testAppendRange_Range() {
        StringBuilder sb = new StringBuilder();
        summarize.appendRange(sb, 1, 7);
        assertEquals("1-7", sb.toString());
    }  
    
    //IsInteger
    @Test
    public void testIsInteger_ValidInteger() {
        assertTrue(summarize.isInteger("1"));
    }

    @Test
    public void testIsInteger_InvalidInteger() {
        assertFalse(summarize.isInteger("lzxc"));
    }
    
    @Test
    public void testIsInteger_NullString() {
        assertFalse(summarize.isInteger(null));
    }
    @Test
    public void testIsInteger_EmptyString() {
        assertFalse(summarize.isInteger(""));
    }

}
