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
		int oldValue = this.value;
		super.setValue(value);
		System.out.println("setValue to " + value);
		if (value > 0 || (oldValue > 0 && value == 0))
			return; // Nothing to do
		startingLevel = -6;
		
		if (oldValue > value) {
			// Decrease
			for (Competence comp : linkedCompetences) {
				if (comp.getTotalXp() == 0) {
					comp.value = comp.startingLevel = value;
				}
			}
		}
		else {
			// Increase
			int osl = Math.min(0, getMaxCompetence());
			for (Competence comp : linkedCompetences) {
				if (comp.startingLevel < osl) 
					comp.startingLevel = osl;
				if (comp.value < comp.startingLevel)
					comp.value = comp.startingLevel;
			}
		}
	}
	
	private int getMaxCompetence() {
		int max = value;
		for (Competence comp : linkedCompetences) {
			if (comp.value > max)
				max = comp.value;
		}
		return max;
	}

}
