package fonction;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modele.Message;

public class RecupererMessage {
	public List<Message> RecupererMessage(String idDeSalon) {
		
		List<Message> listeMessages = new ArrayList<Message>();
		
		String CLE = "xoxb-1503846676852-1544518812964-lbqSBwzun7fEfbiWDiAmW8N6";
		String URL_SALON_DISCUSSION = "https://slack.com/api/conversations.history";
		try {
						
			URL urlSalonDiscussion = new URL(URL_SALON_DISCUSSION + "?channel=" + idDeSalon);
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
