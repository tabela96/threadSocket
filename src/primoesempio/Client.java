package primoesempio;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shlClient;
	private Text txtInvia;
	private Text txtChat;

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
				// Crea un thread di ascolto dei messaggi a cui passerà:
				// - Il socket
				// - La grafica
			}
		});
		btnConnessione.setBounds(10, 10, 400, 25);
		btnConnessione.setText("Connessione");
		
		txtInvia = new Text(shlClient, SWT.BORDER);
		txtInvia.setBounds(10, 229, 307, 21);
		
		Button btnInvia = new Button(shlClient, SWT.NONE);
		btnInvia.setBounds(335, 227, 75, 25);
		btnInvia.setText("Invia");
		
		txtChat = new Text(shlClient, SWT.BORDER);
		txtChat.setBounds(10, 41, 400, 170);

	}
}
