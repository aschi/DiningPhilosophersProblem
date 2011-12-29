package ch.hszt;

public class Table {
	int noForks = 5;
	private Fork[] forks = new Fork[noForks];
	
	public Table(){
		for(int i = 0; i < forks.length; i++){
			forks[i] = new Fork();
		}
	}
	
	public Fork getLeftFork(int position){
		return (position == 0 ? forks[noForks-1] : forks[position-1]);
	}
	
	public Fork getRightFork(int position){
		return (position == (noForks-1)) ? forks[0] : forks[position+1];
	}
	

	
}
