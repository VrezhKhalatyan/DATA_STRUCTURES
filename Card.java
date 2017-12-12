public class Card implements Comparable<Card> {
	String suit;
	String rank;
	
	Card(final int index) {
		// optional create a suit and rank from index
	}
	
	Card(final String rank, final String suit) {
		this.suit = suit;
		this.rank = rank;
	}
	
	private int getRankNumber() {
		if (rank == "King") {
			return 13;
		} else if (rank == "Queen") {
			return 12;
		} else if (rank == "Jack") {
			return 11;
		}else if (rank == "10") {
			return 10;
		}else if (rank == "9") {
			return 9;
		}else if (rank == "8") {
			return 8;
		}else if (rank == "7") {
			return 7;
		}else if (rank == "6") {
			return 6;
		}else if (rank == "5") {
			return 5;
		}else if (rank == "4") {
			return 4;
		}else if (rank == "3") {
			return 3;
		}else if (rank == "2") {
			return 2;
		}else if (rank == "1") {
			return 1;
		}
       else {
			return 0;
		}
	}
	
	private int getSuitNumber() {
		if (suit == "diamonds") {
			return 4;
		} else if (suit == "hearts") {
			return 3;
		} else if (suit == "clubs"){
         return 2;
      } else if (suit == "spades"){
         return 1;
      }
			return 1;
		}
	}
	
	public int compareTo(Card other) {
		int myRank = getRankNumber();
		int hisRank = other.getRankNumber();
		int mySuit = getSuitNumber();
		int hisSuit = other.getSuitNumber();
		
		if (myRank == hisRank) {
		  if (mySuit == hisSuit) {
			  return 0;
		  } else {
			  if (mySuit > hisSuit) {
				  return 1;
			  } else {
				  return -1;
			  }
		  }
		} else {
			if (myRank > hisRank ) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public String toString() {
		return rank + " of " + suit;
	}
}