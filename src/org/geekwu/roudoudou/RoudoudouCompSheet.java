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
import java.util.List;
import java.util.Vector;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.geekwu.roudoudou.ui.CompFinishedEvent;
import org.geekwu.roudoudou.ui.CompSelector;
import org.eclipse.swt.widgets.Button;

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

	private Button btnSauver;

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
		lblStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblStatus.setText("Status");

		btnSauver = new Button(composite, SWT.NONE);
		btnSauver.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MainUI.fireRoudoudouEvent(new CompFinishedEvent(edited));
			}
		});
		btnSauver.setEnabled(false);
		btnSauver.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSauver.setText("Sauver");

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
		lblStatus.setText("XP dépensée : " + this.totalXP() + "/2000");
		GridData gridData = new GridData(GridData.VERTICAL_ALIGN_END);
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 3;
		lblStatus.setLayoutData(gridData);
		btnSauver.setEnabled(totalXP() == 2000);
	}

	public Composite getComposite() {
		return this;
	}

	private void selectNewComp(Table table, CompType type) {
		List<Competence> l = new Vector<Competence>();
		List<Sort> s = null;
		switch (type) {
		case COMBAT:
			for (int i = 0; i < Competence.List.corps_a_corps.length; ++i) {
				Competence tmp = Competence.Factory.combat(Competence.List.corps_a_corps[i]);
				if (l.contains(tmp))
					continue;
				l.add(tmp);
				if (tmp instanceof CompetenceTronc) {
					Iterator<CompetenceTronc> link = ((CompetenceTronc) tmp).linkedCompetences.iterator();
					while (link.hasNext())
						l.add(link.next());
				}
			}
			for (int i = 0; i < Competence.List.tir.length; ++i)
				l.add(Competence.Factory.tir(Competence.List.tir[i]));
			break;

		case GENERALE:
			for (int i = 0; i < Competence.List.generale.length; ++i)
				l.add(Competence.Factory.generale(Competence.List.generale[i]));
			break;

		case PARTICULIERE:
			for (int i = 0; i < Competence.List.particuliere.length; ++i)
				l.add(Competence.Factory.particuliere(Competence.List.particuliere[i]));
			Competence _survie = Competence.Factory.particuliere(Competence.List.special.SURVIE);
			Competence survie = l.get(l.indexOf(_survie));
			if (getEdited().getSurvie() != null) {
				survie = getEdited().getSurvie();
			}
			for (int i = 0; i < Competence.List.survies.length; ++i)
				l.add(Competence.Factory.survie(Competence.List.survies[i], survie));
			break;

		case SPECIALISEE:
			for (int i = 0; i < Competence.List.specialisee.length; ++i)
				l.add(Competence.Factory.specialisee(Competence.List.specialisee[i]));
			break;

		case CONNAISSANCE:
			for (int i = 0; i < Competence.List.connaissance.length; ++i)
				l.add(Competence.Factory.connaissance(Competence.List.connaissance[i]));
			break;

		case DRACONIC:
			for (int i = 0; i < Competence.List.draconic.length; ++i) {
				boolean dest = Competence.List.draconic[i].equals(Competence.List.special.THANATOS);
				l.add(Competence.Factory.draconic(Competence.List.draconic[i], dest));
			}
			s = Sort.loadList();
			break;

		default:
			return;
		}
		// Don't dup
		Iterator<Competence> i = getEdited().competences.iterator();
		while (i.hasNext()) {
			Competence tmp = i.next();
			if (l.contains(tmp)) {
				l.remove(tmp);
			}
		}

		Competence[] c = new Competence[l.size()];
		Object response;
		if (s == null)
			response = new CompSelector(getShell(), getStyle(), l.toArray(c)).open();
		else {
			Sort[] sa = new Sort[s.size()];
			response = new CompSelector(getShell(), getStyle(), l.toArray(c)).setSorts(s.toArray(sa))
					.open();
		}
		if (response == null)
			return;
		if (response instanceof Competence) {
			Competence comp = (Competence) response;
			if (comp instanceof CompetenceSurvie) {
				// Insert survie competence if not already in list
				if (getEdited().getSurvie() == null) {
					insertCompetence(table, ((CompetenceSurvie) comp).survie);
				}
			}
			TableItem item = insertCompetence(table, comp);
			if (comp instanceof CompetenceTronc) {
				List<TableItem> items = new Vector<TableItem>();
				items.add(item);
				CompetenceTronc t = (CompetenceTronc)comp;
				Iterator<CompetenceTronc> it = t.linkedCompetences.iterator();
				while (it.hasNext()) {
					TableItem item2 = insertCompetence(table, it.next());
					items.add(item2);
				}
				for (TableItem tableItem : items) {
					for (TableItem tableItem2 : items) {
						if (tableItem == tableItem2)
							continue;
						Spinner sp = (Spinner) tableItem.getData("spinner");
						sp.addSelectionListener(new TroncSpinChanger(tableItem2));
					}
				}
			}
		} else if (response instanceof Sort) {
			Sort sort = (Sort) response;
			if (XPSorts() + sort.getXP() > 300) {
				new MessageBox(getShell(), SWT.ICON_ERROR).open();
				return;
			}
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(sort);
			item.setText(new String[] { sort.getNom(), "", Integer.toString(sort.getXP()) });
			getEdited().sorts.add(sort);
			updatePerso();
		}
	}

	protected TableItem insertCompetence(Table table, Competence comp) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setData(comp);
		item.setText(comp.name);
		Spinner spin = new Spinner(table, getStyle());
		spin.setMinimum(comp.value);
		spin.setSelection(comp.value);
		spin.setMaximum(3);
		if (comp instanceof CompetenceSurvie) {
			int max = ((CompetenceSurvie) comp).getMax();
			spin.setMaximum(Math.min(3, max));
			// link spinner to survie
			Iterator<SpinChanger> i = _spinChangers.iterator();
			while (i.hasNext()) {
				SpinChanger s = i.next();
				if (s.getComp().equals(getEdited().getSurvie())) {
					s.spin.addSelectionListener(new SurvieSpinChanger(spin, item));
					break;
				}
			}
		}
		TableEditor editor = new TableEditor(table);
		editor.grabHorizontal = editor.grabVertical = true;
		editor.setEditor(spin, item, 1);
		spin.addSelectionListener(new SpinChanger(spin, item));
		getEdited().competences.add(comp);
		item.setData("spinner", spin);
		return item;
	}

	protected int totalXP() {
		return XPCompetences() + XPSorts();
	}

	protected int XPCompetences() {
		int xp = 0;
		Iterator<Competence> i = getEdited().competences.iterator();
		while (i.hasNext())
			xp += i.next().getTotalXp();
		return xp;
	}

	protected int XPSorts() {
		int xp = 0;
		Iterator<Sort> i = getEdited().sorts.iterator();
		while (i.hasNext())
			xp += i.next().getXP();
		return xp;
	}

	private List<SpinChanger> _spinChangers = new Vector<RoudoudouCompSheet.SpinChanger>();

	private class SpinChanger extends SelectionAdapter {
		TableItem item;

		Spinner spin;

		SpinChanger(Spinner spin, TableItem item) {
			super();
			this.spin = spin;
			this.item = item;
			_spinChangers.add(this);
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			Competence comp = (Competence) item.getData();
			comp.setValue(spin.getSelection());
			item.setText(2, Integer.toString(comp.getTotalXp()));
			updatePerso();
		}

		public Competence getComp() {
			return (Competence) item.getData();
		}
	}

	private class SurvieSpinChanger extends SelectionAdapter {
		Spinner linked;

		TableItem item;

		SurvieSpinChanger(Spinner spin, TableItem item) {
			this.linked = spin;
			this.item = item;
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			CompetenceSurvie comp = (CompetenceSurvie) item.getData();
			linked.setMaximum(comp.getMax());
		}

	}

	private class TroncSpinChanger extends SelectionAdapter {
		TableItem item;

		TroncSpinChanger(TableItem item) {
			this.item = item;
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			Spinner s = (Spinner) item.getData("spinner");
			Competence comp = (Competence) item.getData();
			if (s.getMinimum() != comp.startingLevel)
				s.setMinimum(comp.startingLevel);
			if (s.getSelection() != comp.value)
				s.setSelection(comp.value);
			item.setText(2, Integer.toString(comp.getTotalXp()));
			updatePerso();
		}

	}
}
