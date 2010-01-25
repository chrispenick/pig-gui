package org.apache.pig.contrib.gui.action;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.contrib.gui.view.PigScriptViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

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
		redirectIO();

		IViewReference[] viewers = window.getActivePage().getViewReferences();
		for (IViewReference view : viewers) {
			if (view.getId().equals(PigScriptViewer.ID)) {
				PigScriptViewer pigView = (PigScriptViewer) view.getView(true);
				String script = pigView.getScript();
				System.out.println("Start");
				new RunThread(script).start();
			}
		}
	}

	private void redirectIO() {
		MessageConsole console = new MessageConsole("Pig Output", null);
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		MessageConsoleStream stream = console.newMessageStream();

		System.setOut(new PrintStream(stream));
		System.setErr(new PrintStream(stream));
	}
}