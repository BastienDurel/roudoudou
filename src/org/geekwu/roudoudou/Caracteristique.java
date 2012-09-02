package org.geekwu.roudoudou;

public class Caracteristique extends Entrainable {
	private static final long serialVersionUID = 6955242416250672392L;

	boolean finale = false;

	Caracteristique(int value) {
		super(value);
	}

	@Override
	public int getNextStep() {
		if (value < 8) return 6;
		if (value < 10) return 7;
		if (value < 12) return 8;
		if (value < 14) return 9;
		if (value == 14) return 10;
		return 10 + ((value - 14) * 10);
	}

	public void addXP(int xp) {
		if (!finale)
			super.addXP(xp);
	}

	@Override
	Caracteristique set(int value, int xp) {
		super.set(value, xp);
		return this;
	}

	void lock() {
		this.finale = true;
	}

}
