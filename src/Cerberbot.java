import org.jibble.pircbot.*;

public class Cerberbot extends PircBot {
    public String owner = "orthusaku";
    String[] quotes;
    public Cerberbot () {
        this.setName("cerberbot");
    }
    
    
    public void onJoin (String channel){
    	sendMessage(channel, "Cerberbot, alive and awaiting your command.");
    }
    public void onMessage(String channel, String sender,String login, String hostname, String message) {
    	
    	// General Commands
    	
    	if (message.startsWith("!backseat")) {
    		sendMessage(channel, "Please do not backseat game. This includes unsolicited tips.");
    	}
    	if (message.startsWith("!quote")) {
    		String[] quotesplit = message.split(" ", 2);
    		String quote = quotesplit[1];	
        	sendMessage(channel, sender + " tried to add quote: " + "\"" + quote + "\"");
    	}
    	
    	if (message.startsWith("!bytesize")) {
    		sendMessage(channel, "bytesize is a modpack created by Nodecraft hosting LLC. as an intro into modded minecraft");
    	}
    	
    	if (message.startsWith("!nodecraft")) {
    		sendMessage(channel, "I do work for nodecraft hosting, however please do not bring any drama past or present into the stream.");
    	}
    	
    	// owner only commands
    	
    	if (message.startsWith("!check")) {
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(channel, "Cerberbot, awake and awaiting your command.");
    		}
    	}
    	
    	if (message.startsWith("!raid")) {
    		String[] raidsplit = message.split(" ");
    		String caster = raidsplit[1];
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(channel, "Please head over to twitch.tv/" + caster + ", and wait for my command  \"The doges of hell have been released! FrankerZ\" and than post \" Hellhound Raid! FrankerZ\"");
    		}
    	}
    	
    	if (message.startsWith("!wat")) {
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(sender, "Commands are as follows: backseat, quote, bytesize, nodecraft, raid, wat, caster");
    		}
    	}
    	
    	if (message.startsWith("!caster")) {
    		if (sender.equalsIgnoreCase(owner)){
        		String[] castersplit = message.split(" ");
        		String caster = castersplit[1];
        		String game = JsonReader.main(caster);
        		sendMessage(channel, "Please follow this fine person twitch.tv/" + caster + ". Last game played: " + game);
    		}
    	}
    	if (message.startsWith("!ctt")) {
    		if (sender.equalsIgnoreCase(owner)){
        		sendMessage(channel, "no click to tweet");
    		}
    	}
    	// moderator only commands to do
    }
}