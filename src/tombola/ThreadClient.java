package tombola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient extends Thread {
	private Socket s;
	private Client c;
	
	
	// Deve essere inizializzato con il socket e il riferimento della grafica
	public ThreadClient(Socket s, Client c){
		this.c=c;
		this.s=s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		// All'infinito resta in ascolto di nuovi messaggi nel socket
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){
				// Quando arriva un nuovo messaggio:
				String message=in.readLine();
				
				// - legge il messaggio
				// - comunica alla grafica il nuovo messaggio
				c.addMessage(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void scrivi(String m) throws IOException{
		PrintWriter out=new PrintWriter(s.getOutputStream(), true);
		out.println(m);
	}
}
