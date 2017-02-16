package primoesempio;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shlClient;
	private Text txtInvia;
	private Text txtChat;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlClient.open();
		shlClient.layout();
		while (!shlClient.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlClient = new Shell();
		shlClient.setSize(450, 300);
		shlClient.setText("Client");
		
		Button btnConnessione = new Button(shlClient, SWT.NONE);
		btnConnessione.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Si connette al server e crea il socket
				try {
					// Crea un thread di ascolto dei messaggi a cui passerà:
					s=new Socket("localhost", 9999);
					ThreadClient tc=new ThreadClient(s, Client.this);
					out=new PrintWriter(s.getOutputStream(), true);
					// - Il socket
					// - La grafica
					tc.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnessione.setBounds(10, 10, 400, 25);
		btnConnessione.setText("Connessione");
		
		txtInvia = new Text(shlClient, SWT.BORDER);
		txtInvia.setBounds(10, 229, 307, 21);
		
		Button btnInvia = new Button(shlClient, SWT.NONE);
		btnInvia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Uso il socket già aperto
				// Leggo il messaggio dalla casella di testo
				String message=txtInvia.getText();
				// Invio un messaggio al client con il printwriter
				out.println(message);
			}
		});
		btnInvia.setBounds(335, 227, 75, 25);
		btnInvia.setText("Invia");
		
		txtChat = new Text(shlClient, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtChat.setBounds(10, 41, 400, 170);
		
		}
		public void addMessage(String message){
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					txtChat.append(message +"\n");
				}
			});
		}
}
