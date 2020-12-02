package vue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import fonction.RecupererMessage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
		Collections.reverse(listeMessages);
		ScrollPane scroll = (ScrollPane)lookup("#scrollPane");
		Pane messageBox = (Pane)lookup("#vBoxParents");
		scroll.setContent(messageBox); 
		for (Message message : listeMessages) 
		{ 
			Pane messagePane = new Pane();
			Text textUtilisateur = new Text();
			Text textMessage = new Text();
			textUtilisateur.setText(message.user);
			textMessage.setText(message.text);
			textMessage.setLayoutX(90);
			textMessage.setLayoutY(20);
			textUtilisateur.setLayoutY(20);
			messagePane.getChildren().add(textUtilisateur);
			messagePane.getChildren().add(textMessage);
			messagePane.setStyle("-fx-background-color: #5f7bd8");
			messagePane.setMaxWidth(300);
			messagePane.setMinHeight(50);
			messageBox.getChildren().add(messagePane);
			
		}
		BadgeCinephile badge = new BadgeCinephile();
		
		Pane panneauChat = (Pane) lookup("#chat");
		panneauChat.getChildren().add(badge);
		scroll.setVvalue(1.0); 
		scroll.setStyle("-fx-background: #232323; -fx-border-color: #232323;");
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		
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
