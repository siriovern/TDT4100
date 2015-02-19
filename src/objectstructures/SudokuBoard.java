package objectstructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuBoard {

	// Her initialiserer jeg listen "board"
	private List<List<SudokuCell>> board;

	// Her lages spillebrettet ved hjelp av en todimensjonal arraylist
	public void setBoard(String numbers) {
		board = new ArrayList<List<SudokuCell>>();
		int count = 0;
		for (int y = 0; y < 9; y++) {
			// y viser til radene i brettet. Her legges radene (éndimensjonal
			// arraylist) inn i board (todimensjonal arraylist):
			List<SudokuCell> row = new ArrayList<SudokuCell>();
			board.add(row);
			for (int x = 0; x < 9; x++) {
				// henter ut ett og ett tall eller punktum fra strengen:
				char value = numbers.charAt(count++);
				// her lages cellen, og "isPredefined" settes til true, slik at
				// det ikke skal gå an å endre på disse tallene
				SudokuCell cell = new SudokuCell(x, y, value, true);
				// Her finnes den aktuelle raden i brettet (get(y)), og cellen
				// som ble laget ovenfor legges inn
				board.get(y).add(cell);
			}
		}
	}

	// Denne metoden printer ut spillebrettet
	public void printBoard() {
		String boardString = "";
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				// her hentes én og én celle ut fra brettet
				SudokuCell sudokuCell = board.get(y).get(x);
				// her legges cellen inn i strengen "boardstring". toString
				// hjelper til med å formatere tallet riktig
				boardString += sudokuCell.toString();
			}
			// legger til linjeskift i slutten av hver rad
			boardString += "\n";
		}
		System.out.println(boardString);
	}

	// denne metoden sjekker om det er flere like tall i en rad eller en
	// kolonne. Dette sjekkes ved å opprette et HashSet. Hvis lengden av hashSet
	// er lik som listen "value" er det ingen duplikater, men om de er ulike
	// betyr det at det finnes minst to like tall
	private boolean hasDuplicates(List<Character> value) {

		Set<Character> uniqueNumbers = new HashSet<Character>();
		for (Character number : value) {
			if (Character.isDigit(number))
				uniqueNumbers.add(number);
		}
		// returnerer true hvis størrelsen ikke er lik
		return uniqueNumbers.size() != value.size();
	}

	// denne metoden oppdaterer spillebrettet og setter variabelen
	// "isConflictedCell" til "true" hvis
	public void updateBoard() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				SudokuCell cell = board.get(y).get(x);
				boolean isConflictedCell = !isValid(cell);
				// setter "setConflict" lik true hvis cellen er i konflikt, og
				// false ellers
				cell.setConflict(isConflictedCell);
			}
		}
	}

	// printer true hvis både raden, kolonnen og 3x3-kvadrant er gyldig for
	// cellen
	private boolean isValid(SudokuCell chosenCell) {
		return isValidRow(chosenCell) && isValidColoumn(chosenCell) && isValidQuadrant(chosenCell);

	}

	private List<SudokuCell> getQuadrant(int x, int y) {
		List<SudokuCell> quadrant = new ArrayList<SudokuCell>();
		int modx = x % 3; // gir 0, 1 el 2
		int mody = y % 3; // gir 0, 1 el 2

		List<Integer> xList = new ArrayList<Integer>();
		xList.add(x);

		// legger til kolonneverdiene som brukerinput skal sammenlignes med
		if (modx == 0) {
			xList.add(x - 1);
			xList.add(x - 2);
		} else if (modx == 2) {
			xList.add(x - 1);
			xList.add(x + 1);
		} else if (modx == 1) {
			xList.add(x + 1);
			xList.add(x + 2);
		}
		List<Integer> yList = new ArrayList<Integer>();
		yList.add(y);

		// legger til radverdiene som brukerinput skal sammenlignes med
		if (mody == 0) {
			yList.add(y - 1);
			yList.add(y - 2);
		} else if (mody == 2) {
			yList.add(y - 1);
			yList.add(y + 1);
		} else if (mody == 1) {
			yList.add(y + 1);
			yList.add(y + 2);
		}

		for (int y1 : yList) {
			for (int x1 : xList) {
				quadrant.add(board.get(y1).get(x1));
			}
		}
		return quadrant;

	}

	// sjekker om tallet er unikt innen sin 3x3-kvadrant
	private boolean isValidQuadrant(SudokuCell chosenCell) {
		int x = chosenCell.getX();
		int y = chosenCell.getY();
		List<Character> quadrant = new ArrayList<Character>();
		for (SudokuCell cell : getQuadrant(x, y)) {
			quadrant.add(cell.getValue());
		}
		return !hasDuplicates(quadrant);
	}

	private List<SudokuCell> getColoumn(int x) {
		List<SudokuCell> coloumn = new ArrayList<SudokuCell>();
		for (int y = 0; y < 9; y++) {
			coloumn.add(board.get(y).get(x));
		}
		return coloumn;
	}

	// sjekker om tallet er unikt innen sin kolonne
	private boolean isValidColoumn(SudokuCell chosenCell) {
		int x = chosenCell.getX();
		List<Character> coloumn = new ArrayList<Character>();
		for (SudokuCell cell : getColoumn(x)) {
			coloumn.add(cell.getValue());
		}
		return !hasDuplicates(coloumn);

	}

	private List<SudokuCell> getRow(int y) {
		return board.get(y);
	}

	// sjekker om tallet er unikt innen sin rad
	private boolean isValidRow(SudokuCell chosenCell) {
		int y = chosenCell.getY();
		List<Character> row = new ArrayList<Character>();
		for (SudokuCell cell : getRow(y)) {
			row.add(cell.getValue());
		}
		return !hasDuplicates(row);
	}

	public void setCell(SudokuCell chosenCell) {
		int y = chosenCell.getY();
		int x = chosenCell.getX();

		// sjekker verdien i cellen spilleren har valgt. Hvis cellen er tom
		// eller den inneholder et tall som spilleren selv har satt inn blir den
		// nye verdien spilleren ønsker at skal settes inn satt inn i cellen
		SudokuCell oldCell = board.get(y).get(x);
		if (oldCell.isCellEmpty()
				|| (!oldCell.isCellEmpty() && !oldCell.isPredefined()))
			board.get(y).set(x, chosenCell);
	}
}
