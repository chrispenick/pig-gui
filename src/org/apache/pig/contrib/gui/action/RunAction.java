package org.apache.pig.contrib.gui.action;

import java.io.IOException;
import java.io.StringReader;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.contrib.gui.view.PigScriptViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.console.ConsoleView;

public class RunAction extends Action {

	public static String ID = "org.apache.pig.contrib.gui.command.run";

	private IWorkbenchWindow window;

	public RunAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("Run");
	}

	@Override
	public void run() {
		IViewReference[] viewers = window.getActivePage().getViewReferences();
		for (IViewReference view : viewers) {
			if (view.getId().equals(PigScriptViewer.ID)) {
				PigScriptViewer pigView = (PigScriptViewer) view.getView(true);
				String script = pigView.getScript();

				initConsole();
				try {
					PigServer pig = new PigServer(ExecType.LOCAL);
					pig.regisgerScript(new StringReader(script));
				} catch (ExecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	private void initConsole() {
		IViewReference[] viewers = window.getActivePage().getViewReferences();
		for (IViewReference view : viewers) {
			if (view.getId().equals(IConsoleConstants.ID_CONSOLE_VIEW)) {
				ConsoleView console = (ConsoleView) view.getView(true);
				IConsole innerConsole = console.getConsole();
			}
		}
	}
}