package transliteraton;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaresExample
{
    public static String translit(final String text)
    {
	if (null == text || "".equals(text))
	    return text;
	//
	//
	// MAP containing the specific rules
	Map<String, String> mpSpecific = new LinkedHashMap();
	// MAP containing the normal rules
	Map<String, String> mpNormal = new LinkedHashMap();
	// MAP TO STORE ALL RULES COMBINED BY ORDER
	Map<String, String> mpRules = new LinkedHashMap();
	//
	//
	//
	// STATIC MAPING FOR TESTING
	mpSpecific.put("щ", "shch");
	mpSpecific.put("xx", "+");
	mpSpecific.put("ы", "i");
	mpSpecific.put("sh", "ш");
	//
	mpNormal.put("Ч", "Ch");
	mpNormal.put("ч", "ch");
	mpNormal.put("р", "r");
	mpNormal.put("й", "y");
	mpNormal.put("и", "i");
	mpNormal.put("н", "n");
	mpNormal.put("т", "t");
	mpNormal.put("о", "o");
	mpNormal.put("б", "b");
	mpNormal.put("д", "d");
	mpNormal.put("л", "l");
	mpNormal.put("е", "e");
	mpNormal.put("п", "p");
	mpNormal.put("в", "v");
	mpNormal.put("b", "b");
	mpNormal.put("B", "B");
	//
	mpRules.putAll(mpSpecific);
	mpRules.putAll(mpNormal);
	//
	//
	//
	String result = text;
	//
	Pattern pattern;
	Matcher matcher;
	int matchIndx, matchLen;
	//
	// CREATE ARRAY OF STRINGS BY CHARACTER FROM A TEXT
	String[] textArr = text.split("");
	//
	for (Map.Entry<String, String> entry : mpRules.entrySet())
	{
	    // MATCHING MAPPING KEYS IN THE GIVEN TEXT
	    pattern = Pattern.compile(entry.getKey());
	    matcher = pattern.matcher(text);
	    //
	    while (matcher.find())
	    {
		matchIndx = matcher.start();
		matchLen = matcher.group().length();
		//
		// CHANGING THE FINDING MATCH IN THE ARRAY
		textArr[matchIndx] = entry.getValue();
		// IF THE MATCHED KEY LENGTH IS > 1 SO WE NEED TO REMOVE IT FROM
		// THE ARRAY
		// e.g IF WE ARE MATCHING ABC TO BE REPLACES BY X IN THE
		// PREVIOUS LINE WE ARE REPLACING A BY AND X
		// AND IN THE BELOW LOOP WE ARE REMOVING THE REMAINING
		// CHARACTERS (BC) BY AN EMPTY STRING
		// SO ON JOIN WE WILL HAVE X INSTEAD OF ABC
		if (matchLen > 1)
		{
		    for (int i = (matchIndx + 1); i < (matchIndx + matchLen); i++)
		    {
			textArr[i] = "";
		    }
		}
		//
	    }
	}
	//
	result = String.join("", textArr);
	//
	textArr = null;
	pattern = null;
	matcher = null;
	mpSpecific = null;
	mpNormal = null;
	mpRules = null;
	//
	return result;
    }

    public static void main(String[] str)
    {
	String text = "shandar";
	//
	System.out.println(translit(text));
    }
}
