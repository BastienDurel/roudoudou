package org.geekwu.roudoudou;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.geekwu.roudoudou.ui.CaracFinishedEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

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
public class RoudoudouCaracSheet extends Composite implements RoudoudouSheet {

	protected Personnage edited = null;

	private Text textName;

	private Spinner spinnerBea;

	private Spinner spinnerTai;

	private Spinner spinnerVol;

	private Spinner spinnerApp;

	private Spinner spinnerInt;

	private Spinner spinnerCon;

	private Spinner spinnerEmp;

	private Spinner spinnerFor;

	private Spinner spinnerRev;

	private Spinner spinnerAgi;

	private Spinner spinnerCha;

	private Spinner spinnerDex;

	private Spinner spinnerVue;

	private Spinner spinnerOui;

	private Spinner spinnerOdo;

	private Label labelDer;

	private Label labelLan;

	private Label labelTir;

	private Label labelMel;

	private Label labelPts;

	private Label labelInfos;

	private Label labelInfos2;

	private Button btnEnregistrer;

	/**
	 * Create the composite.
	 * 
	 * 
	 * @param parent
	 * @param style
	 */
	public RoudoudouCaracSheet(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(5, false));

		Label lblNom = new Label(this, SWT.NONE);
		lblNom.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNom.setText("Nom");

