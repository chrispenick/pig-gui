package org.apache.pig.contrib.gui.util;

import org.apache.pig.contrib.gui.Activator;
import org.eclipse.core.runtime.IStatus;

public class PigLogger {

	public static void log(IStatus status) {
		Activator.getDefault().getLog().log(status);
	}
}
