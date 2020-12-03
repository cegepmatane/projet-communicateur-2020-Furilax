package vue;

import java.io.IOException;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import controleur.Controleur.ActionNavigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Vue extends Scene{
	protected static FXMLLoader parseur = null;
	protected Controleur controleur = null;
	public String color = "#FFFFFF";
	
	public Vue(String fxml)
	{
		super(parser(fxml, null),1350,744);
		this.controleur = null;
	}
	public Vue(String fxml, Controleur controleur)
	{
		super(parser(fxml, controleur),1350,744);
		this.controleur = controleur;
	}

	public static Parent parser(String fxml, Controleur controleur)
	{
		parseur = new FXMLLoader();
		parseur.setLocation(VueFilmAction.class.getResource(fxml));
		if(null != controleur) parseur.setController(controleur);
		try {
			return parseur.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("fin parser");
		return null;
	}

	public void activerControles()
	{	
		//Logger.logMsg(Logger.INFO, "activerControles()");
		
		Button actionFilmAction = (Button)lookup("#bouttonAction");
		if(actionFilmAction != null) {
			actionFilmAction.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					Logger.logMsg(Logger.INFO,"Bouton film action");
					controleur.notifierEvenement(ActionNavigation.ACTION);
				}
			});
		}
		
		Button actionOptions = (Button)lookup("#bouttonOptions");
		if(actionOptions != null) {
			actionOptions.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					Logger.logMsg(Logger.INFO,"Bouton options");
					controleur.notifierEvenement(ActionNavigation.OPTIONS);
				}
			});
		}
		Button actionAnimation = (Button)lookup("#bouttonAnimation");
		if(actionAnimation != null) {
			actionAnimation.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					Logger.logMsg(Logger.INFO,"Bouton animation");
					controleur.notifierEvenement(ActionNavigation.ANIMATION);
				}
			});
		}
		Button actionScienceFiction = (Button)lookup("#bouttonScienceFiction");
		if(actionScienceFiction != null) {
			actionScienceFiction.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					Logger.logMsg(Logger.INFO,"Bouton science ficiton");
					controleur.notifierEvenement(ActionNavigation.SCIENCEFICTION);
				}
			});
		}
		Button actionBadge = (Button)lookup("#bouttonBadge");
		if(actionBadge != null) {
			actionBadge.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					Logger.logMsg(Logger.INFO,"Bouton badge");
					controleur.notifierEvenement(ActionNavigation.BADGE);
				}
			});
		}
	}		
	
}
