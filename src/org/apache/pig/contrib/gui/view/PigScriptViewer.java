package org.apache.pig.contrib.gui.view;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class PigScriptViewer extends ViewPart {

	public static String ID = "org.apache.pig.contrib.gui.view.PigScriptView";

	private SourceViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		this.viewer = new SourceViewer(parent, new CompositeRuler(),
				  SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.configure(new PigViewerConfiguration());
		this.viewer.setDocument(new Document());
	}

	@Override
	public void setFocus() {
		
	}

	public String getScript(){
		if (viewer!=null){
			return viewer.getTextWidget().getText();
		}else{
			return "";
		}
	}
}
