package search;

import buildNodes.Tiles;


public class CalculateManhattanDistance {

	int manhattanDistance = 0;
	
	public CalculateManhattanDistance() {
		// TODO Auto-generated constructor stub
		
	}
	
	public int GetManhattanDistance(Tiles[][] tilesArray){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				manhattanDistance += tilesArray[0][0].DistanceOfTwoTiles((tilesArray[i][j]).getCurrentPosition(), (tilesArray[i][j]).getOptimalPosition());
			}
		}
		return manhattanDistance;
	}
}
