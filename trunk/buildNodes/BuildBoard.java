package buildNodes;

public class BuildBoard {
	Tiles[][] tilesArray;
	
	public BuildBoard() {
		// TODO Auto-generated constructor stub
	tilesArray = new Tiles[3][3];
	
	
	
//	Tiles tile1 = new Tiles("1",new ArrayIndex(1, 1),new ArrayIndex(0, 0));
//	Tiles tile2 = new Tiles("2",new ArrayIndex(0, 1),new ArrayIndex(0, 1));
//	Tiles tile3 = new  Tiles("3",new ArrayIndex(0, 2),new ArrayIndex(0, 2));
//	Tiles tile4 = new Tiles("4",new ArrayIndex(1, 0),new ArrayIndex(1, 0));
//	Tiles tile5 = new Tiles("5",new ArrayIndex(1, 2),new ArrayIndex(1, 1));
//	Tiles tile6 = new Tiles("6",new ArrayIndex(2, 0),new ArrayIndex(1, 2));
//	Tiles tile7 = new Tiles("7",new ArrayIndex(2, 1),new ArrayIndex(2, 0));
//	Tiles tile8 = new Tiles("8",new ArrayIndex(2, 2),new ArrayIndex(2, 1));
//	Tiles tile0 = new Tiles("0",new ArrayIndex(0, 0),new ArrayIndex(2, 2));
//	
//	tilesArray[0][0] = tile0;
//	tilesArray[0][1] = tile2;
//	tilesArray[0][2] = tile3;
//	tilesArray[1][0] = tile4;
//	tilesArray[1][1] = tile1;
//	tilesArray[1][2] = tile5;
//	tilesArray[2][0] = tile6;
//	tilesArray[2][1] = tile8;
//	tilesArray[2][2] = tile7;

	Tiles tile1 = new Tiles("1",new ArrayIndex(0, 0),new ArrayIndex(0, 0));
	Tiles tile2 = new Tiles("2",new ArrayIndex(0, 1),new ArrayIndex(0, 1));
	Tiles tile3 = new Tiles("3",new ArrayIndex(1, 2),new ArrayIndex(0, 2));
	Tiles tile4 = new Tiles("4",new ArrayIndex(2, 0),new ArrayIndex(1, 0));
	Tiles tile5 = new Tiles("5",new ArrayIndex(2, 1),new ArrayIndex(1, 1));
	Tiles tile6 = new Tiles("6",new ArrayIndex(1, 1),new ArrayIndex(1, 2));
	Tiles tile7 = new Tiles("7",new ArrayIndex(1, 0),new ArrayIndex(2, 0));
	Tiles tile8 = new Tiles("8",new ArrayIndex(0, 2),new ArrayIndex(2, 1));
	Tiles tile0 = new Tiles("0",new ArrayIndex(2, 2),new ArrayIndex(2, 2));
	
	tilesArray[0][0] = tile1;
	tilesArray[0][1] = tile2;
	tilesArray[0][2] = tile8;
	tilesArray[1][0] = tile7;
	tilesArray[1][1] = tile6;
	tilesArray[1][2] = tile3;
	tilesArray[2][0] = tile4;
	tilesArray[2][1] = tile5;
	tilesArray[2][2] = tile0;

	}

	public Tiles[][] getTilesArray() {
		return tilesArray;
	}

}
