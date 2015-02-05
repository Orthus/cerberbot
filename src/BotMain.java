import java.io.File;

public class BotMain {
	public static String server = "irc.twitch.tv";
	public static String oauth = "oauth:";
	public static int port = 6667;
	public static String defaultchannel = "#orthusaku";
	static File f = new File("quotes.txt");
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
    	Cerberbot bot = new Cerberbot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect(server, port, oauth);

        // Join the #pircbot channel.
        bot.joinChannel(defaultchannel); 
    	if(f.exists()){
        bot.quotes = quoteFile.reader();
    	}
    	else{
    		System.out.println("quotes file missing");
    	}
    }
    
}