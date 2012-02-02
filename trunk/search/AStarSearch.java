package search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import buildNodes.*;
import stateCollections.*;

public class AStarSearch {

	State startState;
	State goalState;
	int f_score;

	public AStarSearch(State startState) {
		
		this.startState = startState;

		State current_state = null;

		OpenNodes openNodes = new OpenNodes();
		ClosedNodes closedNodes = new ClosedNodes();

		openNodes.openNodesList.add(startState);

		while (!openNodes.openNodesList.isEmpty()) {
			

			current_state = getStateWithLowestFScore(current_state, openNodes);

			if (current_state.GetManhattanDistance(current_state.tilesArray) == 0) {
				int count = 0;
				
				List<State> path = reconstructPath(current_state);

				for (State state : path) {
					System.out.println(count++);
					System.out.println(state);
				}
				
				System.out.println("yes!");
				break;
			}

			List<State> tempListOfSuccessors = current_state.GetSuccessors();

			openNodes.openNodesList.remove(current_state);
			closedNodes.closedNodesList.add(current_state);

			for (int i = 0; i < tempListOfSuccessors.size(); i++) {

				State tempSuccessor = tempListOfSuccessors.get(i);

				for (int j = 0; j < closedNodes.closedNodesList.size(); j++) {
					State tempState = (State) closedNodes.closedNodesList
							.get(j);
					if (Arrays.deepEquals(tempState.getTilesArray(),
							tempSuccessor.getTilesArray())) {
						continue;
					}
				}

				int tentative_g_score = tempSuccessor.getParentState()
						.getG_score() + 1;

				boolean tentative_is_better = true;

				int index = 0;
				boolean contains = false;
				for (int j = 0; j < openNodes.openNodesList.size(); j++) {
					State tempState = (State) openNodes.openNodesList.get(j);
					if (Arrays.deepEquals(tempState.getTilesArray(),
							tempSuccessor.getTilesArray())) {

						contains = true;
						index = j;
					}

				}

				if (contains == false) {
					openNodes.openNodesList.add(tempSuccessor);
					tempSuccessor.setH_score(tempSuccessor
							.GetManhattanDistance(tempSuccessor.tilesArray));
					tentative_is_better = true;
				}

				else if (openNodes.openNodesList.get(index).getG_score() > tempSuccessor
						.getG_score())
					tentative_is_better = true;

				else
					tentative_is_better = false;

				if (tentative_is_better) {
					tempSuccessor.setParentState(current_state);
					tempSuccessor.setG_score(tentative_g_score);
					tempSuccessor.setF_score(tempSuccessor.getG_score()
							+ tempSuccessor.getH_score());
				}

			}
		}

	}

	private State getStateWithLowestFScore(State current_state,
			OpenNodes openNodes) {
		int lowestFScore = Integer.MAX_VALUE;
		// Lowest F
		for (int i = 0; i < openNodes.openNodesList.size(); i++) {
			int calculatedFScore = CalculateFScore(openNodes.openNodesList
					.get(i));
			if (lowestFScore >= calculatedFScore) {
				lowestFScore = calculatedFScore;
				current_state = (State) openNodes.openNodesList.get(i);
			}
		}
		return current_state;
	}

	private int CalculateFScore(Object object) {
		
		State state = (State) object;

		return state.CalculateFScore();
	}

	List<State> reconstructPath(State goal){
		List<State> path = new LinkedList<State>();
		State current = goal;
		while(current.getParentState() != null){
			path.add(0, current);
			current = current.getParentState();
		}
		path.add(0,current);
		return path;
	}
}
