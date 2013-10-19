/**
 * 
 */
package com.will.aet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Will
 * @version 2010-7-12
 *
 */
public class AccountingExcelTool extends JFrame {
	private static final long serialVersionUID = -3322982456108494854L;
	
	/**
	 * Menu components.
	 */
	private JMenuBar  jmnbMain;
	private JMenu     jmnEdit;
	private JMenu     jmnHelp;
	private JMenuItem jmniExit;
	private JMenuItem jmniHelp;
	private JMenuItem jmniAbout;

	public AccountingExcelTool() {
		// initialize the Menu components
		AetMenuListener menuLsn = new AetMenuListener();
		jmnbMain = new JMenuBar();
		jmnEdit = new JMenu("����(E)");
		jmnHelp = new JMenu("����(H)");
		jmniExit = new JMenuItem("�˳�(X)");
		jmniExit.addActionListener(menuLsn);
		jmniHelp = new JMenuItem("��������(H)");
		jmniHelp.addActionListener(menuLsn);
		jmniAbout = new JMenuItem("����(A)");
		jmniAbout.addActionListener(menuLsn);
		
		jmniExit.setMnemonic('X');
		jmnEdit.add(jmniExit);
		jmniHelp.setMnemonic('H');
		jmnHelp.add(jmniHelp);
		jmnHelp.addSeparator();
		jmniAbout.setMnemonic('A');
		jmnHelp.add(jmniAbout);
		jmnEdit.setMnemonic('E');
		jmnbMain.add(jmnEdit);
		jmnHelp.setMnemonic('H');
		jmnbMain.add(jmnHelp);
		this.getRootPane().setJMenuBar(jmnbMain);
//		this.setJMenuBar(jmnbMain);
		
		// add the chief panel
		AetChiefPanel chfPanel = new AetChiefPanel();
		this.getContentPane().add(chfPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class AetMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if( ae.getSource()==jmniExit ) {
				System.exit(0);
			}
			else if( ae.getSource()==jmniHelp ) {
				// NOP
			}
			else if( ae.getSource()==jmniAbout ) {
				// NOP
			}
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		AccountingExcelTool obj = new AccountingExcelTool();
		obj.setTitle("Excel�ʲ����ɹ��� v0.1");
		obj.setResizable(false);
		obj.setSize(270, 255);
		obj.setVisible(true);
	}

}
