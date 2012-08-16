import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.managers.ListenerManager;
import java.util.*;

public class MyBot extends PircBotX {

     
        HashMap<String,String> dj = new HashMap<String,String>();   
		HashMap<String,ArrayList> kudos = new HashMap<String,ArrayList>();


    public MyBot() {         
		dj.put( "derp", "Imaginarydj" );
		dj.put( "herp", "HypotheticalSoundSystem" );
		kudos.put( "derp", new ArrayList<String>() );
		kudos.put( "herp", new ArrayList<String>() );
        this.setName("Z2GGY");
    }
	
    public void onMessage(MessageEvent event) throws Exception {
        
        if( event.getMessage().equalsIgnoreCase("!kudos derp") | event.getMessage().equalsIgnoreCase("!kudos herp") )
        {
		  String target = event.getMessage().toLowerCase().split(" ")[1];
		  String user = event.getUser().getHostmask();
		  
		  if( kudos.get( target ).contains( user ) ) 
		  {
		   sendNotice( event.getUser(), "You have already given kudos to " + dj.get( target ) + " during this session.");
		  }
		  
		  else 
		  
		  {
           kudos.get( target ).add( user );
           sendMessage("#AwesomeCougars", event.getUser() + " has given kudos to " + dj.get( target ) + ". (" + kudos.get( target ).size() + " kudos)");
		  }
        }
        
        
    }
                        

}