package explorer;

import static org.junit.Assert.*;
import static explorer.Direction.*;

import java.awt.Point;

import maze.*;

import org.junit.*;

import factory.MazeFactory;

public class DirectionTest {
	Maze maze;

	@Before
	public void setUp() throws Exception {
		//Given maze created with example maze layout
		maze = MazeFactory.createExampleMaze();
	}

	@Test
	public void givenFacingNorthPositionInFrontShouldYSubtract1() {
		assertEquals(NORTH.getPointInFront(new Point(3,3)), new Point(3,2));
	}

	@Test
	public void givenFacingEastPositionInFrontShouldXPlus1() {
		assertEquals(EAST.getPointInFront(new Point(3,3)), new Point(4,3));
	}

	@Test
	public void givenFacingSouthPositionInFrontShouldYPlus1() {
		assertEquals(SOUTH.getPointInFront(new Point(3,3)), new Point(3,4));
	}

	@Test
	public void givenFacingWestPositionInFrontShouldXSubtract1() {
		assertEquals(WEST.getPointInFront(new Point(3,3)), new Point(2,3));
	}
	
	@Test
	public void givenFacingNorthLeftShouldBeWest() {
		assertSame(WEST, NORTH.getLeft());
	}
	
	@Test
	public void givenFacingNorthRightShouldBeEast() {
		assertSame(EAST, NORTH.getRight());
	}
	
	@Test
	public void givenFacingEastLeftShouldBeNorth() {
		assertSame(NORTH, EAST.getLeft());
	}
	
	@Test
	public void givenFacingEastRightShouldBeSouth() {
		assertSame(SOUTH, EAST.getRight());
	}
	
	@Test
	public void givenFacingSouthLeftShouldBeEast() {
		assertSame(EAST, SOUTH.getLeft());
	}
	
	@Test
	public void givenFacingSouthRightShouldBeWest() {
		assertSame(WEST, SOUTH.getRight());
	}
	
	@Test
	public void givenFacingWestLeftShouldBeSouth() {
		assertSame(SOUTH, WEST.getLeft());
	}
	
	@Test
	public void givenFacingWestRightShouldBeNorth() {
		assertSame(NORTH, WEST.getRight());
	}
}