package org.geekwu.roudoudou.ui;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.geekwu.roudoudou.Competence;

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
public class CompSelector extends Dialog {

	protected Object result = null;

	protected Shell shlChoisissezLaComptence;
	private List compList;
	private Competence list[] = null;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CompSelector(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}
	
	public CompSelector(Shell parent, int style, Competence list[]) {
		super(parent, style);
		setText("SWT Dialog");
		setList(list);
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlChoisissezLaComptence.open();
		shlChoisissezLaComptence.layout();
		Display display = getParent().getDisplay();
		while (!shlChoisissezLaComptence.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	public void setList(Competence list[]) {
		this.list = list;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlChoisissezLaComptence = new Shell(getParent(), getStyle());
		shlChoisissezLaComptence.setSize(450, 300);
		shlChoisissezLaComptence.setText("Choisissez la compétence");
		shlChoisissezLaComptence.setLayout(new FormLayout());
		
		compList = new List(shlChoisissezLaComptence, SWT.BORDER);
		compList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				result = list[compList.getSelectionIndex()];
			}
		});
		FormData fd_compList = new FormData();
		fd_compList.top = new FormAttachment(0, 10);
		fd_compList.left = new FormAttachment(0, 10);
		fd_compList.right = new FormAttachment(0, 438);
		compList.setLayoutData(fd_compList);
		
		Button btnOk = new Button(shlChoisissezLaComptence, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shlChoisissezLaComptence.dispose();
			}
		});
		fd_compList.bottom = new FormAttachment(100, -49);
		FormData fd_btnOk = new FormData();
		fd_btnOk.top = new FormAttachment(compList, 6);
		fd_btnOk.right = new FormAttachment(100, -10);
		fd_btnOk.left = new FormAttachment(0, 329);
		btnOk.setLayoutData(fd_btnOk);
		btnOk.setText("Ok");
		
		Button btnAnnuler = new Button(shlChoisissezLaComptence, SWT.NONE);
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shlChoisissezLaComptence.dispose();
			}
		});
		FormData fd_btnAnnuler = new FormData();
		fd_btnAnnuler.right = new FormAttachment(0, 110);
		fd_btnAnnuler.top = new FormAttachment(compList, 6);
		fd_btnAnnuler.left = new FormAttachment(0, 10);
		btnAnnuler.setLayoutData(fd_btnAnnuler);
		btnAnnuler.setText("Annuler");

		populateList();
	}
	
	private void populateList() {
		for (int i = 0; i < list.length; ++i) {
			compList.add(list[i].name);
		}
	}
}
