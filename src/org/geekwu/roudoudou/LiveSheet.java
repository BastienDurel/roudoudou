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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.geekwu.roudoudou.ui.EntrainableDisplay;

/**
 * @author Bastien Durel
 * 
 */
public class LiveSheet extends Composite implements RoudoudouSheet {

	private Personnage edited;

	private Label labelNom;

	private Label labelBt;

	private Label lblMel;

	private Label lblLan;

	private Label lblDer;

	private Label lblTir;

	private EntrainableDisplay entrainableDisplayTai;

	private EntrainableDisplay entrainableDisplayApp;

	private EntrainableDisplay entrainableDisplayCon;

	private EntrainableDisplay entrainableDisplayFor;

	private EntrainableDisplay entrainableDisplayAgi;

	private EntrainableDisplay entrainableDisplayDex;

	private EntrainableDisplay entrainableDisplayVue;

	private EntrainableDisplay entrainableDisplayOui;

	private EntrainableDisplay entrainableDisplayOdo;

	private EntrainableDisplay entrainableDisplayVol;

	private EntrainableDisplay entrainableDisplayInt;

	private EntrainableDisplay entrainableDisplayEmp;

	private EntrainableDisplay entrainableDisplayRev;

	private EntrainableDisplay entrainableDisplayCha;

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

		Label lblCaractristiques = new Label(this, SWT.NONE);
		lblCaractristiques.setFont(SWTResourceManager.getFont("Cantarell", 11, SWT.BOLD | SWT.ITALIC));
		lblCaractristiques.setText("Caractéristiques");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblTaille = new Label(this, SWT.NONE);
		lblTaille.setText("TAILLE");

		entrainableDisplayTai = new EntrainableDisplay(this, SWT.NONE);

		Label lblVolont = new Label(this, SWT.NONE);
		lblVolont.setText("VOLONTÉ");

		entrainableDisplayVol = new EntrainableDisplay(this, SWT.NONE);

		Label lblApparence = new Label(this, SWT.NONE);
		lblApparence.setText("APPARENCE");

		entrainableDisplayApp = new EntrainableDisplay(this, SWT.NONE);

		Label lblIntellect = new Label(this, SWT.NONE);
		lblIntellect.setText("INTELLECT");

		entrainableDisplayInt = new EntrainableDisplay(this, SWT.NONE);

		Label lblConstitution = new Label(this, SWT.NONE);
		lblConstitution.setText("CONSTITUTION");

		entrainableDisplayCon = new EntrainableDisplay(this, SWT.NONE);

		Label lblEmpathie = new Label(this, SWT.NONE);
		lblEmpathie.setText("EMPATHIE");

		entrainableDisplayEmp = new EntrainableDisplay(this, SWT.NONE);

		Label lblForce = new Label(this, SWT.NONE);
		lblForce.setText("FORCE");

		entrainableDisplayFor = new EntrainableDisplay(this, SWT.NONE);

		Label lblRve = new Label(this, SWT.NONE);
		lblRve.setText("RÊVE");

		entrainableDisplayRev = new EntrainableDisplay(this, SWT.NONE);

		Label lblAgilit = new Label(this, SWT.NONE);
		lblAgilit.setText("AGILITÉ");

		entrainableDisplayAgi = new EntrainableDisplay(this, SWT.NONE);

		Label lblChance = new Label(this, SWT.NONE);
		lblChance.setText("CHANCE");

		entrainableDisplayCha = new EntrainableDisplay(this, SWT.NONE);

		Label lblDextrit = new Label(this, SWT.NONE);
		lblDextrit.setText("DEXTÉRITÉ");

		entrainableDisplayDex = new EntrainableDisplay(this, SWT.NONE);

		Label lblMle = new Label(this, SWT.NONE);
		lblMle.setText("Mêlée");

		lblMel = new Label(this, SWT.NONE);
		lblMel.setText("New Label");

		Label lblVue = new Label(this, SWT.NONE);
		lblVue.setText("VUE");

		entrainableDisplayVue = new EntrainableDisplay(this, SWT.NONE);

		Label lblTir_ = new Label(this, SWT.NONE);
		lblTir_.setText("Tir");

		lblTir = new Label(this, SWT.NONE);
		lblTir.setText("New Label");

		Label lblOue = new Label(this, SWT.NONE);
		lblOue.setText("OUÏE");

		entrainableDisplayOui = new EntrainableDisplay(this, SWT.NONE);

		Label lblLancer = new Label(this, SWT.NONE);
		lblLancer.setText("Lancer");

		lblLan = new Label(this, SWT.NONE);
		lblLan.setText("New Label");

		Label lblOdoratgot = new Label(this, SWT.NONE);
		lblOdoratgot.setText("ODORAT-GOÛT");

		entrainableDisplayOdo = new EntrainableDisplay(this, SWT.NONE);

		Label lblDrobe = new Label(this, SWT.NONE);
		lblDrobe.setText("Dérobée");

		lblDer = new Label(this, SWT.NONE);
		lblDer.setText("New Label");
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
		lblMel.setText(Integer.toString(edited.getMelee()));
		lblTir.setText(Integer.toString(edited.getTir()));
		lblLan.setText(Integer.toString(edited.getLancer()));
		lblDer.setText(Integer.toString(edited.getDerobee()));
		for (EntrainableDisplay ed : eds) {
			ed.updateValue();
		}
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
		entrainableDisplayTai.setValue(getEdited().taille);
		eds.add(entrainableDisplayTai);
		entrainableDisplayApp.setValue(getEdited().apparence);
		eds.add(entrainableDisplayApp);
		entrainableDisplayCon.setValue(getEdited().constitution);
		eds.add(entrainableDisplayCon);
		entrainableDisplayFor.setValue(getEdited().force);
		eds.add(entrainableDisplayFor);
		entrainableDisplayAgi.setValue(getEdited().agilite);
		eds.add(entrainableDisplayAgi);
		entrainableDisplayDex.setValue(getEdited().dexterite);
		eds.add(entrainableDisplayDex);
		entrainableDisplayVue.setValue(getEdited().vue);
		eds.add(entrainableDisplayVue);
		entrainableDisplayOui.setValue(getEdited().ouie);
		eds.add(entrainableDisplayOui);
		entrainableDisplayOdo.setValue(getEdited().odorat_gout);
		eds.add(entrainableDisplayOdo);
		entrainableDisplayVol.setValue(getEdited().volonte);
		eds.add(entrainableDisplayVol);
		entrainableDisplayInt.setValue(getEdited().intellect);
		eds.add(entrainableDisplayInt);
		entrainableDisplayEmp.setValue(getEdited().empathie);
		eds.add(entrainableDisplayEmp);
		entrainableDisplayRev.setValue(getEdited().reve);
		eds.add(entrainableDisplayRev);
		entrainableDisplayCha.setValue(getEdited().chance);
		eds.add(entrainableDisplayCha);
	}

	protected List<EntrainableDisplay> eds = new Vector<EntrainableDisplay>();

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
