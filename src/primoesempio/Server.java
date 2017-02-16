package primoesempio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	// Array di PrintWriter per invio messaggi
	static ArrayList<PrintWriter> clientList=new ArrayList<PrintWriter>();

	private static class ServerThread extends Thread {

		Socket s;

		// Il costruttore deve ricevere il socket su cui lavorare
		public ServerThread(Socket s) {
			// TODO Auto-generated constructor stub
			this.s=s;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			// resta in attesa dei messaggi del client
			try {
				BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				// quando riceve un messaggio
				while(true){
					String messaggio=in.readLine();
					System.out.println("Ricevo il messaggio");
					// manda il messaggio a tutti i client
					for (PrintWriter printWriter : clientList) {
						printWriter.println(messaggio);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Crea un server socket in ascolto
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			Socket s = ss.accept();
			// Aggiunge ad un vettore di client il nuovo cient
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			clientList.add(out);
			// per ogni connessione crea un socket e un thread che lo gestisca
			ServerThread st=new ServerThread(s);
			st.start();
			// Ritorna in ascolto/attesa
		}

	}

}
