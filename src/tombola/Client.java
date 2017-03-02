package tombola;

import java.net.Socket;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Client {

	protected Shell shlTombola;
	private Socket s;
	private ArrayList<Integer> scheda=new ArrayList<>();
	private Table table;
	

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
		while (!shlTombola.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTombola = new Shell();
		shlTombola.setText("Tombola");
		shlTombola.setLayout(null);
		
		table = new Table(shlTombola, SWT.NONE);
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
		da41a50.setText("ciao");
		
		

	}
	
	public void addMessage(String message){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//txtChat.append(message +"\n");
			}
		});
	}
}
