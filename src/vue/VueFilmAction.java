package vue;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import fonction.RecupererMessage;
import javafx.scene.layout.Pane;
import modele.Message;
import controleur.ControleurFilmAction;

public class VueFilmAction extends Vue {

	protected ControleurFilmAction controleur;
	protected static VueFilmAction instance = null; 
	public static VueFilmAction getInstance() {if(null==instance)instance = new VueFilmAction();return VueFilmAction.instance;}; 
	
	private VueFilmAction() 
	{
		super("VueFilmAction.fxml"); 
		super.controleur = this.controleur = new ControleurFilmAction();
		Logger.logMsg(Logger.INFO, "new VueFilmAction()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		RecupererMessage messageFonction = new RecupererMessage();
		List<Message> listeMessages = new ArrayList<Message>();
		listeMessages = messageFonction.RecupererMessage("C01E6U4MJ23");
		Pane messageBox = (Pane)lookup("#messageBox");
		for (Message message : listeMessages) 
		{ 
			
		}
		
		
		/*
		Button actionCalculatrice = (Button) lookup("#action-calculatrice");
		actionCalculatrice.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Calculatrice activé");
            	controleur.notifierEvenement(ActionNavigation.CALCULATRICE);
            }
        });
		*/

	}
}
