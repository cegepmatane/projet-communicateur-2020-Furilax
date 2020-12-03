package controleur;

import vue.*;

public class Controleur {

	public enum ActionNavigation{ACTION,OPTIONS,ANIMATION,SCIENCEFICTION,BADGE};
	
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
		case ANIMATION:
			Navigateur.getInstance().afficherVue(VueFilmAnimation.getInstance());
			VueFilmAnimation.getInstance().activerControles();
			break;
		case SCIENCEFICTION:
			Navigateur.getInstance().afficherVue(VueFilmScienceFiction.getInstance());
			VueFilmScienceFiction.getInstance().activerControles();
			break;
		case BADGE:
			Navigateur.getInstance().afficherVue(VueBadge.getInstance());
			VueBadge.getInstance().activerControles();
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