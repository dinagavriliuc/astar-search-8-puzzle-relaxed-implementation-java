package buildNodes;

public class Tiles {

    String name;
    ArrayIndex currentPosition;
    ArrayIndex optimalPosition;

    public Tiles(String name, ArrayIndex currentPosition, ArrayIndex optimalPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
        this.optimalPosition = optimalPosition;
    }
    public Tiles(String name, ArrayIndex optimalPosition) {
        this.name = name;
        this.optimalPosition = optimalPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayIndex getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(ArrayIndex currentPosition) {
        this.currentPosition = currentPosition;
    }

    public ArrayIndex getOptimalPosition() {
        return optimalPosition;
    }

    public void setOptimalPosition(ArrayIndex optimalPosition) {
        this.optimalPosition = optimalPosition;
    }
    
    public int DistanceOfTwoTiles(ArrayIndex one, ArrayIndex two){
        
        return Math.abs(one.column - two.column) + Math.abs(one.row - two.row);
        
    }
    
    @Override
    public boolean equals(Object obj) {
        return name.equals(((Tiles)obj).name);
    }

}