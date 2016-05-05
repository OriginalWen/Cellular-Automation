package edu.neu.csye6200.ca;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class CACanvas extends Canvas implements Runnable {
	private int curGeneration=0;
    public int genNums=0; 
    private static boolean status=false;
    private static boolean suspended = false;
    
	public CACanvas(int nog){ 
		this.genNums=nog;
    }
	
	public void beginDraw(){
    	status =true;
    	suspended= false;
    	Thread t =new Thread(this);
    	t.start();
    }
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
    	ArrayList<int[]> genSet=CAGenerationSet.getGenerationSet();
    	//for(int i=0;i<genSet.size();i++){
			//System.out.println(Arrays.toString(genSet.get(i)));
		//}
    	for(int j=0;j<genSet.size()&&j<curGeneration;j++){
    		for(int i=0; i<genSet.get(0).length; i++)
            {
                if(genSet.get(j)[i] == 0)       
                {
                    Color color = Color.WHITE;
                    g2d.setColor(color);
                }

                else if(genSet.get(j)[i] == 2)
                {
                    Color color = Color.BLACK;
                    g2d.setColor(color);
                }
                else if(genSet.get(j)[i] == 1)
                {
                    Color color = Color.GRAY;
                    g2d.setColor(color);
                }
                g2d.fillRect(i*10, j*10, 10, 10);
            }
    	}
    	curGeneration++;
	}
	public void stop(){
    	suspended= true; 	
    }
	synchronized void resume(){
    	suspended = false;
    	notify();    	
    }
    
    @Override
	public void run() {
		while((genNums==0|curGeneration<=genNums)&status){
			try{
				this.repaint();
				Thread.sleep(250L);	
				synchronized (this){
					while (suspended){
						wait(800L);
					}
				}
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}		
	}
}
