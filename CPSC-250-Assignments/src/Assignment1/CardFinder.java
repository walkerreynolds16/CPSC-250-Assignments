package Assignment1;
/*
 * CardFinder
 * By Walker Reynolds
 * CPSC 250
 * 
 */
public class CardFinder {
	public static String findCard(int request){
		String[] rank = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; //beginning array of ranks
		String[] suit = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"}; //beginning array of suits
		int requestRank = (request - 1) % 13; //using mod, you can find the rank of the requested card, the -1 is because array indices start at 0 not 1
		int requestSuit = (request -1) / 13; // using dividing to find the suit of the requested suit
		return rank[(requestRank)] + " of " + suit[requestSuit]; //return the card
		
	}

}
