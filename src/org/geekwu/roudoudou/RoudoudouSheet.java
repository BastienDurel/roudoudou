package org.geekwu.roudoudou;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Spinner;

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

	protected Personnage edited = null;
	
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
		
		Spinner spinnerBea = new Spinner(this, SWT.BORDER);
		spinnerBea.setMaximum(18);
		spinnerBea.setMinimum(3);
		spinnerBea.setSelection(10);
		
		Label lblTaille = new Label(this, SWT.NONE);
		lblTaille.setText("TAILLE");
		
		Spinner spinnerTai = new Spinner(this, SWT.BORDER);
		spinnerTai.setMaximum(15);
		spinnerTai.setMinimum(6);
		
		Label lblVolont = new Label(this, SWT.NONE);
		lblVolont.setText("VOLONTÉ");
		new Label(this, SWT.NONE);
		
		Spinner spinnerVol = new Spinner(this, SWT.BORDER);
		spinnerVol.setMaximum(15);
		spinnerVol.setMinimum(6);
		
		Label lblApparence = new Label(this, SWT.NONE);
		lblApparence.setText("APPARENCE");
		
		Spinner spinnerApp = new Spinner(this, SWT.BORDER);
		spinnerApp.setMaximum(15);
		spinnerApp.setMinimum(6);
		
		Label lblIntellect = new Label(this, SWT.NONE);
		lblIntellect.setText("INTELLECT");
		new Label(this, SWT.NONE);
		
		Spinner spinnerInt = new Spinner(this, SWT.BORDER);
		spinnerInt.setMaximum(15);
		spinnerInt.setMinimum(6);
		
		Label lblConstitution = new Label(this, SWT.NONE);
		lblConstitution.setText("CONSTITUTION");
		
		Spinner spinnerCon = new Spinner(this, SWT.BORDER);
		spinnerCon.setMaximum(15);
		spinnerCon.setMinimum(6);
		
		Label lblEmathie = new Label(this, SWT.NONE);
		lblEmathie.setText("EMATHIE");
		new Label(this, SWT.NONE);
		
		Spinner spinnerEmp = new Spinner(this, SWT.BORDER);
		spinnerEmp.setMaximum(15);
		spinnerEmp.setMinimum(6);
		
		Label lblForce = new Label(this, SWT.NONE);
		lblForce.setText("FORCE");
		
		Spinner spinnerFor = new Spinner(this, SWT.BORDER);
		spinnerFor.setMaximum(15);
		spinnerFor.setMinimum(6);
		
		Label lblRve = new Label(this, SWT.NONE);
		lblRve.setText("RÊVE");
		new Label(this, SWT.NONE);
		
		Spinner spinnerRev = new Spinner(this, SWT.BORDER);
		spinnerRev.setMaximum(15);
		spinnerRev.setMinimum(6);
		
		Label lblAgilit = new Label(this, SWT.NONE);
		lblAgilit.setText("AGILITÉ");
		
		Spinner spinnerAgi = new Spinner(this, SWT.BORDER);
		spinnerAgi.setMaximum(15);
		spinnerAgi.setMinimum(6);
		
		Label lblChance = new Label(this, SWT.NONE);
		lblChance.setText("CHANCE");
		new Label(this, SWT.NONE);
		
		Spinner spinnerCha = new Spinner(this, SWT.BORDER);
		spinnerCha.setMaximum(15);
		spinnerCha.setMinimum(6);
		
		Label lblDextrit = new Label(this, SWT.NONE);
		lblDextrit.setText("DEXTÉRITÉ");
		
		Spinner spinnerDex = new Spinner(this, SWT.BORDER);
		spinnerDex.setMaximum(15);
		spinnerDex.setMinimum(6);
		
		Label lblMle = new Label(this, SWT.NONE);
		lblMle.setText("Mêlée");
		new Label(this, SWT.NONE);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("0");
		
		Label lblVue = new Label(this, SWT.NONE);
		lblVue.setText("VUE");
		
		Spinner spinnerVue = new Spinner(this, SWT.BORDER);
		spinnerVue.setMaximum(15);
		spinnerVue.setMinimum(6);
		
		Label lblTir = new Label(this, SWT.NONE);
		lblTir.setText("Tir");
		new Label(this, SWT.NONE);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("0");
		
		Label lblOue = new Label(this, SWT.NONE);
		lblOue.setText("OUÏE");
		
		Spinner spinnerOui = new Spinner(this, SWT.BORDER);
		spinnerOui.setMaximum(15);
		spinnerOui.setMinimum(6);
		
		Label lblLancer = new Label(this, SWT.NONE);
		lblLancer.setText("Lancer");
		new Label(this, SWT.NONE);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText("0");
		
		Label lblOdoratgot = new Label(this, SWT.NONE);
		lblOdoratgot.setText("ODORAT-GOÛT");
		
		Spinner spinnerOdo = new Spinner(this, SWT.BORDER);
		spinnerOdo.setMaximum(15);
		spinnerOdo.setMinimum(6);
		
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
