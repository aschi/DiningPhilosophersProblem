package ch.hszt;


public class DiningPhilosophersProblem 
{
    public static void main( String[] args )
    {
    	Table t = new Table();
    	Philosopher[] philos = new Philosopher[5];
        philos[0] = new Philosopher("Plato", 0, t);
        philos[1] = new Philosopher("Lessing", 1, t);
        philos[2] = new Philosopher("Decartes", 2, t);
        philos[3] = new Philosopher("Kant", 3, t);
        philos[4] = new Philosopher("Hobes", 4, t);
        
        for(Philosopher p : philos){
        	new Thread(p).start();
        }
    }
}
