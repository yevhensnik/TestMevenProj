package transliteraton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class Main
{
    public static void main(String[] args) throws IOException
    {
	Main main = new Main();
	
	main.resd2();
    }



    public void resd2() throws IOException{
	InputStream is = new FileInputStream("/home/bogdan/Documents/intouch/Phonetics TranslationInJsonWithoutSharp/eng_bul.json"); 
	BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
	String line = buf.readLine(); 

	StringBuilder sb = new StringBuilder();
	while(line != null){ 
	    sb.append(line).append("\n"); 
	    line = buf.readLine(); 
	
	} 
	String fileAsString = sb.toString();
//	System.out.println("Contents : " + fileAsString);
	
	Gson gson = new Gson();
	Dictionary dictionary = gson.fromJson(fileAsString, Dictionary.class);
	System.out.println(gson.toJson(dictionary));
    }

    public void getDictionary(String fromLang, String toLang)
    {

    }
}
