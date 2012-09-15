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

import java.util.List;
import java.util.Vector;

/**
 * @author Bastien Durel
 * 
 */
public class Sort {
	public static final int VARIABLE = Integer.MAX_VALUE;

	String nom;

	public String getNom() {
		return nom;
	}

	public List<Competence> getVoie() {
		return voie;
	}

	public String getTMR() {
		return TMR;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public int getCout() {
		return cout;
	}

	List<Competence> voie;

	String TMR;

	int difficulte;

	int cout;

	/**
	 * @return XP to buy
	 */
	public int getXP() {
		if (difficulte == VARIABLE)
			return 70;
		return difficulte * 10;
	}

	private static List<Sort> _list = null;

	static public List<Sort> loadList() {
		if (_list == null) {
			_list = new Vector<Sort>();
			// TODO: get spell list
			Sort test = new Sort();
			test.cout = 7;
			test.difficulte = 2;
			test.nom = "Test";
			test.TMR = "Partout";
			_list.add(test);
		}
		return _list;
	}
}
