package org.apache.pig.contrib.gui;

import org.apache.pig.contrib.gui.view.PigScriptViewer;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);

		layout.addView(PigScriptViewer.ID, IPageLayout.TOP, 0.5f, editorArea);
		layout.addView(IConsoleConstants.ID_CONSOLE_VIEW, IPageLayout.BOTTOM,
				0.5f, editorArea);
	}
}
