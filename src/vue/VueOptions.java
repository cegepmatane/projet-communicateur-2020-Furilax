package vue;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import fonction.RecupererMessage;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import modele.BadgeCinephile;
import modele.Message;
import controleur.ControleurOptions;

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
		ColorPicker picker = new ColorPicker();
		super.color = picker.getValue().toString();
		
		
		
	}
}