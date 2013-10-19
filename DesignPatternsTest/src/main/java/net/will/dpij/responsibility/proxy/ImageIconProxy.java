/**
 * 
 */
package net.will.dpij.responsibility.proxy;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Will
 * @version v1.0 2008-11-19
 *
 */
public class ImageIconProxy extends ImageIcon implements Runnable {
	private static final long serialVersionUID = 904251795422581263L;
	
	protected static final ImageIcon ABSENT = new ImageIcon(
			ClassLoader.getSystemResource("images/absent.jpg"));
	protected static final ImageIcon LOADING = new ImageIcon(
			ClassLoader.getSystemResource("images/loading.jpg"));
	
	private ImageIcon current = ABSENT;
	
	protected String filename;
	protected JFrame callbackFrame;
	
	public ImageIconProxy(String filename) {
		super(ABSENT.getImage());
		this.filename = filename;
	}
	
	public void load(JFrame callbackFrame) {
		this.callbackFrame = callbackFrame;
		current = LOADING;
		callbackFrame.repaint();
		new Thread(this).start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		current = new ImageIcon(
				ClassLoader.getSystemResource(filename));
		callbackFrame.pack();
	}
	
	@Override
	public int getIconHeight() {
		// Challenge!
		return this.current.getIconHeight();
	}
	
	@Override
	public int getIconWidth() {
		// Challenge!
		return this.current.getIconWidth();
	}
	
	@Override
	public synchronized void paintIcon(Component c,
			Graphics g, int x, int y) {
		// Challenge!
		this.current.paintIcon(c, g, x, y);
	}

}
