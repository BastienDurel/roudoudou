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

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Bastien Durel
 * 
 */
public class CompetenceTronc extends Competence {

	private static final long serialVersionUID = -59642103285867130L;

	protected java.util.List<CompetenceTronc> linkedCompetences;

	/**
	 * @param value
	 * @param name
	 */
	CompetenceTronc(int value, String name, java.util.List<CompetenceTronc> link) {
		super(value, name);
		linkedCompetences = new Vector<CompetenceTronc>();
		if (link != null) {
			Iterator<CompetenceTronc> i = link.iterator();
			while (i.hasNext()) {
				addLink(i.next());
			}
		}
	}

	void addLink(CompetenceTronc link) {
		if (link == this)
			return;
		linkedCompetences.add(link);
		if (!link.linkedCompetences.contains(this))
			link.linkedCompetences.add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geekwu.roudoudou.Competence#setValue(int)
	 */
	@Override
	void setValue(int value) {
		// TODO
		super.setValue(value);
		System.out.println("setValue to " + value);
		Iterator<CompetenceTronc> i = linkedCompetences.iterator();
		while (i.hasNext()) {
			CompetenceTronc l = i.next();
			if (l.value < 0 && l.value < value) {
				l.value = value;
				l.startingLevel = value;
				System.out.println("raise linked value and starting level");
			}
			if (l.value > value) {
				if (l.startingLevel > value) {
					System.out.println("lower starting level to " + value);
					l.startingLevel = value;
				}
				l.value = value;
				System.out.println("lower linked value to " + value);
			}
		}
	}

}
