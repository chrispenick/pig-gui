package org.apache.pig.contrib.gui;

import org.apache.pig.contrib.gui.action.RunAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private static String FileMenuID="org.apache.pig.contrib.gui.menu.file";
	
	private static String ToolBarID="org.apache.pig.contrib.gui.toolbar.main";
	
	private IWorkbenchAction exitAction;
	
	private RunAction runAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
		
    	this.runAction=new RunAction(window);
    	register(runAction);
    	
    	exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		
		
    }

    protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File",
				FileMenuID);
		menuBar.add(fileMenu);
		fileMenu.add(exitAction);
//		
//		fileMenu.add(runAction);
    }
    
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
    	 IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
         coolBar.add(new ToolBarContributionItem(toolbar, ToolBarID));   
         toolbar.add(runAction);
    }
    
}
