/*
  	Copyright © 2012 Bastien Durel

    This file is part of roudoudou.

    myDobble is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    myDobble is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with myDobble.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.geekwu.roudoudou;

/**
 * @author Bastien Durel
 * 
 */
public class CompetenceDraconic extends Competence {
	private static final long serialVersionUID = -6301110191864466130L;

	/**
	 * Destroys XP when level is gained
	 */
	boolean destroyer = false;

	public boolean isDestroyer() {
		return destroyer;
	}

	CompetenceDraconic(int value, String name, boolean destroyer) {
		super(value, name);
		this.destroyer = destroyer;
	}

	@Override
	public int getTotalXp() {
		if (destroyer)
			return super.getTotalXp() * 2;
		return super.getTotalXp();
	}

	public void looseXP(int xp) throws Exception {
		if (getTotalXp() < xp)
			throw new Exception("Impossible de réduire l'XP: niveau pas assez élevé");
		int _xp = this.xp;
		int _value = this.value;
		this.xp -= xp;
		while (this.xp < 0) {
			value--;
			this.xp += getNextStep();
			if (value < -11) {
				// double-check
				this.xp = _xp;
				this.value = _value;
				throw new Exception("Impossible de réduire l'XP: niveau pas assez élevé");
			}
		}
	}

}
