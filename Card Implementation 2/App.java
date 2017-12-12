package homework2Revised;

import java.util.Map;
import java.util.TreeMap;

public class App {

	public void runTest() {
		Deck<Card> deck = new Deck<Card>();

		// add 52 cards to the deck
		for (int i = 0; i < 52; i++) {
			deck.addCard(new Card(i));
		}

		deck.shuffle();

		// print all cards in the deck
		for (Card c : deck.getCards()) {
			System.out.println(c);
		}
	}

	public void singlePlayer() {
		int n = 5;
		int k = 5;
		int m = 20;
		new Game().playGame(n, k, m);
	}

	@SuppressWarnings("unused")
	public void multiPlayer() {
		int n = 5;
		int k = 5;
		int m = 20;
		Map<String, Game> scoreBoard = new TreeMap<String, Game>();

		// registration
		scoreBoard.put("john", new Game());
		scoreBoard.put("chris", new Game());
		scoreBoard.put("george", new Game());

		// play the games
		for (String player : scoreBoard.keySet()) {
			new Game().playGame(n, k, m);
		}

	}

	public static void main(String[] args) {
		new App().singlePlayer();
	}

}
