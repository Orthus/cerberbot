import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.jibble.pircbot.*;

import com.google.gson.Gson;

public class Cerberbot extends PircBot {
    // vars
	public String owner = "orthusaku";
    public ArrayList<String> quotes;
    public String backseat = "backseating is not allow, that includes unsolisted tips.";
    public String bytesize = "bytesize is a modpack created by Nodecraft hosting LLC. as an intro into modded minecraft";
    public String nodecraft = "I do work for nodecraft hosting, however please do not bring any drama past or present into the stream.";
    public String check = "Cerberbot, awake and awaiting your command.";
    public String clicktotweet = "no click to tweet";
    public String currentgame = JsonReader.game(owner);
    public static Boolean roulette = false;
    public List<String> namelist = new ArrayList<String>();
    public Gson CurrentQuote;
    public java.util.Date date = Calendar.getInstance().getTime();
    
    
    //init
    public Cerberbot () {
        this.setName("cerberbot");
    }
    //on event
    public void onMessage(String channel, String sender,String login, String hostname, String message) {
    	
    	// General Commands
    	
    	if (message.startsWith("!backseat")) {
    		sendMessage(channel, backseat);
    	}
    	if (message.startsWith("!quote")) {
    		String[] quotesplit = message.split(" ", 2);
    		String quote = quotesplit[1];
    		String QuoteString = owner + " : \"" + quote + "\"| " + currentgame;
    		
        	sendMessage(channel,  sender + " tried to add quote: " +  QuoteString);
        	quotes.add(QuoteString);
        	
        	try {
        		sendMessage(channel, "Cerberbot is attempting to update quotes.");
				quoteFile.writer(quotes);
			} catch (IOException e) {
        		sendMessage(channel, "Cerberbot failed to update quotes.");
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
    	}
    	
    	if (message.startsWith("!bytesize")) {
    		sendMessage(channel, bytesize);
    	}
    	
    	if (message.startsWith("!nodecraft")) {
    		sendMessage(channel, nodecraft);
    	}
    	
    	if (message.startsWith("!ctt")) {
        		sendMessage(channel, clicktotweet);
    	}
    	
    	// owner only commands
    	
    	if (message.startsWith("!check")) {
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(channel, check);
    		}
    	}
    	
    	if (message.startsWith("!raid")) {
    		String[] raidsplit = message.split(" ");
    		String caster = raidsplit[1];
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(channel, "Please head over to twitch.tv/" + caster + ", and wait for my command  \"The doges of hell have been released! FrankerZ\" and than post \" Hellhound Raid! FrankerZ\"");
    		}
    	}
       	
    	if (message.startsWith("!caster")) {
    		if (sender.equalsIgnoreCase(owner)){
        		String[] castersplit = message.split(" ");
        		String caster = castersplit[1];
        		String game = JsonReader.game(caster);
        		sendMessage(channel, "Please follow this fine person twitch.tv/" + caster + ". Last game played: " + game);
    		}
    	}
    	
    	if (message.startsWith("!sleep")) {
    		if (sender.equalsIgnoreCase(owner)){
        		try {
            		sendMessage(channel, "Cerberbot is attempting to update quotes.");
					quoteFile.writer(quotes);
				} catch (IOException e) {
            		sendMessage(channel, "Cerberbot failed to update quotes.");
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		sendMessage(channel, "Cerberbot is going back to sleep");
        		System.exit(0);
    		}
    	}
    	// moderator only commands to do
    	
    	
    	if (message.startsWith("!mod1")) {
    		User[] userList = this.getUsers(channel);
            for (int i = 0; i < userList.length; i++){
            	if (userList[i].getNick().equals(sender)){
            		if (userList[i].isOp()){
                        // do command here
                        }
                    }
                }
    	}
    	// special commands
    	
    	if (message.startsWith("!kettlette")) {
    		if (roulette == false){
        		if (sender.equalsIgnoreCase(owner)){
            		sendMessage(channel, "Kettlette is now open, Please type !kettlette into chat to have your named entered into the drawing.");
            		roulette = true;
        		}
    		}
    		else{
        		if (sender.equalsIgnoreCase(owner)){
            		sendMessage(channel, "Kettlette is now closed");
            		roulette = false;
            		if(!namelist.isEmpty()){
            			int idx = new Random().nextInt(namelist.size());
                    		String usernamed = (namelist.get(idx));
                    		sendMessage(channel, usernamed);	
            		}
            		else{
                		sendMessage(channel, "No entries");	
            		}
        		}
        		else{
        			if (!Arrays.asList(namelist).contains(sender)){
        				namelist.add(sender);
        			}
        			else{
        				
        			}
        		}
    		}
    	}
    	
    	if (message.startsWith("!wat")) {
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(sender, "Commands are as follows: backseat, quote, bytesize, nodecraft, raid, wat, caster");
    		}
    		else{
    			User[] userList = this.getUsers(channel);
    			for (int i = 0; i < userList.length; i++){
                	if (userList[i].getNick().equals(sender)){
                		if (userList[i].isOp()){
                			sendMessage(sender, "Commands are as follows: !backseat, !quote, !bytesize, !nodecraft, !wat, !ctt, !kettlette");
                			}
                		else{
                			sendMessage(sender, "Commands are as follows: !backseat, !quote, !bytesize, !nodecraft, !wat, !ctt, !kettlette, !check, !mod1");
                		}
                	}
    			}
    		}
    	}
}}