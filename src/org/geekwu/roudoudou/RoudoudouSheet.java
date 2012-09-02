package org.geekwu.roudoudou;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;

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

/**
 * @author Bastien Durel
 *
 */
public class RoudoudouSheet extends Composite {
	private Text textName;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RoudoudouSheet(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(5, false));
		
		Label lblNom = new Label(this, SWT.NONE);
		lblNom.setText("Nom");
		
		textName = new Text(this, SWT.BORDER);
		GridData gridData = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.horizontalSpan = 4;
		textName.setLayoutData(gridData);
		
		Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData2 = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData2.horizontalAlignment = SWT.FILL;
		gridData2.verticalAlignment = SWT.FILL;
		gridData2.horizontalSpan = 5;
		label.setLayoutData(gridData2);
		
		Label lblCaractristiques = new Label(this, SWT.NONE);
		lblCaractristiques.setFont(SWTResourceManager.getFont("Cantarell", 12, SWT.BOLD));
		lblCaractristiques.setText("Caractéristiques");
		GridData gridData3 = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData3.horizontalAlignment = SWT.FILL;
		gridData3.verticalAlignment = SWT.FILL;
		gridData3.horizontalSpan = 2;
		lblCaractristiques.setLayoutData(gridData3);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label lblbeaut = new Label(this, SWT.NONE);
		lblbeaut.setText("(Beauté)");
		new Label(this, SWT.NONE);
		
		Spinner spinner_12 = new Spinner(this, SWT.BORDER);
		
		Label lblTaille = new Label(this, SWT.NONE);
		lblTaille.setText("TAILLE");
		
		Spinner spinnerTaille = new Spinner(this, SWT.BORDER);
		
		Label lblVolont = new Label(this, SWT.NONE);
		lblVolont.setText("VOLONTÉ");
		new Label(this, SWT.NONE);
		
		Spinner spinnerVolonte = new Spinner(this, SWT.BORDER);
		
		Label lblApparence = new Label(this, SWT.NONE);
		lblApparence.setText("APPARENCE");
		
		Spinner spinner = new Spinner(this, SWT.BORDER);
		
		Label lblIntellect = new Label(this, SWT.NONE);
		lblIntellect.setText("INTELLECT");
		new Label(this, SWT.NONE);
		
		Spinner spinner_8 = new Spinner(this, SWT.BORDER);
		
		Label lblConstitution = new Label(this, SWT.NONE);
		lblConstitution.setText("CONSTITUTION");
		
		Spinner spinner_1 = new Spinner(this, SWT.BORDER);
		
		Label lblEmathie = new Label(this, SWT.NONE);
		lblEmathie.setText("EMATHIE");
		new Label(this, SWT.NONE);
		
		Spinner spinner_9 = new Spinner(this, SWT.BORDER);
		
		Label lblForce = new Label(this, SWT.NONE);
		lblForce.setText("FORCE");
		
		Spinner spinner_2 = new Spinner(this, SWT.BORDER);
		
		Label lblRve = new Label(this, SWT.NONE);
		lblRve.setText("RÊVE");
		new Label(this, SWT.NONE);
		
		Spinner spinner_10 = new Spinner(this, SWT.BORDER);
		
		Label lblAgilit = new Label(this, SWT.NONE);
		lblAgilit.setText("AGILITÉ");
		
		Spinner spinner_3 = new Spinner(this, SWT.BORDER);
		
		Label lblChance = new Label(this, SWT.NONE);
		lblChance.setText("CHANCE");
		new Label(this, SWT.NONE);
		
		Spinner spinner_11 = new Spinner(this, SWT.BORDER);
		
		Label lblDextrit = new Label(this, SWT.NONE);
		lblDextrit.setText("DEXTÉRITÉ");
		
		Spinner spinner_4 = new Spinner(this, SWT.BORDER);
		
		Label lblMle = new Label(this, SWT.NONE);
		lblMle.setText("Mêlée");
		new Label(this, SWT.NONE);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("0");
		
		Label lblVue = new Label(this, SWT.NONE);
		lblVue.setText("VUE");
		
		Spinner spinner_5 = new Spinner(this, SWT.BORDER);
		
		Label lblTir = new Label(this, SWT.NONE);
		lblTir.setText("Tir");
		new Label(this, SWT.NONE);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("0");
		
		Label lblOue = new Label(this, SWT.NONE);
		lblOue.setText("OUÏE");
		
		Spinner spinner_6 = new Spinner(this, SWT.BORDER);
		
		Label lblLancer = new Label(this, SWT.NONE);
		lblLancer.setText("Lancer");
		new Label(this, SWT.NONE);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText("0");
		
		Label lblOdoratgot = new Label(this, SWT.NONE);
		lblOdoratgot.setText("ODORAT-GOÛT");
		
		Spinner spinner_7 = new Spinner(this, SWT.BORDER);
		
		Label lblDrobe = new Label(this, SWT.NONE);
		lblDrobe.setText("Dérobée");
		new Label(this, SWT.NONE);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("0");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
