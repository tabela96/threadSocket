package tombola;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shlPlayer;
	private Socket s;
	private Table table;
	private ArrayList<Integer> numeri = new ArrayList<>();
	private ArrayList<Boolean> usciti = new ArrayList<>();
	private TableItem ti1;
	private TableItem ti2;
	private TableItem ti3;
	private boolean ambo = false;
	private boolean terna = false;
	private boolean quaterna = false;
	private boolean cinquina = false;
	private boolean tombola = false;
	private Button btnAmbo;
	private Button btnTerno;
	private Button btnQuaterna;
	private Button btnCinquina;
	private Button btnTombola;
	private ThreadClient tc;

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
		shlPlayer.open();
		vai();
		shlPlayer.layout();
		while (!shlPlayer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @throws IOException
	 */
	protected void createContents() throws IOException {
		shlPlayer = new Shell();
		shlPlayer.setSize(450, 227);
		shlPlayer.setText("Player");

		table = new Table(shlPlayer, SWT.NONE);
		table.setBounds(10, 10, 415, 84);
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

		ti1 = new TableItem(table, SWT.NONE);
		ti2 = new TableItem(table, SWT.NONE);
		ti3 = new TableItem(table, SWT.NONE);

		btnAmbo = new Button(shlPlayer, SWT.NONE);
		btnAmbo.setEnabled(false);

		btnAmbo.addSelectionListener(new SelectionAdapter() {
			@Override	
			public void widgetSelected(SelectionEvent e) {
				String string = "Ambo";
				try {
					tc.scrivi(string);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAmbo.setBounds(10, 109, 75, 71);
		btnAmbo.setText("Ambo");

		btnTerno = new Button(shlPlayer, SWT.NONE);
		btnTerno.setEnabled(false);

		btnTerno.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = "Terno";
				try {
					tc.scrivi(string);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnTerno.setText("Terno");
		btnTerno.setBounds(91, 109, 75, 70);

		btnQuaterna = new Button(shlPlayer, SWT.NONE);
		btnQuaterna.setEnabled(false);
		btnQuaterna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = "Quaterna";
				try {
					tc.scrivi(string);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuaterna.setText("Quaterna");
		btnQuaterna.setBounds(178, 109, 75, 70);

		btnCinquina = new Button(shlPlayer, SWT.NONE);
		btnCinquina.setEnabled(false);
		btnCinquina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = "Cinquina";
				try {
					tc.scrivi(string);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCinquina.setText("Cinquina");
		btnCinquina.setBounds(264, 109, 75, 70);

		btnTombola = new Button(shlPlayer, SWT.NONE);
		btnTombola.setEnabled(false);
		btnTombola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = "Tombola";
				try {
					tc.scrivi(string);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTombola.setText("Tombola");
		btnTombola.setBounds(350, 109, 75, 70);

	}

	public void addMessage(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				int n = 0;
				int temp = 0;
				int j = 0;
				if (numeri.size() < 15) {
					numeri.add(Integer.parseInt(message));
				} else {
					for (int i = 0; i < numeri.size(); i++) {
						if (Integer.parseInt(message) == numeri.get(i)) {
							usciti.set(i, true);
						}
					}
					for (int i = 0; i < 5; i++) {
						if (usciti.get(n))
							ti1.setForeground(i, SWTResourceManager.getColor(SWT.COLOR_GREEN));
						n++;
						if (usciti.get(n))
							ti2.setForeground(i, SWTResourceManager.getColor(SWT.COLOR_GREEN));
						n++;
						if (usciti.get(n))
							ti3.setForeground(i, SWTResourceManager.getColor(SWT.COLOR_GREEN));
						n++;
					}
					System.out.println("-----");
					for (int i = 0; i < usciti.size(); i++) {
						System.out.println("primo for " + i);
						if (usciti.get(i) && i < 15) {
							System.out.println("primo if " + i);
							for (j = i + 3; j < usciti.size(); j += 3) {
								System.out.println("secondo for " + i);
								if (usciti.get(j) && j < 15) {
									System.out.println("ambo true " + i);
									ambo = true;
									btnAmbo.setEnabled(true);
									for (j = j + 3; j < usciti.size(); j += 3) {
										System.out.println("terzo for " + i);
										if (usciti.get(j) && j < 15) {
											System.out.println("terna true " + i);
											terna = true;
											btnTerno.setEnabled(true);
											for (j = j + 3; j < usciti.size(); j += 3) {
												System.out.println("quarto for " + i);
												if (usciti.get(j) && j < 15) {
													System.out.println("quaterna true " + i);
													quaterna = true;
													btnQuaterna.setEnabled(true);
													for (j = j + 3; j < usciti.size(); j += 3) {
														System.out.println("quinto for " + i);
														if (usciti.get(j) && j<15) {
															System.out.println("cinquina true " + i);
															cinquina = true;
															btnCinquina.setEnabled(true);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				for(int i=0;i<usciti.size();i++){
					if(usciti.get(i))
						temp++;
				}
				if(temp==15){
					tombola=true;
					btnTombola.setEnabled(true);
				}else{
					temp=0;
				}
				if (numeri.size() == 15) {
					for (int i = 0; i < 5; i++) {
						ti1.setText(i, numeri.get(n).toString());
						n++;
						ti2.setText(i, numeri.get(n).toString());
						n++;
						ti3.setText(i, numeri.get(n).toString());
						n++;
					}
					numeri.add(0);
					numeri.add(0);
					numeri.add(0);
					numeri.add(0);
					
				}
			}
		});
	}

	public void vai() throws IOException {
		s = new Socket("localhost", 9999);
		tc = new ThreadClient(s, Client.this);
		tc.start();
		for (int i = 0; i < 15; i++)
			usciti.add(false);
	}
}
