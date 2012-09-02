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

import java.io.File;
import java.io.IOException;

/**
 * @author Bastien Durel
 *
 */
public class Test {
	
	/**
	 * 
	 */
	private static final String TEST_FILENAME = "/tmp/usul.rdd";
	
	static Personnage getDefault() {
		Personnage p = new Personnage("Usul");
		p.taille.set(11, 0).lock();
		p.apparence.set(9, 0);
		p.constitution.set(14, 2);
		p.force.set(13, 0);
		p.agilite.set(14, 1);
		p.dexterite.set(15, 5);
		p.vue.set(15, 1);
		p.ouie.set(11, 0);
		p.odorat_gout.set(9, 0);
		p.volonte.set(12, 5);
		p.intellect.set(8, 0);
		p.empathie.set(10, 5);
		p.reve.set(13, 5);
		p.chance.set(11, 0);
		
		p.competences.add(Competence.Factory.tir("Tir à l'arc").set(7, 13));
		return p;
	}

	static Personnage load() {
		try {
			return Personnage.fromFile(new File(TEST_FILENAME));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
			Personnage p = getDefault();
			try {
				p.save(new File(TEST_FILENAME));
			} catch (IOException e1) {
				e1.printStackTrace();
				return null;
			}
			return p;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Personnage p = load();
		
		System.out.println(p);
	}

}
