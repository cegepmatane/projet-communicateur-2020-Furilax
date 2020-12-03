package controleur;

import vue.*;

public class Controleur {

	public enum ActionNavigation{ACTION,OPTIONS};
	
	public void notifierEvenement(ActionNavigation action) {
		switch(action) 
		{
		case ACTION:
			Navigateur.getInstance().afficherVue(VueFilmAction.getInstance());
			VueFilmAction.getInstance().activerControles();
			break;
		case OPTIONS:
			Navigateur.getInstance().afficherVue(VueOptions.getInstance());
			VueOptions.getInstance().activerControles();
			break;
		}
		
	}
	
	
	
	public static Vue selectionnerVuePrincipale() 
	{
		//return VueFilmScienceFiction.getInstance();
		return VueFilmAction.getInstance();
		//return VueFilmAnimation.getInstance();
		//return VueOptions.getInstance();
		//return VueBadge.getInstance();
	}	
}