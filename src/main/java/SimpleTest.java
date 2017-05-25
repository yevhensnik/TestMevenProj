import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

import httpclient.ForTestMain;

public class SimpleTest
{

    public static void pr()
    {
	System.out.println("1");
    }

    public static void main(String[] args)
    {
	// SimpleTest s = new SimpleTest();

	// List<String> list = new ArrayList<String>();
	// list.add(null);
	// list.add("Go");
	// list.add("Home!!!");
	//
	// System.out.println(list);
	//
	// int a = 5;
	// int b = 6;
	//
	// b += a;
	// System.out.println(b);

	/*
	 * String s = "(FFF),";
	 * StringBuilder builder = new StringBuilder();
	 * for (int i = 0; i < 3; i++) {
	 * builder.append("(?,?,?,?,?,?),");
	 * }
	 * String insertBuilder = builder.toString();
	 * String insertParameters = insertBuilder.substring(0,
	 * insertBuilder.length()-1);
	 * System.out.println(insertParameters);
	 */

	// List<String> doublemetaphone = new ArrayList<String>();
	// doublemetaphone.add("Chuvak");
	// doublemetaphone.add("Petuch");
	//
	// System.out.println(doublemetaphone.toString());

	/*
	 * Long l = 77777777777L;
	 * int i = l.intValue();
	 * System.out.println(i);
	 */

	/*
	 * Map<String, String> mapping = new HashMap<>();
	 * mapping.put("he", "ш");
	 * String translatedLangCharacter = mapping.get("hee");
	 * if (translatedLangCharacter == null)
	 * {
	 * translatedLangCharacter = mapping.get("he");
	 * }
	 * System.out.println(translatedLangCharacter);
	 */

	/*
	 * String str = "ggggff5665fffrrrFFF";
	 * str = str.replaceAll("[F-f]", "X");
	 * System.out.println(str);
	 */

	/*
	 * StringBuilder stringBuilder = new StringBuilder();
	 * stringBuilder.append("http").append("://").append("www.lviv.com");
	 * System.out.println(stringBuilder.toString());
	 */

	/*
	 * String s = "abvgfdertyu";
	 * int i = s.indexOf("f", 6);
	 * System.out.println(i);
	 */
	///////////////////////////

	// Map<String, String> map = new HashMap<>();
	// // map.put("(?<=\\w)h(?=\\w)", "H");
	// map.put("r", "ru");
	// map.put("u", "e");
	//
	// map.put("t", "т");
	// map.put("o", "оо");
	// map.put("sh", "ш");
	// map.put("i", "и");
	// map.put("ba", "ба");
	//
	// String content = "toshiba";
	// String[] array = content.split("");
	// // String[] responseArray = new String[array.length*2];
	//
	// String response = "";
	// for (int i = 0; i < array.length; i++)
	// {
	// String tmp = array[i];
	//
	// String transliterated = tmp;
	// for (Map.Entry<String, String> entry : map.entrySet())
	// {
	// Pattern pattern = Pattern.compile(entry.getKey());
	// Matcher matcher = pattern.matcher(transliterated);
	// // while (matcher.find()) {
	// // int start = matcher.start();
	// // int end = matcher.end();
	// //
	// // responseArray[start] = "";
	// // }
	// boolean contains = matcher.matches();
	// if (!contains)
	// {
	// continue;
	// }
	//
	// transliterated = transliterated.replaceAll(entry.getKey(),
	// entry.getValue());
	// }
	// response = response + transliterated;
	//
	// }
	// System.out.println(response);

	//////////////////////////

	/*
	 * String str = "some 'string' with 'the data i want' inside";
	 * Pattern pattern = Pattern.compile("s");
	 * Matcher matcher = pattern.matcher(str);
	 * while (matcher.find()) {
	 * System.out.println(matcher.start());
	 * System.out.println(matcher.end());
	 * System.out.println(matcher.group());
	 * }
	 */

	// Map<Integer,String> ascsortedMAP = new TreeMap<Integer,String>();
	//
	// ascsortedMAP.put(8, "name8");
	// ascsortedMAP.put(5, "name5");
	// ascsortedMAP.put(15, "name15");
	// ascsortedMAP.put(35, "name35");
	// ascsortedMAP.put(44, "name44");
	// ascsortedMAP.put(7, "name7");
	// ascsortedMAP.put(6, "name6");
	//
	// for(Map.Entry<Integer, String> mapData : ascsortedMAP.entrySet()) {
	// System.out.println("Key : " +mapData.getKey()+ " Value :
	// "+mapData.getValue());
	// }

	// int array[] = { 2, 2, 4, 3, 1, 1, 4, 3 };
	// int min = 0;
	// int max = 0;
	// int lastDno = 0;
	// int lastVersh = 0;
	// int prev = 0;
	// int current = 0;
	// for (int i = 0; i < array.length; i++)
	// {
	// if (i == 0)
	// {
	// prev = array[i];
	// } else
	// {
	// prev = array[i - 1];
	// }
	//
	// current = array[i];
	// if (current < prev)
	// {
	// min = current;
	// if(lastVersh < prev){
	// lastVersh = prev;
	// }
	//
	// } else if (current > prev)
	// {
	// max = current;
	// lastDno = prev;
	// }

	// }
	int score = 0;
	
	score++;
	System.out.println(score);
	
    }
    
    
   

}
