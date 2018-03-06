package Assignment2;

public class WordSearchTester {

	public static void main(String[] args) {
		WordSearch search = new WordSearch();
		
		for(int i = 0; i < search.array.length; i++){
			for(int k = 0; k < search.array[i].length; k++){
				System.out.print(search.array[i][k] + " ");
				
			}
			System.out.println();
		}
		
		System.out.println("\n" +search.usedWords);

	}
}
