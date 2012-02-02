package main;

import java.util.Scanner;

import search.AStarSearch;
import search.CalculateManhattanDistance;

import buildNodes.BuildBoard;
import buildNodes.State;

public class Main {

	public static void main(String[] args) {
		
		
		BuildBoard buildBoard = new BuildBoard();
		State startState = new State(buildBoard.getTilesArray(),null, 0);
		
		AStarSearch aStarSearch = new AStarSearch(startState);
		
		
	}
}
