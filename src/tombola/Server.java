package tombola;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Server {

	protected Shell shell;
	private ServerSocket ss;
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
	private boolean check=false;
	private ThreadServer ts;
	private Table table;

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
		shell.setSize(505, 378);
		shell.setText("SWT Application");
		
		Button btnGenera = new Button(shell, SWT.NONE);
		btnGenera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ts=new ThreadServer();
					ts.start();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}			
			}
		});
		btnGenera.setBounds(0, 259, 479, 25);
		btnGenera.setText("Genera");
		
		table = new Table(shell, SWT.NONE);
		table.setBounds(10, 10, 469, 217);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(93);
		tblclmnNewColumn.setText("New Column");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(94);
		tblclmnNewColumn_1.setText("New Column");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(94);
		tblclmnNewColumn_2.setText("New Column");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(94);
		tblclmnNewColumn_3.setText("New Column");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(93);
		tblclmnNewColumn_4.setText("New Column");
		
		Button btnCreaNumeri = new Button(shell, SWT.NONE);
		btnCreaNumeri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int n = ts.numera();
				int riga = n%10;
				int colonna = (int)((n-1)/10);
				switch(riga){
				case 1:
					ti1.setText(colonna, "" + n);
					break;
				case 2:
					ti2.setText(colonna, "" + n);
					break;
				case 3:
					ti3.setText(colonna, "" + n);
					break;
				case 4:
					ti4.setText(colonna, "" + n);
					break;
				case 5:
					ti5.setText(colonna, "" + n);
					break;
				case 6:
					ti6.setText(colonna, "" + n);
					break;
				case 7:
					ti7.setText(colonna, "" + n);
					break;
				case 8:
					ti8.setText(colonna, "" + n);
					break;
				case 9:
					ti9.setText(colonna, "" + n);
					break;
				case 0:
					ti10.setText(colonna, "" + n);
					break;
				
				
				}
				
			}
		});
		btnCreaNumeri.setBounds(0, 290, 75, 25);
		btnCreaNumeri.setText("crea numeri");

	}
}
