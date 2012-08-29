package org.geekwu.roudoudou;

public class Caracteristique extends Entrainable {
	
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

}
