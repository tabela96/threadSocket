package tombola;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.internal.progress.TaskBarProgressManager;

public class Client {

	protected Shell shell;
	private Socket s;
	private Table table;
	private ArrayList<Integer> numeri = new ArrayList<>();
	private TableItem ti1;
	private TableItem ti2;
	private TableItem ti3;
	
	/**
	 * Launch the application.
	 * 
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
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		vai();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws IOException 
	 */
	protected void createContents() throws IOException {
		shell = new Shell();
		shell.setSize(450, 166);
		shell.setText("SWT Application");

		table = new Table(shell, SWT.FULL_SELECTION);
		table.setBounds(10, 10, 415, 81);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn da0a10 = new TableColumn(table, SWT.NONE);
		da0a10.setWidth(83);
		da0a10.setText("New Column");

		TableColumn da11a20 = new TableColumn(table, SWT.NONE);
		da11a20.setWidth(83);
		da11a20.setText("New Column");

		TableColumn da21a30 = new TableColumn(table, SWT.NONE);
		da21a30.setWidth(83);
		da21a30.setText("New Column");
		
		
		

		TableColumn da31a40 = new TableColumn(table, SWT.NONE);
		da31a40.setWidth(83);
		da31a40.setText("New Column");

		TableColumn da41a50 = new TableColumn(table, SWT.NONE);
		da41a50.setWidth(83);
		da41a50.setText("New Column");
		
		ti1=new TableItem(table, SWT.NONE);
		ti2=new TableItem(table, SWT.NONE);
		ti3=new TableItem(table, SWT.NONE);

	}

	public void addMessage(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				numeri.add(Integer.parseInt(message));
				System.out.println(numeri);
				if(numeri.size()==15){
					ti1.setText(0, numeri.get(0).toString());
					ti2.setText(0, numeri.get(1).toString());
					ti3.setText(0, numeri.get(2).toString());
					ti1.setText(1, numeri.get(3).toString());
					ti2.setText(1, numeri.get(4).toString());
					ti3.setText(1, numeri.get(5).toString());
					ti1.setText(2, numeri.get(6).toString());
					ti2.setText(2, numeri.get(7).toString());
					ti3.setText(2, numeri.get(8).toString());
					ti1.setText(3, numeri.get(9).toString());
					ti2.setText(3, numeri.get(10).toString());
					ti3.setText(3, numeri.get(11).toString());
					ti1.setText(4, numeri.get(12).toString());
					ti2.setText(4, numeri.get(13).toString());
					ti3.setText(4, numeri.get(14).toString());
				}
			}
		});
	}

	public void vai() throws IOException {
		Socket s = new Socket("localhost", 9999);
		ThreadClient tc = new ThreadClient(s, Client.this);
		tc.start();
	}
}
