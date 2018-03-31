package explorer;

import static explorer.Direction.NORTH;
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.*;

import explorer.Step;

public class StepTest {
	Step step;
	Point point;
	
	@Before
	public void setUp() {
		point = new Point(2, 3);
		step = new Step(NORTH, point);
	}

	@Test
	public void shouldReturnDirectionAndPoint() {
		assertSame(NORTH, step.getDirection());
		assertEquals(new Point(2,3), step.getPoint());
	}
	
	@Test
	public void shouldNotBeAbleToChangePoint() {
		point.x = 5;
		point.y = 7;
		assertEquals(new Point(2,3), step.getPoint());
	}
	
	@Test
	public void stepToStringMethodOverriden() {
		assertEquals("Moved NORTH one step to point: x = 2, y = 3", step.toString());
	}
}