package vue;
import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurMurmure;

public class VueMurmure extends Vue {

	protected ControleurMurmure controleur;
	protected static VueMurmure instance = null; 
	public static VueMurmure getInstance() {if(null==instance)instance = new VueMurmure();return VueMurmure.instance;}; 
	
	private VueMurmure() 
	{
		super("murmure.fxml"); 
		super.controleur = this.controleur = new ControleurMurmure();
		Logger.logMsg(Logger.INFO, "new VueMurmure()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
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
