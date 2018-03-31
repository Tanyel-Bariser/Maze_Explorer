package maze;

import static maze.MazePart.*;

import java.awt.Point;

public class Maze {
	private final MazePart[][] mazeMatrix;
	private final Point startPoint;
	private final Point exitPoint;
	private final int numberOfWalls;
	private final int numberOfEmptySpaces;

	public Maze(final MazePart[][] mazeMatrix) {
		this.mazeMatrix = mazeMatrix;
		startPoint = findPoint(START);
		exitPoint = findPoint(EXIT);
		numberOfWalls = count(WALL);
		numberOfEmptySpaces = count(SPACE);
	}

	private Point findPoint(final MazePart mazePart) {
		for (int row = 0; row < mazeMatrix.length; row++) {
			for (int column = 0; column < mazeMatrix[row].length; column++) {
				if (mazeMatrix[row][column] == mazePart) {
					return new Point(column, row);
				}
			}
		}
		throw new IllegalArgumentException("MazePart: " + mazePart.name() + " is not in maze.");
	}

	private int count(final MazePart mazePart) {
		int mazeParts = 0;
		for (final MazePart[] row : mazeMatrix) {
			for (final MazePart part : row) {
				if (part == mazePart) {
					mazeParts++;
				}
			}
		}
		return mazeParts;
	}

	public Point getStartPoint() {
		return new Point(startPoint);
	}

	public Point getExitPoint() {
		return new Point(exitPoint);
	}

	public MazePart getMazePart(final Point point) {
		return mazeMatrix[point.y][point.x];
	}

	public int getNumberOfWalls() {
		return numberOfWalls;
	}

	public int getNumberOfEmptySpaces() {
		return numberOfEmptySpaces;
	}

	@Override
	public String toString() {
		final StringBuilder maze = new StringBuilder();
		for (final MazePart[] row : mazeMatrix) {
			for (final MazePart part : row) {
				maze.append(part.getSymbol());
			}
			maze.append('\n');
		}
		return maze.toString();
	}
}