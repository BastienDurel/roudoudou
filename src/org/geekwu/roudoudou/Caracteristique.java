package org.geekwu.roudoudou;

public class Caracteristique extends Entrainable {
	private static final long serialVersionUID = 6955242416250672392L;
	boolean finale = false;

	Caracteristique(int value) {
		super(value);
	}

	@Override
	public int getNextStep() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void addXP(int xp) {
		if (!finale)
			super.addXP(xp);
	}
	
	Caracteristique set(int value, int xp) {
		this.value = value;
		this.xp = xp;
		return this;
	}
	
	void lock() {
		this.finale = true;
	}

}
