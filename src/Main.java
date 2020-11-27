
public class Main {
	
	/*
	 * Runs synchronous cellular automaton on 45 different fire spread probabilities
	 * (corresponding to grass densities) and prints the result in a format that is
	 * readily copy-pasted into a spreadsheet for further numerical analysis.
	 */
	public static void main(String[] args) {
		int size = 650;
		for (int i = 0; i < 45; i++) {
			double numTrials = 3;
			double average = 0;
			for (int j = 0; j < numTrials; j++) {
				FireSimulator simulator = new FireSimulator(size, size, i * 0.0016, 6.35, 125, 152);
				simulator.simulate();
				double burntArea = simulator.getNumBurntSquares();
				double area = size * size;
				average += burntArea / area;
			}
			System.out.println(average / numTrials);
		}
	}

}
