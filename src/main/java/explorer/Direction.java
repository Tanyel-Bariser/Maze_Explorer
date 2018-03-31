package explorer;

import java.awt.Point;

enum Direction {
	NORTH {
		@Override
		Point getPointInFront(Point point) {
			return new Point(point.x, point.y-1);
		}
		
		@Override
		Direction getLeft() {
			return WEST;
		}
		
		@Override
		Direction getRight() {
			return EAST;
		}
	}, 
	EAST {
		@Override
		Point getPointInFront(Point point) {
			return new Point(point.x+1, point.y);
		}
		
		@Override
		Direction getLeft() {
			return NORTH;
		}
		
		@Override
		Direction getRight() {
			return SOUTH;
		}
	}, 
	SOUTH {
		@Override
		Point getPointInFront(Point point) {
			return new Point(point.x, point.y+1);
		}
		
		@Override
		Direction getLeft() {
			return EAST;
		}
		
		@Override
		Direction getRight() {
			return WEST;
		}
	}, 
	WEST {
		@Override
		Point getPointInFront(Point point) {
			return new Point(point.x-1, point.y);
		}
		
		@Override
		Direction getLeft() {
			return SOUTH;
		}
		
		@Override
		Direction getRight() {
			return NORTH;
		}
	};
	
	abstract Point getPointInFront(Point point);
	abstract Direction getLeft();
	abstract Direction getRight();
}