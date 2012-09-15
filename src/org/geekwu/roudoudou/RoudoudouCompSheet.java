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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.geekwu.roudoudou.ui.CompSelector;

/**
 * @author Bastien Durel
 * 
 */
public class RoudoudouCompSheet extends Composite implements RoudoudouSheet {

	/**
	 * @author Bastien Durel
	 * 
	 */
	public enum CompType {
		COMBAT, GENERALE, PARTICULIERE, SPECIALISEE, CONNAISSANCE, DRACONIC
	}

	protected Personnage edited = null;

	private Label lblPerso;

	private Table tableComb;

	private Table tablePart;

	private Table tableSpe;

	private Table tableGene;

	private Table tableConn;

	private Table tableDraco;

	private Label lblStatus;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public RoudoudouCompSheet(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));

		lblPerso = new Label(this, SWT.WRAP);
		lblPerso.setLayoutData(BorderLayout.NORTH);
		lblPerso.setText("New Label");

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label lblComptencesDeCombat = new Label(composite, SWT.NONE);
		lblComptencesDeCombat.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblComptencesDeCombat.setText("Compétences de combat");

		Label lblComptencesDeTir = new Label(composite, SWT.NONE);
		lblComptencesDeTir.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblComptencesDeTir.setText("Compétences Générales");

		tableComb = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableComb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tableComb, CompType.COMBAT);
			}
		});
		tableComb.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableComb.setHeaderVisible(true);
		tableComb.setLinesVisible(true);

		TableColumn tblclmnNom = new TableColumn(tableComb, SWT.NONE);
		tblclmnNom.setWidth(150);
		tblclmnNom.setText("Nom");

		TableColumn tblclmnNiveau = new TableColumn(tableComb, SWT.NONE);
		tblclmnNiveau.setWidth(60);
		tblclmnNiveau.setText("Niveau");

		TableColumn tblclmnXp = new TableColumn(tableComb, SWT.NONE);
		tblclmnXp.setWidth(50);
		tblclmnXp.setText("XP");

		tableGene = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableGene.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableGene.setHeaderVisible(true);
		tableGene.setLinesVisible(true);
		tableGene.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tableGene, CompType.GENERALE);
			}
		});

		TableColumn tableColumn = new TableColumn(tableGene, SWT.NONE);
		tableColumn.setWidth(150);
		tableColumn.setText("Nom");

		TableColumn tableColumn_1 = new TableColumn(tableGene, SWT.NONE);
		tableColumn_1.setWidth(60);
		tableColumn_1.setText("Niveau");

		TableColumn tableColumn_2 = new TableColumn(tableGene, SWT.NONE);
		tableColumn_2.setWidth(50);
		tableColumn_2.setText("XP");

		Label lblComptencesParticulires = new Label(composite, SWT.NONE);
		lblComptencesParticulires.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblComptencesParticulires.setText("Compétences Particulières");

		Label lblComptencesSpcialises = new Label(composite, SWT.NONE);
		lblComptencesSpcialises.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblComptencesSpcialises.setText("Compétences spécialisées");

		tablePart = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_tablePart = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_tablePart.widthHint = 281;
		tablePart.setLayoutData(gd_tablePart);
		tablePart.setHeaderVisible(true);
		tablePart.setLinesVisible(true);
		tablePart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tablePart, CompType.PARTICULIERE);
			}
		});

		TableColumn tableColumn_3 = new TableColumn(tablePart, SWT.NONE);
		tableColumn_3.setWidth(150);
		tableColumn_3.setText("Nom");

		TableColumn tableColumn_4 = new TableColumn(tablePart, SWT.NONE);
		tableColumn_4.setWidth(60);
		tableColumn_4.setText("Niveau");

		TableColumn tableColumn_5 = new TableColumn(tablePart, SWT.NONE);
		tableColumn_5.setWidth(50);
		tableColumn_5.setText("XP");

		tableSpe = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableSpe.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableSpe.setHeaderVisible(true);
		tableSpe.setLinesVisible(true);
		tableSpe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tableSpe, CompType.SPECIALISEE);
			}
		});

		TableColumn tableColumn_6 = new TableColumn(tableSpe, SWT.NONE);
		tableColumn_6.setWidth(150);
		tableColumn_6.setText("Nom");

		TableColumn tableColumn_7 = new TableColumn(tableSpe, SWT.NONE);
		tableColumn_7.setWidth(60);
		tableColumn_7.setText("Niveau");

		TableColumn tableColumn_8 = new TableColumn(tableSpe, SWT.NONE);
		tableColumn_8.setWidth(50);
		tableColumn_8.setText("XP");

		Label lblConnaissances = new Label(composite, SWT.NONE);
		lblConnaissances.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblConnaissances.setText("Connaissances");

		Label lblDraconic = new Label(composite, SWT.NONE);
		lblDraconic.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDraconic.setText("Draconic");

		tableConn = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableConn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableConn.setHeaderVisible(true);
		tableConn.setLinesVisible(true);
		tableConn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tableConn, CompType.CONNAISSANCE);
			}
		});

		TableColumn tableColumn_9 = new TableColumn(tableConn, SWT.NONE);
		tableColumn_9.setWidth(150);
		tableColumn_9.setText("Nom");

		TableColumn tableColumn_10 = new TableColumn(tableConn, SWT.NONE);
		tableColumn_10.setWidth(60);
		tableColumn_10.setText("Niveau");

		TableColumn tableColumn_11 = new TableColumn(tableConn, SWT.NONE);
		tableColumn_11.setWidth(50);
		tableColumn_11.setText("XP");

		tableDraco = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableDraco.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableDraco.setHeaderVisible(true);
		tableDraco.setLinesVisible(true);
		tableDraco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				selectNewComp(tableDraco, CompType.DRACONIC);
			}
		});

		TableColumn tableColumn_12 = new TableColumn(tableDraco, SWT.NONE);
		tableColumn_12.setWidth(150);
		tableColumn_12.setText("Nom");

		TableColumn tableColumn_13 = new TableColumn(tableDraco, SWT.NONE);
		tableColumn_13.setWidth(60);
		tableColumn_13.setText("Niveau");

		TableColumn tableColumn_14 = new TableColumn(tableDraco, SWT.NONE);
		tableColumn_14.setWidth(50);
		tableColumn_14.setText("XP");

		lblStatus = new Label(composite, SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblStatus.setText("Status");
		new Label(composite, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
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
	 * @see org.geekwu.roudoudou.RoudoudouSheet#updatePerso()
	 */
	@Override
	public void updatePerso() {
		lblPerso.setText(edited.getCaracTextCompressed());
	}

	public Composite getComposite() {
		return this;
	}

	private void selectNewComp(Table table, CompType type) {
		// TODO Auto-generated method stub
		List<Competence> l = new Vector<Competence>();
		switch (type) {
		case COMBAT:
			for (int i = 0; i < Competence.List.corps_a_corps.length; ++i)
				l.add(Competence.Factory.combat(Competence.List.corps_a_corps[i]));
			for (int i = 0; i < Competence.List.tir.length; ++i)
				l.add(Competence.Factory.tir(Competence.List.tir[i]));
			break;

		default:
			break;
		}
		Competence[] c = new Competence[l.size()];
		Object response = new CompSelector(getShell(), getStyle(), l.toArray(c)).open();
		if (response == null || !(response instanceof Competence))
			return;
		Competence comp = (Competence) response;
		TableItem item = new TableItem(table, SWT.NONE);
		item.setData(comp);
		item.setText(comp.name);
	}
}
