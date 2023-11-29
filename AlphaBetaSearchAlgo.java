package lab8;

import java.util.ArrayList;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo{

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("Gia tri cua A: " + v);
		for (Node s : node.getChildren())
			System.out.println("Gia tri cua " + s + " " + minValue(s, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v = Integer.MIN_VALUE;
		if (node.isTerminal())
			return node.getValue();
		else {
			List<Node> sorted = new ArrayList<>(node.getChildren());
			sorted.sort(Node.LabelComparator);
			for (Node s : sorted) {
				v = Math.max(v, minValue(s, alpha, beta));
				alpha = Math.max(alpha, v);
				if (v >= beta) {
					System.out.println("Nút cắt: " + s.getLabel());
					return v;
				}
				
			}

		}

		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v = Integer.MAX_VALUE;
		if (node.isTerminal())
			return node.getValue();
		else {
			List<Node> sorted = new ArrayList<>(node.getChildren());
			sorted.sort(Node.LabelComparator);
			for (Node s : sorted) {
				v = Math.min(v, maxValue(s, alpha, beta));
				beta = Math.min(beta, v);
				if (v <= beta) {
					System.out.println("Nút cắt: " + s.getLabel());
					return v;
				}
			
			}
 
		}
		return v;
	}

	
}
