package encapsulation;

import java.util.Scanner;

public class NimProgram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		boolean nimPlay = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hvor mange brikker vil du starte med? ");
		int userIn = scanner.nextInt();
		Nim nim = new Nim(userIn);
		
		System.out.println("Hva vil du gjøre? ");

		while (nimPlay) {

			if (nim.isGameOver() == true) {
				System.out.println("Spillet er over");
				nimPlay = false;
				break;
			}

			System.out.println("Skriv - se - for å se pile");
			System.out
					.println("Skriv - fjern - for å fjerne brikker, eller - avslutt - for å avslutte spillet: ");

			String userInput = scanner.nextLine();

			
			if (userInput.equals("se")) {
				System.out.println(nim.toString());
			} else if (userInput.equals("fjern")) {

				System.out
						.println("Hvor mange brikker vil du fjerne. Du må velge minst én: ");
				int userInput2 = scanner.nextInt();
				System.out
						.println("Du kan fjerne brikker fra pile 0, 1 eller 2. Hvilken pile velge du? ");
				int userInput3 = scanner.nextInt();
				if (nim.isValidMove(userInput2, userInput3) == true) {
					if (userInput3 == 0) {
						System.out.println("Fjerner " + userInput2
								+ " brikker fra pile nr. " + userInput3);
						nim.removePieces(userInput2, userInput3);

					} else if (userInput3 == 1) {
						System.out.println("Fjerner " + userInput2
								+ " brikker fra pile nr. " + userInput3);
						nim.removePieces(userInput2, userInput3);
					} else if (userInput3 == 2) {
						System.out.println("Fjerner " + userInput2
								+ " brikker fra pile nr. " + userInput3);
						nim.removePieces(userInput2, userInput3);
					}
				}
			} else if (userInput.equals("avslutt")) {
				System.out.println("Spillet er avsluttet");
				nimPlay = false;
				break;
			}
		}

	}
}
