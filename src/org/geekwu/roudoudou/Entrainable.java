package org.geekwu.roudoudou;

import java.io.Serializable;

public abstract class Entrainable implements Serializable {
	private static final long serialVersionUID = 3380768181163591230L;
	int value;
	int xp;

	Entrainable(int value) {
		this.value = value;
		this.xp = 0;
	}
	/**
	 * Sets default info to this object
	 * @param value value for this object
	 * @param xp xp for this object
	 * @return this object
	 */
	Entrainable set(int value, int xp) {
		this.value = value;
		this.xp = xp;
		return this;
	}

	/**
	 * Add XP to object
	 */
	public void addXP(int xp) {
		this.xp += xp;
		while (this.xp >= getNextStep()) {
			this.xp -= getNextStep();
			this.value++;
		}
	}

	public int getValue() {
		return value;
	}

	public int getXP() {
		return xp;
	}

	/**
	 * Computes XP needed for next value increment, regardless of current level
	 * 
	 * @return needed XP
	 */
	public abstract int getNextStep();
	
	public boolean acceptXp() {
		return true;
	}

}
