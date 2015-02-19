package encapsulation;

public class Nim {

	private int pile0;
	private int pile1;
	private int pile2;

	public Nim() {
		pile0 = 10;
		pile1 = 10;
		pile2 = 10;
	}

	public Nim(int pileSize) {
		pile0 = pileSize;
		pile1 = pileSize;
		pile2 = pileSize;
	}

	public void removePieces(int number, int targetPile) {
		if (isGameOver() == true) {
			throw new IllegalStateException();
		}

		else if (isValidMove(number, targetPile) && !isGameOver()) {
			if (targetPile == 0) {
				pile0 -= number;
			} else if (targetPile == 1) {
				pile1 -= number;
			} else if (targetPile == 2) {
				pile2 -= number;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public boolean isValidMove(int number, int targetPile) {
		if (number >= 1 && targetPile >= 0 && targetPile <= 2) {
			if (targetPile == 0 && pile0 - number >= 0) {
				return true;
			} else if (targetPile == 1 && pile1 - number >= 0) {
				return true;
			} else if (targetPile == 2 && pile2 - number >= 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isGameOver() {
		if (pile0 == 0 || pile1 == 0 || pile2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getPile(int targetPile) {
		if (targetPile == 0) {
			return pile0;
		} else if (targetPile == 1) {
			return pile1;
		} else if (targetPile == 2) {
			return pile2;
		} else {
			throw new IllegalArgumentException("Velg en gyldig pile");
		}
	}

	public String toString() {
		return ("pile 0: " + pile0 + " - pile 1: " + pile1 + " - pile 2: " + pile2);
	}

}
