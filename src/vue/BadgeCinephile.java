package vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class BadgeCinephile extends AnchorPane{

	protected ImageView masqueEcusson = new ImageView();
	protected ImageView symboleFilm = new ImageView();
	
	public BadgeCinephile() 
	{
		Label titre = new Label("Cinephile");
		masqueEcusson.setImage(new Image("badge.png"));
		symboleFilm.setImage(new Image("iconeFilm.png"));
		
		this.getChildren().add(titre);
		this.getChildren().add(masqueEcusson);
		this.getChildren().add(symboleFilm);
		
	}
	
}
