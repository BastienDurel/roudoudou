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

import org.eclipse.swt.widgets.Composite;
import org.geekwu.roudoudou.Entrainable;
import org.geekwu.roudoudou.MainUI;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * @author Bastien Durel
 * 
 */
public class EntrainableDisplay extends Composite {

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public EntrainableDisplay(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		lblVal = new Label(this, SWT.NONE);
		lblVal.setText("VAL");

		lblXp = new Label(this, SWT.NONE);
		lblXp.setText("XP");

		btnAdd = new Button(this, SWT.NONE);
		btnAdd.setFont(SWTResourceManager.getFont("Cantarell", 9, SWT.NORMAL));
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				value.addXP(1);
				updateValue();
				MainUI.fireRoudoudouEvent(new PersoEdited());
				if (value.getXP() == 0)
					MainUI.fireRoudoudouEvent(new PersoChanged());
			}
		});
		btnAdd.setText("Add");
		
	}

	protected Entrainable value;

	private Label lblVal;

	private Label lblXp;

	private Button btnAdd;

	public Entrainable getValue() {
		return value;
	}

	public void setValue(Entrainable value) {
		this.value = value;
		if (!value.acceptXp()) {
			lblXp.setVisible(false);
			btnAdd.setVisible(false);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void updateValue() {
		if (value == null)
			return;
		lblVal.setText(Integer.toString(value.getValue()));
		lblXp.setText(Integer.toString(value.getXP()));
	}

}
