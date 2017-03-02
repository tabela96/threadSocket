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
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private boolean check=false;
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
		shell.setSize(166, 133);
		shell.setText("SWT Application");
		
		Label n1 = new Label(shell, SWT.NONE);
		n1.setBounds(10, 10, 21, 15);
		
		Label n2 = new Label(shell, SWT.NONE);
		n2.setBounds(37, 10, 21, 15);
		
		Label n3 = new Label(shell, SWT.NONE);
		n3.setBounds(64, 10, 21, 15);
		
		Label n4 = new Label(shell, SWT.NONE);
		n4.setBounds(91, 10, 21, 15);
		
		Label n5 = new Label(shell, SWT.NONE);
		n5.setBounds(118, 10, 21, 15);
		
		Label controlla = new Label(shell, SWT.NONE);
		controlla.setBounds(10, 47, 129, 15);
		
		Button btnGenera = new Button(shell, SWT.NONE);
		btnGenera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(check==false){
					num1=(int)(Math.random()*10);
					n1.setText(String.valueOf(num1));
					num2=(int)(Math.random()*(21-11)+11);
					n2.setText(String.valueOf(num2));
					num3=(int)(Math.random()*(31-21)+21);
					n3.setText(String.valueOf(num3));
					num4=(int)(Math.random()*(41-31)+31);
					n4.setText(String.valueOf(num4));
					num5=(int)(Math.random()*(51-41)+41);
					n5.setText(String.valueOf(num5));
					check=true;
				}else{
					controlla.setText("Numeri già generati!");
				}	
				
			}
		});
		btnGenera.setBounds(10, 70, 129, 25);
		btnGenera.setText("Genera");

	}
}
