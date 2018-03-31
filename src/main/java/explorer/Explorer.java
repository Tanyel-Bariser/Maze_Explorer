package explorer;

import static explorer.Direction.NORTH;
import static maze.MazePart.WALL;

import java.awt.Point;
import java.util.List;

import maze.Maze;

public class Explorer {
	private final Maze maze;
	private final Route route;
	private Point position;
	private Direction directionFacing;

	public static Explorer createExplorer(final Maze maze) {
		return new Explorer(maze, maze.getStartPoint(), new Route(), NORTH);
	}

	Explorer(final Maze maze, final Point startPoint, final Route route, final Direction directionFacing) {
		this.maze = maze;
		position = startPoint;
		this.route = route;
		this.directionFacing = directionFacing;
		route.recordMovement(directionFacing, startPoint);
	}

	public void exploreMaze() {
		do {
			takeStep();
		} while (isStillExploring());
	}

	private void takeStep() {
		faceDirectionOfAvailablePath();
		moveForward();
	}

	void faceDirectionOfAvailablePath() {
		for (final Direction d : Direction.values()) {
			if (isAvailablePathInFront() && isUnvisitedPathInFront()) {
				return;
			}
			turnLeft();
		}
		for (final Direction d : Direction.values()) {
			if (isAvailablePathInFront()) {
				return;
			}
			turnRight();
		}
		throw new IllegalStateException("Explorer has no valid moves.");
	}

	private boolean isAvailablePathInFront() {
		return maze.getMazePart(getPointInFront()) != WALL;
	}

	private boolean isUnvisitedPathInFront() {
		return !route.beenHereBefore(getPointInFront());
	}

	private Point getPointInFront() {
		return directionFacing.getPointInFront(position);
	}

	void turnLeft() {
		directionFacing = directionFacing.getLeft();
	}

	void turnRight() {
		directionFacing = directionFacing.getRight();
	}

	void moveForward() {
		position = getPointInFront();
		route.recordMovement(directionFacing, position);
	}

	private boolean isStillExploring() {
		return !position.equals(maze.getExitPoint());
	}

	Point getPosition() {
		return new Point(position);
	}

	Direction getDirectionFacing() {
		return directionFacing;
	}

	public List<Step> getStepsTaken() {
		return route.getStepsTaken();
	}
}