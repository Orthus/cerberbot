import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class JsonReader {
	
	@SuppressWarnings("finally")
	public static String main(String str1) {
		String API = "https://api.twitch.tv/kraken/channels/"+ str1;
		String game = "null";
		try 
		{
			
			// read the json file
			URL oracle = new URL(API);
			
			Reader in = new InputStreamReader(oracle.openStream());
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(in);
			// get a String from the JSON object
			//JsonObject is a JsonElement but you can't use JsonElement as JsonObject, JsonObject is needed to get value data from a key.
			JsonElement JsonCheck = jsonObject.get("game");
			if (JsonCheck.isJsonObject() != true ){
				boolean ErrorMessage = JsonCheck.getAsBoolean();
				if (ErrorMessage == true){
					System.out.println(ErrorMessage);
				}
				else {			// handle a structure into the json object
					String gotgame = jsonObject.get("game").getAsString();
					game = gotgame;
				}
			}
			else
			{
				game = "null";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			return game;
		}
		
	}
}


