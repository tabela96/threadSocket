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
		
		table = new Table(shell, SWT.NONE);
		table.setBounds(10, 10, 415, 241);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn da0a10 = new TableColumn(table, SWT.NONE);
		da0a10.setResizable(false);
		da0a10.setWidth(83);
		
		TableColumn da11a20 = new TableColumn(table, SWT.NONE);
		da11a20.setWidth(83);
		
		TableColumn da21a30 = new TableColumn(table, SWT.NONE);
		da21a30.setWidth(83);
		
		TableColumn da31a40 = new TableColumn(table, SWT.NONE);
		da31a40.setWidth(83);
		
		TableColumn da41a50 = new TableColumn(table, SWT.NONE);
		da41a50.setWidth(83);
		
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
				int n = 0;
				if(numeri.size()==15){
					for(int i = 0;i < 5;i++){
					ti1.setText(i, numeri.get(n).toString());
					n++;
					ti2.setText(i, numeri.get(n).toString());
					n++;
					ti3.setText(i, numeri.get(n).toString());
					n++;
					}
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
