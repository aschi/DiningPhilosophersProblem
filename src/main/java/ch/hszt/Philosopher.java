package ch.hszt;

import java.util.Random;


public class Philosopher implements Runnable {
	private Random r = new Random();
	private int gang;
	private String name;
	private int position;
	private Table table;
	
	public Philosopher(String name, int position, Table table){
		this.gang = 1;
		this.name = name;
		this.position = position;
		this.table = table;
	}
	
	@Override
	public void run() {
		
		think();
		while(gang <= 3){
			if(r.nextInt(5) == 2){
				eat();
				think();
			}
		}
		System.out.println(name + " ist fertig mit seinen 3 Gängen und verlässt den Tisch");
	}
	
	private void eat(){
		System.out.println(name + " hat hunger und würde gerne essen.");
		synchronized(table.getLeftFork(position)){
			System.out.println(name + " hat die Gabel zu seiner Linken aufgenommen");
			synchronized (table.getRightFork(position)) {
				System.out.println(name + " hat die Gabel zu seiner Rechten aufgenommen und isst den " + gang + ". Gang");
				gang++;
			}
		}
		try {
			Thread.sleep(r.nextInt(500));
		} catch (InterruptedException e) {
			//jaja
		}
	}
	
	private void think(){
		System.out.println(name + " denkt...");
	}
	
	
	
}
