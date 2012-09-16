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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
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
import org.geekwu.roudoudou.ui.CaracFinishedEvent;
import org.geekwu.roudoudou.ui.CompFinishedEvent;
import org.geekwu.roudoudou.ui.PersoChanged;
import org.geekwu.roudoudou.ui.PersoEdited;
import org.geekwu.roudoudou.ui.RoudoudouEvent;
import org.geekwu.roudoudou.ui.RoudoudouListener;

/**
 * @author Bastien Durel
 * 
 */
public class MainUI {

	protected Shell shlRoudoudou;

	protected RoudoudouSheet compositeSheet;

	private ToolItem tltmNew;

	private ToolItem tltmOpen;

	private MenuItem mntmSave;

	private MenuItem mntmNew;

	protected File lastSave = null;

	protected enum State {
		NONE, NEW, VIEW, EDIT
	};

	protected State state = State.NONE;

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

	protected static Map<Class<?>, RoudoudouListener> roudoudouListners = new HashMap<Class<?>, RoudoudouListener>();

	private ScrolledComposite scrolledComposite;

	private ToolItem tltmSave;

	private MenuItem mntmOpen;

	protected static class RoudoudouRunnable implements Runnable {
		RoudoudouEvent event;

		RoudoudouRunnable(RoudoudouEvent e) {
			event = e;
		}

		@Override
		public void run() {
			if (roudoudouListners.containsKey(event.getClass())) {
				roudoudouListners.get(event.getClass()).handle(event);
			}
		}
	}

	public static void fireRoudoudouEvent(RoudoudouEvent event) {
		Display.getDefault().asyncExec(new RoudoudouRunnable(event));
	}

