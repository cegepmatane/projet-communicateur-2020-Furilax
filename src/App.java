import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fonction.RecupererMessage;
import modele.Message;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		//Fenetre.launch(Fenetre.class, parametres);	
		RecupererMessage messageFonction = new RecupererMessage();
		List<Message> listeMessages = new ArrayList<Message>();
		listeMessages = messageFonction.RecupererMessage();
		for (Message message : listeMessages) 
		{ 
			System.out.println(message.user + " : "+message.text);
		}
	}

}
