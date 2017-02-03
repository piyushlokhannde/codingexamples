package main.java;

public class Location {
	
	private int xLocation;
	
	private int yLocation;

	public Location(int xLocation, int yLocation) {
		this.setxLocation(xLocation);
		this.setyLocation(yLocation);
	}

	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.xLocation+ this.yLocation;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		} 
		
		if(!(obj instanceof Location)) {
			return false;
		}
		Location otherLocation = (Location)obj;
		
		if (this.xLocation != otherLocation.xLocation ||
				this.yLocation != otherLocation.yLocation) {
			
			return false;
		}
		
	
		
		return true;
	}
	
	
	
	
	
	
	
	

}
