package main;

import maze.Maze;
import presentation.Presentation;
import explorer.Explorer;
import factory.MazeFactory;

public class Navigation {

	public static void main(String[] args) {
		Maze maze = MazeFactory.createExampleMaze();
		
		Explorer explorer = Explorer.createExplorer(maze);
		explorer.exploreMaze();
		
		Presentation presentation = new Presentation();
		presentation.display(maze);
		presentation.display(explorer.getStepsTaken());
	}
}