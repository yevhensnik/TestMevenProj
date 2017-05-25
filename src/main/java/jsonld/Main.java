package jsonld;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

public class Main
{
    public static void main(String[] args) throws IOException, JsonLdError
    {
	// Open a valid json(-ld) input file
//	InputStream inputStream = new FileInputStream("input.json");
	// Read the file into an Object (The type of this object will be a List, Map, String, Boolean,
	// Number or null depending on the root object in the file).
	Object jsonObject = JsonUtils.fromString("{  \"@context\": {    \"@vocab\": \"http://schema.org/\",    \"goog\": \"http://schema.googleapis.com/\",    \"EntitySearchResult\": \"goog:EntitySearchResult\",    \"detailedDescription\": \"goog:detailedDescription\",    \"resultScore\": \"goog:resultScore\",    \"kg\": \"http://g.co/kg\"  },  \"@type\": \"ItemList\",  \"itemListElement\": [    {      \"@type\": \"EntitySearchResult\",      \"result\": {        \"@id\": \"kg:/m/02mjmr\",        \"name\": \"Barack Obama\",        \"@type\": [          \"Thing\",          \"Person\"        ],        \"description\": \"44th U.S. President\",        \"image\": {          \"contentUrl\": \"http://t0.gstatic.com/images?q=tbn:ANd9GcSkJEGgR2wJ0bp8DhOXx2QuexPLTslqt0v-G2iTiDWVp3iRhSnc\",          \"url\": \"https://en.wikipedia.org/wiki/Illinois_Senate_career_of_Barack_Obama\"        },        \"detailedDescription\": {          \"articleBody\": \"Barack Hussein Obama II is an American politician and the 44th and current President of the United States. He is the first African American to be elected to that office and the first president born outside the contiguous United States. \",          \"url\": \"https://en.wikipedia.org/wiki/Barack_Obama\",          \"license\": \"https://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License\"        },        \"url\": \"http://whitehouse.gov\"      },      \"resultScore\": 706.712036    },    {      \"@type\": \"EntitySearchResult\",      \"result\": {        \"@id\": \"kg:/m/0h54tr_\",        \"name\": \"Barack Obama Male Leadership Academy\",        \"@type\": [          \"School\",          \"EducationalOrganization\",          \"Thing\",          \"Place\",          \"Organization\"        ],        \"description\": \"School\",        \"detailedDescription\": {          \"articleBody\": \"Barack Obama Male Leadership Academy at B.F. Darrell is a magnet secondary school for boys located in the Oak Cliff area of Dallas, Texas. It is a part of the Dallas Independent School District. After the Irma Lerma Rangel Young Women's Leadership School, it is DISD's second single gender school. The school, which occupies the campus of the former B.F. \",          \"url\": \"https://en.wikipedia.org/wiki/Barack_Obama_Male_Leadership_Academy\",          \"license\": \"https://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License\"        }      },      \"resultScore\": 41.859333    }  ]}\r\n");
	// Create a context JSON map containing prefixes and definitions
	Map context = new HashMap();
	
	// Customise context...
	// Create an instance of JsonLdOptions with the standard JSON-LD options
	JsonLdOptions options = new JsonLdOptions();
	
	// Customise options...
	// Call whichever JSONLD function you want! (e.g. compact)
	Object compact = JsonLdProcessor.compact(jsonObject, context, options);
	System.out.println(jsonObject + "\n\n\n");
	// Print out the result (or don't, it's your call!)
//	System.out.println(JsonUtils.toPrettyString(compact));
	System.out.println(JsonUtils.toString(jsonObject));
	System.out.println(JsonUtils.toString(compact));
    }
}
