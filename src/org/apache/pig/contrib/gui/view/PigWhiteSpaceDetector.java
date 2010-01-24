package org.apache.pig.contrib.gui.view;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class PigWhiteSpaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}

}
