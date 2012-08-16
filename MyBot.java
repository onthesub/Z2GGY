import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.managers.ListenerManager;
import java.util.*;

public class MyBot extends ListenerAdapter implements Listener   {

     
        HashMap<String,String> dj = new HashMap<String,String>();   
    HashMap<String,ArrayList<String>> kudos = new HashMap<String,ArrayList<String>>();


    public MyBot() {         
    dj.put( "derp", "Imaginarydj" );
    dj.put( "herp", "HypotheticalSoundSystem" );
    kudos.put( "derp", new ArrayList<String>() );
    kudos.put( "herp", new ArrayList<String>() );
    }             
  
    public void onMessage(MessageEvent event) throws Exception
  {
        
        if( event.getMessage().equalsIgnoreCase("!kudos derp") || event.getMessage().equalsIgnoreCase("!kudos herp") )
        {
      String target = event.getMessage().toLowerCase().split(" ")[1];
      String userhost = event.getUser().getHostmask();
      
      if( kudos.get( target ).contains( userhost ) ) 
      {
       sendNotice( event.getUser(), "You have already given kudos to " + dj.get( target ) + " during this session.");
      }
      
      else 
      
      {
           kudos.get( target ).add( userhost );
           sendMessage("#AwesomeCougars", event.getUser() + " has given kudos to " + dj.get( target ) + ". (" + kudos.get( target ).size() + " kudos)");
      }
        }
    
    else if( event.getMessage().toLowerCase().startsWith("go away Z2GGY") &&  event.getUser().isIrcop() )
    {
      quitServer("Goodbye, " + event.getUser().getNick() + "!");
    }
        
    }  

}