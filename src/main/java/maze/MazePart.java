package maze;

public enum MazePart {
	WALL('X'), SPACE(' '), START('S'), EXIT('F');

	private final char symbol;

	MazePart(final char symbol) {
		this.symbol = symbol;
	}

	char getSymbol() {
		return symbol;
	}
}