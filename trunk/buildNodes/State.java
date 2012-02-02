package buildNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {

    public Tiles[][] tilesArray;
    State parentState;
    List<State> successors;

    int f_score;
    int g_score;
    int h_score;

    public State(Tiles[][] tiles, State parentState, int g_score) {
        this.parentState = parentState;
        if (parentState == null)
            this.g_score = 0;
        this.tilesArray = tiles;
        this.g_score = g_score;
        successors = new ArrayList<State>();
    }

    Tiles[][] MoveLeft(Tiles[][] tilesArray) {

        Tiles[][] tempTilesArray = new Tiles[3][3];

        Tiles[][] tempTilesArrayToSend = new Tiles[3][3];
        tempTilesArrayToSend = CopyTilesArrays(tilesArray, tempTilesArrayToSend);

        ArrayIndex zeroPos = FindZero(tilesArray);

        Tiles zeroTile = GetTile(zeroPos, tilesArray);

        if (zeroPos.column != 0) {
            ArrayIndex otherPos = new ArrayIndex(zeroPos.row,
                    zeroPos.column - 1);
            tempTilesArray = SwapTilesPositions(zeroTile, GetTile(otherPos,
                    tilesArray), tempTilesArrayToSend);
        }
        return tempTilesArray;

    }

    Tiles[][] MoveRight(Tiles[][] tilesArray) {

        Tiles[][] tempTilesArray = new Tiles[3][3];
        Tiles[][] tempTilesArrayToSend = new Tiles[3][3];

        tempTilesArrayToSend = CopyTilesArrays(tilesArray, tempTilesArrayToSend);

        ArrayIndex zeroPos = FindZero(tilesArray);

        Tiles zeroTile = GetTile(zeroPos, tilesArray);

        if (zeroPos.column != 2) {
            ArrayIndex otherPos = new ArrayIndex(zeroPos.row,
                    zeroPos.column + 1);
            tempTilesArray = SwapTilesPositions(zeroTile, GetTile(otherPos,
                    tilesArray), tempTilesArrayToSend);
        }
        return tempTilesArray;

    }

    Tiles[][] MoveUp(Tiles[][] tilesArray) {

        Tiles[][] tempTilesArray = new Tiles[3][3];

        Tiles[][] tempTilesArrayToSend = new Tiles[3][3];
        tempTilesArrayToSend = CopyTilesArrays(tilesArray, tempTilesArrayToSend);
        ArrayIndex zeroPos = FindZero(tilesArray);

        Tiles zeroTile = GetTile(zeroPos, tilesArray);

        if (zeroPos.row != 0) {
            ArrayIndex otherPos = new ArrayIndex(zeroPos.row - 1,
                    zeroPos.column);
            tempTilesArray = SwapTilesPositions(zeroTile, GetTile(otherPos,
                    tilesArray), tempTilesArrayToSend);
        }
        return tempTilesArray;

    }

    Tiles[][] MoveDown(Tiles[][] tilesArray) {

        Tiles[][] tempTilesArrayToSend = new Tiles[3][3];
        tempTilesArrayToSend = CopyTilesArrays(tilesArray, tempTilesArrayToSend);
        Tiles[][] tempTilesArray = new Tiles[3][3];

        ArrayIndex zeroPos = FindZero(tilesArray);

        Tiles zeroTile = GetTile(zeroPos, tilesArray);

        if (zeroPos.row != 2) {
            ArrayIndex otherPos = new ArrayIndex(zeroPos.row + 1,
                    zeroPos.column);
            tempTilesArray = SwapTilesPositions(zeroTile, GetTile(otherPos,
                    tilesArray), tempTilesArrayToSend);
        }
        return tempTilesArray;

    }

    ArrayIndex FindZero(Tiles[][] tilesArray) {

        Tiles zero = new Tiles("0", new ArrayIndex(2, 2));
        ArrayIndex arrayIndex = null;

        for (int i = 0; i < tilesArray.length; i++) {

            for (int j = 0; j < 3; j++) {
                if (tilesArray[i][j].name == zero.name) {
                    arrayIndex = new ArrayIndex(i, j);
                }
            }

        }
        return arrayIndex;

    }

    Tiles[][] SwapTilesPositions(Tiles zeroTile, Tiles otherTile,
            Tiles[][] tempTilesArray) {

        Tiles[][] temp = new Tiles[3][3];

        temp = CopyTilesArrays(tempTilesArray, temp);

        ArrayIndex tempOtherTile = new ArrayIndex(otherTile.currentPosition
                .getRow(), otherTile.currentPosition.getColumn());
        ArrayIndex tempZeroTile = new ArrayIndex(zeroTile.currentPosition
                .getRow(), zeroTile.currentPosition.getColumn());

        temp[tempZeroTile.row][tempZeroTile.column] = otherTile;
        temp[tempZeroTile.row][tempZeroTile.column].currentPosition = zeroTile.currentPosition;

        temp[tempOtherTile.row][tempOtherTile.column] = zeroTile;
        temp[tempOtherTile.row][tempOtherTile.column].currentPosition = tempOtherTile;

        return temp;
    }

    Tiles GetTile(ArrayIndex currentPosition, Tiles[][] tilesArray2) {

        Tiles tile = tilesArray2[currentPosition.row][currentPosition.column];
        Tiles returnTile = new Tiles(tile.name, tile.optimalPosition);
        returnTile.currentPosition = tile.currentPosition;
        return returnTile;

    }

    public List<State> GetSuccessors() {

        ArrayIndex zeroPos = FindZero(tilesArray);

        Tiles[][] tempTilesArray = new Tiles[3][3];
        tempTilesArray = CopyTilesArrays(tilesArray, tempTilesArray);

        if (zeroPos.column != 2) {
            Tiles[][] temp = new Tiles[3][3];
            temp = CopyTilesArrays(tempTilesArray, temp);

            successors.add(new State(MoveRight(temp), this, this.g_score + 1));
        }
        if (zeroPos.column != 0) {
            Tiles[][] temp = new Tiles[3][3];
            temp = CopyTilesArrays(tempTilesArray, temp);
            successors.add(new State(MoveLeft(temp), this, this.g_score + 1));
        }
        if (zeroPos.row != 2) {
            Tiles[][] temp = new Tiles[3][3];
            temp = CopyTilesArrays(tempTilesArray, temp);
            successors.add(new State(MoveDown(temp), this, this.g_score + 1));
        }
        if (zeroPos.row != 0) {
            Tiles[][] temp = new Tiles[3][3];
            temp = CopyTilesArrays(tempTilesArray, temp);
            successors.add(new State(MoveUp(temp), this, this.g_score + 1));
        }

        return successors;

    }

    public int CalculateFScore() {
        int f_score = 0;
        f_score = this.g_score + GetManhattanDistance(tilesArray);

        return f_score;

    }

    public int GetManhattanDistance(Tiles[][] tilesArray) {

        int manhattanDistance = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                manhattanDistance += tilesArray[0][0].DistanceOfTwoTiles(
                        (tilesArray[i][j]).getCurrentPosition(),
                        (tilesArray[i][j]).getOptimalPosition());
            }
        }
        return manhattanDistance;
    }

    public int getF_score() {
        return f_score;
    }

    public void setF_score(int fScore) {
        f_score = fScore;
    }

    public int getG_score() {
        return g_score;
    }

    public void setG_score(int gScore) {
        g_score = gScore;
    }

    public int getH_score() {
        return h_score;
    }

    public void setH_score(int hScore) {
        h_score = hScore;
    }

    public State getParentState() {
        return parentState;
    }

    public void setParentState(State parentState) {
        this.parentState = parentState;
    }

    public Tiles[][] getTilesArray() {
        return tilesArray;
    }

    Tiles[][] CopyTilesArrays(Tiles[][] source, Tiles[][] destination) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < 3; j++) {
                destination[i][j] = source[i][j];
            }
        }
        return destination;
    }

    @Override
    public boolean equals(Object obj) {
        State state = (State) obj;
        return Arrays.deepEquals(state.tilesArray, tilesArray);
    }

    @Override
    public String toString() {
        String string = "";
        for (Tiles[] tiles : tilesArray) {
            for (Tiles tile : tiles) {
                string += tile.name + " ";
            }
            string += "\n";
        }
        return string;
    }
}