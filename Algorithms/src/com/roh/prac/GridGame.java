package com.roh.prac;

public class GridGame {
	
	public static boolean searchPath(XY[][] grid, XY start, XY end) {
		//Queue<XY> queue = new ArrayDeque<>();
		if(start.equals(end))
			return true;
		
		if(isValid(grid, start) == null) {
			return false;
		}
		
		// traversal
		//left
		XY pix = new XY(start.x -1, start.y);
		if(isValid(grid, pix) != null && (pix.left & 1) > 0)
			searchPath(grid, pix, end);
		
		//right
		pix = new XY(start.x + 1, start.y);
		if(isValid(grid, pix) != null  && (pix.right & 2) > 0)
			searchPath(grid, pix, end);
		
		//top
		pix = new XY(start.x, start.y -1);
		if(isValid(grid, pix) != null  && (pix.top & 4) > 0)
			searchPath(grid, pix, end);
				
		//bottom
		pix = new XY(start.x, start.y + 1);
		if(isValid(grid, pix) != null  && (pix.bottom & 8) > 0)
			searchPath(grid, pix, end);
		
		
		return false;
	}
	
	public static XY isValid(XY[][] grid, XY pixel) {
		if(pixel.x < grid.length && pixel.y < grid[0].length && pixel.x >= 0 && pixel.y >= 0)
		{
			XY pix = grid[pixel.x][pixel.y];
			return pix;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class XY {
	int x, y;
	boolean isVisited = false;
	int left, right, top, bottom;
	public XY() {}
	
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public XY(int left, int right, int top, int bottom) {
		this.left = left; // 1
		this.right = right;// 2
		this.top = top;// 4
		this.bottom = bottom;// 8
	}
	public boolean equals(XY a, XY b) {
		if(a.x == b.x && a.y == b.y)
			return true;
		return false;
	}
}
