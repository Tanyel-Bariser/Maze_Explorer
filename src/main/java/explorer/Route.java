package explorer;

import java.awt.Point;
import java.util.*;

class Route {
	private final List<Step> stepsTaken;

	Route() {
		stepsTaken = new ArrayList<>();
	}
	
	void recordMovement(Direction direction, Point point) {
		stepsTaken.add(new Step(direction, point));
	}
	
	boolean beenHereBefore(Point point) {
		for (Step step : stepsTaken) {
			if (step.getPoint().equals(point)) {
				return true;
			}
		}
		return false;
	}
	
	List<Step> getStepsTaken() {
		return Collections.unmodifiableList(stepsTaken);
	}
}