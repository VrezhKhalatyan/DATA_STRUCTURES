package homework2Revised;

import java.util.ArrayList;
import java.util.Iterator;

public class UniqueHand extends Hand {
	private MySet<Card> cards;

	public UniqueHand() {
		this.cards = new MySet<Card>();
	}

	public ArrayList<Card> getCards() {
		ArrayList<Card> newCards;
		newCards = cards.getAll();
		return newCards;
	}

	public Card removeCard() {

		int index = (int) (Math.random() * cards.size());
		Card randomlySelectedCard = new Card(index);
		cards.Remove(randomlySelectedCard);
		return randomlySelectedCard;

	}

	public Card findLeastCard() {

		Card minItem = cards.getAll().get(0);
		for (int i = 1; i < cards.size(); i++) {
			if (minItem.compareTo(cards.getAll().get(i)) == -1) {
				minItem = cards.getAll().get(i);
			}
		}
		return minItem;

	}

	public void removeCard(Card card) {
		Iterator<Card> it = cards.getAll().iterator();
		while (it.hasNext()) {
			Card e = it.next();

			if (e.compareTo(card) == 0) {
				it.remove();
			}
		}
	}

	public void addCard(Card card) {
		cards.Insert(card);
	}

	public int count() {

		int size = cards.size();
		return size;

	}

	public boolean has(Card card) {

		boolean status = false;
		for (Card c : cards.getAll()) {
			if (c.compareTo(card) == 0) {
				return true;
			}
		}
		return status;

	}

	public int calculateScore() {

		int score = 0;
		int suitValue = 0;
		for (Card currentCard : cards.getAll()) {
			if (currentCard.Rank().equals("K") || currentCard.Rank().equals("Q") || currentCard.Rank().equals("J")) {
				score = score + 12;
			} else if (currentCard.Rank().equals("A")) {
				score = score + 15;
			}
			if (currentCard.Rank().equals("2")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (2 * suitValue);
			} else if (currentCard.Rank().equals("3")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (3 * suitValue);
			} else if (currentCard.Rank().equals("4")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (4 * suitValue);
			} else if (currentCard.Rank().equals("5")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (5 * suitValue);
			} else if (currentCard.Rank().equals("6")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (6 * suitValue);
			} else if (currentCard.Rank().equals("7")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (7 * suitValue);
			} else if (currentCard.Rank().equals("8")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (8 * suitValue);
			} else if (currentCard.Rank().equals("9")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (9 * suitValue);
			} else if (currentCard.Rank().equals("10")) {
				suitValue = Card.suitToIndex(currentCard.Suit());
				score = score + (10 * suitValue);
			}
		}
		return score;
	}

	public String toString() {
		return cards + " ";
	}
}