/**
 * 
 */
package net.will.javatest.java.swing;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 * 测试javax.swing.JFileChooser、javax.swing.filechooser.FileFilter的用法。
 * 
 * @author Will
 * @version 2010-7-12
 *
 */
@SuppressWarnings("unused")
public class JFileChooserTest extends JFrame {
	private static final long serialVersionUID = 3997006741140503721L;
	
	/**
	 * Menu components.
	 */
	private JMenuBar  jmnbMain;
	private JMenu     jmnEdit;
	private JMenu     jmnHelp;
	private JMenuItem jmniExit;
	private JMenuItem jmniHelp;
	private JMenuItem jmniAbout;

	public JFileChooserTest() {
		// initialize the Menu components
		AetMenuListener menuLsn = new AetMenuListener();
		jmnbMain = new JMenuBar();
		jmnEdit = new JMenu("编辑(E)");
		jmnHelp = new JMenu("帮助(H)");
		jmniExit = new JMenuItem("退出(X)");
		jmniExit.addActionListener(menuLsn);
		jmniHelp = new JMenuItem("帮助主题(H)");
		jmniHelp.addActionListener(menuLsn);
		jmniAbout = new JMenuItem("关于(A)");
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

	public static void main(String[] args) throws Exception {
		JFrame.setDefaultLookAndFeelDecorated(true);
//		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		
		JFileChooserTest obj = new JFileChooserTest();
		obj.setResizable(false);
		obj.setSize(270, 255);
		obj.setVisible(true);
	}

}

class AetChiefPanel extends JPanel {
	private static final long serialVersionUID = 4148760320378958040L;
	
	protected AetChiefPanel() {
		jtfFilePath = new JTextField();
		jbtnOK1 = new JButton("JFileChooser");
		jbtnOK2 = new JButton("FileDialog");
		jfc = new JFileChooser();
		jfc.setFileFilter(new ExcelFileFilter());  // 只能选择Excel文件
		
		jbtnOK1.addActionListener( new JfcBtnListener() );
		
		jpnlBtns = new JPanel(new GridLayout(1, 2));
		jpnlBtns.add(jbtnOK1);
		jpnlBtns.add(jbtnOK2);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(jtfFilePath);
		this.add(jpnlBtns);
	}
	
	private JPanel jpnlBtns;
	private JButton jbtnOK1;
	private JButton jbtnOK2;
	
	private JTextField jtfFilePath;
	
	private JFileChooser jfc;
//	private FileDialog fileDialog;
	
	private class JfcBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == jbtnOK1 ) {
				int ret = jfc.showOpenDialog(jbtnOK1.getParent());
				
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					jtfFilePath.setText( file.getAbsolutePath() );
				} else {
					// Open command cancelled by user.
				}
			}
		}
	}
	
	private class ExcelFileFilter extends FileFilter {
		public boolean accept(File f) {
			if ( f == null ) {
				return false;
			}
			
			if ( f.isDirectory() ) {
				return true;
			}
			
			String fileName = f.getName();
			int i = fileName.lastIndexOf('.');
			if ( i<=0 || i>=fileName.length()-1 ) {
				return false;
			}
			
			String ext = fileName.substring(i+1).toLowerCase();
			if ("xls".equals(ext) || "xlsx".equals(ext)) {
				return true;
			}
			
			return false;
		}

		public String getDescription() {
			return "Excel Files";
		}
	}
}
