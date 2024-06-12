package numberrangesummarizer;

import java.util.Collection;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SummarizeNumbers implements NumberRangeSummarizer
{
    // Collect the input
    @Override
    public Collection<Integer> collect(String input) //Time Complexity: O(nlogn)
    {
        // Check if input is null or empty
        if (input == null || input.trim().isEmpty()) {
            return new TreeSet<>(); 
        }

        return Arrays.stream(input.split(","))
                .map(String::trim) //Method Reference
                .filter(s -> this.isInteger(s)) // Lambda Expression
                .map(s -> Integer.parseInt(s)) 
                .collect(Collectors.toCollection(TreeSet::new)); //Add to Treeset collection
    }

    // Get the summarized string
    @Override
    public String summarizeCollection(Collection<Integer> input) //Time Complexity: O(n) grows as data grows
    {
        StringBuilder sb = new StringBuilder();
        Integer prev = null, rangeBegin = null;

        for (Integer num : input) {
            if (prev == null || num != prev + 1) {
                if (prev != null) {
                    appendRange(sb, rangeBegin, prev); //Adding range to final sb
                }
                rangeBegin = num;
            }
            prev = num;
        }

        if (rangeBegin != null) {
            appendRange(sb, rangeBegin, prev);
        }

        return sb.toString();
    }
    //Helper function for appending values to a string builder
    public void appendRange(StringBuilder sb, Integer start, Integer end) { //Time Complexity: O(1) constant
        if (sb.length() > 0) {
            sb.append(", ");
        }

        String range = (start.equals(end)) ? start.toString() : start + "-" + end;
        sb.append(range);
    }

    //Helper function for check if input can be integer
    public boolean isInteger(String str) { //Time Complexity: O(1) constant
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
