package test.java;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.Cell;
import main.java.Location;
import main.java.Universe;
import static org.hamcrest.Matchers.hasSize;

@RunWith(value = Parameterized.class)
public class TestUniverse {
	
	  private Integer xLocation;
	     private Integer yLocation;
	
	private Universe universe;
	
	@Before
	public void setUp() {
		 universe = new Universe();
		
		 
	}
	
	public  TestUniverse(Integer xLocation, Integer yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		
	}
	
	 @Parameterized.Parameters
     public static Collection locations() {
       System.out.println("loccation() is called");
        return Arrays.asList(new Object[][] {
        	{ 1, 1 },
        	{ 1, 2 },
        	{ 1, 3 },
        	{ 2, 1 },
        	{ 2, 3 },
        	{ 3, 1 },
            { 3, 2 },
            { 3, 3 },
          
        });
     }
	
	
	@Test
	public void testUniveseWithOnlyOneCell() {
		Cell cell = Cell.createLiveCell(new Location(1, 1));		
		universe.addCell(cell);		
		assertEquals(0,universe.getLiveNeighbours(cell.getLocation()).intValue() );
		
	}	
	
	@Test
	public void testUniveseWithTwoNonNeghbours() {
		Cell cell = Cell.createLiveCell(new Location(1, 1));		
		universe.addCell(cell);	
		universe.addCell(Cell.createLiveCell(new Location(3, 3)));	
		
		assertEquals(0,universe.getLiveNeighbours(cell.getLocation()).intValue() );
	}
	
	
	@Test
	public void testUniveseWithOnlyOneNeighbourCell() {
		Cell cell = Cell.createLiveCell(new Location(2, 2));		
		universe.addCell(cell);	
		universe.addCell(Cell.createLiveCell(new Location(this.xLocation, this.yLocation)));		
		assertEquals(1,universe.getLiveNeighbours(cell.getLocation()).intValue() );
	}
	
	@Test
	public void testUniveseWithOnlyOneNeighbourDeadCell() {
		Cell cell = Cell.createLiveCell(new Location(2, 2));		
		universe.addCell(cell);	
		universe.addCell(Cell.createDeadCell(new Location(this.xLocation, this.yLocation)));		
		assertEquals(0,universe.getLiveNeighbours(cell.getLocation()).intValue() );
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
