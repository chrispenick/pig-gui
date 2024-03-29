package org.apache.pig.contrib.gui;

import org.apache.pig.contrib.gui.view.PigColorProvider;
import org.apache.pig.contrib.gui.view.PigScriptScanner;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.apache.pig.contrib.eclipse";

	// The shared instance
	private static Activator plugin;

	private PigColorProvider colorProvider;

	private PigScriptScanner codeScanner;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public PigColorProvider getColorProvider() {
		if (colorProvider == null)
			colorProvider = new PigColorProvider();
		return colorProvider;
	}

	public PigScriptScanner getCodeScanner() {
		if (codeScanner == null) {
			codeScanner = new PigScriptScanner(getColorProvider());
		}
		return codeScanner;
	}
}
