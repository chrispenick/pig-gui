package org.apache.pig.contrib.gui.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;
import org.apache.pig.backend.executionengine.ExecException;

public class PigServerPool {

	private static Map<ExecType,PigServer> pigs=new HashMap<ExecType, PigServer>();
	
	public static PigServer getPigServer(ExecType type) throws ExecException{
		PigServer pig=pigs.get(type);
		if (pig==null){
			pig=new PigServer(type);
			pigs.put(type, pig);
		}
		return pigs.get(type);
	}
}
