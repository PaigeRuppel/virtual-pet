package virtual.pet.project;

public class VirtualPet {

	boolean running() {
		return true;
	}

	int hunger = 50;
	int boredom = 50;
	int tired = 50;

	void tick() {
		hunger = hunger + 5;
		boredom = boredom + 5;
		tired = tired + 5;
	}

	boolean isHungry() {
		return hunger >= 60;
	}

	boolean isVeryHungry() {
		return hunger >= 80;
	}

	boolean isBored() {
		return boredom >= 60;
	}

	boolean isVeryBored() {
		return boredom >= 80;
	}

	boolean isTired() {
		return tired >= 60;
	}

	boolean isVeryTired() {
		return tired >= 80;
	}

	void giveFood() {
		hunger = hunger - 20;
	}

	void playWith() {
		boredom = boredom - 20;
	}

	void giveRest() {
		tired = tired - 20;
	}

}
