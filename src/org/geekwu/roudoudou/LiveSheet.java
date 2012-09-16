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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

/**
 * @author Bastien Durel
 * 
 */
public class LiveSheet extends Composite implements RoudoudouSheet {

	private Personnage edited;
	private Label labelNom;
	private Label labelBt;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public LiveSheet(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(4, false));
		
		Label lblNom = new Label(this, SWT.NONE);
		lblNom.setText("Nom");
		
		labelNom = new Label(this, SWT.NONE);
		labelNom.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		labelNom.setText("--");
		
		Label lblBeaut = new Label(this, SWT.NONE);
		lblBeaut.setText("Beauté");
		
		labelBt = new Label(this, SWT.NONE);
		labelBt.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		labelBt.setText("--");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geekwu.roudoudou.RoudoudouSheet#updatePerso()
	 */
	@Override
	public void updatePerso() {
		// TODO Auto-generated method stub
		labelNom.setText(getEdited().name);
		labelBt.setText(Integer.toString(getEdited().beaute));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geekwu.roudoudou.RoudoudouSheet#getEdited()
	 */
	@Override
	public Personnage getEdited() {
		return edited;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.geekwu.roudoudou.RoudoudouSheet#setEdited(org.geekwu.roudoudou.Personnage
	 * )
	 */
	@Override
	public void setEdited(Personnage edited) {
		this.edited = edited;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geekwu.roudoudou.RoudoudouSheet#getComposite()
	 */
	@Override
	public Composite getComposite() {
		return this;
	}

}
