package virtual.pet.project;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPet bob = new VirtualPet();

		System.out.println("This is your new pet Bob! He has basic needs like food, activity, and rest.");
		System.out.println("Here is what you can do with Bob:");
		System.out.println(
				"To check on the needs of Bob, type \"needs?\" - this will give you a summary of Bob's current state.");
		System.out.println(" - type \"give food\" - this will decrease Bob's hunger by 20.");
		System.out.println(" - type \"play with\" - this will decrease Bob's boredom by 20.");
		System.out.println(" - type \"give rest\" - this will decrease Bob's boredom by 20.");
		System.out.println();
		System.out.println("Are you ready to care for Bob? Type \"yes\" to begin the game.");
		String begin = input.nextLine();

		if (begin.toLowerCase().equals("yes")) {
			System.out.println("Bob now depends on you for life.");
		} else {
			System.out.println("Goodbye.");
			System.exit(0);
		}

		do {
			bob.tick();
			System.out.println("What would you like to do with Bob?");
			String command = input.nextLine();
			switch (command.toLowerCase()) {
			case ("give food"):
				bob.giveFood();
				break;
			case ("play with"):
				bob.playWith();
				break;
			case ("give rest"):
				bob.giveRest();
				break;
			case ("needs?"):
				System.out.println("bored - " + bob.isBored());
				System.out.println("hungry - " + bob.isHungry());
				System.out.println("tired - " + bob.isTired());
				break;
			}
		} while (bob.running());
	}

}
