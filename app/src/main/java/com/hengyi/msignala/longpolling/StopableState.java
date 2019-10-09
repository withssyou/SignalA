package com.hengyi.msignala.longpolling;

import com.hengyi.msignala.singala.ConnectionBase;
import com.hengyi.msignala.singala.Transport.StateBase;

import java.util.concurrent.atomic.AtomicBoolean;


public abstract class StopableState extends StateBase {
	protected AtomicBoolean requestStop = new AtomicBoolean(false);
    protected final String TRANSPORT_NAME = "LongPolling";

	
	public StopableState(ConnectionBase connection) {
		super(connection);
	}

	protected boolean DoStop()
	{
		if(requestStop.get()) 
		{
            mConnection.SetNewState(new DisconnectedState(mConnection));
            return true;
		}
		return false;
	}
	

}
