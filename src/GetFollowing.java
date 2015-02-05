import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;





import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class GetFollowing {
	
	@SuppressWarnings("finally")
	public static List<String> main(String str1) {
		String API = "https://api.twitch.tv/kraken/users/" + str1 + "/follows/channels?limit=100";
		ArrayList<String> following = new ArrayList<String>();
		try 
		{
			// read the json file
			URL oracle = new URL(API);
			Reader in = new InputStreamReader(oracle.openStream());
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(in);
			JsonElement JsonCheck = jsonObject.get("_total");
			if (JsonCheck.isJsonObject() != true ){
				boolean ErrorMessage = JsonCheck.getAsBoolean();
				if (ErrorMessage == true){
					System.out.println(ErrorMessage);
				}
				else {
					JsonArray fArray = (JsonArray) jsonObject.get("follows");
					for (int i =0; i < fArray.size(); i++)	{
						JsonObject AllInfo = fArray.get(i).getAsJsonObject();
						JsonObject ChannelInfo = (JsonObject) AllInfo.get("channel");
						String GotName = ChannelInfo.get("display_name").getAsString();
						following.add(i, GotName);
					}
				}

			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally{
			return following;
		}
		
	}
}


