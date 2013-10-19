/**
 * A simple calculator.
 * 请在JDK1.5以上的环境下运行此程序！
 * 
 * 残留问题：
 *     1. 不能精确显示多于六位的小数位。见String CalChiefPanel.formatDoubleNum(double)。
 * 
 * 扩充想法：
 *     在将来的版本中，将声明两个变量来分别存储两个操作数。这样更方便实现更多的功能。
 *     要使用BigDecimal，Formatter等等。
 */
package net.will.javatest.java.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;

/**
 * @author   ZJ.Yuan
 * @version  2006-04-20
 */
public class Calculator extends JFrame {
	private static final long serialVersionUID = -4293275540692105259L;
	
	/**
	 * Menu components.
	 */
	private JMenuBar  jmnbMain;
	private JMenu     jmnEdit;
	private JMenu     jmnHelp;
	private JMenuItem jmniExit;
	private JMenuItem jmniHelp;
	private JMenuItem jmniAbout;
	
	public Calculator() {
		// initialize the Menu components
		CalMenuListener mnLst = new CalMenuListener();
		jmnbMain = new JMenuBar();
		jmnEdit = new JMenu("编辑(E)");
		jmnHelp = new JMenu("帮助(H)");
		jmniExit = new JMenuItem("退出(X)");
		jmniExit.addActionListener(mnLst);
		jmniHelp = new JMenuItem("帮助主题(H)");
		jmniHelp.addActionListener(mnLst);
		jmniAbout = new JMenuItem("关于(A)");
		jmniAbout.addActionListener(mnLst);
		
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
		//this.setJMenuBar(jmnbMain);
		
		// add the chief panel
		CalChiefPanel chfPanel = new CalChiefPanel();
		this.getContentPane().add(chfPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class CalMenuListener implements ActionListener {
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
		
		Calculator cal = new Calculator();
		cal.setResizable(false);
		cal.setSize(270, 255);
		cal.setVisible(true);
	}
}

class CalChiefPanel extends JPanel {
	private static final long serialVersionUID = -2672599356096996541L;

	private JTextField jtfInput;
	
	/**
	 * Function Buttons.
	 */
	private JButton jbtnBackspace;
	private JButton jbtnCE;
	private JButton jbtnC;
	private JPanel  jpnlFunc;
	
	/**
	 * Memory components.
	 */
	private JTextField jtfMemory;
	private JButton jbtnMC;
	private JButton jbtnMR;
	private JButton jbtnMS;
	private JButton jbtnMPlus;
	private JPanel  jpnlMemo;
	
	/**
	 * Main Calculator Buttons.
	 */
	private JButton[] jbtnNum = new JButton[10];
	private JButton jbtnPlus;
	private JButton jbtnMinus;
	private JButton jbtnMultiply;
	private JButton jbtnDivide;
	private JButton jbtnEqualTo;
	private JButton jbtnDot;
	private JButton jbtnPositiveNegative;
	private JButton jbtnSqrt;
	private JButton jbtnPercent;
	private JButton jbtnReciprocal;
	private JPanel  jpnlCal;
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	
	/**
	 * Input a new number from next Number key (including Dot
	 * key) pressing.
	 */
	protected boolean blnIsNewNum;
	
	/**
	 * What's the previous Operator.
	 */
	protected StringBuffer strOldOper;
	
	/**
	 * What's the previous operand.
	 */
	protected double dblOldNum;
	
	/**
	 * Pressed Dot key.
	 */
	protected boolean blnPressedDot;
	
	/**
	 * Flag for calculating.
	 */
	protected boolean blnHasCalculated;
	
	/**
	 * Stored number for memory.
	 */
	protected double dblStoredNumber;
	
	//----------------------------------------------------------
	//----------------------------------------------------------

	/**
	 * The Constructor.
	 */
	public CalChiefPanel() {
		// *1 initialize the input TextField
		jtfInput = new JTextField("0.", 21);
		jtfInput.setHorizontalAlignment(JTextField.RIGHT);
		jtfInput.setEditable(false);
		jtfInput.setBackground(Color.WHITE);
		
		// *2 initialize the Function buttons
		jbtnBackspace = new JButton("Backspace");
		jbtnCE        = new JButton("CE");
		jbtnC         = new JButton("C");
		jpnlFunc = new JPanel( new GridLayout(1, 3, 3, 3) );
		jpnlFunc.add(jbtnBackspace);
		jpnlFunc.add(jbtnCE);
		jpnlFunc.add(jbtnC);
		
		// *3 initialize the Memory components
		jtfMemory = new JTextField(3);
		jtfMemory.setHorizontalAlignment(JTextField.CENTER);
		jtfMemory.setEditable(false);
		jtfMemory.setBorder( new BevelBorder(BevelBorder.LOWERED) );  // set the Border
		
		jbtnMC = new JButton("MC");
		jbtnMR = new JButton("MR");
		jbtnMS = new JButton("MS");
		jbtnMPlus = new JButton("M+");
		jpnlMemo = new JPanel( new GridLayout(4, 1, 3, 3) );
		jpnlMemo.add(jbtnMC);
		jpnlMemo.add(jbtnMR);
		jpnlMemo.add(jbtnMS);
		jpnlMemo.add(jbtnMPlus);
		
		// *4 initialize the Main calculator buttons
		for(int i=0; i<10; i++) {
			jbtnNum[i] = new JButton(i + "");
		}
		jbtnPlus     = new JButton("+");
		jbtnMinus    = new JButton("-");
		jbtnMultiply = new JButton("*");
		jbtnDivide   = new JButton("/");
		jbtnEqualTo  = new JButton("=");
		jbtnDot      = new JButton(".");
		jbtnPositiveNegative = new JButton("+/-");
		jbtnSqrt             = new JButton("Sqrt");
		jbtnPercent          = new JButton("%");
		jbtnReciprocal       = new JButton("1/x");
		
		jpnlCal = new JPanel( new GridLayout(4, 5, 3, 3) );
		jpnlCal.add(jbtnNum[7]);
		jpnlCal.add(jbtnNum[8]);
		jpnlCal.add(jbtnNum[9]);
		jpnlCal.add(jbtnDivide);
		jpnlCal.add(jbtnSqrt);
		jpnlCal.add(jbtnNum[4]);
		jpnlCal.add(jbtnNum[5]);
		jpnlCal.add(jbtnNum[6]);
		jpnlCal.add(jbtnMultiply);
		jpnlCal.add(jbtnPercent);
		jpnlCal.add(jbtnNum[1]);
		jpnlCal.add(jbtnNum[2]);
		jpnlCal.add(jbtnNum[3]);
		jpnlCal.add(jbtnMinus);
		jpnlCal.add(jbtnReciprocal);
		jpnlCal.add(jbtnNum[0]);
		jpnlCal.add(jbtnPositiveNegative);
		jpnlCal.add(jbtnDot);
		jpnlCal.add(jbtnPlus);
		jpnlCal.add(jbtnEqualTo);
		
		// *5 add the events listeners
		blnIsNewNum      = true;
		strOldOper       = new StringBuffer("");
		dblOldNum        = 0.0;
		blnPressedDot    = false;
		blnHasCalculated = true;
		dblStoredNumber  = 0.0;
		this.addButtonsListener();
		
		// *6 lay the components
		this.setButtonsFont();
		this.setLayout(null);
		jtfInput.setBounds(5, 2, 250, 22);
		jtfMemory.setBounds(8, 36, 28, 24);
		jpnlFunc.setBounds(54, 35, 202, 26);
		jpnlMemo.setBounds(5, 70, 36, 120);
		jpnlCal.setBounds(54, 70, 202, 120);
		this.add(jtfInput);
		this.add(jtfMemory);
		this.add(jpnlFunc);
		this.add(jpnlMemo);
		this.add(jpnlCal);
	}
	
	/**
	 * Set Buttons' caption Font and margin, to properly display
	 * the captions. It is called by the Constructor.
	 */
	private void setButtonsFont() {
		Font ft = new Font("Dialog", Font.PLAIN, 11);
		
		jbtnBackspace.setFont(ft);
		jbtnBackspace.setMargin( new Insets(0,0,0,0) );   // display all caption
		jbtnCE.setFont(ft);
		jbtnCE.setMargin( new Insets(0,0,0,0) );
		jbtnC.setFont(ft);
		jbtnC.setMargin( new Insets(0,0,0,0) );
		
		jbtnMC.setFont(ft);
		jbtnMC.setMargin( new Insets(0,0,0,0) );
		jbtnMPlus.setFont(ft);
		jbtnMPlus.setMargin( new Insets(0,0,0,0) );
		jbtnMR.setFont(ft);
		jbtnMR.setMargin( new Insets(0,0,0,0) );
		jbtnMS.setFont(ft);
		jbtnMS.setMargin( new Insets(0,0,0,0) );
		
		jbtnDivide.setFont(ft);
		jbtnDivide.setMargin( new Insets(0,0,0,0) );
		jbtnDot.setFont(ft);
		jbtnDot.setMargin( new Insets(0,0,0,0) );
		jbtnEqualTo.setFont(ft);
		jbtnEqualTo.setMargin( new Insets(0,0,0,0) );
		jbtnMinus.setFont(ft);
		jbtnMinus.setMargin( new Insets(0,0,0,0) );
		jbtnMultiply.setFont(ft);
		jbtnMultiply.setMargin( new Insets(0,0,0,0) );
		for(int i=0; i<10; i++) {
			jbtnNum[i].setFont(ft);
			jbtnNum[i].setMargin( new Insets(0,0,0,0) );
		}
		jbtnPercent.setFont(ft);
		jbtnPercent.setMargin( new Insets(0,0,0,0) );
		jbtnPlus.setFont(ft);
		jbtnPlus.setMargin( new Insets(0,0,0,0) );
		jbtnPositiveNegative.setFont(ft);
		jbtnPositiveNegative.setMargin( new Insets(0,0,0,0) );
		jbtnReciprocal.setFont(ft);
		jbtnReciprocal.setMargin( new Insets(0,0,0,0) );
		jbtnSqrt.setFont(ft);
		jbtnSqrt.setMargin( new Insets(0,0,0,0) );
	}
	
	/**
	 * Add the Buttons' event listeners. It is called by
	 * the Constructor.
	 */
	private void addButtonsListener() {
		CalFunctionBtnListener fbl = new CalFunctionBtnListener();
		jbtnBackspace.addActionListener(fbl);
		jbtnCE.addActionListener(fbl);
		jbtnC.addActionListener(fbl);
		
		CalMemoryBtnListener mbl = new CalMemoryBtnListener();
		jbtnMC.addActionListener(mbl);
		jbtnMR.addActionListener(mbl);
		jbtnMS.addActionListener(mbl);
		jbtnMPlus.addActionListener(mbl);
		
		CalNumberBtnListener nbl = new CalNumberBtnListener();
		for(int i=0; i<10; i++) {
			jbtnNum[i].addActionListener(nbl);
		}
		
		CalDotKeyListener dkl = new CalDotKeyListener();
		jbtnDot.addActionListener(dkl);
		
		CalOperator2OpdBtnListener o2bl = new CalOperator2OpdBtnListener();
		jbtnPlus.addActionListener(o2bl);
		jbtnMinus.addActionListener(o2bl);
		jbtnMultiply.addActionListener(o2bl);
		jbtnDivide.addActionListener(o2bl);
		
		CalEqualToBtnListener ebl = new CalEqualToBtnListener();
		jbtnEqualTo.addActionListener(ebl);

		CalOperatorBtnListener obl = new CalOperatorBtnListener();
		jbtnPositiveNegative.addActionListener(obl);
		jbtnSqrt.addActionListener(obl);
		jbtnPercent.addActionListener(obl);
		jbtnReciprocal.addActionListener(obl);
	}
	
	/**
	 * Reset the text of <code>jtfInput</code> to "0.".
	 */
	protected void resetInputTextfieldText() {
		jtfInput.setText("0.");
	}
	
	/**
	 * Get the <code>double</code> value of String in jtfInput.
	 */
	protected double getInputNumberValue() {
		double val = 0.0;
		try {
			val = Double.parseDouble( jtfInput.getText() );
		}
		catch(NumberFormatException e) { }
		
		return val;
	}
	
	/**
	 * Convert a <code>double</code> number to a appropriate
	 * <code>String</code>.
	 */
	protected String formatDoubleNum(double num) {
	    /*
	      下面的语句使文本框中的数字只保留六位小数，整数部分可以任意长。
	      这样作是为了达到两个目的：
	      1. 当小数位太多时，在计算过程中会出现精度不准确的情况，比如
	         在计算
	             1 - 0.1
	         时，连减多次（结果还为正数）后，小数点后可能会出现多于一
	         位的小数。显然后面几位小数的精度是不准确的。这里的解决办法
	         是不管结果有多少位小数，直接选择丢弃更多的小数位，只保留六
	         位小数。
	      2. 通过DecimalFormat强制格式化数字格式。避免出现类似于
	             6.66666666E8
	         的科学计数形式。
	     */
		DecimalFormat df = new DecimalFormat("#.######");
		String strVal = df.format(num);
		
		if( strVal.indexOf(".") == -1 ) {
			strVal = strVal + ".";          // reserve the decimal point anyhow
		}
		/*  // drop the trailing 0 after decimal point.
		if( strVal.charAt(strVal.length()-1)=='0' ) {
			strVal = strVal.substring(0, strVal.length()-1);
		}
		*/
		return strVal;
	}
	
	/**
	 * Compute for '+', '-', '*', '/'.
	 * <p>
	 * If the operator passed to <code>opr</code> was not any of
	 * the 4 operators('+', '-', '*', '/'), the 2nd operand
	 * <code>opd2</code> will be returned.
	 */
	protected double compute(double opd1, double opd2, String opr) {
		double result;
		
		if( opr.equals("+") ) {
			result = opd1 + opd2;
		}
		else if( opr.equals("-") ) {
			result = opd1 - opd2;
		}
		else if( opr.equals("*") ) {
			result = opd1 * opd2;
		}
		else if( opr.equals("/") ) {
			if( opd2!=0 ) {
				result = opd1 / opd2;
			}
			else {                          // ERROR
				result = 0.0;
			}
		}
		else {
			result = opd2;
		}
		
		return result;
	}
	
	/**
	 * For Backspace, CE, C buttons.
	 */
	private class CalFunctionBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) { // "Backspace"
			if( ae.getSource()==jbtnBackspace ) {
				actionForBackspace();
			}
			else if( ae.getSource()==jbtnCE ) {       // "CE"
				resetInputTextfieldText();
				blnIsNewNum = true;
				blnPressedDot = false;
			}
			else if( ae.getSource()==jbtnC ) {        // "C"
				resetInputTextfieldText();
				blnIsNewNum = true;
				blnPressedDot = false;
				blnHasCalculated = true;    // clear calculating record
				strOldOper.replace(0, strOldOper.length(), "");
				dblOldNum = 0.0;
			}
			
			jtfInput.requestFocus(true);
		}
		
		private void actionForBackspace() {
			if( blnIsNewNum ) {             // if there would be a new number inputed
				return;
			}
			
			if( blnPressedDot ) {
				int i = jtfInput.getText().indexOf(".");
				int len = jtfInput.getText().length();
				
				if( i==len-1 ) {
					blnPressedDot = false;  // clear inputed Dot
				}
				else {
					try {                   // backspace the last digit
						jtfInput.setText( jtfInput.getText(0, len-1) );
					}
					catch(BadLocationException e) { }
				}
			}
			else {
				double inVal = Math.abs( getInputNumberValue() );
				if( inVal>=10 ) {
					int len = jtfInput.getText().length();
					try {                   // backspace the last digit and reserve '.'
						jtfInput.setText( jtfInput.getText(0, len-2) + "." );
					}
					catch(BadLocationException e) { }
				}
				else if( inVal>0 ) {        // only 1 digit in the input textfield
					resetInputTextfieldText();
				}
				else {
					// NOP
				}
			}
		}    // end Method actionForBackspace()
	}
	
