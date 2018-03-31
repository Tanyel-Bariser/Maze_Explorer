package explorer;

import static explorer.Direction.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import explorer.*;
import factory.MazeFactory;

import java.awt.Point;

import maze.Maze;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExplorerTest {
	
	class ExplorerBuilder {
		private final Maze maze;
		private Point position;
		private Route route;
		private Direction facingDirection;
		ExplorerBuilder() {
			this.maze = MazeFactory.createExampleMaze();
			position = new Point(3,3);//Start point of example maze
			facingDirection = NORTH;
			route = new Route();
		}
		ExplorerBuilder position(Point position) {
			this.position = position;
			return this;
		}
		ExplorerBuilder route(Route route) {
			this.route = route;
			return this;
		}
		ExplorerBuilder direction(Direction facingDirection) {
			this.facingDirection = facingDirection;
			return this;
		}
		Explorer build() {
			return new Explorer(maze, position, route, facingDirection);
		}
	}

	@Test
	public void shouldChooseUnvisitedPointWhenGivenMultipleAvailablePaths() {
		//Given at point x = 11, y = 6 in example maze there are three available paths to move
		Point startPoint = new Point(11, 6);
		
		//And explorer is positioned at point x = 11, y = 6
		Route route = new Route();
		Explorer explorer = new ExplorerBuilder().position(startPoint).route(route).build();
		
		//And two of the three available paths have been visited previously
		route.recordMovement(NORTH, new Point(11, 5));
		route.recordMovement(SOUTH, new Point(11, 7));
		
		//Then should face West in preparation to move to the only available unvisited path
		explorer.faceDirectionOfAvailablePath();
		assertSame(WEST, explorer.getDirectionFacing());
	}
	
	@Test
	public void shouldChooseAnyPathIfAllAvailblePathsHaveBeenVisited() {
		//Given point x = 5, y = 3 has two available paths, either West or East but not North or South
		Point startPoint = new Point(5,3);
		
		//And explorer is positioned at point x = 5, y = 3 
		Route route = new Route();
		Explorer explorer = new ExplorerBuilder().position(startPoint).route(route).build();
		
		//And both available paths have been visited
		route.recordMovement(WEST, new Point(4, 3));
		route.recordMovement(EAST, new Point(6, 3));
		
		//Then should choose either path, West or East, but not North or South
		explorer.faceDirectionOfAvailablePath();
		assertTrue(explorer.getDirectionFacing() == WEST || explorer.getDirectionFacing() == EAST);
	}
	
	@Test
	public void givenFacingNorthWhenTurnRightThenShouldFaceEast() {
		//Given explorer facing North
		Explorer explorer = new ExplorerBuilder().direction(NORTH).build();

		//When turn right
		explorer.turnRight();
		
		//Then should face East
		assertSame(EAST, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingNorthWhenTurnLeftThenShouldFaceWest() {
		//Given explorer facing North
		Explorer explorer = new ExplorerBuilder().direction(NORTH).build();

		//When turn left
		explorer.turnLeft();
		
		//Then should face West
		assertSame(WEST, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingEastWhenTurnRightThenShouldFaceSouth() {
		//Given explorer facing East
		Explorer explorer = new ExplorerBuilder().direction(EAST).build();

		//When turn right
		explorer.turnRight();
		
		//Then should face South
		assertSame(SOUTH, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingEastWhenTurnLeftThenShouldFaceNorth() {
		//Given explorer facing East
		Explorer explorer = new ExplorerBuilder().direction(EAST).build();

		//When turn left
		explorer.turnLeft();
		
		//Then should face North
		assertSame(NORTH, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingSouthWhenTurnRightThenShouldFaceWest() {
		//Given explorer facing South
		Explorer explorer = new ExplorerBuilder().direction(SOUTH).build();

		//When turn right
		explorer.turnRight();
		
		//Then should face West
		assertSame(WEST, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingSouthWhenTurnLeftThenShouldFaceEast() {
		//Given explorer facing South
		Explorer explorer = new ExplorerBuilder().direction(SOUTH).build();

		//When turn left
		explorer.turnLeft();
		
		//Then should face East
		assertSame(EAST, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingWestWhenTurnRightThenShouldFaceNorth() {
		//Given explorer facing West
		Explorer explorer = new ExplorerBuilder().direction(WEST).build();

		//When turn right
		explorer.turnRight();
		
		//Then should face North
		assertSame(NORTH, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingWestWhenTurnLeftThenShouldFaceSouth() {
		//Given explorer facing West
		Explorer explorer = new ExplorerBuilder().direction(WEST).build();

		//When turn left
		explorer.turnLeft();
		
		//Then should face South
		assertSame(SOUTH, explorer.getDirectionFacing());
	}
	
	@Test
	public void givenFacingNorthWhenMoveForwardThenNewPositionShouldBeOnePointTowardNorth() {
		//Given an Empty Space is located at point x = 1, y = 1 in example maze layout
		Point expectedEndPosition = new Point(1, 1);
		
		//And explorer is initialised at position point x = 1, y = 2
		//And explorer is initialised to face North
		Explorer explorer = new ExplorerBuilder().position(new Point(1,2)).direction(NORTH).build();
	
		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should be located one step North of initial position
		assertEquals(expectedEndPosition, explorer.getPosition());
	}
	
	@Test
	public void givenFacingEastWhenMoveForwardThenNewPositionShouldBeOnePointTowardEast() {
		//Given an Empty Space is located at point x = 4, y = 1 in example maze layout
		Point expectedEndPosition = new Point(4, 1);
		
		//And explorer is initialised at position point x = 3, y = 1
		//And explorer is initialised to face East
		Explorer explorer = new ExplorerBuilder().position(new Point(3,1)).direction(EAST).build();

		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should be located one step East of initial position
		assertEquals(expectedEndPosition, explorer.getPosition());
	}

	@Test
	public void givenFacingSouthWhenMoveForwardThenNewPositionShouldBeOnePointTowardSouth() {
		//Given an Empty Space is located at point x = 1, y = 3 in example maze layout
		Point expectedEndPosition = new Point(1, 3);
		
		//And explorer is initialised at position point x = 1, y = 2
		//And explorer is initialised to face South
		Explorer explorer = new ExplorerBuilder().position(new Point(1,2)).direction(SOUTH).build();
	
		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should be located one step South of initial position
		assertEquals(expectedEndPosition, explorer.getPosition());
	}
	
	@Test
	public void givenFacingWestWhenMoveForwardThenNewPositionShouldBeOnePointTowardWest() {
		//Given an Empty Space is located at point x = 2, y = 1 in example maze layout
		Point expectedEndPosition = new Point(2, 1);
		
		//And explorer is initialised at position point x = 3, y = 1
		//And explorer is initialised to face West
		Explorer explorer = new ExplorerBuilder().position(new Point(3,1)).direction(WEST).build();

		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should be located one step West of initial position
		assertEquals(expectedEndPosition, explorer.getPosition());
	}
	
	@Test
	public void shouldKeepRecordOfRouteTaken() {
		//Given an Empty Space is located at point x = 1, y = 3 in example maze layout
		//And explorer is initialised at position point x = 1, y = 2
		//And explorer is initialised to face South
		Route route = Mockito.mock(Route.class);
		Explorer explorer = new ExplorerBuilder().position(new Point(1,2))
												 .route(route).direction(SOUTH).build();
	
		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should record movement
		verify(route).recordMovement(SOUTH, explorer.getPosition());
	}
	
	@Test
	public void shouldKeepRecordOfRouteTakenInUnderstandableFormat() {
		//Given an Empty Space is located at point x = 1, y = 3 in example maze layout
		//And explorer is initialised at position point x = 1, y = 4
		//And explorer is initialised to face North
		Explorer explorer = new ExplorerBuilder().position(new Point(1,4)).direction(NORTH).build();
	
		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should record movement in an understandable fashion
		String expected1 = "Moved NORTH one step to point: x = 1, y = 3";
		String actual1 = explorer.getStepsTaken().get(1).toString();
		assertEquals(expected1, actual1);
		
		//And should also record subsequent movements in an understandable fashion
		explorer.moveForward();
		String expected2 = "Moved NORTH one step to point: x = 1, y = 2";
		String actual2 = explorer.getStepsTaken().get(2).toString();
		assertEquals(expected2, actual2);
	}

	@Test
	public void shouldKnowPointsVisited() {
		//Given an Empty Space is located at point x = 1, y = 3 in example maze layout
		Point expectedPoint = new Point(1,3);
		//And explorer is initialised at position point x = 1, y = 2
		//And explorer is initialised to face South
		Explorer explorer = new ExplorerBuilder().position(new Point(1,2)).direction(SOUTH).build();
	
		//When explorer moves one step forward
		explorer.moveForward();
		
		//Then should record movement
		assertTrue(explorer.getStepsTaken().contains(new Step(SOUTH, expectedPoint)));
	}
	
	@Test
	public void shouldAlwaysReachExitAfterExploringMaze() {
		//Given Exit is located at point x = 1, y = 14 in example maze layout
		Point exitPoint = new Point(1, 14);
		
		//When explorer explores maze from example maze start point x = 3, y = 3
		Explorer explorer = new ExplorerBuilder().position(new Point(3,3)).build();
		explorer.exploreMaze();
		
		//Then should always reach exit point and stop there
		assertEquals(exitPoint, explorer.getPosition());
	}
}