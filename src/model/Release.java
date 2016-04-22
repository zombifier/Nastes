package model;

public class Release extends Level{
	int redNumbersUncovered;
	int yellowNumbersUncovered;
	int greenNumbersUncovered;
	
	public Release() {
		super();
		this.redNumbersUncovered = 6;
		this.yellowNumbersUncovered = 6;
		this.greenNumbersUncovered = 6;
	}
	
	public boolean hasWon() {
		return false;
	}
	
	public String name() { return "Release"; }
	
	public String getLimit() { return ""; }
}
