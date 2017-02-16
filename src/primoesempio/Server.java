package primoesempio;

public class Server {
	
	private static class ServerThread extends Thread{
		
		// Il costruttore deve ricevere il socket su cui lavorare
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			// resta in attesa dei messaggi del client
			// quando riceve un messaggio
			// manda il messaggio a tutti i client
		}
	}

	public static void main(String[] args) {
		// Crea un server socket in ascolto
		// per ogni connessione crea un socket e un thread che lo gestisca
		// Aggiunge ad un vettore di client il nuovo cient
		// Ritorna in ascolto/attesa
		
	}

}
