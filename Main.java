package numberrangesummarizer;
import java.util.Collection;

public class Main
{

	public static void main(String[] args) 
	{
		SummarizeNumbers summarize = new SummarizeNumbers();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collection = summarize.collect(input);        
        System.out.println(summarize.summarizeCollection(collection)); 	
	}

}
