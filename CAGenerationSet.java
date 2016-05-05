package edu.neu.csye6200.ca;

import java.util.ArrayList;

import javax.swing.SwingWorker;

public class CAGenerationSet {
	private static ArrayList<int[]> generationSet=new ArrayList<int[]>();
	public static ArrayList<int[]> getGenerationSet(){
		return generationSet;
	}
	public void startCAGenerate(int numOfCells, int numOfGens,int rule){
		CAGeneration gen=new CAGeneration();
		generationSet.add(gen.generateCellArrays(numOfCells));
		for(int i=1;i<numOfGens;i++){
			generationSet.add(gen.generateCellArrays(generationSet.get(i-1),rule));
		}
	}
	static SwingWorker<ArrayList<int[]>, Void> worker = new SwingWorker<ArrayList<int[]>, Void>() {
	    @Override
	    public ArrayList<int[]> doInBackground() {
	        return generationSet;
	    }
	};
}
