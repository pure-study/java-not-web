/**
 * 
 */
package com.will.aet;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.will.aet.bo.DetailAccountBO;
import com.will.aet.bo.SummaryAccountBO;

/**
 * @author Will
 * @version 2010-7-12
 *
 */
public class AetChiefPanel extends JPanel {
	private static final long serialVersionUID = -3592871849025688857L;

	protected AetChiefPanel() {
		jtfFilePath = new JTextField();
		jbtnSelectFile = new JButton("选择Excel文件");
		jbtnExecute = new JButton("执行");
		jfc = new JFileChooser();
		jfc.setFileFilter(new ExcelFileFilter());  // 只能选择Excel文件
		
		jbtnSelectFile.addActionListener( new JfcBtnListener() );
		jbtnExecute.addActionListener( new ExecuteBtnListener() );
		
		jpnlBtns = new JPanel(new GridLayout(1, 2));
		jpnlBtns.add(jbtnSelectFile);
		jpnlBtns.add(jbtnExecute);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(jtfFilePath);
		this.add(jpnlBtns);
	}
	
	private JPanel jpnlBtns;
	private JButton jbtnSelectFile;
	private JButton jbtnExecute;
	
	private JTextField jtfFilePath;
	
	private JFileChooser jfc;
	
	private File opFile;
	
	private class JfcBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if ( ae.getSource() == jbtnSelectFile ) {
				int ret = jfc.showOpenDialog(jbtnSelectFile.getParent());
				
				if (ret == JFileChooser.APPROVE_OPTION) {
					opFile = jfc.getSelectedFile();
					jtfFilePath.setText( opFile.getAbsolutePath() );
				} else {
					opFile = null;
					jtfFilePath.setText("");
				}
			}
		}
	}
	
	private class ExecuteBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if ( ae.getSource() == jbtnExecute ) {
				if ( null == opFile ) {
					return;
				}
				
				try {
					FileInputStream fis = new FileInputStream(opFile);
					Workbook wb = new HSSFWorkbook(fis);
					
					SummaryAccountBO summaryAccountBO = new SummaryAccountBO();
					DetailAccountBO detailAccountBO = new DetailAccountBO();
					summaryAccountBO.generateTotalAcnt(wb, wb);
					detailAccountBO.generateDetailAcnt(wb, wb);
					fis.close();
					
					FileOutputStream fos = new FileOutputStream(opFile);
					wb.write(fos);
					fos.close();
					
					System.out.println("恭喜您，操作完成！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
