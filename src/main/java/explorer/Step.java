package explorer;

import java.awt.Point;

public class Step {
	private final Direction direction;
	private final Point point;

	Step(final Direction direction, final Point point) {
		this.direction = direction;
		this.point = new Point(point);
	}

	Direction getDirection() {
		return direction;
	}

	public Point getPoint() {
		return point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Step other = (Step) obj;
		if (direction != other.direction) {
			return false;
		}
		if (point == null) {
			if (other.point != null) {
				return false;
			}
		} else if (!point.equals(other.point)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Moved " + direction.name() + " one step to point: x = " + point.x + ", y = " + point.y;
	}
}