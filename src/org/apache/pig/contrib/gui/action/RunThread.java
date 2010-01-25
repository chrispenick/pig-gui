package org.apache.pig.contrib.gui.action;

import java.io.IOException;
import java.io.StringReader;

import org.apache.pig.ExecType;
import org.apache.pig.backend.executionengine.ExecException;

public class RunThread extends Thread {

	private String script;

	public RunThread(String script) {
		this.script = script;
	}

	@Override
	public void run() {
		try {
			PigServerPool.getPigServer(ExecType.LOCAL).registerScript(
					new StringReader(script));
		} catch (ExecException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
