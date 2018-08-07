package com.chris.CkSearchE.process;

public class InsertCommand implements ICommand{
	private ICommandReceiver receiver;
	
	public InsertCommand(ICommandReceiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.extract();
	}

}
