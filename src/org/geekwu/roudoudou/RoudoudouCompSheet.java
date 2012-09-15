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

import org.eclipse.swt.widgets.Composite;

/**
 * @author Bastien Durel
 *
 */
public class RoudoudouCompSheet extends Composite implements RoudoudouSheet {

	protected Personnage edited = null;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RoudoudouCompSheet(Composite parent, int style) {
		super(parent, style);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/* (non-Javadoc)
	 * @see org.geekwu.roudoudou.RoudoudouSheet#getEdited()
	 */
	@Override
	public Personnage getEdited() {
		return edited;
	}

	/* (non-Javadoc)
	 * @see org.geekwu.roudoudou.RoudoudouSheet#setEdited(org.geekwu.roudoudou.Personnage)
	 */
	@Override
	public void setEdited(Personnage edited) {
		this.edited = edited;
	}

	/* (non-Javadoc)
	 * @see org.geekwu.roudoudou.RoudoudouSheet#updatePerso()
	 */
	@Override
	public void updatePerso() {
		// TODO Auto-generated method stub
		
	}
	
	public Composite getComposite() {
		return this;
	}

}
