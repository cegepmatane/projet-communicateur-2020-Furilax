import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import vue.Fenetre;

public class App {

	//public static void main(String[] parametres) {
	//	Fenetre.launch(Fenetre.class, parametres);	
	//}
	// https://api.slack.com/methods/conversations.history
		public static void main(String[] args) {
			String CLE = "xoxp-1503846676852-1482950876327-1544507517572-b27c0e5e4a7aa8e51557708a04e843f8";
			String URL_SALON_DISCUSSION = "https://slack.com/api/conversations.history";
			String SALON = "#﻿filmsaction";
			String SALON_ID = "C01E6U4MJ23";	
			try {
							
				URL urlSalonDiscussion = new URL(URL_SALON_DISCUSSION + "?channel=" + SALON_ID);
				HttpURLConnection connection = (HttpURLConnection) urlSalonDiscussion.openConnection();
				connection.setRequestProperty("Authorization","Bearer "+CLE);
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Content-Type","application/json");
				
				int codeReponse = connection.getResponseCode();			
				InputStream fluxLecture = connection.getInputStream();
				Scanner lecteur = new Scanner(fluxLecture);			
				lecteur.useDelimiter("\\A");
				String reponse = lecteur.next();
				lecteur.close();
				System.out.println("Code Reponse : " + codeReponse);
				System.out.println("Reponse : " + reponse);
				
				connection.disconnect();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 	

		}

}
