package main.java;

import java.util.HashMap;
import java.util.Map;

public class Universe {
	
	private Map<Location, Cell> universeMatrix =  new HashMap<Location, Cell>();
	
	public Universe addCell(Cell cell) {
		universeMatrix.put(cell.getLocation(), cell);		
		return this;
	}
	
	public Cell getCellFromUniverse(Location location) {
		return universeMatrix.get(location);
	}

	public Integer getLiveNeighbours(Location location) {	
		Location valueLocation  =  new Location(0, 0);	
		 int  neighbours = 0;  			
		 for(NeighbourOffset neighbourOffset: NeighbourOffset.values()) {			 
			 neighbours += checkAndUpateNeghbourCount(location, 
					 neighbourOffset, valueLocation);
		 }			 
		return neighbours;
	}
	
	private int  checkAndUpateNeghbourCount(Location cellLocation,NeighbourOffset offset,
			Location valueLocation) {
		 valueLocation.setxLocation(cellLocation.getxLocation()+offset.getxOffset());
		 valueLocation.setyLocation(cellLocation.getyLocation()+offset.getyOffset());
		 if(universeMatrix.get(valueLocation) != null 
				 && universeMatrix.get(valueLocation).isAlive()) {
			 return 1;			 
		 }	
		 return 0;
	}

	public void tick() {
		Map<Location, Cell> universeMatrixTemp =  new HashMap<Location, Cell>();
		universeMatrix.values().parallelStream().forEach(cell ->
		{
			
			Cell tempCell =cell.tick(this.getLiveNeighbours(cell.getLocation()));
			universeMatrixTemp.put(tempCell.getLocation(), tempCell);
		}		
		);
		universeMatrix = universeMatrixTemp;
	}
	
	
	
	
	

}
