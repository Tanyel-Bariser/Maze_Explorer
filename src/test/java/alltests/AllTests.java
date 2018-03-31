package alltests;

import maze.ExampleMazeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import explorer.*;
import factory.MazeFactoryTest;

@RunWith(Suite.class)
@SuiteClasses({ DirectionTest.class, ExplorerTest.class, ExampleMazeTest.class,
		MazeFactoryTest.class, RouteTest.class })
public class AllTests {

}