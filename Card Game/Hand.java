package homework2Revised;

import java.util.ArrayList;

public abstract class Hand {
	abstract ArrayList<Card> getCards();

	abstract Card findLeastCard();

	abstract void removeCard(Card card);

	abstract void addCard(Card card);
}
