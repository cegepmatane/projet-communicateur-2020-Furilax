package fonction;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modele.Message;

public class RecupererMessage {
	public List<Message> RecupererMessage() {
		
		List<Message> listeMessages = new ArrayList<Message>();
		
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
			Scanner contenue=new Scanner(reponse);  
			contenue.useDelimiter(",");
			String user  ="";
			String text  ="";
			while (contenue.hasNext())   
			{  
				String ligne = contenue.next();
				if(ligne.contains("user")) {
					user = ligne;
				}
				if(ligne.contains("text")) {
					text = ligne;
				}
				if(user != "" && text != "") {
					String userFinal = null;
					String textFinal = null;
					if(!text.contains("elements")) {
						//System.out.println(user + text);
					      for (String userString: user.split(":")) {
					    	  if(!userString.contains("user")) {
					    		  userFinal = userString.replaceAll("\"","");
						    	  break; 
					    	  }
					       }
					      for (String textString: text.split(":")) {
					    	  if(!textString.contains("text") && !textString.contains("a rejoint le canal") ) {
					    		  textFinal = textString.replaceAll("\"","").replaceAll("}","").replaceAll("]","");
						    	  break; 
					    	  }
					       }
					    if(userFinal != null && textFinal != null ) {
					    	Message message = new Message();
					    	message.user = userFinal;
					    	message.text = textFinal;
					    	listeMessages.add(message);
					    	
					    }
						user = "";
						text = "";
					}
				}
			}
			
			//System.out.println("Code Reponse : " + codeReponse);
			//System.out.println("Reponse : " + reponse);
			connection.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeMessages; 
	}
	
}
