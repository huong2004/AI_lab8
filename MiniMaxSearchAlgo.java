package lab8;

public class MiniMaxSearchAlgo implements ISearchAlgo {
	// function MINIMAX-DECISION(state) returns an action
		// inputs: state, current state in game
		// v <- MAX-VALUE(state)
		// return the action in SUCCESSORS(state) with value v
		@Override
		public void execute(Node node) {
			// Enter your code here
			int value = maxValue(node);
			System.out.println("Gia tri nut A: " + value);
			for (Node child : node.getChildren()) {
				int childValue = minValue(child);
				System.out.println("Gia tri nut: " + child.getLabel() + " " + childValue);
			}
		}

		// function MAX-VALUE(state) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- Integer.MIN_VALUE
		// for each s in SUCCESSORS(state) do
		// v <- MAX(v, MIN-VALUE(s))
		// return v
		public int maxValue(Node node) {
			// Enter your code here
			int v = Integer.MIN_VALUE;
			if (node.isTerminal())
				return node.getValue();
			else {

				for (Node n : node.getChildren()) {
					v = Math.max(v, minValue(n));
				}
			}
			return v;
		}

		// function MIN-VALUE(state) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- Integer.MAX_VALUE
		// for each s in SUCCESSORS(state) do
		// v <- MIN(v, MAX-VALUE(s))
		// return v

		public int minValue(Node node) {
			// Enter your code here
			int v = Integer.MAX_VALUE;
			if (node.isTerminal())
				return node.getValue();
			else {
				for (Node n : node.getChildren()) {
					v = Math.min(v, maxValue(n));
				}
			}
			return v;
		}

}
