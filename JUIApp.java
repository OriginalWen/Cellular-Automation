package edu.neu.csye6200.ca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JUIApp implements ActionListener {
    protected JFrame frame = null;
    protected JPanel mainPanel = null;
    protected JScrollPane showPanel=null;
    protected JButton btn0 = null;
    protected JButton btn1 = null;
    protected JButton btn2 = null;
    protected JLabel numOfCells, numOfGens, rule;
    protected JFormattedTextField noc, nog;
    protected JComboBox<String> rules;
    protected CACanvas caCanvas =null;
    protected int numOC=100,numOG=500;
    protected int rul=2;
    
    
	public JUIApp() {
		initGUI();		
	}
	
	public void initGUI() {
		frame = new JFrame();
		frame.setTitle("JUIApp");
		frame.setSize(700, 600);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(),BorderLayout.NORTH);
		frame.setVisible(true);
	}

	public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		numOfCells=new JLabel("Number of cells");
		mainPanel.add(numOfCells);		
		noc=new JFormattedTextField(100);
		//noc.setActionCommand("numOfCells");
		noc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numOC=Integer.valueOf(noc.getText().trim());
				//System.out.println(numOC);
			}
		});
		mainPanel.add(noc);
		
		numOfGens=new JLabel("Number of generations");
		mainPanel.add(numOfGens);		
		nog=new JFormattedTextField(200);
		//nog.setActionCommand("numOfGens");
		nog.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numOG=Integer.valueOf(nog.getText().trim());
				//System.out.println(numOG);
			}
		});
		mainPanel.add(nog);
		
		rule=new JLabel("rules:");
		mainPanel.add(rule);
		rules = new JComboBox<String>();
		rules.addItem("Rule1");
		rules.addItem("Rule2");
		rules.addItem("Rule3");
		rules.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rul=rules.getSelectedIndex();
				//System.out.println(rul);
			}
		});
		mainPanel.add(rules);
		
		btn0 = new JButton("Start");
		btn0.addActionListener(this);
		mainPanel.add(btn0);
		
		btn1 = new JButton("Stop");
		btn1.addActionListener(this);
		mainPanel.add(btn1);
		
		btn2 = new JButton("Continue");
		btn2.addActionListener(this);
		mainPanel.add(btn2);
		
		mainPanel.setVisible(true);
		return mainPanel;
	}
	
    public void run(){
    	
    }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		numOC=Integer.valueOf(noc.getText().trim());
		numOG=Integer.valueOf(nog.getText().trim());
		//System.out.println(numOG);
		//System.out.println(numOC);
		//if(ae.getActionCommand().equals("numOfCells")){
			//System.out.println(noc.getText());
			//numOfCells=Integer.parseInt(noc.getText());
			//System.out.println(numOfCells);
		//}
		if(ae.getActionCommand().equals("Start")){
			if(caCanvas !=null){
				frame.dispose();
				initGUI();
			}
			CAGenerationSet gs=new CAGenerationSet();
			gs.startCAGenerate(numOC,numOG,rul);
			caCanvas=new CACanvas(numOG);
			showPanel = new JScrollPane(caCanvas);
			frame.add(showPanel);
			frame.setVisible(true);
			caCanvas.beginDraw();
		}
		if (ae.getActionCommand().equals("Stop")){
			caCanvas.stop();				
		}
		if (ae.getActionCommand().equals("Continue")){
			caCanvas.resume();
		}
		System.out.println("We received an ActionEvent " + ae);	
	}	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JUIApp app = new JUIApp();
				app.getMainPanel();
			}
		});
		System.out.println("JUIApp is done");
	}
}