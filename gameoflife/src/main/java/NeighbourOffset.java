package main.java;

public enum NeighbourOffset {
	
	NORTH(-1,0), SOUTH(1,0),NORTHWEST(-1,-1),NORTHEAST(-1,1),
	WEST(0,-1),EAST(0,1),SOUTHWEST(1,-1),SOUTHEAST(1,1);
	
	NeighbourOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public int getxOffset() {
		return xOffset;
	}
	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}
	public int getyOffset() {
		return yOffset;
	}
	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	private int xOffset;
	private int yOffset;

}