	public static void addRoudoudouListener(Class<?> c, RoudoudouListener listener) {
		roudoudouListners.put(c, listener);
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
		shlRoudoudou.setSize(620, 640);
		shlRoudoudou.setText("Roudoudou");
		shlRoudoudou.setLayout(new GridLayout(1, false));

		Menu menu = new Menu(shlRoudoudou, SWT.BAR);
		shlRoudoudou.setMenuBar(menu);

		MenuItem mntmFile_1 = new MenuItem(menu, SWT.CASCADE);
		mntmFile_1.setText("File");

		Menu menu_1 = new Menu(mntmFile_1);
		mntmFile_1.setMenu(menu_1);

		mntmNew = new MenuItem(menu_1, SWT.NONE);
		mntmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onNew();
			}
		});
		mntmNew.setText("New");

		mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onOpen();
			}
		});
		mntmOpen.setText("Open");

		mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setEnabled(false);
		mntmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onSave();
			}
		});
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

		tltmNew = new ToolItem(toolBar, SWT.NONE);
		tltmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onNew();
			}
		});
		tltmNew.setText("New");

		tltmOpen = new ToolItem(toolBar, SWT.NONE);
		tltmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				onOpen();
			}
		});
		tltmOpen.setText("Open");

		tltmSave = new ToolItem(toolBar, SWT.NONE);
		tltmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (onSave())
					state = State.VIEW;
				updateState();
			}
		});
		tltmSave.setEnabled(false);
		tltmSave.setText("Save");

		scrolledComposite = new ScrolledComposite(shlRoudoudou, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_scrolledComposite.heightHint = 551;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		addRoudoudouListener(CaracFinishedEvent.class, new RoudoudouListener() {

			@Override
			public void handle(RoudoudouEvent event) {
				if (compositeSheet != null) {
					compositeSheet.getComposite().dispose();
					caracToComp(compositeSheet.getEdited());
				}
			}
		});
		addRoudoudouListener(CompFinishedEvent.class, new RoudoudouListener() {

			@Override
			public void handle(RoudoudouEvent event) {
				if (compositeSheet != null) {
					compositeSheet.getComposite().dispose();
					Personnage perso = compositeSheet.getEdited();
					compositeSheet = null;
					openLiveSheet(perso);
					fireRoudoudouEvent(new PersoEdited());
				}
			}
		});
		addRoudoudouListener(PersoChanged.class, new RoudoudouListener() {

			@Override
			public void handle(RoudoudouEvent event) {
				if (compositeSheet != null) {
					compositeSheet.updatePerso();
					state = State.EDIT;
					updateState();
				}
			}
		});
		addRoudoudouListener(PersoEdited.class, new RoudoudouListener() {

			@Override
			public void handle(RoudoudouEvent event) {
				state = State.EDIT;
				updateState();
			}
		});

	}

	protected void updateState() {
		tltmSave.setEnabled(state == State.EDIT);
		mntmSave.setEnabled(state == State.EDIT);
		tltmNew.setEnabled(state != State.NEW);
		mntmNew.setEnabled(state != State.NEW);
		tltmOpen.setEnabled(state != State.NEW);
		mntmOpen.setEnabled(state != State.NEW);
	}

	protected boolean checkSave() {
		return checkSave(true);
	}

	protected boolean checkSave(boolean cancel) {
		if (compositeSheet == null)
			return true;
		if (compositeSheet.getEdited() != null) {
			switch (state) {
			case NONE:
			case VIEW:
				return true;
			case EDIT: {
				MessageBox messageBox = new MessageBox(shlRoudoudou, SWT.ICON_WARNING | SWT.YES | SWT.NO
						| SWT.CANCEL);
				messageBox.setMessage("Voulez-vous sauver l'édition en cours ?");
				int rc = messageBox.open();
				if (rc == SWT.CANCEL)
					return false;
				if (rc == SWT.YES)
					return onSave();
				return true;
			}
			case NEW:
				return false;
			}
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
			onClose();
			compositeSheet = new RoudoudouCaracSheet(scrolledComposite, SWT.NONE);
			scrolledComposite.setContent(compositeSheet.getComposite());
			scrolledComposite.setMinSize(compositeSheet.getComposite().computeSize(SWT.DEFAULT,
					SWT.DEFAULT));

			compositeSheet.setEdited(new Personnage("unnamed"));
			compositeSheet.updatePerso();
		}
	}

	protected void onClose() {
		if (checkSave()) {
			state = State.NONE;
			lastSave = null;
			if (compositeSheet != null) {
				compositeSheet.getComposite().dispose();
				compositeSheet = null;
			}
			updateState();
		}
	}

	protected void onOpen() {
		if (checkSave()) {
			FileDialog fd = new FileDialog(shlRoudoudou, SWT.OPEN);
			String selected = fd.open();
			if (selected != null) {
				File f = new File(selected);
				if (f.canRead()) {
					onClose();
					try {
						Personnage perso = Personnage.fromFile(f);
						lastSave = f;
						openLiveSheet(perso);
						System.out.println(perso);
					} catch (Exception e) {
						MessageBox messageBox = new MessageBox(shlRoudoudou, SWT.ICON_ERROR);
						messageBox.setMessage("Impossible d'ouvrir ce personnage: " + e.getLocalizedMessage());
						messageBox.open();
					}
				} else {
					MessageBox messageBox = new MessageBox(shlRoudoudou, SWT.ICON_ERROR);
					messageBox.setMessage("Impossible d'ouvrir ce fichier");
					messageBox.open();
				}
			}
		}
	}

	protected boolean onSave() {
		try {
			if (lastSave == null) {
				FileDialog fd = new FileDialog(shlRoudoudou, SWT.SAVE);
				String selected = fd.open();
				if (selected != null) {
					File f = new File(selected);
					if (!f.exists()) {
						FileOutputStream out = new FileOutputStream(f);
						out.close();
					}
					if (f.canWrite())
						lastSave = f;
					else
						throw new IOException("Impossible d'écrire dans ce fichier");
				}
			}
			compositeSheet.getEdited().save(lastSave);
		} catch (Exception e) {
			e.printStackTrace();
			MessageBox messageBox = new MessageBox(shlRoudoudou, SWT.ICON_ERROR);
			messageBox.setMessage(e.getLocalizedMessage());
			messageBox.open();
			return false;
		}
		return true;
	}

	protected void caracToComp(Personnage perso) {
		compositeSheet = new RoudoudouCompSheet(scrolledComposite, SWT.NONE);
		compositeSheet.setEdited(perso);
		compositeSheet.updatePerso();
		scrolledComposite.setContent(compositeSheet.getComposite());
		scrolledComposite.setMinSize(compositeSheet.getComposite()
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	protected void openLiveSheet(Personnage perso) {
		compositeSheet = new LiveSheet(scrolledComposite, SWT.NATIVE);
		compositeSheet.setEdited(perso);
		compositeSheet.updatePerso();
		scrolledComposite.setContent(compositeSheet.getComposite());
		scrolledComposite.setMinSize(compositeSheet.getComposite()
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		state = State.VIEW;
	}
}