	/**
	 * For "MS", "M+", "MR", "MC" buttons.
	 */
	private class CalMemoryBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if( ae.getSource()==jbtnMS ) {            // "MS"
				dblStoredNumber = getInputNumberValue();
				jtfMemory.setText("M");
			}
			else if( ae.getSource()==jbtnMPlus ) {    // "M+"
				dblStoredNumber += getInputNumberValue();
				jtfMemory.setText("M");
			}
			else if( ae.getSource()==jbtnMR ) {       // "MR"
				double storedNum = dblStoredNumber;
				jtfInput.setText( formatDoubleNum(storedNum) );
			}
			else if( ae.getSource()==jbtnMC ) {       // "MC"
				dblStoredNumber = 0.0;
				jtfMemory.setText("");
			}
			
			blnIsNewNum = true;
			blnPressedDot = false;
			jtfInput.requestFocus(true);
		}
	}
	
	/**
	 * For "+/-", "Sqrt", "1/x", "%" buttons.
	 */
	private class CalOperatorBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			double num = getInputNumberValue();

			if( ae.getSource()==jbtnPositiveNegative ) {   // "+/-"
				if( num!=0 ) {
					num = -num;
				}
			}
			else if( ae.getSource()==jbtnSqrt ) {          // "Sqrt"
				if( num>=0 ) {
					num = Math.sqrt(num);
				}
				else {                      // ERROR
					num = 0.0;
				}
				
				blnIsNewNum = true;
				blnPressedDot = false;
			}
			else if( ae.getSource()==jbtnReciprocal ) {    // "1/x"
				num = compute(1, num, "/");
				blnIsNewNum = true;
				blnPressedDot = false;
			}
			else if( ae.getSource()==jbtnPercent ) {       // "%"
				if( blnHasCalculated ) {
					num = 0.0;
				}
				else {
					num = compute(dblOldNum, num/100.0, "*");
				}
				
				blnIsNewNum = true;
				blnPressedDot = false;
			}
			
			jtfInput.setText( formatDoubleNum(num) );
			jtfInput.requestFocus(true);
		}
	}
	
	/**
	 * For '=' button.
	 */
	private class CalEqualToBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			double oprd2 = getInputNumberValue();
			double res;
			if( blnHasCalculated ) {
				res = compute(oprd2, dblOldNum, strOldOper.toString());
			}
			else {
				res = compute(dblOldNum, oprd2, strOldOper.toString());
				dblOldNum = oprd2;
			}
			jtfInput.setText( formatDoubleNum(res) );
			
			blnHasCalculated = true;
			blnIsNewNum = true;
			blnPressedDot = false;
			
			jtfInput.requestFocus(true);
		}
	}
	
	/**
	 * For '+', '-', '*', '/' buttons.
	 */
	private class CalOperator2OpdBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if( !blnHasCalculated && !blnIsNewNum ) {
				double res = compute(dblOldNum,
				                     getInputNumberValue(),
				                     strOldOper.toString());
				jtfInput.setText( formatDoubleNum(res) );
			}
			
			    // save the operator and current operand
			strOldOper.replace(0, strOldOper.length(), ae.getActionCommand());
			dblOldNum = getInputNumberValue();
			
			blnIsNewNum = true;
			blnPressedDot = false;
			blnHasCalculated = false;
			
			jtfInput.requestFocus(true);
		}
	}
	
	/**
	 * For the number(0 - 9) buttons.
	 */
	private class CalNumberBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if( blnIsNewNum ) {
				resetInputTextfieldText();
			}
			StringBuffer in = new StringBuffer( jtfInput.getText() );
			
			if( blnPressedDot ) {           // && !blnIsNewNum
				in.append( ae.getActionCommand() );
			}
			else {
				if( getInputNumberValue()==0 ) {
					    // replace '0' to the inputed number
					in.replace(0, 1, ae.getActionCommand());
				}
				else {
					in.insert( in.length()-1, ae.getActionCommand() );
				}
			}
			jtfInput.setText( in.toString() );
			
			blnIsNewNum = false;
			jtfInput.requestFocus(true);
		}
	}
	
	/**
	 * For the dot key.
	 */
	private class CalDotKeyListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if( !blnPressedDot ) {          // return if pressed '.' before
				if( blnIsNewNum ) {
					resetInputTextfieldText();
					blnIsNewNum = false;
				}
				else {                      // not a new number
					// NOP
				}
				
				blnPressedDot = true;
			}
			
			jtfInput.requestFocus(true);
		}
	}
}