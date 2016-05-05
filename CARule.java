package edu.neu.csye6200.ca;

public class CARule {
	public static int[] averageOfPrev(int[] prev){
		int[] newGen=new int[prev.length];
		//wrap the array 
		newGen[0]=(prev[0]+prev[1]+prev[prev.length-1])/3;
		newGen[prev.length-1]=(prev[0]+prev[prev.length-2]+prev[prev.length-1])/3;
		for(int i=1;i<prev.length-1;i++){
			newGen[i]=(prev[i-1]+prev[i]+prev[i+1])/3;
		}
		return newGen;
	}
	public static int[] rule1(int[] prev){
		int[] newGen=new int[prev.length];
		newGen[0]=(prev[0]+prev[1]+prev[prev.length-1])/3;
		newGen[prev.length-1]=(prev[0]+prev[prev.length-2]+prev[prev.length-1])/3;
		for(int i=1;i<prev.length-1;i++){
			if(prev[i-1]+prev[i]+prev[i+1]==0){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==1){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==2){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==3){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==4){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==5){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==6){
				newGen[i]=2;
			}
		}
		return newGen;
	}
	public static int[] rule2(int[] prev){
		int[] newGen=new int[prev.length];
		newGen[0]=(prev[0]+prev[1]+prev[prev.length-1])/3;
		newGen[prev.length-1]=(prev[0]+prev[prev.length-2]+prev[prev.length-1])/3;
		for(int i=1;i<prev.length-1;i++){
			if(prev[i-1]+prev[i]+prev[i+1]==0){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==1){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==2){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==3){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==4){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==5){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==6){
				newGen[i]=0;
			}
		}
		return newGen;
	}
	public static int[] rule3(int[] prev){
		int[] newGen=new int[prev.length];
		newGen[0]=(prev[0]+prev[1]+prev[prev.length-1])/3;
		newGen[prev.length-1]=(prev[0]+prev[prev.length-2]+prev[prev.length-1])/3;
		for(int i=1;i<prev.length-1;i++){
			if(prev[i-1]+prev[i]+prev[i+1]==0){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==1){
				newGen[i]=1;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==2){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==3){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==4){
				newGen[i]=2;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==5){
				newGen[i]=0;
			}
			else if(prev[i-1]+prev[i]+prev[i+1]==6){
				newGen[i]=1;
			}
		}
		return newGen;
	}
}
