package tombola;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Server {

	protected Shell shell;
	private ServerSocket ss;
	
	private static class ServerThread extends Thread{
		Socket s;
		
		public ServerThread(Socket s) {
			// TODO Auto-generated constructor stub
			this.s=s;
		}
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Server window = new Server();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(166, 113);
		shell.setText("SWT Application");
		
		Label n1 = new Label(shell, SWT.NONE);
		n1.setBounds(10, 10, 21, 15);
		n1.setText("n1");
		
		Label n2 = new Label(shell, SWT.NONE);
		n2.setBounds(37, 10, 21, 15);
		n2.setText("n2");
		
		Label n3 = new Label(shell, SWT.NONE);
		n3.setBounds(64, 10, 21, 15);
		n3.setText("n3");
		
		Label n4 = new Label(shell, SWT.NONE);
		n4.setBounds(91, 10, 21, 15);
		n4.setText("n4");
		
		Label n5 = new Label(shell, SWT.NONE);
		n5.setBounds(118, 10, 21, 15);
		n5.setText("n5");
		
		Button btnGenera = new Button(shell, SWT.NONE);
		btnGenera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnGenera.setBounds(10, 40, 129, 25);
		btnGenera.setText("Genera");

	}
}
