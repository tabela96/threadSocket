package tombola;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Server {

	protected Shell shlTabellone;
	private TableItem ti1;
	private TableItem ti2;
	private TableItem ti3;
	private TableItem ti4;
	private TableItem ti5;
	private TableItem ti6;
	private TableItem ti7;
	private TableItem ti8;
	private TableItem ti9;
	private TableItem ti10;
	private ThreadServer ts;
	private boolean iniziata = false;
	private Table table;
	private boolean check = false; 
	private Button btnChiamaNumero;
	/**
	 * Launch the application.
	 * 
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
		shlTabellone.open();
		System.out.println("Premi tasto ACCENDI, poi avvia i CLIENT");
		shlTabellone.layout();
		while (!shlTabellone.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	public boolean getIniziata(){
		return iniziata;
	}
	
	protected void createContents() {
		shlTabellone = new Shell();
		shlTabellone.setSize(505, 323);
		shlTabellone.setText("Tabellone!");

		Button btnAccendi = new Button(shlTabellone, SWT.NONE);
		btnAccendi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("LA TOMBOLA È ATTIVA!");
				try {
					ts = new ThreadServer(Server.this);
					ts.start();
					btnAccendi.setEnabled(false);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnAccendi.setBounds(10, 259, 226, 25);
		btnAccendi.setText("Accendi");

		table = new Table(shlTabellone, SWT.NONE);
		table.setBounds(10, 10, 469, 217);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(93);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(94);

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(94);

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(94);

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(93);

		ti1 = new TableItem(table, SWT.NONE);
		ti2 = new TableItem(table, SWT.NONE);
		ti3 = new TableItem(table, SWT.NONE);
		ti4 = new TableItem(table, SWT.NONE);
		ti5 = new TableItem(table, SWT.NONE);
		ti6 = new TableItem(table, SWT.NONE);
		ti7 = new TableItem(table, SWT.NONE);
		ti8 = new TableItem(table, SWT.NONE);
		ti9 = new TableItem(table, SWT.NONE);
		ti10 = new TableItem(table, SWT.NONE);

		btnChiamaNumero = new Button(shlTabellone, SWT.NONE);
		btnChiamaNumero.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				iniziata = true;
				int n = ts.numera();
				int n1= n;
				if(!check){
					check = true;
				}
				else{
					n1 = ts.decolora();
				}
				ts.scriviTutti(n+"");
				int riga = n % 10;
				int colonna = (int) ((n - 1) / 10);
				switch (riga) {
				case 1:
					ti1.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti1.setText(colonna, "" + n);
					break;
				case 2:
					ti2.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti2.setText(colonna, "" + n);
					break;
				case 3:
					ti3.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti3.setText(colonna, "" + n);
					break;
				case 4:
					ti4.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti4.setText(colonna, "" + n);
					break;
				case 5:
					ti5.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti5.setText(colonna, "" + n);
					break;
				case 6:
					ti6.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti6.setText(colonna, "" + n);
					break;
				case 7:
					ti7.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti7.setText(colonna, "" + n);
					break;
				case 8:
					ti8.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti8.setText(colonna, "" + n);
					break;
				case 9:
					ti9.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti9.setText(colonna, "" + n);
					break;
				case 0:
					ti10.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ti10.setText(colonna, "" + n);
					break;
				}

				
				riga = n1 % 10;
				colonna = (int) ((n1 - 1) / 10);
				switch (riga) {
				case 1:
					ti1.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti1.setText(colonna, "" + n1);
					break;
				case 2:
					ti2.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));		
					ti2.setText(colonna, "" + n1);
					break;
				case 3:
					ti3.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti3.setText(colonna, "" + n1);
					break;
				case 4:
					ti4.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti4.setText(colonna, "" + n1);
					break;
				case 5:
					ti5.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti5.setText(colonna, "" + n1);
					break;
				case 6:
					ti6.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti6.setText(colonna, "" + n1);
					break;
				case 7:
					ti7.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti7.setText(colonna, "" + n1);
					break;
				case 8:
					ti8.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti8.setText(colonna, "" + n1);
					break;
				case 9:
					ti9.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti9.setText(colonna, "" + n1);
					break;
				case 0:
					ti10.setForeground(colonna,SWTResourceManager.getColor(SWT.COLOR_BLACK));
					ti10.setText(colonna, "" + n1);
					break;
				}

			}
		});
		btnChiamaNumero.setBounds(253, 259, 226, 25);
		btnChiamaNumero.setText("Chiama numero");
		

	}
	public void bottone(){
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				btnChiamaNumero.setEnabled(false);
			}
			
		} );
		}
		public void testo(String message,Socket s){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					JOptionPane.showMessageDialog(null, s.getInetAddress() + " ha fatto " + message, "WOW!!", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} );
		
	}
}
