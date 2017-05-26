package virtual.pet.project;

public class VirtualPet {

	int hunger = 70;
	int boredom = 70;
	int tired = 70;

	void tick() {
		hunger = hunger + 5;
		boredom = boredom + 5;
		tired = tired + 5;
	}

	void giveFood() {
		hunger = hunger - 20;
	}

	boolean isHungry() {
		return hunger >= 60;
	}

	void playWith() {
		boredom = boredom - 20;
	}

	boolean isBored() {
		return boredom >= 60;
	}

	void giveRest() {
		tired = tired - 20;
	}

	boolean isTired() {
		return tired >= 60;
	}

	boolean running() {
		return true;
	}

	// void feed(int amount) { }
}
