package vue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurFilmAnimation;
import fonction.EnvoyerMessage;
import fonction.RecupererMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.Message;



public class VueFilmAnimation extends Vue {
	protected static VueFilmAnimation instance = null; 
	public static VueFilmAnimation getInstance() {if(null==instance)instance = new VueFilmAnimation();return VueFilmAnimation.instance;}; 
	protected ControleurFilmAnimation  controleur;
	private List<Pane> paneList = new ArrayList<Pane>(); 
	private VueFilmAnimation() 
	{
		super("VueFilmAnimation.fxml"); 
		super.controleur = this.controleur = new ControleurFilmAnimation();
		Logger.logMsg(Logger.INFO, "new VueFilmAnimation()");
	}
		
	public void activerControles() 
	{	
		super.activerControles();
		LoadMessage();
		Button BouttonEnvoyer = (Button)lookup("#BouttonEnvoyer");
		BouttonEnvoyer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				EnvoyerText();
			}
		});
	}
	
	private void EnvoyerText() {
		TextField text = (TextField)lookup("#Text");
		EnvoyerMessage envoyerFonction = new EnvoyerMessage();
		envoyerFonction.envoyer(text.getText(), "#filmsanimation");
		text.setText("");
		LoadMessage();
	}
	
	private void LoadMessage() {
		RecupererMessage messageFonction = new RecupererMessage();
		List<Message> listeMessages = new ArrayList<Message>();
		listeMessages = messageFonction.RecupererMessage("C01E6U4MJ23");
		Collections.reverse(listeMessages);
		ScrollPane scroll = (ScrollPane)lookup("#scrollPane");
		Pane messageBox = (Pane)lookup("#vBoxParents");
		scroll.setContent(messageBox); 
		for(Pane pane : paneList) {
			messageBox.getChildren().remove(pane);
		}
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
			paneList.add(messagePane);
		}
		scroll.setVvalue(1.0); 
		scroll.setStyle("-fx-background: #232323; -fx-border-color: #232323;");
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	}
	
	
	
}
