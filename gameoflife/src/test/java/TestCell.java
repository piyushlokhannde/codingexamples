package test.java;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.Cell;
import main.java.Location;
import main.java.Universe;

@RunWith(value = Parameterized.class)
public class TestCell {
	
	private int numCell;
	private boolean result;
	
	Cell cell =null;
	@Before
	public void setUp() {
		cell = Cell.createLiveCell(new Location(1, 1));
		
	}
	
	public  TestCell(int numCell, boolean result) {
		this.numCell = numCell;
		this.result =result;
		
	}
	
	@Parameterized.Parameters
    public static Collection locations() {
      System.out.println("loccation() is called");
       return Arrays.asList(new Object[][] {
       	{ 0, false },
       	{ 1, false },       
       	{ 2, true },
       	{ 3, true },
       	{ 4, false },
          
       });
    }
	
	
	@Test
	public void singleLiveCellPresentIntheUniverseTest() {
				
		cell = cell.tick(this.numCell);
		assertThat(cell.isAlive(), is(this.result));
	}
	

	
	@Test
	public void singleDeadCellWithExacltyThreeLiveNeighbours() {
		cell = Cell.createDeadCell(new Location(2, 2));	
		cell =cell.tick(3);
		assertThat(cell.isAlive(), is(true));
	}
	
	
	
}
