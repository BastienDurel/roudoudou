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
package org.geekwu.roudoudou.ui;

import org.geekwu.roudoudou.Personnage;

/**
 * @author Bastien Durel
 *
 */
public class PersoEvent extends RoudoudouEvent {
	Personnage perso;

	public PersoEvent(Personnage perso) {
		this.perso = perso;
	}

	public Personnage getPerso() {
		return perso;
	}

}
