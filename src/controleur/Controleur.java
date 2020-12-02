package controleur;

import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale() 
	{
		//return VueMurmure.getInstance();
		return VueFilmAction.getInstance();
	}	
}