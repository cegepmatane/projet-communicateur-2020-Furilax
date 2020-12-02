package vue;
import com.sun.media.jfxmedia.logging.Logger;

import fonction.EnvoyerMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class VueFilmAnimation extends Vue {
	protected static VueFilmAnimation instance = null; 
	public static VueFilmAnimation getInstance() {if(null==instance)instance = new VueFilmAnimation();return VueFilmAnimation.instance;}; 
	
	private VueFilmAnimation() 
	{
		super("VueFilmAnimation.fxml"); 
		Logger.logMsg(Logger.INFO, "new VueFilmAnimation()");
	}
		
	public void activerControles() 
	{	
		TextField text = new TextField();
		Button BouttonEnvoyer = (Button)lookup("#BouttonEnvoyer");
		BouttonEnvoyer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				text.getText();
				EnvoyerMessage envoyerFonction = new EnvoyerMessage();
				envoyerFonction.envoyer("text", "#filmAnimation");
			}
		});
	}
}
