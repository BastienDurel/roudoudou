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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.custom.ScrolledComposite;

/**
 * @author Bastien Durel
 * 
 */
public class MainUI {

	protected Shell shlRoudoudou;

	protected RoudoudouSheet compositeSheet;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainUI window = new MainUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRoudoudou.open();
		shlRoudoudou.layout();
		while (!shlRoudoudou.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRoudoudou = new Shell();
		shlRoudoudou.setSize(553, 422);
		shlRoudoudou.setText("Roudoudou");
		shlRoudoudou.setLayout(new GridLayout(1, false));

		Menu menu = new Menu(shlRoudoudou, SWT.BAR);
		shlRoudoudou.setMenuBar(menu);

		MenuItem mntmFile_1 = new MenuItem(menu, SWT.CASCADE);
		mntmFile_1.setText("File");

		Menu menu_1 = new Menu(mntmFile_1);
		mntmFile_1.setMenu(menu_1);

		MenuItem mntmNew = new MenuItem(menu_1, SWT.NONE);
		mntmNew.setText("New");

		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.setText("Open");

		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setEnabled(false);
		mntmSave.setText("Save");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmQuit = new MenuItem(menu_1, SWT.NONE);
		mntmQuit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onQuit();
			}
		});
		mntmQuit.setText("Quit");

		MenuItem mntmHelp = new MenuItem(menu, SWT.NONE);
		mntmHelp.setText("Help");

		ToolBar toolBar = new ToolBar(shlRoudoudou, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		
		ToolItem tltmNew = new ToolItem(toolBar, SWT.NONE);
		tltmNew.setText("New");
		
		ToolItem tltmOpen = new ToolItem(toolBar, SWT.NONE);
		tltmOpen.setText("Open");
		
		ToolItem tltmSave = new ToolItem(toolBar, SWT.NONE);
		tltmSave.setEnabled(false);
		tltmSave.setText("Save");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlRoudoudou, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		compositeSheet = new RoudoudouSheet(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(compositeSheet);
		scrolledComposite.setMinSize(compositeSheet.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		

	}

	protected boolean checkSave() {
		return checkSave(true);
	}

	protected boolean checkSave(boolean cancel) {
		if (compositeSheet.edited != null) {

		}
		return true;
	}

	protected void onQuit() {
		if (checkSave()) {
			shlRoudoudou.close();
		}
	}

	protected void onNew() {
		if (checkSave()) {
			compositeSheet.edited = new Personnage("unnamed");
		}
	}
}
