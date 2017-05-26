package virtual.pet.project;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPet bob = new VirtualPet();

		writeLine("This is your new pet Bob! He has basic needs like food, activity, and rest.");
		writeLine("+++++++++++++++++++++++++++++++");
		writeLine("+     /               \\     +");
		writeLine("+    /  ----      ---- \\    +");
		writeLine("+   /    __       __    \\   +");
		writeLine("++++     ||       ||     ++++");
		writeLine("  |           <>          |");
		writeLine("  |    \\_____________/    |");
		writeLine("  |     \\___________/     |");
		writeLine("  |                       |");
		writeLine("  +-----------------------+");
		writeLine(" ");
		writeLine("Here is what you can do with Bob:");
		writeLine(
				"To check on the needs of Bob, type \"needs?\" - this will give you a summary of Bob's current state.");
		writeLine(
				"These are the commands to take care of Bob \n -to execute the command simply type the number listed next to the command:");
		writeLine("1. Give food (decreases hunger)");
		writeLine("2. Entertain (decreases boredom");
		writeLine("3. Give rest (decreases fatigue)");
//		Think about changing menu to String menu ... that way you can call that? but that will only be in the scope of the main method...
		writeLine("Are you ready to care for Bob? Type \"yes\" to begin the game.");
		String begin = input.nextLine();

		if (begin.toLowerCase().equals("yes")) {
			writeLine("Bob now depends on you for life.");
			writeLine(
					"Type \"menu\" if you need to view possible commands again. \n -this advances time in the game because you need to remember directions.");
			writeLine("Type \"quit\" at any time to abandon Bob.");
			writeLine("Type \"stats\" at any time to check on Bob's current needs.");
		} else {
			writeLine("Goodbye.");
			System.exit(0);
		}

		do {
			writeLine("What would you like to do with Bob");

			String command = input.nextLine();
			checkForQuit(command);
			checkForMenu(command);

			if (command.toLowerCase().equals("stats")) {
				writeLine("Bob's current hunger is " + bob.hunger);
				writeLine("Bob's current fatigue is " + bob.tired);
				writeLine("Bob's current boredom is " + bob.boredom);
				writeLine(
						"Ranges:\n1-59 = acceptable level \n60-79 = needs attention \n80-99 = urgent need! \n100 = DEATH");
				continue; // this will pull current stats, skip the rest of the
							// loop (and the tick()) method and take you back to
							// the beginning of the game loop
			} else {
				// if stats are not checked, goes through rest of game loop
				switch (command.toLowerCase()) {
				case ("1"):
					bob.giveFood();
					break;
				case ("2"):
					bob.playWith();
					break;
				case ("3"):
					bob.giveRest();
					break;
				}

				if (bob.isVeryBored()) {
					writeLine("I NEED ATTENTION NOW HUMAN!!!");
				} else if (bob.isBored()) {
					writeLine("I am getting bored, human!!");
				}
				if (bob.isVeryHungry()) {
					writeLine("I NEED FOOD NOW HUMAN!!!");
				} else if (bob.isHungry()) {
					writeLine("I could use some food, human!");
				}
				if (bob.isVeryTired()) {
					writeLine("CRANKY AND NEED SLEEP, HUMAN!!!");
				} else if (bob.isTired()) {
					writeLine("I am getting tired, human!");
				}

				if (bob.isDead()) {
					writeLine("YOU HAVE FAILED HUMAN. I AM DEAD.");

					writeLine("+++++++++++++++++++++++++++++++");
					writeLine("+     /               \\     +");
					writeLine("+    /                 \\    +");
					writeLine("+   /                   \\   +");
					writeLine("++++     XX       XX     ++++");
					writeLine("  |           <>          |");
					writeLine("  |    _________________  |");
					writeLine("  |   /                 \\ |");
					writeLine("  +-----------------------+");
					System.exit(0);
				}
				bob.tick();
				writeLine("Time is moving forward, and Bob's needs are increasing!");
			}
			if (bob.hunger < 0) {
				bob.hunger = 0;
			}
			if (bob.boredom < 0) {
				bob.boredom = 0;
			}
			if (bob.tired < 0) {
				bob.tired = 0;
			}

		} while (bob.running());

	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	public static void checkForMenu(String input) {
		if (input.equalsIgnoreCase("menu")) {
			writeLine(
					"To check on the needs of Bob, type \"needs?\" - this will give you a summary of Bob's current state.");
			writeLine(
					"These are the commands to take care of Bob \n -to execute the command simply type the number listed next to the command:");
			writeLine("1. Give food (decreases hunger)");
			writeLine("2. Entertain (decreases boredom");
			writeLine("3. Give rest (decreases fatigue)");
			writeLine("Type \"quit\" at any time to abandon Bob.");
			writeLine("Type \"stats\" at any time to check on Bob's current needs.");

		}
	}

	public static void checkForQuit(String input) {
		if (input.equalsIgnoreCase("quit")) {
			writeLine("Bob will die without you, selfish human.");
			System.exit(0);
		}
	}
}
