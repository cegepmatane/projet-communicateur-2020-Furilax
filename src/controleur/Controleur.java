package controleur;

import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale() 
	{
		//return VueFilmScienceFiction.getInstance();
		//return VueFilmAction.getInstance();
		//return VueFilmAnimation.getInstance();
		//return VueOptions.getInstance();
		return VueBadge.getInstance();
	}	
}