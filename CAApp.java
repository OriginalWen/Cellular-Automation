package edu.neu.csye6200.ca;

import java.util.logging.Logger;

import javax.swing.SwingUtilities;

public class CAApp extends JUIApp {
	private Logger log = Logger.getLogger(CAApp.class.getName());
	//private CACanvas cacanvas= null;
	
	public CAApp() {
		frame.setSize(700,300);
	    log.info("We are in the constructor");
	    //cacanvas = new CACanvas();
	    //frame.add(cacanvas);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				CAApp app = new CAApp();
				app.getMainPanel();
			}
		});
		System.out.println("CAApp is done");
	}

}
