package vue;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import fonction.RecupererMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modele.BadgeCinephile;
import modele.Message;
import controleur.ControleurOptions;
import controleur.Controleur.ActionNavigation;

public class VueOptions extends Vue {

	protected ControleurOptions controleur;
	protected static VueOptions instance = null; 
	public static VueOptions getInstance() {if(null==instance)instance = new VueOptions();return VueOptions.instance;}; 
	
	private VueOptions() 
	{
		super("VueOption.fxml"); 
		super.controleur = this.controleur = new ControleurOptions();
		Logger.logMsg(Logger.INFO, "new VueOptions()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		ColorPicker picker = (ColorPicker) lookup("#ColorPicker");
		super.color = "#FFFFF";
		
		Button actionValider = (Button)lookup("#validerOptions");
		if(actionValider != null) {
			actionValider.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					ChangeColor(toRGBCode(picker.getValue()));
				}
			});
		}
	}
	
	   protected void ChangeColor(String rgbCode) {
		   VueFilmAction.getInstance().color = rgbCode;
		   VueFilmAnimation.getInstance().color = rgbCode;
		   VueFilmScienceFiction.getInstance().color = rgbCode;
	}

	public static String toRGBCode( Color color )
	    {
	        return String.format( "#%02X%02X%02X",
	            (int)( color.getRed() * 255 ),
	            (int)( color.getGreen() * 255 ),
	            (int)( color.getBlue() * 255 ) );
	    }
	
	
}