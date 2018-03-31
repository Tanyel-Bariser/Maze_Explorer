package factory;

import static org.junit.Assert.*;
import maze.Maze;

import org.junit.*;

import factory.MazeFactory;

public class MazeFactoryTest {
	Maze maze;
	
	@Before
	public void setUp() {
		//Given maze created with example layout
		maze = MazeFactory.createExampleMaze();
	}
	
	@Test
	public void shouldCreateMazeWithExampleLayout() {
		//Given maze created with example layout
		String expectedMazeLayout =
				"XXXXXXXXXXXXXXX\n" +
				"X             X\n" +
				"X XXXXXXXXXXX X\n" +
				"X XS        X X\n" +
				"X XXXXXXXXX X X\n" +
				"X XXXXXXXXX X X\n" +
				"X XXXX      X X\n" +
				"X XXXX XXXX X X\n" +
				"X XXXX XXXX X X\n" +
				"X X    XXXXXX X\n" +
				"X X XXXXXXXXX X\n" +
				"X X XXXXXXXXX X\n" +
				"X X         X X\n" +
				"X XXXXXXXXX   X\n" +
				"XFXXXXXXXXXXXXX\n";
		
		//When maze returns output of layout 
		String actualMazeLayout = maze.toString();
		
		//Then example layout and maze layout should be equal
		assertEquals(expectedMazeLayout, actualMazeLayout);
	}
	
	@Test
	public void shouldCreateMazeWithOneAndOnlyOneStartPoint() {
		//Then should have only one start point
		int numberOfStartPoints = maze.toString().length() - maze.toString().replace("S", "").length();
		assertSame(1, numberOfStartPoints);		
	}
	
	@Test
	public void shouldCreateMazeWithOneAndOnlyOneExitPoint() {
		//Then should have only one exit point
		int numberOfExitPoints = maze.toString().length() - maze.toString().replace("F", "").length();
		assertSame(1, numberOfExitPoints);		
	}
}