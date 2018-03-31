package presentation;

import java.util.List;

import maze.Maze;
import explorer.Step;

public class Presentation {

	public void display(final Maze maze) {
		System.out.println(maze);
	}

	public void display(final List<Step> stepsTaken) {
		for (final Step step : stepsTaken) {
			System.out.println(step);
		}
	}
}