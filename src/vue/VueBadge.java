package vue;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.scene.layout.Pane;
import modele.BadgeCinephile;
import modele.BadgeCinephile.ECUSSON;
import modele.BadgeCinephile.SYMBOLE;
import controleur.ControleurBadge;

public class VueBadge extends Vue {

	protected ControleurBadge controleur;
	protected static VueBadge instance = null; 
	public static VueBadge getInstance() {if(null==instance)instance = new VueBadge();return VueBadge.instance;}; 
	
	private VueBadge() 
	{
		super("VueBadge.fxml"); 
		super.controleur = this.controleur = new ControleurBadge();
		Logger.logMsg(Logger.INFO, "new VueBadge()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		BadgeCinephile badge = new BadgeCinephile().colorer("red").utiliseBadge(ECUSSON.DEUXIEME).afficherSymbole(SYMBOLE.PELLICULE);
		
		Pane panneauChat = (Pane) lookup("#chat");
		panneauChat.getChildren().add(badge);
		
	}
}