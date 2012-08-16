import org.jibble.pircbot.*;
import java.util.*;

public class MyBot extends PircBot {
  String derpDJ = "ImaginaryDJ";
  String herpDJ = "HypotheticalSoundSystem";
	HashMap kudos = new HashMap();
	kudos.put( "derp", new HashMap() ) ;
	kudos.put( "herp", new HashMap() ) ;


  public MyBot() {
    this.setName("Z2GGY");
  }
	
  public void onMessage(String channel, String sender, String login, String hostname, String message) {
    if (message.toLowerCase().startsWith("!kudos derp") ) {
      derpKudos.add(sender);
      sendMessage("NickServ", "info " + sender);
    }
    if( message.toLowerCase().startsWith("!kudos herp") {
      herpKudos.add(sender);
      sendMessage("NickServ", "info " + sender);
    }
  }
}