package fonction;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class EnvoyerMessage {
	public void envoyer(String message, String salon) {
		try {
			
			String CLE = "xoxp-1503846676852-1482950876327-1544507517572-b27c0e5e4a7aa8e51557708a04e843f8";
			String URL_ENVOYER_MESSAGE = "https://slack.com/api/chat.postMessage";
			String ENVOI = "{'channel': '"+ salon +"',  'text': '"+message+"'}";
			System.out.println(ENVOI);
						
			URL urlAjouterMessage = new URL(URL_ENVOYER_MESSAGE);
			HttpURLConnection connection = (HttpURLConnection) urlAjouterMessage.openConnection();
			connection.setRequestProperty("Authorization","Bearer "+CLE);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setDoOutput(true);
			
			OutputStream fluxEcriture = connection.getOutputStream();
			OutputStreamWriter envoyeur = new OutputStreamWriter(fluxEcriture);
			envoyeur.write(ENVOI);
			envoyeur.close();	
			
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
