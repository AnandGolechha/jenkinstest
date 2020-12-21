/**
 * 
 */
package com.rockwell.model;

/**
 * @author anand.golechha
 *
 */
public class PLC {
	
	private Mode mode;
	
	public PLC(Mode mode) {
		this.mode = mode;
	}

	/**
	 * @return the mode
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void flipMode() {
		this.mode = Mode.PROGRAM.equals(this.mode) ? Mode.RUNNING : Mode.PROGRAM;  
	}

}
