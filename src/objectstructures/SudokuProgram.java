package objectstructures;

import java.util.Scanner;

public class SudokuProgram {

	public static void main(String[] args) {

		boolean isPredefined = false;

		// lager brettoppsett
		SudokuBoard board = new SudokuBoard();
		board.setBoard(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
		board.printBoard();

		boolean game = true;

		while (game) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
		
			System.out.println("Hvilken rad vil du bruke (0-8) ? ");
			int y = scanner.nextInt();

			System.out.println("Hvilken kolonne vil du bruke (0-8) ? ");
			int x = scanner.nextInt();

			System.out
					.println("Hvilket tall vil du sette inn (1-9 eller .) ? ");
			char value = scanner.next().charAt(0);
			SudokuCell chosenCell = new SudokuCell(x, y, value, isPredefined);

			board.setCell(chosenCell);
			board.printBoard();
			board.updateBoard();

			System.out.println("Vil du fortsette (ja/nei) ? ");
			String continueAnswer = scanner.next();

			if (continueAnswer.equals("nei")) {
				break;
			}
		}
		System.out.println("Takk for spillet");
	}

}