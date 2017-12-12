package Homework1Revised;

import java.util.Comparator;

public class PCompare implements Comparator<Point> {
	@Override
	public int compare(Point two, Point one) {
		if (one.x % 2 == 0) {
			return 1;
		}else if(two.x % 3 == 0){
			return 1;
		}
		else if (one.x == two.x) {
			if (one.y < two.y) {
				return 1;
			}
			if (one.y == two.y) {
				return 0;
			} else {
				return -1;
			}
		}

		return -1;

	}
}
