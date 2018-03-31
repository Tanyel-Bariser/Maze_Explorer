package maze;

import static maze.MazePart.*;
import static org.junit.Assert.*;

import java.awt.Point;

import maze.*;

import org.junit.*;

import factory.MazeFactory;

public class ExampleMazeTest {
	Maze maze;
	
	@Before
	public void setUp() throws Exception {
		//Given created maze with example layout
		maze = MazeFactory.createExampleMaze();
	}

	@Test
	public void shouldReturnNumberOfWalls() {
		//When maze returns number of walls
		int numberOfWalls = maze.getNumberOfWalls();
		
		//Then should equal number of walls in example maze layout
		assertEquals(149, numberOfWalls);
	}

	@Test
	public void shouldReturnNumberOfEmptySpaces() {
		//When maze returns number of empty spaces
		int numberOfEmptySpaces = maze.getNumberOfEmptySpaces();
		
		//Then should equal number of empty spaces in example maze layout
		assertEquals(74, numberOfEmptySpaces);
	}
	
	@Test
	public void shouldReturnCorrectStartPoint() {
		//Given Start is located at point x = 3, y = 3 in example maze layout
		Point expectedStartPoint = new Point(3, 3);
				
		//When maze returns start point
		Point actualStartPoint = maze.getStartPoint();
		
		//Then should be at point x = 3, y = 3
		assertEquals(expectedStartPoint, actualStartPoint);
	}
	
	@Test
	public void immutableStartPointShouldBeReturn() {
		//When maze returns start point
		Point expectedStartPoint = maze.getStartPoint();
		int expectedX = expectedStartPoint.x;
		int expectedY = expectedStartPoint.y;
		
		//And an attempt to change start point is made
		maze.getStartPoint().x += 4;
		maze.getStartPoint().x -= 2;
		
		//Then start point should remain unchanged
		assertSame(expectedX, maze.getStartPoint().x);
		assertSame(expectedY, maze.getStartPoint().y);
		assertEquals(expectedStartPoint, maze.getStartPoint());
	}
	
	@Test
	public void shouldReturnCorrectExitPoint() {
		//Given Exit is located at point x = 1, y = 14 in example maze layout
		Point expectedExitPoint = new Point(1, 14);
				
		//When maze returns exit point
		Point actualExitPoint = maze.getExitPoint();
		
		//Then should be at point x = 1, y = 14
		assertEquals(expectedExitPoint, actualExitPoint);
	}
	
	@Test
	public void immutableExitPointShouldBeReturn() {
		//When maze returns exit point
		Point expectedExitPoint = maze.getExitPoint();
		int expectedX = expectedExitPoint.x;
		int expectedY = expectedExitPoint.y;
		
		//And an attempt to change exit point is made
		maze.getExitPoint().x += 4;
		maze.getExitPoint().x -= 2;
		
		//Then exit point should remain unchanged
		assertSame(expectedX, maze.getExitPoint().x);
		assertSame(expectedY, maze.getExitPoint().y);
		assertEquals(expectedExitPoint, maze.getExitPoint());
	}
	
	@Test
	public void shouldReturnCorrectMazePartWall() {
		//Given a Wall is located at point x = 2, y = 2 in example maze layout
				
		//When maze returns maze part at point x = 2, y = 2
		MazePart mazePart = maze.getMazePart(new Point(2, 2));
		
		//Then should be of type Wall
		assertSame(mazePart, WALL);
	}
	
	@Test
	public void shouldReturnCorrectMazePartEmptySpace() {
		//Given an Empty Space is located at point x = 1, y = 1 in example maze layout
				
		//When maze returns maze part at point x = 1, y = 1
		MazePart mazePart = maze.getMazePart(new Point(1, 1));
		
		//Then should be of type Empty Space
		assertSame(mazePart, SPACE);
	}
	
	@Test
	public void shouldReturnCorrectMazePartStart() {
		//Given Start is located at point x = 3, y = 3 in example maze layout
				
		//When maze returns maze part at point x = 3, y = 3
		MazePart mazePart = maze.getMazePart(new Point(3, 3));
		
		//Then should be of type Start
		assertSame(mazePart, START);
	}
	
	@Test
	public void shouldReturnCorrectMazePartExit() {
		//Given Exit is located at point x = 1, y = 14 in example maze layout
				
		//When maze returns maze part at point x = 1, y = 14
		MazePart mazePart = maze.getMazePart(new Point(1, 14));
		
		//Then should be of type Exit
		assertSame(mazePart, EXIT);
	}
}