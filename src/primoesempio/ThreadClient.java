package primoesempio;

public class ThreadClient extends Thread {
	
	// Deve essere inizializzato con il socket e il riferimento della grafica
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		// All'infinito resta in ascolto di nuovi messaggi nel socket
		// Quando arriva un nuovo messaggio:
		// - legge il messaggio
		// - comunica alla grafica il nuovo messaggio
	}
}
