package totalSourceJavaAdvantage;

public class Day8 {
	
	public static void main(String[] args) {
		System.out.println("-----------------Day 10: Queue -----------------");
		Customer customerWatchFilm4DQueen = new Customer("Queen", 18);
		Customer customerWatchFilm4DKing = new Customer("King", 21);
		Customer customerWatchFilm4DChildren = new Customer("Children", 21);
		
		Film4DQueue<Customer> customerQueue = new Film4DQueue<>();
		customerQueue.getSeatesInRoom().add(customerWatchFilm4DKing);
		customerQueue.getSeatesInRoom().add(customerWatchFilm4DQueen);
		customerQueue.getSeatesInRoom().add(customerWatchFilm4DChildren);
		
		customerQueue.printSeatByQueue();
	}

}
