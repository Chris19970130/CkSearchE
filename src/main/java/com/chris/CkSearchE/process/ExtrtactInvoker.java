package com.chris.CkSearchE.process;

public class ExtrtactInvoker {
	private ICommand command;
	
	public void setCommand(ICommand command){
		this.command = command;
	}
	
	public void action(){
		command.execute();
	}

}
