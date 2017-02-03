package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import main.java.Cell;
import main.java.Location;
import main.java.Universe;

public class TestUniverseTick {
	
private Universe universe;
	
	@Before
	public void setUp() {
		 universe = new Universe();		 
	}

	@Test
	public void testUniversetWithThreeVerticalLiveCell() {
		Cell cell22 = Cell.createLiveCell(new Location(2, 2));
		Cell cell12 = Cell.createLiveCell(new Location(1, 2));
		Cell cell32 = Cell.createLiveCell(new Location(3, 2));
		universe.addCell(cell22);
		universe.addCell(cell12);
		universe.addCell(cell32);
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(false));
	}
	
	@Test
	public void testUniversetWithThreeVerticalLiveCellWithTwoTick() {
		Cell cell22 = Cell.createLiveCell(new Location(2, 2));
		Cell cell12 = Cell.createLiveCell(new Location(1, 2));
		Cell cell32 = Cell.createLiveCell(new Location(3, 2));
		universe.addCell(cell22);
		universe.addCell(cell12);
		universe.addCell(cell32);
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(false));
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(false));
	}
	
	
	@Test
	public void testVerticalAndHorizontalBarPatter() {
		Cell cell12 = Cell.createLiveCell(new Location(1, 2));
		Cell cell22 = Cell.createLiveCell(new Location(2, 2));		
		Cell cell32 = Cell.createLiveCell(new Location(3, 2));
		Cell cell21 = Cell.createDeadCell(new Location(2, 1));
		Cell cell23 = Cell.createDeadCell(new Location(2, 3));
		universe.addCell(cell22);
		universe.addCell(cell12);
		universe.addCell(cell32);
		universe.addCell(cell21);
		universe.addCell(cell23);
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));		
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell21.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell23.getLocation()).isAlive(), is(true));
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));		
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell21.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell23.getLocation()).isAlive(), is(false));
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));		
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell21.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell23.getLocation()).isAlive(), is(true));
		universe.tick();
		assertThat(universe.getCellFromUniverse(cell12.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell22.getLocation()).isAlive(), is(true));		
		assertThat(universe.getCellFromUniverse(cell32.getLocation()).isAlive(), is(true));
		assertThat(universe.getCellFromUniverse(cell21.getLocation()).isAlive(), is(false));
		assertThat(universe.getCellFromUniverse(cell23.getLocation()).isAlive(), is(false));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
