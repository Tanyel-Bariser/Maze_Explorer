package explorer;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.*;

import org.junit.*;

import explorer.*;

public class RouteTest {
	Route route;
	Point startPoint;
	Direction direction;
	Random random = new Random();
	
	@Before
	public void setUp() throws Exception {
		//Given route created with start point
		startPoint = new Point(4,6);
		direction = Direction.values()[random.nextInt(Direction.values().length)];
		route = new Route();
		route.recordMovement(direction, startPoint);
	}

	@Test
	public void shouldOnlyContainStartPointWhenCreated() {
		//Then route should contain start point as a visited point
		assertTrue(route.getStepsTaken().contains(new Step(direction, startPoint)));
		
		//And only contain start point as a visited point
		assertSame(1, route.getStepsTaken().size());
	}
	
	@Test
	public void shouldContainOnlyTwoPointsWhenVisitedSecondPoint() {
		//When visiting a second point from any direction
		Point secondPoint = new Point(5,6);
		route.recordMovement(direction, secondPoint);
		
		//Then route should contain start point as a visited point
		assertTrue(route.getStepsTaken().contains(new Step(direction, startPoint)));
		
		//And route should contain second point as a visited point
		assertTrue(route.getStepsTaken().contains(new Step(direction, secondPoint)));
		
		//And only contain 2 points as a visited points
		assertSame(2, route.getStepsTaken().size());
	}
	
	@Test
	public void shouldContainAllPointsVisitedAndNoMore() {
		//When visiting 10,000 additional points from any direction in addition to the start point (10,001 in total)
		List<Step> visitedPoints = new ArrayList<>();
		visitedPoints.add(new Step(direction, startPoint));
		for (int x = 0; x < 100; x++) {
			for (int y = 99; y > -1; y--) {
				Point newPoint = new Point(x, y);
				visitedPoints.add(new Step(direction, newPoint));
				route.recordMovement(direction, newPoint);
			}
		}
		
		//Then route should contain all visited points
		assertTrue(route.getStepsTaken().containsAll(visitedPoints));
		
		//And only contain 10,001 points as visited points
		assertEquals(10001, route.getStepsTaken().size());
	}
	
	@Test
	public void shouldRecordAllMovementsTakenAndNoMore() {
		//When moving 2,500 steps in any direction
		List<Step> expectedRouteTaken = new ArrayList<>();
		for (int x = 0; x < 50; x++) {
			for (int y = 49; y > -1; y--) {
				Point newPoint = new Point(x, y);
				direction = Direction.values()[random.nextInt(Direction.values().length)];
				expectedRouteTaken.add(new Step(direction, newPoint));
				route.recordMovement(direction, newPoint);
			}
		}
		
		//Then route should contain record of all movements in route taken
		assertTrue(route.getStepsTaken().containsAll(expectedRouteTaken));
		
		//And only contain 2,501 movements in route taken, first one add the additional 2,500
		assertEquals(2501, route.getStepsTaken().size());
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void recordOfRouteTakenShouldBeImmutibleOnceReturned() {
		//Given moved 3 steps
		Point point1 = new Point(5,6);
		Point point2 = new Point(5,7);
		Point point3 = new Point(5,8);
		route.recordMovement(direction, point1);
		route.recordMovement(direction, point2);
		route.recordMovement(direction, point3);
		
		//When route returns record of route taken
		List<Step> routeTaken = route.getStepsTaken();
		
		//And an attempt to remove a movement from the returned route taken
		routeTaken.remove(0);
		
		//Then should be disallowed
	}
}