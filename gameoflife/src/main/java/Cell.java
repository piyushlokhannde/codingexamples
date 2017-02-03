package main.java;

public final class Cell {
	
	final private boolean alive;	
	final private Location location ;	

	public static Cell createLiveCell(Location cellLocation) {		
		Cell cell = new Cell(true, cellLocation);		
		return cell;
	}
	
	private Cell(boolean alive, Location location) {
		this.alive = alive;
		this.location = location;
	}

	public Cell tick(int neighbours) {		
		if(this.isAlive() && (neighbours < 2 || neighbours >3) ) {
			return Cell.createDeadCell(this.location);
		} else if(!this.isAlive() && neighbours ==3) {
			return Cell.createLiveCell(this.location);
		}		
		return this;
	}

	public boolean  isAlive() {		
		return alive;
	}
	
	

	public static Cell createDeadCell(Location location) {
		Cell cell = new Cell(false, location);	
		return cell;		
	}

	public Location getLocation() {
		return location;
	}

	
}
