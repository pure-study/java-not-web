/**
 * @(#)LoadingImageIcon.java - Will's practices.
 */
package net.will.dpij.responsibility.proxy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 这个类在结构上已经不是一个代理(它已经不存在转发)，但本质上却起着代理的作用。
 * 
 * @author Will
 * @version v1.0 2008-11-20
 */
public class LoadingImageIcon extends ImageIcon implements Runnable {
	private static final long serialVersionUID = 8096733918131512115L;
	
	protected static final ImageIcon ABSENT = new ImageIcon(
			ClassLoader.getSystemResource("images/absent.jpg"));
	protected static final ImageIcon LOADING = new ImageIcon(
			ClassLoader.getSystemResource("images/loading.jpg"));
	
	protected String filename;
	protected JFrame callbackFrame;
	
	public LoadingImageIcon(String filename) {
		super(ABSENT.getImage());
		this.filename = filename;
	}
	
	public void load(JFrame callbackFrame) {
		// Challenge!
		this.callbackFrame = callbackFrame;
		setImage(LOADING.getImage());
		this.callbackFrame.repaint();
		new Thread(this).start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Challenge!
		ImageIcon current = new ImageIcon(
				ClassLoader.getSystemResource(this.filename));
		setImage(current.getImage());
		this.callbackFrame.pack();
	}

}