		textName = new Text(this, SWT.BORDER);
		textName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (edited == null)
					return;
				edited.name = textName.getText();
			}
		});
		GridData gridData = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.horizontalSpan = 4;
		textName.setLayoutData(gridData);

		Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData2 = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = SWT.FILL;
		gridData2.verticalAlignment = SWT.FILL;
		gridData2.horizontalSpan = 5;
		label.setLayoutData(gridData2);

		Label lblCaractristiques = new Label(this, SWT.NONE);
		lblCaractristiques.setFont(SWTResourceManager.getFont("Cantarell", 12, SWT.BOLD));
		lblCaractristiques.setText("Caractéristiques");
		GridData gridData3 = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalAlignment = SWT.FILL;
		gridData3.verticalAlignment = SWT.FILL;
		gridData3.horizontalSpan = 2;
		lblCaractristiques.setLayoutData(gridData3);

		labelPts = new Label(this, SWT.NONE);
		labelPts.setAlignment(SWT.RIGHT);
		GridData gridData4 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData4.horizontalAlignment = SWT.FILL;
		gridData4.verticalAlignment = SWT.FILL;
		gridData4.horizontalSpan = 3;
		labelPts.setLayoutData(gridData4);
		labelPts.setText("0");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblbeaut = new Label(this, SWT.NONE);
		lblbeaut.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblbeaut.setText("(Beauté)");
		new Label(this, SWT.NONE);

		spinnerBea = new Spinner(this, SWT.BORDER);
		spinnerBea.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerBea.setMaximum(16);
		spinnerBea.setMinimum(3);
		spinnerBea.setSelection(10);
		spinnerBea.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.beaute = spinnerBea.getSelection();
				updatePerso();
			}
		});

		Label lblTaille = new Label(this, SWT.NONE);
		lblTaille.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTaille.setText("TAILLE");

		spinnerTai = new Spinner(this, SWT.BORDER);
		spinnerTai.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerTai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.taille.value = spinnerTai.getSelection();
				updatePerso();
			}
		});
		spinnerTai.setMaximum(15);
		spinnerTai.setMinimum(6);

		Label lblVolont = new Label(this, SWT.NONE);
		lblVolont.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblVolont.setText("VOLONTÉ");
		new Label(this, SWT.NONE);

		spinnerVol = new Spinner(this, SWT.BORDER);
		spinnerVol.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerVol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.volonte.value = spinnerVol.getSelection();
				updatePerso();
			}
		});
		spinnerVol.setMaximum(15);
		spinnerVol.setMinimum(6);

		Label lblApparence = new Label(this, SWT.NONE);
		lblApparence.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblApparence.setText("APPARENCE");

		spinnerApp = new Spinner(this, SWT.BORDER);
		spinnerApp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerApp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.apparence.value = spinnerApp.getSelection();
				updatePerso();
			}
		});
		spinnerApp.setMaximum(15);
		spinnerApp.setMinimum(6);

		Label lblIntellect = new Label(this, SWT.NONE);
		lblIntellect.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblIntellect.setText("INTELLECT");
		new Label(this, SWT.NONE);

		spinnerInt = new Spinner(this, SWT.BORDER);
		spinnerInt.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerInt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.intellect.value = spinnerInt.getSelection();
				updatePerso();
			}
		});
		spinnerInt.setMaximum(15);
		spinnerInt.setMinimum(6);

		Label lblConstitution = new Label(this, SWT.NONE);
		lblConstitution.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblConstitution.setText("CONSTITUTION");

		spinnerCon = new Spinner(this, SWT.BORDER);
		spinnerCon.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerCon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.constitution.value = spinnerCon.getSelection();
				updatePerso();
			}
		});
		spinnerCon.setMaximum(15);
		spinnerCon.setMinimum(6);

		Label lblEmathie = new Label(this, SWT.NONE);
		lblEmathie.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblEmathie.setText("EMATHIE");
		new Label(this, SWT.NONE);

		spinnerEmp = new Spinner(this, SWT.BORDER);
		spinnerEmp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerEmp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.empathie.value = spinnerEmp.getSelection();
				updatePerso();
			}
		});
		spinnerEmp.setMaximum(15);
		spinnerEmp.setMinimum(6);

		Label lblForce = new Label(this, SWT.NONE);
		lblForce.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblForce.setText("FORCE");

		spinnerFor = new Spinner(this, SWT.BORDER);
		spinnerFor.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerFor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.force.value = spinnerFor.getSelection();
				updatePerso();
			}
		});
		spinnerFor.setMaximum(15);
		spinnerFor.setMinimum(6);

		Label lblRve = new Label(this, SWT.NONE);
		lblRve.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblRve.setText("RÊVE");
		new Label(this, SWT.NONE);

		spinnerRev = new Spinner(this, SWT.BORDER);
		spinnerRev.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerRev.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.reve.value = spinnerRev.getSelection();
				updatePerso();
			}
		});
		spinnerRev.setMaximum(15);
		spinnerRev.setMinimum(6);

		Label lblAgilit = new Label(this, SWT.NONE);
		lblAgilit.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblAgilit.setText("AGILITÉ");

		spinnerAgi = new Spinner(this, SWT.BORDER);
		spinnerAgi.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerAgi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.agilite.value = spinnerAgi.getSelection();
				updatePerso();
			}
		});
		spinnerAgi.setMaximum(15);
		spinnerAgi.setMinimum(6);

		Label lblChance = new Label(this, SWT.NONE);
		lblChance.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblChance.setText("CHANCE");
		new Label(this, SWT.NONE);

		spinnerCha = new Spinner(this, SWT.BORDER);
		spinnerCha.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerCha.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.chance.value = spinnerCha.getSelection();
				updatePerso();
			}
		});
		spinnerCha.setMaximum(15);
		spinnerCha.setMinimum(6);

		Label lblDextrit = new Label(this, SWT.NONE);
		lblDextrit.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDextrit.setText("DEXTÉRITÉ");

		spinnerDex = new Spinner(this, SWT.BORDER);
		spinnerDex.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerDex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.dexterite.value = spinnerDex.getSelection();
				updatePerso();
			}
		});
		spinnerDex.setMaximum(15);
		spinnerDex.setMinimum(6);

		Label lbl_10_3 = new Label(this, SWT.NONE);
		lbl_10_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lbl_10_3.setText("Mêlée");
		new Label(this, SWT.NONE);

		labelMel = new Label(this, SWT.NONE);
		labelMel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		labelMel.setText("0");

		Label lblVue = new Label(this, SWT.NONE);
		lblVue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblVue.setText("VUE");

		spinnerVue = new Spinner(this, SWT.BORDER);
		spinnerVue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerVue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.vue.value = spinnerVue.getSelection();
				updatePerso();
			}
		});
		spinnerVue.setMaximum(15);
		spinnerVue.setMinimum(6);

		Label lbl_11_3 = new Label(this, SWT.NONE);
		lbl_11_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lbl_11_3.setText("Tir");
		new Label(this, SWT.NONE);

		labelTir = new Label(this, SWT.NONE);
		labelTir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		labelTir.setText("0");

		Label lblOue = new Label(this, SWT.NONE);
		lblOue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblOue.setText("OUÏE");

		spinnerOui = new Spinner(this, SWT.BORDER);
		spinnerOui.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerOui.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.ouie.value = spinnerOui.getSelection();
				updatePerso();
			}
		});
		spinnerOui.setMaximum(15);
		spinnerOui.setMinimum(6);

		Label lbl_12_3 = new Label(this, SWT.NONE);
		lbl_12_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lbl_12_3.setText("Lancer");
		new Label(this, SWT.NONE);

		labelLan = new Label(this, SWT.NONE);
		labelLan.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		labelLan.setText("0");

		Label lblOdoratgot = new Label(this, SWT.NONE);
		lblOdoratgot.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblOdoratgot.setText("ODORAT-GOÛT");

		spinnerOdo = new Spinner(this, SWT.BORDER);
		spinnerOdo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		spinnerOdo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (edited == null)
					return;
				edited.odorat_gout.value = spinnerOdo.getSelection();
				updatePerso();
			}
		});
		spinnerOdo.setMaximum(15);
		spinnerOdo.setMinimum(6);

		Label lbl_13_3 = new Label(this, SWT.NONE);
		lbl_13_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lbl_13_3.setText("Dérobée");
		new Label(this, SWT.NONE);

		labelDer = new Label(this, SWT.NONE);
		labelDer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		labelDer.setText("0");

		labelInfos = new Label(this, SWT.NONE);
		labelInfos.setText("Informations calculées");
		GridData gridDatainfos = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridDatainfos.horizontalAlignment = SWT.FILL;
		gridDatainfos.verticalAlignment = SWT.FILL;
		gridDatainfos.horizontalSpan = 5;
		labelInfos.setLayoutData(gridDatainfos);

		labelInfos2 = new Label(this, SWT.NONE);
		GridData gridDatainfos2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridDatainfos2.horizontalAlignment = SWT.FILL;
		gridDatainfos2.verticalAlignment = SWT.FILL;
		gridDatainfos2.horizontalSpan = 5;
		labelInfos2.setLayoutData(gridDatainfos2);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		btnEnregistrer = new Button(this, SWT.NONE);
		btnEnregistrer.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnEnregistrer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onValid();
			}
		});
		btnEnregistrer.setText("Enregistrer");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * 
	 */
	protected void onValid() {
		if (edited.getCaracsPoints() == 160) {
			MainUI.fireRoudoudouEvent(new CaracFinishedEvent(edited));
		}
	}

	/**
	 * 
	 */
	public void updatePerso() {
		if (edited == null)
			return;
		textName.setText(edited.name);
		labelMel.setText(Integer.toString(edited.getMelee()));
		labelTir.setText(Integer.toString(edited.getTir()));
		labelLan.setText(Integer.toString(edited.getLancer()));
		labelDer.setText(Integer.toString(edited.getDerobee()));
		spinnerBea.setSelection(edited.beaute);
		spinnerTai.setSelection(edited.taille.value);
		spinnerVol.setSelection(edited.volonte.value);
		spinnerApp.setSelection(edited.apparence.value);
		spinnerInt.setSelection(edited.intellect.value);
		spinnerCon.setSelection(edited.constitution.value);
		spinnerEmp.setSelection(edited.empathie.value);
		spinnerFor.setSelection(edited.force.value);
		spinnerRev.setSelection(edited.reve.value);
		spinnerAgi.setSelection(edited.agilite.value);
		spinnerCha.setSelection(edited.chance.value);
		spinnerDex.setSelection(edited.dexterite.value);
		spinnerVue.setSelection(edited.vue.value);
		spinnerOui.setSelection(edited.ouie.value);
		spinnerOdo.setSelection(edited.odorat_gout.value);
		labelPts.setText("(" + edited.getCaracsPoints() + " points)");
		labelInfos.setText("Vie: " + edited.getVie() + " End: " + edited.getEndurance() + " S. Const:"
				+ edited.getSeuilConstitution() + " Sust: " + edited.getSeuilConstitution());
		labelInfos2.setText("+Dom: " + edited.getPlusdom() + " Encombrement: "
				+ edited.getEncombrement());

		spinnerFor.setMaximum(Math.min(spinnerTai.getSelection() + 4, 15));
		btnEnregistrer.setEnabled(edited.getCaracsPoints() == 160);
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
	
	public Composite getComposite() {
		return this;
	}
}
