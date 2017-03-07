package tombola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer extends Thread {
	private ServerSocket ss;
	private ArrayList<Connessione> connessioni=new ArrayList<>();
	
	public ThreadServer() throws IOException {
		// TODO Auto-generated constructor stub
		ss=new ServerSocket(9999);
	}
	
	public void run(){
		while(true){
			try {
				Socket s=ss.accept();
				Connessione cn=new Connessione(s);
				connessioni.add(cn);
				cn.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void scriviTutti(String m){
		for(int i=0;i<connessioni.size();i++){
			connessioni.get(i).scrivi(m);
		}
	}
	
	public class Connessione extends Thread{
		private Socket s1;
		PrintWriter out;
		BufferedReader in;
		public Connessione(Socket s) throws IOException {
			// TODO Auto-generated constructor stub
			s1=s;
			out=new PrintWriter(s1.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader(s1.getInputStream()));
		}
		
		public void run(){
			for(int i=0;i<15;i++){
				int n=(int)(Math.random()*10) + (int)((i/3)*10)+1;
				System.out.println("numero" + n );
				scrivi(String.valueOf(n));
			}
			while(true){
				try {
					String message=in.readLine();
					System.out.println(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					return;
					//e.printStackTrace();
				}
			}
		}
		
		public void scrivi(String s){
			out.println(s);
		}
	}
}
