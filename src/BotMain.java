public class BotMain {
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
    	Cerberbot bot = new Cerberbot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, "oauth:i4z4c0tifupv2chil2bcezu8xzz07i");

        // Join the #pircbot channel.
        bot.joinChannel("#orthusaku"); 
   }
    
}