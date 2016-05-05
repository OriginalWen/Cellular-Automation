package edu.neu.csye6200.ca;

public enum CAcells {
	ON(2),GREY(1),OFF(0);
	private int state;
	CAcells(int s){
		this.state=s;
	}
	public String toString() {
        return String.valueOf ( this .state);
    }
}
