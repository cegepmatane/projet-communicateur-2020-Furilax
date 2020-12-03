package vue;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import fonction.RecupererMessage;
import javafx.scene.layout.Pane;
import modele.BadgeCinephile;
import modele.BadgeCinephile.ECUSSON;
import modele.BadgeCinephile.SYMBOLE;
import modele.Message;
import controleur.ControleurFilmScienceFiction;

public class VueFilmScienceFiction extends Vue {

	protected ControleurFilmScienceFiction controleur;
	protected static VueFilmScienceFiction instance = null; 
	public static VueFilmScienceFiction getInstance() {if(null==instance)instance = new VueFilmScienceFiction();return VueFilmScienceFiction.instance;}; 
	
	private VueFilmScienceFiction() 
	{
		super("VueFilmScienceFiction.fxml"); 
		super.controleur = this.controleur = new ControleurFilmScienceFiction();
		Logger.logMsg(Logger.INFO, "new VueFilmScienceFiction()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		BadgeCinephile badge = new BadgeCinephile().colorer("blue").utiliseBadge(ECUSSON.DEUXIEME).afficherSymbole(SYMBOLE.SOUCOUPE);
		
		Pane panneauChat = (Pane) lookup("#chat");
		panneauChat.getChildren().add(badge);
		
	}
}