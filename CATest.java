package edu.neu.csye6200.ca;

import java.util.Arrays;

public class CATest {
	public static void main(String args[]){
		CAGenerationSet gs=new CAGenerationSet();
		gs.startCAGenerate(64,10,1);
		for(int i=0;i<CAGenerationSet.getGenerationSet().size();i++){
			System.out.println(Arrays.toString(CAGenerationSet.getGenerationSet().get(i)));
		}
	}
}
