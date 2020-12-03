package modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class BadgeCinephile extends AnchorPane{

	protected ImageView masqueEcusson = new ImageView();
	protected ImageView symboleFilm = new ImageView();
	
	public BadgeCinephile() 
	{
		this.setPrefHeight(200);
		this.setPrefWidth(166);
		this.setLayoutX(40);
		this.setLayoutY(30);
		this.setStyle("-fx-background-color: white;");
		
		masqueEcusson.setImage(new Image("vue/badge.png"));
		masqueEcusson.setFitHeight(200);
		masqueEcusson.setFitWidth(200);
		masqueEcusson.setPreserveRatio(true);
		
		symboleFilm.setImage(new Image("vue/iconeFilm.png"));
		symboleFilm.setLayoutX(50);
		symboleFilm.setLayoutY(90);
		symboleFilm.setFitHeight(79);
		symboleFilm.setFitWidth(81);
		symboleFilm.setPreserveRatio(true);

		Label titre = new Label("Cinephile");
		titre.setLayoutX(22);
		titre.setLayoutY(30);
		titre.setPrefHeight(40);
		titre.setPrefWidth(137);
		titre.setAlignment(Pos.CENTER);
		titre.setStyle("-fx-weight:bold; -fx-font-size:30px;");
		titre.setTextFill(Color.WHITE);
		
		this.getChildren().add(masqueEcusson);
		this.getChildren().add(titre);
		this.getChildren().add(symboleFilm);
		
	}
	
	public BadgeCinephile colorer(String couleur) 
	{
		this.setStyle("-fx-background-color:" + couleur);
		return this;
	}
	
	public enum ECUSSON{PREMIER, DEUXIEME};
	public BadgeCinephile utiliseBadge(ECUSSON ecusson) 
	{
		if(ecusson == ECUSSON.PREMIER)
			masqueEcusson.setImage(new Image("vue/badge.png"));
		else if (ecusson == ECUSSON.DEUXIEME) {
			masqueEcusson.setImage(new Image("vue/badge2.png"));
			masqueEcusson.setFitHeight(300);
			masqueEcusson.setFitWidth(200);
			masqueEcusson.setPreserveRatio(true);
			
			symboleFilm.setLayoutX(60);
			symboleFilm.setLayoutY(120);
			symboleFilm.setFitHeight(79);
			symboleFilm.setFitWidth(81);
			symboleFilm.setPreserveRatio(true);
		}
		return this;
	}
	
	public enum SYMBOLE {PELLICULE, CLAP, SOUCOUPE}
	public BadgeCinephile afficherSymbole(SYMBOLE symbole) 
	{
		if(symbole == SYMBOLE.PELLICULE)
			symboleFilm.setImage(new Image("vue/iconeFilm.png"));
		else if (symbole == SYMBOLE.CLAP)
			symboleFilm.setImage(new Image("vue/clap.png"));
		else if (symbole == SYMBOLE.SOUCOUPE)
			symboleFilm.setImage(new Image("vue/scifi.png"));
		
		return this;
	}
}
