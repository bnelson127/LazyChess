package objects;

import constants.RowNames;

public class Location {
	private int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return RowNames.rowNames[7 - this.x] + "" + (this.y + 1);
	}
	
	@Override
	public boolean equals(Object location) {
		if (location.getClass() != this.getClass()) {
			return false;
		}
		Location castLocation = (Location) location;
		
		return castLocation.getX() == this.x && castLocation.getY() == this.y;
	}
}
