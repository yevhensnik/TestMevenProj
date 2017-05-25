package transliteraton;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass
{

    public static void main(String[] args)
    {
	TestClass.case1();
	System.out.println("**************************");
	TestClass.case2();
    }
    
    
    public static void case1(){
	Map<Integer, String> responseMap = new TreeMap<Integer, String>();

	Map<String, String> map = new HashMap<>();
	// map.put("(?<=\\w)h(?=\\w)", "H");
	map.put("r", "ru");
	map.put("u", "e");
	map.put("t", "т");
	map.put("o", "оо");
	map.put("i", "и");

	Map<String, String> specificMap = new HashMap<>();
	specificMap.put("ba", "ба");
	specificMap.put("sh", "ш");

	String content = "toshiba ukraine";

	for (Map.Entry<String, String> entry : specificMap.entrySet())
	{
	    Pattern pattern = Pattern.compile(entry.getKey());
	    Matcher matcher = pattern.matcher(content);
	    while (matcher.find())
	    {
		int start = matcher.start();
		int end = matcher.end() - 1;

		responseMap.put(start, entry.getValue());

		int length = matcher.group().length();
		String tmpChars = "";
		for (int i = 0; i < length; i++)
		{
		    tmpChars = tmpChars + "_";
		}
		content = content.replace(matcher.group(), tmpChars);
	    }
	}
	System.out.println(content);

	for (Map.Entry<String, String> entry : map.entrySet())
	{
	    Pattern pattern = Pattern.compile(entry.getKey());
	    Matcher matcher = pattern.matcher(content);
	    while (matcher.find())
	    {
		int start = matcher.start();
		int end = matcher.end() - 1;

		responseMap.put(start, entry.getValue());

		int length = matcher.group().length();
		String tmpChars = "";
		for (int i = 0; i < length; i++)
		{
		    tmpChars = tmpChars + "_";
		}
		content = content.replace(matcher.group(), tmpChars);

	    }
	    // boolean contains = matcher.matches();
	    // if (!contains)
	    // {
	    // continue;
	    // }
	}
	System.out.println(content);
	
	String[] array = content.split("");
	for (int i = 0; i < array.length; i++)
	{
	    if(!"_".equals(array[i])){
		responseMap.put(i, array[i]);
	    }	
	}
	
	
	String response = "";
	for (Map.Entry<Integer, String> mapData : responseMap.entrySet())
	{
//	    System.out.println("Key : " + mapData.getKey() + "  Value : " + mapData.getValue());
	    response = response + mapData.getValue();
	}
	System.out.println(response);
    }
    
    public static void case2(){
	Map<Integer, String> responseMap = new TreeMap<Integer, String>();

	Map<String, String> map = new HashMap<>();
	map.put("(?<=\\w)d(?=\\w)", "D");
	map.put("r", "ru");
	map.put("u", "e");
	map.put("y", "i");

	Map<String, String> specificMap = new HashMap<>();
//	specificMap.put("ba", "ба");
//	specificMap.put("sh", "ш");

	String content = "rudiy";

	for (Map.Entry<String, String> entry : specificMap.entrySet())
	{
	    Pattern pattern = Pattern.compile(entry.getKey());
	    Matcher matcher = pattern.matcher(content);
	    while (matcher.find())
	    {
		int start = matcher.start();
		int end = matcher.end() - 1;

		responseMap.put(start, entry.getValue());

		int length = matcher.group().length();
		String tmpChars = "";
		for (int i = 0; i < length; i++)
		{
		    tmpChars = tmpChars + "_";
		}
		content = content.replace(matcher.group(), tmpChars);
	    }
	}

	for (Map.Entry<String, String> entry : map.entrySet())
	{
	    Pattern pattern = Pattern.compile(entry.getKey());
	    Matcher matcher = pattern.matcher(content);
	    while (matcher.find())
	    {
		int start = matcher.start();
		int end = matcher.end() - 1;
		System.out.println(entry.getKey() + ":   start: " + start + " end: " + end);

		responseMap.put(start, entry.getValue());

		int length = matcher.group().length();
		String tmpChars = "";
		for (int i = 0; i < length; i++)
		{
		    tmpChars = tmpChars + "_";
		}
		content = content.replace(matcher.group(), tmpChars);

	    }
	}
	
	String response = "";
	for (Map.Entry<Integer, String> mapData : responseMap.entrySet())
	{
	    response = response + mapData.getValue();
	}
	System.out.println(response);
    }
    

}
