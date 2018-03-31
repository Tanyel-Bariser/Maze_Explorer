package factory;

import static maze.MazePart.*;
import maze.*;

public class MazeFactory {

	public static Maze createExampleMaze() {
		final MazePart[][] exampleMazeMatrix = {
				{ WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL },
				{ WALL,  SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  START, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  SPACE, SPACE, SPACE, SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, WALL,  SPACE, WALL },
				{ WALL,  SPACE, WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  SPACE, SPACE, SPACE, WALL },
				{ WALL,  EXIT,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL }
		};
		return new Maze(exampleMazeMatrix);
	}
}