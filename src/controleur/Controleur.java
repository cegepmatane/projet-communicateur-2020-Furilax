package controleur;

import vue.Vue;
import vue.VueMurmure;
import vue.VueFilmAction;

public class Controleur {

	public static Vue selectionnerVuePrincipale() 
	{
		return VueMurmure.getInstance();
		//return VueFilmAction.getInstance();
	}

		
}
