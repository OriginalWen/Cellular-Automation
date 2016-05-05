package edu.neu.csye6200.ca;

public class CAGeneration {
	public int[] generateCellArrays(int length){
		int[] result=new int[length];
		result[length/2]=2;
		return result;
	}
	public int[] generateCellArrays(int[] lastGen,int rule){
		if(rule==0)return CARule.rule1(lastGen);
		else if(rule==1)return CARule.rule2(lastGen);
		else if(rule==2)return CARule.rule3(lastGen);
		return CARule.averageOfPrev(lastGen);
	}
}
